package effects;

import battle.BattleSetting;
import heroes.Hero;

/**
 * Burn effect
 */
public class Burn extends TemporaryEffect {

  public Burn(BattleSetting setting, Integer remainingRounds, Hero source, double skillStrength) {
    super(h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null),
        h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null), h -> null, "Poison",
        remainingRounds);
  }

}

// end of file
