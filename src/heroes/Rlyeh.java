// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import effects.Heal;
import effects.TemporaryEffect;
import util.Utilities;

/**
 * TODO documentation
 *
 * @author (C) cantamen/Paul Kramer 2019
 * @version $Id $
 */
public class Rlyeh extends AbstractHero {

  private static final Faction FACTION=Faction.HORDE;
  private static final HeroClass HERO_CLASS=HeroClass.CLERIC;
  private static final HeroType HERO_TYPE=HeroType.RLYEH;
  private static final Map<Integer,BaseStats> baseStats=new HashMap<>();

  static {
    baseStats.put(4,new BaseStats(108,26,8,190));
    baseStats.put(5,new BaseStats(161,34,9,209));
    baseStats.put(6,new BaseStats(360,57,10,232));
    baseStats.put(7,new BaseStats(570,65,10,250));
    baseStats.put(8,new BaseStats(668,67,10,225));
    baseStats.put(9,new BaseStats(852,74,10,225));
    baseStats.put(10,new BaseStats(1167,105,10,225));
  }

  public Rlyeh(HeroParameters parameters) {
    super(parameters,baseStats,HERO_CLASS,FACTION,HERO_TYPE);
    applySkill3();
    applySkill4();
  }

  @Override
  public void initTeam(BattleSetting setting) {
    //nothing to do here
  }

  @Override
  public LogItem skillAttack(BattleSetting setting) {
    Log log = new Log();
    Hero attackedHero=setting.getOpposingTeam(this).getLowestHealthHero().orElseThrow(()->new IllegalStateException("No hero is alive anymore"));
    log.addItem(logMessage("Dealing Damage (170% of Attack) to "+attackedHero.getFullName()));
    log.addItem(attackedHero.damage(setting,this,new BigDecimal("1.7")));
    Hero healedHero=setting.getOwnTeam(this).getLowestHealthHero().orElseThrow(()->new IllegalStateException("No hero is alive anymore"));
    log.addItem(logMessage("Healing (400% of Attack) to "+healedHero.getFullName()));
    log.addItem(healedHero.heal(this.getAttack(),new BigDecimal("4")));
    log.addItem(logMessage("Increase DamageReduce by 20% for 3 rounds"));
    log.addItem(this.addTemporaryEffect(new TemporaryEffect(h->h.increaseDamageReduce(new BigDecimal("0.2")),h->null,h->h.increaseDamageReduce(new BigDecimal("-0.2")),"Increase DamageReduce by 20%",3)));
    return log;
  }

  private void applySkill3() {
    this.addOnHitAction(setting->this.addTemporaryEffect(new Heal(1, getAttack(),new BigDecimal("0.66"))));
  }
  
  private void applySkill4() {
    this.addAttackModifier(new BigDecimal("0.25"));
    this.addMaxHPModifier(new BigDecimal("0.2"));
  }
  
  @Override
  public LogItem basicAttack(BattleSetting setting) {
    //overriding this method because of Rlyeh's second skill
    Log log=new Log();
    switch (star) {
    case 10:
      Hero attackedHero=setting.getOpposingTeam(this).getHeroes().get(0);
      log.addItem(logMessage("Basic attack at " + attackedHero.getFullName()));
      log.addItem(attackedHero.damage(setting,this,new BigDecimal("1")));
      if (Utilities.getRandomThrow(new BigDecimal("0.51"))) {
        Hero healedHero=setting.getOwnTeam(this).getLowestHealthHero()
          .orElseThrow(() -> new IllegalStateException("No hero is alive anymore"));
        log.addItem(logMessage("Healing "+healedHero.getFullName()+" for 151% of Attack for 1 round"));
        log.addItem(healedHero.addTemporaryEffect(new Heal(1,this.getAttack(), new BigDecimal("1.51"))));
      }
      log.addItem(increaseEnergy(50));
      break;
    default:
      break;
    }
    return log;
  }

}

// end of file
