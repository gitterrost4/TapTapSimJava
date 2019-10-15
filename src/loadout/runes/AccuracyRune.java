// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/** 
 * implementation of the accuracy rune
 *
 */
public class AccuracyRune extends AbstractRune {
  private final Integer hitRate;
  private final Integer attackBonus;
  private final BigDecimal attackModifier;
  public AccuracyRune(RuneRarity rarity) {
    switch(rarity) {
    case RED2:
      hitRate=19;
      attackBonus=620;
      attackModifier=new BigDecimal(1.09);
      break;
    default:
      hitRate=0;
      attackBonus=0;
      attackModifier=new BigDecimal(1);
      break;
    
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(attackModifier);
    hero.increaseAttack(attackBonus);
    hero.increaseHitRate(hitRate);
  }

}


// end of file
