package effects;

import java.math.BigDecimal;

import battle.BattleSetting;
import heroes.Hero;

/**
 * Poison effect
 *
 */
public class Poison extends TemporaryEffect {

  public Poison(BattleSetting setting, Integer remainingRounds, Hero source, BigDecimal strength) {
    super(h -> h.damage(setting, source, strength), h -> h.damage(setting, source, strength), h -> null, "Poison",
        remainingRounds);
  }

}

// end of file
