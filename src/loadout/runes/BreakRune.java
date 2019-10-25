package loadout.runes;

import heroes.Hero;

/**
 * representation of the break rune
 * 
 * @author gitterrost4
 */
public class BreakRune extends AbstractRune {

  private final double defenseBreakBonus;
  private final Integer attackBonus;
  private final double attackModifier;

  public BreakRune(RuneRarity rarity) {
    super(RuneType.BREAK, rarity);
    switch (rarity) {
    case GOLD1:
      defenseBreakBonus = 2;
      attackBonus = 32;
      attackModifier = 0;
      break;
    case GOLD2:
      defenseBreakBonus = 3;
      attackBonus = 40;
      attackModifier = 0;
      break;
    case GOLD3:
      defenseBreakBonus = 4;
      attackBonus = 48;
      attackModifier = 0;
      break;
    case PURPLE1:
      defenseBreakBonus = 5;
      attackBonus = 59;
      attackModifier = 0;
      break;
    case PURPLE2:
      defenseBreakBonus = 6;
      attackBonus = 69;
      attackModifier = 0;
      break;
    case PURPLE3:
      defenseBreakBonus = 7;
      attackBonus = 80;
      attackModifier = 0;
      break;
    case ORANGE1:
      defenseBreakBonus = 8;
      attackBonus = 95;
      attackModifier = 0;
      break;
    case ORANGE2:
      defenseBreakBonus = 10;
      attackBonus = 111;
      attackModifier = 0;
      break;
    case ORANGE3:
      defenseBreakBonus = 11;
      attackBonus = 128;
      attackModifier = 0;
      break;
    case ORANGE4:
      defenseBreakBonus = 12;
      attackBonus = 145;
      attackModifier = 0;
      break;
    case RED1:
      defenseBreakBonus = 13;
      attackBonus = 167;
      attackModifier = 0.075;
      break;
    case RED2:
      defenseBreakBonus = 14;
      attackBonus = 168;
      attackModifier = 0.097;
      break;
    default:
      defenseBreakBonus = 0;
      attackBonus = 0;
      attackModifier = 0;
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(attackModifier);
    hero.increaseAttack(attackBonus);
    hero.increaseDefenseBreak(defenseBreakBonus);
  }
}
