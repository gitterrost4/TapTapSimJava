package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * TODO: Documentation
 * 
 * @author gitterrost4
 *
 */
public class EvasionRune extends AbstractRune {
  private final BigDecimal dodgeRateBonus;
  private final Integer maxHPBonus;
  private final BigDecimal maxHPModifier;
  public EvasionRune(RuneRarity rarity) {
    switch (rarity) {
    case GOLD1:
      dodgeRateBonus = new BigDecimal("0.036");
      maxHPBonus = 236;
      maxHPModifier = new BigDecimal("0");
      break;
    case GOLD2:
      dodgeRateBonus = new BigDecimal("0.046");
      maxHPBonus = 309;
      maxHPModifier = new BigDecimal("0");
      break;
    case GOLD3:
      dodgeRateBonus = new BigDecimal("0.057");
      maxHPBonus = 383;
      maxHPModifier = new BigDecimal("0");
      break;
    case PURPLE1:
      dodgeRateBonus = new BigDecimal("0.073");
      maxHPBonus = 437;
      maxHPModifier = new BigDecimal("0");
      break;
    case PURPLE2:
      dodgeRateBonus = new BigDecimal("0.084");
      maxHPBonus = 517;
      maxHPModifier = new BigDecimal("0");
      break;
    case PURPLE3:
      dodgeRateBonus = new BigDecimal("0.095");
      maxHPBonus = 599;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE1:
      dodgeRateBonus = new BigDecimal("0.111");
      maxHPBonus = 786;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE2:
      dodgeRateBonus = new BigDecimal("0.122");
      maxHPBonus = 917;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE3:
      dodgeRateBonus = new BigDecimal("0.133");
      maxHPBonus = 1060;
      maxHPModifier = new BigDecimal("0");
      break;
    case ORANGE4:
      dodgeRateBonus = new BigDecimal("0.144");
      maxHPBonus = 1204;
      maxHPModifier = new BigDecimal("0");
      break;
    case RED1:
      dodgeRateBonus = new BigDecimal("0.161");
      maxHPBonus = 0;
      maxHPModifier = new BigDecimal("0.097");
      break;
    case RED2:
      dodgeRateBonus = new BigDecimal("0.173");
      maxHPBonus = 0;
      maxHPModifier = new BigDecimal("0.13");
      break;
    default:
      dodgeRateBonus = new BigDecimal("0");
      maxHPBonus = 0;
      maxHPModifier = new BigDecimal("0");
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseDodgeChance(dodgeRateBonus);
    hero.addMaxHPModifier(maxHPModifier);
    hero.increaseMaxHP(maxHPBonus);
  }
}
