// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.util.HashMap;
import java.util.Map;

/**
 * Reaper
 */
public class Reaper extends AbstractHero {

  private static final Faction FACTION=Faction.UNDEAD;
  private static final HeroClass HERO_CLASS=HeroClass.MAGE;
  
  private static final Map<Integer,BaseStats> baseStats = new HashMap<>();

  static {
    baseStats.put(5, new BaseStats(207,43,7,217));
    baseStats.put(6, new BaseStats(393,63,8,244));
    baseStats.put(7, new BaseStats(629,67,8,262));
    baseStats.put(8, new BaseStats(727,76,8,262));
    baseStats.put(9, new BaseStats(971,79,8,262));
    baseStats.put(10, new BaseStats(1345,110,8,262));
  }

  public Reaper(HeroParameters parameters) {
    super(parameters, baseStats, HERO_CLASS,FACTION);
  }

  @Override
  public String toString() {
    return "Reaper ["+super.toString()+"]";
  }
  
  
}

// end of file
