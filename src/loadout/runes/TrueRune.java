package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * implementation of the true rune
 * 
 * @author gitterrost4
 *
 */
public class TrueRune extends AbstractRune {

  private final BigDecimal trueDamageBonus;
  private final Integer attackBonus;
  private final BigDecimal maxHPModifier;

  public TrueRune(RuneRarity rarity) {
    super(RuneType.TRUE, rarity);
    switch (rarity) {
    case ORANGE1:
      trueDamageBonus = new BigDecimal("0.116");
      attackBonus = 95;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE2:
      trueDamageBonus = new BigDecimal("0.138");
      attackBonus = 111;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE3:
      trueDamageBonus = new BigDecimal("0.16");
      attackBonus = 128;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE4:
      trueDamageBonus = new BigDecimal("0.182");
      attackBonus = 145;
      maxHPModifier = new BigDecimal("0");
      break;
    case RED1:
      trueDamageBonus = new BigDecimal("0.215");
      attackBonus = 167;
      maxHPModifier = new BigDecimal("0.097");
      break;
    case RED2:
      trueDamageBonus = new BigDecimal("0.238");
      attackBonus = 168;
      maxHPModifier = new BigDecimal("0.13");
      break;
    default:
      trueDamageBonus = new BigDecimal("0");
      attackBonus = 0;
      maxHPModifier = new BigDecimal("0");
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseTrueDamage(trueDamageBonus);
    hero.increaseAttack(attackBonus);
    hero.addMaxHPModifier(maxHPModifier);
  }
}
