// $Id $
// (C) cantamen/Paul Kramer 2019
package effects;

import java.util.Optional;

/** 
 * Base class for all effects
 *
 */
public abstract class AbstractEffect {

  /**
   * how many more rounds this effect triggers
   */
  private Optional<Integer> remainingRounds;

  public AbstractEffect(Integer remainingRounds) {
    super();
    this.remainingRounds=Optional.ofNullable(remainingRounds);
  }

  public Optional<Integer> getRemainingRounds() {
    return remainingRounds;
  }
  
  public abstract void apply();
  
}


// end of file
