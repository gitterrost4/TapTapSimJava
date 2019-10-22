// $Id $
// (C) cantamen/Paul Kramer 2019
package effects;

import java.util.function.Consumer;

import heroes.Hero;

/** 
 * This is a basic Temporary effect that's intentionally very flexible.
 * the "start" method is executed when the effect is applied
 * the "trigger" method is executed at the end of each round
 * the "end" method is executed whenever the effect is over
 * 
 * temporary stat changes can be represented by increasing the stat in the start method and decreasing it by the same value in the end method
 * 
 * Often used effects like silence or poison should be derived from this class
 *
 */
public class TemporaryEffect {
  private final Consumer<Hero> start;
  private final Consumer<Hero> trigger;
  private final Consumer<Hero> end;
  private int remainingRounds;

  public TemporaryEffect(Consumer<Hero> start, Consumer<Hero> trigger, Consumer<Hero> end, int length) {
    super();
    this.start=start;
    this.trigger=trigger;
    this.end=end;
    this.remainingRounds = length;
  }
  
  public void apply(Hero t) {
    start.accept(t);
  }
  
  public void trigger(Hero t) {
    trigger.accept(t);
    remainingRounds-=1;
  }
  
  public void end(Hero t) {
    end.accept(t);
  }
  
  public boolean isOver() {
    return remainingRounds<=0;
  }
  
  
}


// end of file
