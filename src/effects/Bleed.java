package effects;

import java.math.BigDecimal;

import battle.BattleSetting;
import heroes.Hero;

/**
 * Poison effect
 *
 */
public class Bleed extends TemporaryEffect {

  public Bleed(BattleSetting setting, Integer remainingRounds, Hero source, BigDecimal skillStrength) {
    super(h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null),
        h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null), h -> null, "Poison",
        remainingRounds);
  }

}

// end of file
