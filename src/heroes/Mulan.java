// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.util.HashMap;
import java.util.Map;

import battle.BattleSetting;

/**
 * representation of Mulan
 * TODO: Not done yet
 */
public class Mulan extends AbstractHero {

  private static final Faction FACTION=Faction.ALLIANCE;
  private static final HeroClass HERO_CLASS=HeroClass.WANDERER;
  
  private static final Map<Integer,BaseStats> baseStats = new HashMap<>();

  static {
    baseStats.put(5, new BaseStats(217,41,11,235));
    baseStats.put(6, new BaseStats(407,59,12,254));
    baseStats.put(7, new BaseStats(636,66,12,272));
    baseStats.put(8, new BaseStats(751,71,12,272));
    baseStats.put(9, new BaseStats(1037,75,12,261));
    baseStats.put(10, new BaseStats(1432,109,7,261));
  }

  public Mulan(HeroParameters parameters) {
    super(parameters, baseStats, HERO_CLASS,FACTION);
  }

  @Override
  public void initTeam(BattleSetting setting) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void skillAttack(BattleSetting setting) {
    // TODO Auto-generated method stub
    
  }
  
}

// end of file
