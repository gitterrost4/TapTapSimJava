package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * implementation of the storm attack rune
 * 
 * @author gitterrost4
 *
 */
public class StormAttackRune extends AbstractRune {

  private Integer attackBonus;
  private BigDecimal attackModifier;
  private BigDecimal hitRateBonus;

  public StormAttackRune(RuneRarity rarity) {
    super(RuneType.STORMATTACK, rarity);
    switch (rarity) {
    case ORANGE1:
      attackBonus = 169;
      attackModifier = new BigDecimal("0.106");
      hitRateBonus = new BigDecimal("0.021");
      break;
    case ORANGE2:
      attackBonus = 191;
      attackModifier = new BigDecimal("0.117");
      hitRateBonus = new BigDecimal("0.027");
      break;
    case ORANGE3:
      attackBonus = 213;
      attackModifier = new BigDecimal("0.133");
      hitRateBonus = new BigDecimal("0.032");
      break;
    case ORANGE4:
      attackBonus = 236;
      attackModifier = new BigDecimal("0.15");
      hitRateBonus = new BigDecimal("0.037");
      break;
    case RED1:
      attackBonus = 258;
      attackModifier = new BigDecimal("0.167");
      hitRateBonus = new BigDecimal("0.048");
      break;
    case RED2:
      attackBonus = 281;
      attackModifier = new BigDecimal("0.184");
      hitRateBonus = new BigDecimal("0.054");
      break;
    default:
      attackBonus = 0;
      attackModifier = new BigDecimal("0");
      hitRateBonus = new BigDecimal("0");
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(attackModifier);
    hero.increaseAttack(attackBonus);
    hero.increaseHitRate(hitRateBonus);
  }
}
