package loadout.runes;

import heroes.Hero;

/**
 * implementation of the storm attack rune
 * 
 * @author gitterrost4
 */
public class StormAttackRune extends AbstractRune {

  private Integer attackBonus;
  private double attackModifier;
  private double hitRateBonus;

  public StormAttackRune(RuneRarity rarity) {
    super(RuneType.STORMATTACK, rarity);
    switch (rarity) {
    case ORANGE1:
      attackBonus = 169;
      attackModifier = 0.106;
      hitRateBonus = 0.021;
      break;
    case ORANGE2:
      attackBonus = 191;
      attackModifier = 0.117;
      hitRateBonus = 0.027;
      break;
    case ORANGE3:
      attackBonus = 213;
      attackModifier = 0.133;
      hitRateBonus = 0.032;
      break;
    case ORANGE4:
      attackBonus = 236;
      attackModifier = 0.15;
      hitRateBonus = 0.037;
      break;
    case RED1:
      attackBonus = 258;
      attackModifier = 0.167;
      hitRateBonus = 0.048;
      break;
    case RED2:
      attackBonus = 281;
      attackModifier = 0.184;
      hitRateBonus = 0.054;
      break;
    default:
      attackBonus = 0;
      attackModifier = 0;
      hitRateBonus = 0;
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
