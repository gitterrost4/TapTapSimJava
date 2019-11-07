package effects;

/**
 * This is the (non-stackable) -15% attack debuff of phoenix's auto-attack.
 */
public class AttackDebuff extends TemporaryEffect {

  /**
   * @param remainingRounds
   *        how long the effect lasts
   * @param amount
   *        amount to debuff
   */
  public AttackDebuff(Integer remainingRounds, double amount) {
    super(h -> h.removeAttackModifier(amount), h -> null, h -> h.addAttackModifier(amount),
        "Removing " + amount * 100 + "% of attack", remainingRounds);
  }

}

// end of file
