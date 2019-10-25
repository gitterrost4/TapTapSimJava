package effects;

import java.math.BigDecimal;

import battle.BattleSetting;
import heroes.Hero;

/**
 * Poison effect
 *
 */
public class Poison extends TemporaryEffect {

  public Poison(BattleSetting setting, Integer remainingRounds, Hero source, BigDecimal skillStrength) {
    //TODO: implement this
    super(h -> h.receiveAttack(setting,source,skillStrength,false,false,x->null),h -> h.receiveAttack(setting,source,skillStrength,false,false,x->null), h -> null, "Poison",
        remainingRounds);
  }

}

// end of file
