// $Id $
package loadout.runes;

import heroes.Hero;

/**
 * implementation of the accuracy rune
 */
public class AccuracyRune extends AbstractRune {
  /** the hitRate bonus of this rune */
  private final double hitRate;
  /** the flat attack bonus of this rune */
  private final Integer attackBonus;
  /** the attack modifier of this rune */
  private final double attackModifier;

  /**
   * create an accuracy rune of a given rarity
   * 
   * @param rarity
   *        the rarity of the rune
   */
  public AccuracyRune(RuneRarity rarity) {
    super(RuneType.ACCURACY, rarity);
    switch (rarity) {
    case GREEN1:
      hitRate = 0.02;
      attackBonus = 13;
      attackModifier = 0;
      break;
    case GREEN2:
      hitRate = 0.031;
      attackBonus = 18;
      attackModifier = 0;
      break;
    case GOLD1:
      hitRate = 0.051;
      attackBonus = 32;
      attackModifier = 0;
      break;
    case GOLD2:
      hitRate = 0.062;
      attackBonus = 40;
      attackModifier = 0;
      break;
    case GOLD3:
      hitRate = 0.072;
      attackBonus = 48;
      attackModifier = 0;
      break;
    case PURPLE1:
      hitRate = 0.094;
      attackBonus = 59;
      attackModifier = 0;
      break;
    case PURPLE2:
      hitRate = 0.105;
      attackBonus = 69;
      attackModifier = 0;
      break;
    case PURPLE3:
      hitRate = 0.116;
      attackBonus = 80;
      attackModifier = 0;
      break;
    case ORANGE1:
      hitRate = 0.137;
      attackBonus = 95;
      attackModifier = 0;
      break;
    case ORANGE2:
      hitRate = 0.148;
      attackBonus = 111;
      attackModifier = 0;
      break;
    case ORANGE3:
      hitRate = 0.16;
      attackBonus = 128;
      attackModifier = 0.032;
      break;
    case ORANGE4:
      hitRate = 0.171;
      attackBonus = 145;
      attackModifier = 0.054;
      break;
    case RED1:
      hitRate = 0.194;
      attackBonus = 167;
      attackModifier = 0.075;
      break;
    case RED2:
      hitRate = 0.205;
      attackBonus = 168;
      attackModifier = 0.097;
      break;
    default:
      hitRate = 0;
      attackBonus = 0;
      attackModifier = 0;
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
