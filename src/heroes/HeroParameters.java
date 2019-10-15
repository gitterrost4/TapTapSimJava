// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import loadout.Loadout;

/** 
 * TODO documentation
 *
 */
public class HeroParameters {
  public final Integer level;
  public final Integer star;
  public final Loadout loadout;
  
  public HeroParameters(Integer level, Integer star, Loadout loadout) {
    super();
    this.level=level;
    this.star=star;
    this.loadout=loadout;
  }
  
}


// end of file
