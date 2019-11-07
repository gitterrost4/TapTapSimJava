package effects;

/**
 * Poison effect
 */
public class Heal extends TemporaryEffect {

  public Heal(Integer remainingRounds, Integer baseStat, double modifier) {
    super(h -> h.heal(baseStat, modifier, false), h -> h.heal(baseStat, modifier, false), h -> null, "Heal", remainingRounds);
  }

}

// end of file
