package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * implementation of the skilldmg rune
 * 
 * @author gitterrost4
 *
 */
public class SkilldmgRune extends AbstractRune {

  private BigDecimal skillDamageBonus;
  private BigDecimal hitRateBonus;

  public SkilldmgRune(RuneRarity rarity) {
    switch (rarity) {
    case PURPLE1:
      skillDamageBonus = new BigDecimal("0.104");
      hitRateBonus = new BigDecimal("0.031");
      break;
    case PURPLE2:
      skillDamageBonus = new BigDecimal("0.12");
      hitRateBonus = new BigDecimal("0.042");
      break;
    case PURPLE3:
      skillDamageBonus = new BigDecimal("0.147");
      hitRateBonus = new BigDecimal("0.053");
      break;
    case ORANGE1:
      skillDamageBonus = new BigDecimal("0.164");
      hitRateBonus = new BigDecimal("0.074");
      break;
    case ORANGE2:
      skillDamageBonus = new BigDecimal("0.18");
      hitRateBonus = new BigDecimal("0.085");
      break;
    case ORANGE3:
      skillDamageBonus = new BigDecimal("0.197");
      hitRateBonus = new BigDecimal("0.096");
      break;
    case ORANGE4:
      skillDamageBonus = new BigDecimal("0.214");
      hitRateBonus = new BigDecimal("0.107");
      break;
    case RED1:
      skillDamageBonus = new BigDecimal("0.258");
      hitRateBonus = new BigDecimal("0.129");
      break;
    case RED2:
      skillDamageBonus = new BigDecimal("0.281");
      hitRateBonus = new BigDecimal("0.14");
      break;
    default:
      skillDamageBonus = new BigDecimal("0");
      hitRateBonus = new BigDecimal("0");
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseSkillDamage(skillDamageBonus);
    hero.increaseHitRate(hitRateBonus);
  }
}
