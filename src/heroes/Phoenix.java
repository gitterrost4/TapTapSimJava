// $Id $
package heroes;

import java.util.HashMap;
import java.util.Map;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import effects.Burn;
import effects.PhoenixDebuff;
import effects.TemporaryEffect;
import util.Tuple;

/**
 * Phoenix
 */
public class Phoenix extends AbstractHero {

  /** constant for the faction */
  private static final Faction FACTION = Faction.HORDE;
  /** constant for the class */
  private static final HeroClass HERO_CLASS = HeroClass.CLERIC;
  /** constant for the name */
  private static final HeroType HERO_TYPE = HeroType.PHOENIX;
  /**
   * constant for the base stats (maxHP, attack, armor, speed) at each star level
   */
  private static final Map<Integer, BaseStats> baseStats = new HashMap<>();

  static {
    baseStats.put(5, new BaseStats(214, 45, 8, 215));
    baseStats.put(6, new BaseStats(364, 67, 9, 226));
    baseStats.put(7, new BaseStats(561, 77, 9, 237));
    baseStats.put(8, new BaseStats(798, 86, 9, 248));
    baseStats.put(9, new BaseStats(1003, 89, 9, 259));
    baseStats.put(10, new BaseStats(1427, 114, 10, 259));
  }

  private boolean alreadyRevived = false;

  /**
   * create a Phoenix according to its parameters
   * 
   * @param parameters
   *        basic hero parameters
   */
  public Phoenix(HeroParameters parameters) {
    super(parameters, baseStats, HERO_CLASS, FACTION, HERO_TYPE);
    applyHPBonusOfSkill2();
    applySkill4();
  }

  @Override
  public void initTeam(BattleSetting setting) {
    applySkill3(setting);
  }

  @Override
  public String toString() {
    return "Phoenix [" + super.toString() + "]";
  }

  /**
   * Adds the 35% passive hp bonus of the second skill
   */
  public void applyHPBonusOfSkill2() {
    switch (star) {
    case 10:
      this.addMaxHPModifier(0.35);
      break;
    default:
      break;
    }
  }

  /**
   * apply the ExDmgToBurning to all allies. Since this is only while Phoenix is
   * alive, we take it away as an onDeath action
   * 
   * @param setting
   *        the battle setting
   */
  public void applySkill3(BattleSetting setting) {
    setting.getOwnTeam(this).getHeroes().stream().sequential().forEach(h -> h.increaseBurningDamageModifier(0.3));
    this.addOnDeathAction(s -> {
      Log log = new Log();
      log.addMessage("Decreasing the ExDmgToBurning on all allies again, because phoenix died");
      s.getOwnTeam(this).getHeroes(true, true).stream().map(h -> h.increaseBurningDamageModifier(-0.3))
          .forEach(log::addItem);
      return log;
    });
  }

  /**
   * Apply the onHit action checking for revivability
   */
  public void applySkill4() {
    this.addOnHitAction((s, h) -> {
      Log log = new Log();
      if (this.getCurrentHP() <= 0 && !alreadyRevived) {
        log.addItem(logMessage("Reviving and restoring 77% of maxHP"));
        log.addItem(this.heal(this.getMaxHP(), 0.77, true));
        log.addItem(logMessage("Healing all allies by 77% of Attack"));
        s.getOwnTeam(this).getHeroes(true, true).stream().map(hero -> hero.heal(this.getAttack(), 0.77, false))
            .forEach(log::addItem);
        alreadyRevived = true;
      }
      return log;
    });
  }

  @Override
  public LogItem skillAttack(BattleSetting setting) {
    Log log = new Log();
    switch (star) {
    case 10:
      log.addItem(logMessage("attacking all opposing heroes for 100% of attack"));
      setting.getOpposingTeam(this).getHeroes(true, true).forEach(h -> {
        Tuple<Boolean, LogItem> attackResult = h.receiveAttack(setting, this, 1, true, true, x -> {
          Log onHitLog = new Log();
          onHitLog.addItem(x.addTemporaryEffect(new Burn(setting, 3, this, 0.5)));
          onHitLog.addItem(x.addTemporaryEffect(new TemporaryEffect(y -> y.increaseDefense(-10), y -> null,
              y -> y.increaseDefense(10), "Decrease defense by 10", 3)));
          return onHitLog;
        });
        log.addItem(attackResult._1);
      });
      // increase the energy of a random ally by 100
      setting.getOwnTeam(this).getRandomHeroes(1).stream().findFirst().map(h -> h.increaseCurrentEnergy(100))
          .ifPresent(log::addItem);

      // increase own attack by 20% for 2 rounds
      log.addItem(this.addTemporaryEffect(new TemporaryEffect(h -> h.addAttackModifier(0.3), h -> null,
          h -> h.removeAttackModifier(0.3), "increase own attack by 30%", 2)));
      break;
    default:
      log.addItem(logMessage("not doing anything. Probably something went wrong"));
      break;
    }
    return log;
  }

  @Override
  public LogItem basicAttack(BattleSetting setting) {
    // overriding this method because of Phoenix's second skill
    Log log = new Log();
    switch (star) {
    case 10:
      Hero attackedHero = setting.getOpposingTeam(this).getHeroes(true, true).stream()
          .sorted((h1, h2) -> h2.getAttack().compareTo(h1.getAttack())).findFirst()
          .orElseThrow(() -> new IllegalStateException("Basic attack executed when all opposing heroes are dead"));
      log.addItem(logMessage("Basic attack at " + attackedHero.getFullName()));
      Tuple<Boolean, LogItem> attackResult = attackedHero.receiveAttack(setting, this, 1, false, true, h -> {
        Log onHitLog = new Log();
        h.addTemporaryEffect(new Burn(setting, 3, this, 0.5));
        if (!h.hasTemporaryEffect(
            effect -> effect instanceof PhoenixDebuff && ((PhoenixDebuff) effect).getSource() == this)) {
          // this debuff does not stack!
          h.addTemporaryEffect(new PhoenixDebuff(3, this, 0.15));
        }
        return onHitLog;
      });
      log.addItem(attackResult._1);
      if (attackResult._0) {
        log.addItem(increaseCurrentEnergy(50));
      }
      break;
    default:
      break;
    }
    return log;
  }

}

// end of file
