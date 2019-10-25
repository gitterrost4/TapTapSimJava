package loadout.runes;

import heroes.Hero;

/**
 * Implementation of the critrate rune
 * 
 * @author gitterrost4
 */
public class CritrateRune extends AbstractRune {
  private final double critRateBonus;
  private final Integer maxHPBonus;
  private final double maxHPModifier;

  public CritrateRune(RuneRarity rarity) {
    super(RuneType.CRITRATE, rarity);
    switch (rarity) {
    case GREEN1:
      critRateBonus = 0.02;
      maxHPBonus = 76;
      maxHPModifier = 0;
      break;
    case GREEN2:
      critRateBonus = 0.031;
      maxHPBonus = 153;
      maxHPModifier = 0;
      break;
    case GOLD1:
      critRateBonus = 0.051;
      maxHPBonus = 236;
      maxHPModifier = 0;
      break;
    case GOLD2:
      critRateBonus = 0.062;
      maxHPBonus = 309;
      maxHPModifier = 0;
      break;
    case GOLD3:
      critRateBonus = 0.072;
      maxHPBonus = 383;
      maxHPModifier = 0;
      break;
    case PURPLE1:
      critRateBonus = 0.094;
      maxHPBonus = 437;
      maxHPModifier = 0;
      break;
    case PURPLE2:
      critRateBonus = 0.105;
      maxHPBonus = 517;
      maxHPModifier = 0;
      break;
    case PURPLE3:
      critRateBonus = 0.116;
      maxHPBonus = 599;
      maxHPModifier = 0;
      break;
    case ORANGE1:
      critRateBonus = 0.137;
      maxHPBonus = 786;
      maxHPModifier = 0;
      break;
    case ORANGE2:
      critRateBonus = 0.148;
      maxHPBonus = 917;
      maxHPModifier = 0;
      break;
    case ORANGE3:
      critRateBonus = 0.16;
      maxHPBonus = 1060;
      maxHPModifier = 0;
      break;
    case ORANGE4:
      critRateBonus = 0.171;
      maxHPBonus = 1204;
      maxHPModifier = 0;
      break;
    case RED1:
      critRateBonus = 0.194;
      maxHPBonus = 0;
      maxHPModifier = 0.108;
      break;
    case RED2:
      critRateBonus = 0.205;
      maxHPBonus = 0;
      maxHPModifier = 0.14;
      break;
    default:
      critRateBonus = 0.;
      maxHPBonus = 0;
      maxHPModifier = 0;
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseCritRate(critRateBonus);
    hero.increaseMaxHP(maxHPBonus);
    hero.addMaxHPModifier(maxHPModifier);
  }
}
