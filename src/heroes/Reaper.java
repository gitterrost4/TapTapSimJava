// $Id $
package heroes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import effects.Silence;
import effects.TemporaryEffect;
import util.Tuple;

/**
 * Reaper
 */
public class Reaper extends AbstractHero {

  /** constant for the faction */
  private static final Faction FACTION = Faction.UNDEAD;
  /** constant for the class */
  private static final HeroClass HERO_CLASS = HeroClass.MAGE;
  /** constant for the name */
  private static final HeroType HERO_TYPE = HeroType.REAPER;
  /**
   * constant for the base stats (maxHP, attack, armor, speed) at each star level
   */
  private static final Map<Integer, BaseStats> baseStats = new HashMap<>();

  static {
    baseStats.put(5, new BaseStats(207, 43, 7, 217));
    baseStats.put(6, new BaseStats(393, 63, 8, 244));
    baseStats.put(7, new BaseStats(629, 67, 8, 262));
    baseStats.put(8, new BaseStats(727, 76, 8, 262));
    baseStats.put(9, new BaseStats(971, 79, 8, 262));
    baseStats.put(10, new BaseStats(1345, 110, 8, 262));
  }

  /**
   * create a Reaper according to it's parameters
   * 
   * @param parameters
   *        basic hero parameters
   */
  public Reaper(HeroParameters parameters) {
    super(parameters, baseStats, HERO_CLASS, FACTION, HERO_TYPE);
    applySkill3();
    applySkill4();
  }

  @Override
  public void initTeam(BattleSetting setting) {
    applySkill2(setting);
  }

  @Override
  public String toString() {
    return "Reaper [" + super.toString() + "]";
  }

  /**
   * apply the second skill of reaper increasing attack when a team member dies TODO:
   * Add the rest of the star versions of this skill
   * 
   * @param setting
   *        the complete battle setting
   */
  private void applySkill2(BattleSetting setting) {
    switch (star) {
    case 10:
      setting.getOwnTeam(this).getHeroes(true, true).stream().forEach(h -> h.addOnDeathAction(unused -> {
        if (this.isDead() || this.isDying()) {
          return null;
        }
        Log log = new Log();
        log.addItem(logMessage("Increasing attack and Defense Break of " + this.getFullName()));
        log.addItem(this.increaseDefenseBreak(0.084));
        log.addItem(this.addAttackModifier(0.21));
        return log;
      }));
      break;
    default:
      break;
    }
  }

  /**
   * apply the third skill of Reaper, increasing its stats TODO: Add the rest of the
   * star versions of the skill
   */
  private void applySkill3() {
    switch (star) {
    case 10:
      this.increaseDefenseBreak(9.6);
      this.addAttackModifier(0.3);
      this.addMaxHPModifier(0.3);
      break;
    default:
      break;
    }
  }

  /**
   * apply the fourth skill of reaper adding an onDeath action dealing damage to all
   * enemies TODO: Add the rest of the star versions
   */
  private void applySkill4() {
    switch (star) {
    case 10:
      addOnDeathAction(setting -> {
        Log log = new Log();
        List<Hero> opposingHeroes = setting.getOpposingTeam(this).getHeroes(true, true);
        if (opposingHeroes.size() > 0) {
          log.addItem(logMessage("Dealing Damage (107% of Attack) to all enemies"));
        }
        opposingHeroes.stream()
            .forEach(h -> log.addItem(h.receiveAttack(setting, this, 1.07, false, true, x -> null)._1));
        return log;
      });
      break;
    default:
      break;
    }
  }

  @Override
  public LogItem skillAttack(BattleSetting setting) {
    Log log = new Log();
    switch (star) {
    case 10:
      log.addItem(logMessage("attacking all opposing heroes for 180% of attack"));
      setting.getOpposingTeam(this).getHeroes(true, true).forEach(h -> {
        Tuple<Boolean, LogItem> attackResult = h.receiveAttack(setting, this, 1.8, true, false, x -> null);
        log.addItem(attackResult._1);
        if (attackResult._0 && h.getHeroClass().equals(HeroClass.WARRIOR)) {
          log.addItem(h.addTemporaryEffect(new Silence(2)));
        }
      });

      // increase own attack by 20% for 2 rounds
      log.addItem(this.addTemporaryEffect(new TemporaryEffect(h -> h.addAttackModifier(0.2), h -> null,
          h -> h.removeAttackModifier(0.2), "increase own attack by 20%", 2)));
      break;
    default:
      log.addItem(logMessage("not doing anything. Probably something went wrong"));
      break;
    }
    return log;
  }

}

// end of file
