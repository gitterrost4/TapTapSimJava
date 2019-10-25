package effects;

import java.math.BigDecimal;

/**
 * Poison effect
 *
 */
public class Heal extends TemporaryEffect {

  public Heal(Integer remainingRounds, Integer baseStat, BigDecimal modifier) {
    super(h -> h.heal(baseStat, modifier), h -> h.heal(baseStat, modifier), h -> null, "Heal",
        remainingRounds);
  }

}

// end of file
