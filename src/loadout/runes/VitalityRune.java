// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/** 
 * implementation of the accuracy rune
 *
 */
public class VitalityRune extends AbstractRune {
  private final BigDecimal maxHPModifier;
  private final Integer maxHPBonus;
  private final BigDecimal attackModifier;
  public VitalityRune(RuneRarity rarity) {
    switch(rarity) {
    case ORANGE2:
      maxHPModifier=new BigDecimal("0.17");
      maxHPBonus=1436;
      attackModifier=new BigDecimal("0.027");
      break;
    default:
      maxHPModifier=new BigDecimal("0");
      maxHPBonus=0;
      attackModifier=new BigDecimal("0");
      break;
    
    }
  }

  @Override
  public void apply(Hero hero) {
    System.err.println("handling rune");
    hero.addAttackModifier(attackModifier);
    hero.addMaxHPModifier(maxHPModifier);
    hero.increaseMaxHP(maxHPBonus);
  }

}


// end of file
