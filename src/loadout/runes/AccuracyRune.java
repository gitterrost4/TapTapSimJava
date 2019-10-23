// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * implementation of the accuracy rune
 *
 */
public class AccuracyRune extends AbstractRune {
  private final BigDecimal hitRate;
  private final Integer attackBonus;
  private final BigDecimal attackModifier;

  public AccuracyRune(RuneRarity rarity) {
    super(RuneType.ACCURACY, rarity);
    switch (rarity) {
    case GREEN1:
      hitRate = new BigDecimal("0.02");
      attackBonus = 13;
      attackModifier = new BigDecimal("0");
      break;
    case GREEN2:
      hitRate = new BigDecimal("0.031");
      attackBonus = 18;
      attackModifier = new BigDecimal("0");
      break;
    case GOLD1:
      hitRate = new BigDecimal("0.051");
      attackBonus = 32;
      attackModifier = new BigDecimal("0");
      break;
    case GOLD2:
      hitRate = new BigDecimal("0.062");
      attackBonus = 40;
      attackModifier = new BigDecimal("0");
      break;
    case GOLD3:
      hitRate = new BigDecimal("0.072");
      attackBonus = 48;
      attackModifier = new BigDecimal("0");
      break;
    case PURPLE1:
      hitRate = new BigDecimal("0.094");
      attackBonus = 59;
      attackModifier = new BigDecimal("0");
      break;
    case PURPLE2:
      hitRate = new BigDecimal("0.105");
      attackBonus = 69;
      attackModifier = new BigDecimal("0");
      break;
    case PURPLE3:
      hitRate = new BigDecimal("0.116");
      attackBonus = 80;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE1:
      hitRate = new BigDecimal("0.137");
      attackBonus = 95;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE2:
      hitRate = new BigDecimal("0.148");
      attackBonus = 111;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE3:
      hitRate = new BigDecimal("0.16");
      attackBonus = 128;
      attackModifier = new BigDecimal("0.032");
      break;
    case ORANGE4:
      hitRate = new BigDecimal("0.171");
      attackBonus = 145;
      attackModifier = new BigDecimal("0.054");
      break;
    case RED1:
      hitRate = new BigDecimal("0.194");
      attackBonus = 167;
      attackModifier = new BigDecimal("0.075");
      break;
    case RED2:
      hitRate = new BigDecimal("0.205");
      attackBonus = 168;
      attackModifier = new BigDecimal("0.097");
      break;
    default:
      hitRate = new BigDecimal("0");
      attackBonus = 0;
      attackModifier = new BigDecimal("0");
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(attackModifier);
    hero.increaseAttack(attackBonus);
    hero.increaseHitRate(hitRate);
  }

}

// end of file
