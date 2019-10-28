package effects;

import battle.BattleSetting;
import heroes.Hero;

/**
 * Poison effect
 */
public class Poison extends TemporaryEffect {

  public Poison(BattleSetting setting, Integer remainingRounds, Hero source, double skillStrength) {
    super(h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null)._1,
        h -> h.receiveAttack(setting, source, skillStrength, false, false, x -> null)._1, h -> null, "Poison",
        remainingRounds);
  }

}

// end of file
