// $Id $
package loadout.runes;

import heroes.Hero;

/**
 * implementation of the vitality rune
 */
public class VitalityRune extends AbstractRune {
  private final double maxHPModifier;
  private final Integer maxHPBonus;
  private final double attackModifier;

  public VitalityRune(RuneRarity rarity) {
    super(RuneType.VITALITY, rarity);
    switch (rarity) {
    case ORANGE1:
      maxHPBonus = 1271;
      maxHPModifier = 0.148;
      attackModifier = 0.021;
      break;
    case ORANGE2:
      maxHPBonus = 1436;
      maxHPModifier = 0.17;
      attackModifier = 0.027;
      break;
    case ORANGE3:
      maxHPBonus = 1630;
      maxHPModifier = 0.192;
      attackModifier = 0.032;
      break;
    case ORANGE4:
      maxHPBonus = 1851;
      maxHPModifier = 0.214;
      attackModifier = 0.037;
      break;
    case RED1:
      maxHPBonus = 2102;
      maxHPModifier = 0.247;
      attackModifier = 0.054;
      break;
    case RED2:
      maxHPBonus = 2419;
      maxHPModifier = 0.27;
      attackModifier = 0.065;
      break;
    default:
      maxHPModifier = 0;
      maxHPBonus = 0;
      attackModifier = 0;
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(attackModifier);
    hero.addMaxHPModifier(maxHPModifier);
    hero.increaseMaxHP(maxHPBonus);
  }

}

// end of file
