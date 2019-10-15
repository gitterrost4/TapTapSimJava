// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.util.HashMap;
import java.util.Map;

import util.Utilities;

/**
 * TODO documentation
 */
public class Reaper extends AbstractHero {

  private static final Faction FACTION=Faction.UNDEAD;
  private static final HeroClass HERO_CLASS=HeroClass.MAGE;
  
  private static final Map<Integer,Integer> baseHP=new HashMap<>();
  private static final Map<Integer,Integer> baseAttack=new HashMap<>();
  private static final Map<Integer,Integer> baseArmor=new HashMap<>();
  private static final Map<Integer,Integer> baseSpeed=new HashMap<>();

  static {
    baseHP.put(100,5203);
    baseHP.put(140,15691);
    baseHP.put(250,95967);

    baseAttack.put(100,893);
    baseAttack.put(140,1977);
    baseAttack.put(250,6351);

    baseArmor.put(100,11);
    baseArmor.put(140,12);
    baseArmor.put(250,12);

    baseSpeed.put(140,874);
    baseSpeed.put(100,668);
    baseSpeed.put(250,1248);
  }

  public Reaper(HeroParameters parameters) {
    super(parameters.level, HERO_CLASS,FACTION,
      Utilities.interpolateStatsLinearly(baseHP,parameters.level),
      Utilities.interpolateStatsLinearly(baseAttack,parameters.level),
      Utilities.interpolateStatsLinearly(baseArmor,parameters.level),
      Utilities.interpolateStatsLinearly(baseSpeed,parameters.level),
      parameters.loadout);
  }
}

// end of file
