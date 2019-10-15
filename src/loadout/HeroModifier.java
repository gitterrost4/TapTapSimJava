package loadout;

import heroes.Hero;

/** 
 * This interface applies to anything that modifies a hero's stats in any way.
 *
 */
public interface HeroModifier {
  public void apply(Hero hero);
}


// end of file
