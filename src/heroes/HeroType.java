// $Id $
package heroes;

import java.util.function.Function;

/**
 * enumeration of all heroes in the game TODO:create all heroes
 **/

public enum HeroType {
  /** Reaper */
  REAPER("Reaper", params -> new Reaper(params)),
  /** Rlyeh */
  RLYEH("Rlyeh", params -> new Rlyeh(params)),
  /** Mulan */
  MULAN("Mulan", params -> new Mulan(params));

  /**
   * method to create the hero from its base parameters
   */
  private final Function<HeroParameters, AbstractHero> creator;

  /**
   * human-readable name of the hero
   */
  private final String name;

  /**
   * constructor setting the name and object supplier
   * 
   * @param name
   *        the name of the hero
   * @param creator
   *        the object supplier
   */
  private HeroType(String name, Function<HeroParameters, AbstractHero> creator) {
    this.name = name;
    this.creator = creator;
  }

  /**
   * create the hero by its parameters
   * 
   * @param parameters
   *        base parameters of the hero
   * @return the hero object
   */
  public AbstractHero create(HeroParameters parameters) {
    return creator.apply(parameters);
  }

  /**
   * @return the human-readable name of the hero
   */
  public String getName() {
    return name;
  }
}

// end of file
