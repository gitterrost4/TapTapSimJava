package effects;

import java.math.BigDecimal;

import battle.BattleSetting;
import heroes.Hero;

/**
 * Burn effect
 *
 */
public class Burn extends TemporaryEffect {

  public Burn(BattleSetting setting, Integer remainingRounds, Hero source, BigDecimal skillStrength) {
    super(h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null),
        h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null), h -> null, "Poison",
        remainingRounds);
  }

}

// end of file
