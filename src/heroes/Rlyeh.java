// $Id $
package heroes;

import java.util.HashMap;
import java.util.Map;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import effects.Heal;
import effects.TemporaryEffect;
import util.Tuple;
import util.Utilities;

/**
 * Implementation of the Rlyeh Hero
 */
public class Rlyeh extends AbstractHero {

  /** constant for the faction */
  private static final Faction FACTION = Faction.HORDE;
  /** constant for the class */
  private static final HeroClass HERO_CLASS = HeroClass.CLERIC;
  /** constant for the name */
  private static final HeroType HERO_TYPE = HeroType.RLYEH;
  /**
   * constant for the base stats (maxHP, attack, armor, speed) at each star level
   */
  private static final Map<Integer, BaseStats> baseStats = new HashMap<>();

  static {
    baseStats.put(4, new BaseStats(108, 26, 8, 190));
    baseStats.put(5, new BaseStats(161, 34, 9, 209));
    baseStats.put(6, new BaseStats(360, 57, 10, 232));
    baseStats.put(7, new BaseStats(570, 65, 10, 250));
    baseStats.put(8, new BaseStats(668, 67, 10, 225));
    baseStats.put(9, new BaseStats(852, 74, 10, 225));
    baseStats.put(10, new BaseStats(1167, 105, 10, 225));
  }

  /**
   * create a Rlyeh according to it's parameters
   * 
   * @param parameters
   *        basic hero parameters
   */
  public Rlyeh(HeroParameters parameters) {
    super(parameters, baseStats, HERO_CLASS, FACTION, HERO_TYPE);
    applySkill3();
    applySkill4();
  }

  @Override
  public void initTeam(BattleSetting setting) {
    // nothing to do here
  }

  @Override
  public LogItem skillAttack(BattleSetting setting) {
    Log log = new Log();
    Hero attackedHero = setting.getOpposingTeam(this).getLowestHealthHero()
        .orElseThrow(() -> new IllegalStateException("No hero is alive anymore"));
    log.addItem(logMessage("Dealing Damage (170% of Attack) to " + attackedHero.getFullName()));
    Tuple<Boolean, LogItem> attackResult = attackedHero.receiveAttack(setting, this, 1.7, true, true, h -> null);
    log.addItem(attackResult._1);
    if (attackResult._0) {
      Hero healedHero = setting.getOwnTeam(this).getLowestHealthHero()
          .orElseThrow(() -> new IllegalStateException("No hero is alive anymore"));
      log.addItem(logMessage("Healing (400% of Attack) to " + healedHero.getFullName()));
      log.addItem(healedHero.heal(this.getAttack(), 4));
      log.addItem(logMessage("Increase DamageReduce by 20% for 3 rounds"));
      log.addItem(this.addTemporaryEffect(new TemporaryEffect(h -> h.increaseDamageReduce(0.2), h -> null,
          h -> h.increaseDamageReduce(-0.2), "Increase DamageReduce by 20%", 3)));
    }
    return log;
  }

  /**
   * apply the third skill to add the onHit heal of Rlyeh. TODO: add the other star
   * variants of the skill
   */
  private void applySkill3() {
    this.addOnHitAction((hero, setting) -> this.addTemporaryEffect(new Heal(1, getAttack(), 0.66)));
  }

  /**
   * apply the fourth skill to add stats to Rlyeh. TODO: add the other star variants
   * of the skill
   */
  private void applySkill4() {
    this.addAttackModifier(0.25);
    this.addMaxHPModifier(0.2);
  }

  @Override
  public LogItem basicAttack(BattleSetting setting) {
    // overriding this method because of Rlyeh's second skill
    Log log = new Log();
    switch (star) {
    case 10:
      Hero attackedHero = setting.getOpposingTeam(this).getHeroes(true, true).get(0);
      log.addItem(logMessage("Basic attack at " + attackedHero.getFullName()));
      Tuple<Boolean, LogItem> attackResult = attackedHero.receiveAttack(setting, this, 1, false, true, h -> null);
      log.addItem(attackResult._1);
      if (attackResult._0) {
        if (Utilities.getRandomThrow(0.51)) {
          Hero healedHero = setting.getOwnTeam(this).getLowestHealthHero()
              .orElseThrow(() -> new IllegalStateException("No hero is alive anymore"));
          log.addItem(logMessage("Healing " + healedHero.getFullName() + " for 151% of Attack for 1 round"));
          log.addItem(healedHero.addTemporaryEffect(new Heal(1, this.getAttack(), 1.51)));
        }
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
