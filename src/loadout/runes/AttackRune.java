package loadout.runes;

import heroes.Hero;

/**
 * Representation of the attack rune
 * 
 * @author gitterrost4
 */
public class AttackRune extends AbstractRune {

  private Integer attackBonus;
  private double attackModifier;

  public AttackRune(RuneRarity rarity) {
    super(RuneType.ATTACK, rarity);
    switch (rarity) {
    case BLUE1:
      attackBonus = 14;
      break;
    case BLUE2:
      attackBonus = 18;
      break;
    case GREEN1:
      attackBonus = 28;
      break;
    case GREEN2:
      attackBonus = 38;
      break;
    case GOLD1:
      attackBonus = 54;
      attackModifier = 0.041;
      break;
    case GOLD2:
      attackBonus = 70;
      attackModifier = 0.052;
      break;
    case GOLD3:
      attackBonus = 86;
      attackModifier = 0.062;
      break;
    case PURPLE1:
      attackBonus = 117;
      attackModifier = 0.083;
      break;
    case PURPLE2:
      attackBonus = 131;
      attackModifier = 0.099;
      break;
    case PURPLE3:
      attackBonus = 147;
      attackModifier = 0.116;
      break;
    case ORANGE1:
      attackBonus = 169;
      attackModifier = 0.142;
      break;
    case ORANGE2:
      attackBonus = 191;
      attackModifier = 0.159;
      break;
    case ORANGE3:
      attackBonus = 213;
      attackModifier = 0.176;
      break;
    case ORANGE4:
      attackBonus = 236;
      attackModifier = 0.193;
      break;
    case RED1:
      attackBonus = 274;
      attackModifier = 0.22;
      break;
    case RED2:
      attackBonus = 324;
      attackModifier = 0.238;
      break;
    default:
      attackBonus = 0;
      attackModifier = 0.0;
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(attackModifier);
    hero.increaseAttack(attackBonus);
  }
}
