// $Id $
package effects;

import java.util.Optional;
import java.util.function.Function;

import battle.logging.LogItem;
import heroes.Hero;

/**
 * This is a basic Temporary effect that's intentionally very flexible. the
 * "start" method is executed when the effect is applied the "trigger" method is
 * executed at the end of each round the "end" method is executed whenever the
 * effect is over
 * 
 * temporary stat changes can be represented by increasing the stat in the start
 * method and decreasing it by the same value in the end method
 * 
 * Often used effects like silence or poison should be derived from this class
 *
 */
public class TemporaryEffect {
  private final Function<Hero, LogItem> start;
  private final Function<Hero, LogItem> trigger;
  private final Function<Hero, LogItem> end;
  private final String description;
  private int remainingRounds;

  public TemporaryEffect(Function<Hero, LogItem> start, Function<Hero, LogItem> trigger, Function<Hero, LogItem> end,
      String description, int remainingRounds) {
    super();
    this.start = start;
    this.trigger = trigger;
    this.end = end;
    this.description = description;
    this.remainingRounds = remainingRounds;
  }

  public Optional<LogItem> apply(Hero t) {
    return Optional.ofNullable(start.apply(t));
  }

  public Optional<LogItem> trigger(Hero t) {
    remainingRounds -= 1;
    return Optional.ofNullable(trigger.apply(t));
  }

  public Optional<LogItem> end(Hero t) {
    return Optional.ofNullable(end.apply(t));
  }

  public boolean isOver() {
    return remainingRounds <= 0;
  }

  @Override
  public String toString() {
    return "TemporaryEffect [description=" + description + ", remainingRounds=" + remainingRounds + "]";
  }

}

// end of file
