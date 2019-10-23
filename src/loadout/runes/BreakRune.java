package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * representation of the break rune
 * 
 * @author gitterrost4
 *
 */
public class BreakRune extends AbstractRune {

  private final BigDecimal defenseBreakBonus;
  private final Integer attackBonus;
  private final BigDecimal attackModifier;

  public BreakRune(RuneRarity rarity) {
    super(RuneType.BREAK, rarity);
    switch (rarity) {
    case GOLD1:
      defenseBreakBonus = new BigDecimal("2");
      attackBonus = 32;
      attackModifier = new BigDecimal("0");
      break;
    case GOLD2:
      defenseBreakBonus = new BigDecimal("3");
      attackBonus = 40;
      attackModifier = new BigDecimal("0");
      break;
    case GOLD3:
      defenseBreakBonus = new BigDecimal("4");
      attackBonus = 48;
      attackModifier = new BigDecimal("0");
      break;
    case PURPLE1:
      defenseBreakBonus = new BigDecimal("5");
      attackBonus = 59;
      attackModifier = new BigDecimal("0");
      break;
    case PURPLE2:
      defenseBreakBonus = new BigDecimal("6");
      attackBonus = 69;
      attackModifier = new BigDecimal("0");
      break;
    case PURPLE3:
      defenseBreakBonus = new BigDecimal("7");
      attackBonus = 80;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE1:
      defenseBreakBonus = new BigDecimal("8");
      attackBonus = 95;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE2:
      defenseBreakBonus = new BigDecimal("10");
      attackBonus = 111;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE3:
      defenseBreakBonus = new BigDecimal("11");
      attackBonus = 128;
      attackModifier = new BigDecimal("0");
      break;
    case ORANGE4:
      defenseBreakBonus = new BigDecimal("12");
      attackBonus = 145;
      attackModifier = new BigDecimal("0");
      break;
    case RED1:
      defenseBreakBonus = new BigDecimal("13");
      attackBonus = 167;
      attackModifier = new BigDecimal("0.075");
      break;
    case RED2:
      defenseBreakBonus = new BigDecimal("14");
      attackBonus = 168;
      attackModifier = new BigDecimal("0.097");
      break;
    default:
      defenseBreakBonus = new BigDecimal("0");
      attackBonus = 0;
      attackModifier = new BigDecimal("0");
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
