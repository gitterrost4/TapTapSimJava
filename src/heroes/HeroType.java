// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.util.function.Function;

/** 
 * enumeration of all heroes in the game
 * TODO:create all heroes
 **/

public enum HeroType {
  MULAN(params->new Mulan(params));

  private final Function<HeroParameters,AbstractHero> creator;

  private HeroType(Function<HeroParameters,AbstractHero> creator) {
    this.creator=creator;
  }

  public AbstractHero create(HeroParameters parameters) {
    return creator.apply(parameters);
  }
}

// end of file
