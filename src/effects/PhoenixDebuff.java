package effects;

import heroes.Hero;

/**
 * This is the (non-stackable) -15% attack debuff of phoenix's auto-attack.
 */
public class PhoenixDebuff extends AttackDebuff {

  /**
   * the source hero of this effect
   */
  private final Hero source;

  /**
   * @param remainingRounds
   *        remaining rounds of phoenix's attack debuff
   * @param amount
   *        amount to debuff
   */
  public PhoenixDebuff(Integer remainingRounds, Hero source, double amount) {
    super(remainingRounds, amount);
    this.source = source;
  }

  /**
   * @return the source hero of this effect
   */
  public Hero getSource() {
    return source;
  }

}
