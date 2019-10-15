package effects;

import heroes.Hero;

/** 
 * Poison effect
 *
 */
public class Poison extends AbstractEffect {
  
  /**
   * strength of the poison
   */
  public final Integer strength;
  public final Hero hero;

  public Poison(Integer remainingRounds, Integer strength, Hero hero) {
    super(remainingRounds);
    this.strength=strength;
    this.hero=hero;
  }

  @Override
  public void apply() {
    hero.damage(strength);
  }
  
}


// end of file
