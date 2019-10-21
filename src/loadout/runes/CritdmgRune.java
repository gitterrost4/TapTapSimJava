package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * Representation of a Critdmg rune
 * 
 * @author gitterrost4
 *
 */
public class CritdmgRune extends AbstractRune {

  private BigDecimal critRateBonus;
  private BigDecimal critDamageBonus;

  public CritdmgRune(RuneRarity rarity) {
    switch (rarity) {
    case PURPLE1:
      critDamageBonus = new BigDecimal("0.104");
      critRateBonus = new BigDecimal("0.031");
      break;
    case PURPLE2:
      critDamageBonus = new BigDecimal("0.146");
      critRateBonus = new BigDecimal("0.042");
      break;
    case PURPLE3:
      critDamageBonus = new BigDecimal("0.189");
      critRateBonus = new BigDecimal("0.053");
      break;
    case ORANGE1:
      critDamageBonus = new BigDecimal("0.253");
      critRateBonus = new BigDecimal("0.074");
      break;
    case ORANGE2:
      critDamageBonus = new BigDecimal("0.276");
      critRateBonus = new BigDecimal("0.085");
      break;
    case ORANGE3:
      critDamageBonus = new BigDecimal("0.32");
      critRateBonus = new BigDecimal("0.096");
      break;
    case ORANGE4:
      critDamageBonus = new BigDecimal("0.364");
      critRateBonus = new BigDecimal("0.107");
      break;
    case RED1:
      critDamageBonus = new BigDecimal("0.43");
      critRateBonus = new BigDecimal("0.129");
      break;
    case RED2:
      critDamageBonus = new BigDecimal("0.475");
      critRateBonus = new BigDecimal("0.14");
      break;
    default:
      critDamageBonus = new BigDecimal("0");
      critRateBonus = new BigDecimal("0");
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseCritDamage(critDamageBonus);
    hero.increaseCritRate(critRateBonus);
  }
}
