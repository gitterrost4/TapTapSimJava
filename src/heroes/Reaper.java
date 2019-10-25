// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import effects.Silence;
import effects.TemporaryEffect;

/**
 * Reaper
 */
public class Reaper extends AbstractHero {

  private static final Faction FACTION = Faction.UNDEAD;
  private static final HeroClass HERO_CLASS = HeroClass.MAGE;
  private static final HeroType HERO_TYPE = HeroType.REAPER;
  private static final Map<Integer, BaseStats> baseStats = new HashMap<>();

  static {
    baseStats.put(5, new BaseStats(207, 43, 7, 217));
    baseStats.put(6, new BaseStats(393, 63, 8, 244));
    baseStats.put(7, new BaseStats(629, 67, 8, 262));
    baseStats.put(8, new BaseStats(727, 76, 8, 262));
    baseStats.put(9, new BaseStats(971, 79, 8, 262));
    baseStats.put(10, new BaseStats(1345, 110, 8, 262));
  }

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

  private void applySkill2(BattleSetting setting) {
    switch (star) {
    case 10:
      setting.getOwnTeam(this).getHeroes(true, true).stream().forEach(h -> h.addOnDeathAction(unused -> {
        if (this.isDead() || this.isDying()) {
          return null;
        }
        Log log = new Log();
        log.addItem(logMessage("Increasing attack and Defense Break of " + this.getFullName()));
        log.addItem(this.increaseDefenseBreak(new BigDecimal("0.084")));
        log.addItem(this.addAttackModifier(new BigDecimal("0.21")));
        return log;
      }));
      break;
    default:
      break;
    }
  }

  private void applySkill3() {
    switch (star) {
    case 10:
      this.increaseDefenseBreak(new BigDecimal("9.6"));
      this.addAttackModifier(new BigDecimal("0.3"));
      this.addMaxHPModifier(new BigDecimal("0.3"));
      break;
    default:
      break;
    }
  }

  private void applySkill4() {
    switch (star) {
    case 10:
      addOnDeathAction(setting -> {
        Log log = new Log();
        List<Hero> opposingHeroes = setting.getOpposingTeam(this).getHeroes(true, true);
        if (opposingHeroes.size() > 0) {
          log.addItem(logMessage("Dealing Damage (107% of Attack) to all enemies"));
        }
        opposingHeroes.stream().forEach(h -> log.addItem(h.damage(setting, this, new BigDecimal("1.07"))));
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
        log.addItem(h.damage(setting, this, new BigDecimal("1.8")));
        if (h.getHeroClass().equals(HeroClass.WARRIOR)) {
          log.addItem(h.addTemporaryEffect(new Silence(2)));
        }
      });

      // increase own attack by 20% for 2 rounds
      log.addItem(this.addTemporaryEffect(new TemporaryEffect(h -> h.addAttackModifier(new BigDecimal("1.2")),
          h -> null, h -> h.addAttackModifier(new BigDecimal("1").divide(new BigDecimal("1.2"))),
          "increase own attack by 20%", 2)));
      break;
    default:
      log.addItem(logMessage("not doing anything. Probably something went wrong"));
      break;
    }
    return log;
  }

}

// end of file
