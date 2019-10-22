// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * implementation of the vitality rune
 *
 */
public class VitalityRune extends AbstractRune {
  private final BigDecimal maxHPModifier;
  private final Integer maxHPBonus;
  private final BigDecimal attackModifier;

  public VitalityRune(RuneRarity rarity) {
    switch (rarity) {
    case ORANGE1:
      maxHPBonus=1271;
      maxHPModifier = new BigDecimal("0.148");
      attackModifier = new BigDecimal("0.021");
      break;
    case ORANGE2:
      maxHPBonus = 1436;
      maxHPModifier = new BigDecimal("0.17");
      attackModifier = new BigDecimal("0.027");
      break;
    case ORANGE3:
      maxHPBonus=1630;
      maxHPModifier = new BigDecimal("0.192");
      attackModifier = new BigDecimal("0.032");
      break;
    case ORANGE4:
      maxHPBonus=1851;
      maxHPModifier = new BigDecimal("0.214");
      attackModifier = new BigDecimal("0.037");
      break;
    case RED1:
      maxHPBonus=2102;
      maxHPModifier = new BigDecimal("0.247");
      attackModifier = new BigDecimal("0.054");
      break;
    case RED2:
      maxHPBonus=2419;
      maxHPModifier = new BigDecimal("0.27");
      attackModifier = new BigDecimal("0.065");
      break;
    default:
      maxHPModifier = new BigDecimal("0");
      maxHPBonus = 0;
      attackModifier = new BigDecimal("0");
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
