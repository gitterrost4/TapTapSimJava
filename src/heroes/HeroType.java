// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.util.function.Function;

/** 
 * enumeration of all heroes in the game
 * TODO:create all heroes
 **/

public enum HeroType {
  REAPER("Reaper",params->new Reaper(params)),
  MULAN("Mulan",params->new Mulan(params));

  private final Function<HeroParameters,AbstractHero> creator;
  private final String name;

  private HeroType(String name, Function<HeroParameters,AbstractHero> creator) {
    this.name = name;
    this.creator=creator;
  }

  public AbstractHero create(HeroParameters parameters) {
    return creator.apply(parameters);
  }

  public String getName() {
    return name;
  }
}

// end of file
