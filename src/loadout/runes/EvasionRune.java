package loadout.runes;

import heroes.Hero;

/**
 * implementation of the evasion rune
 * 
 * @author gitterrost4
 */
public class EvasionRune extends AbstractRune {
  private final double dodgeRateBonus;
  private final Integer maxHPBonus;
  private final double maxHPModifier;

  public EvasionRune(RuneRarity rarity) {
    super(RuneType.EVASION, rarity);
    switch (rarity) {
    case GOLD1:
      dodgeRateBonus = 0.036;
      maxHPBonus = 236;
      maxHPModifier = 0;
      break;
    case GOLD2:
      dodgeRateBonus = 0.046;
      maxHPBonus = 309;
      maxHPModifier = 0;
      break;
    case GOLD3:
      dodgeRateBonus = 0.057;
      maxHPBonus = 383;
      maxHPModifier = 0;
      break;
    case PURPLE1:
      dodgeRateBonus = 0.073;
      maxHPBonus = 437;
      maxHPModifier = 0;
      break;
    case PURPLE2:
      dodgeRateBonus = 0.084;
      maxHPBonus = 517;
      maxHPModifier = 0;
      break;
    case PURPLE3:
      dodgeRateBonus = 0.095;
      maxHPBonus = 599;
      maxHPModifier = 0;
      break;
    case ORANGE1:
      dodgeRateBonus = 0.111;
      maxHPBonus = 786;
      maxHPModifier = 0;
      break;
    case ORANGE2:
      dodgeRateBonus = 0.122;
      maxHPBonus = 917;
      maxHPModifier = 0;
      break;
    case ORANGE3:
      dodgeRateBonus = 0.133;
      maxHPBonus = 1060;
      maxHPModifier = 0;
      break;
    case ORANGE4:
      dodgeRateBonus = 0.144;
      maxHPBonus = 1204;
      maxHPModifier = 0;
      break;
    case RED1:
      dodgeRateBonus = 0.161;
      maxHPBonus = 0;
      maxHPModifier = 0.097;
      break;
    case RED2:
      dodgeRateBonus = 0.173;
      maxHPBonus = 0;
      maxHPModifier = 0.13;
      break;
    default:
      dodgeRateBonus = 0;
      maxHPBonus = 0;
      maxHPModifier = 0;
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
