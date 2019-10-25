// $Id $
package heroes;

import loadout.Loadout;

/**
 * Container class containing all defining parameters of a hero (except which
 * hero it actually is)
 *
 */
public class HeroParameters {
  public final Integer level;
  public final Integer star;
  public final Loadout loadout;

  public HeroParameters(Integer level, Integer star, Loadout loadout) {
    super();
    this.level = level;
    this.star = star;
    this.loadout = loadout;
  }

}

// end of file
