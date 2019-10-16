package loadout.equipment;

import java.math.BigDecimal;

import heroes.Hero;

/** 
 * This describes all armor rarities
 *
 */
public enum EquipmentRarity {
  NONE(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0")),
  GREEN2(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0")),
  BLUE1(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0")),
  BLUE2(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0")),
  YELLOW1(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0")),
  YELLOW2(new BigDecimal("0"),new BigDecimal("0"),new BigDecimal("0")),
  YELLOW3(new BigDecimal("0.025"),new BigDecimal("0.0305"),new BigDecimal("0.005")),
  PURPLE1(new BigDecimal("0.045"),new BigDecimal("0.051"),new BigDecimal("0.015")),
  PURPLE2(new BigDecimal("0.055"),new BigDecimal("0.0715"),new BigDecimal("0.035")),
  PURPLE3(new BigDecimal("0.075"),new BigDecimal("0.092"),new BigDecimal("0.035")),
  PURPLE4(new BigDecimal("0.085"),new BigDecimal("0.1125"),new BigDecimal("0.045")),
  ORANGE1(new BigDecimal("0.105"),new BigDecimal("0.133"),new BigDecimal("0.045")),
  ORANGE2(new BigDecimal("0.115"),new BigDecimal("0.1535"),new BigDecimal("0.055")),
  ORANGE3(new BigDecimal("0.125"),new BigDecimal("0.174"),new BigDecimal("0.065")),
  ORANGE4(new BigDecimal("0.145"),new BigDecimal("0.1945"),new BigDecimal("0.065")),
  ;
  private final BigDecimal twoSetHPBonus;
  private final BigDecimal threeSetAttackBonus;
  private final BigDecimal fourSetHPBonus;
  
  private EquipmentRarity(BigDecimal twoSetBonus, BigDecimal threeSetBonus, BigDecimal fourSetBonus) {
    this.twoSetHPBonus=twoSetBonus;
    this.threeSetAttackBonus=threeSetBonus;
    this.fourSetHPBonus=fourSetBonus;
  }
  
  /**
   * Apply the set bonus for a number of set pieces
   * 
   * @param hero
   * @param numberOfPieces
   */
  public void applyBonus(Hero hero,long numberOfPieces) {
    System.err.println("handling set bonus "+numberOfPieces);
    BigDecimal maxHPModifier = new BigDecimal(0);
    BigDecimal attackModifier = new BigDecimal(0);
    if(numberOfPieces>=2) {
      maxHPModifier = maxHPModifier.add(twoSetHPBonus);
    }
    if(numberOfPieces>=3) {
      attackModifier = attackModifier.add(threeSetAttackBonus);
    }
    if(numberOfPieces>=4) {
      maxHPModifier = maxHPModifier.add(fourSetHPBonus);
    }
    hero.addMaxHPModifier(maxHPModifier);
    hero.addAttackModifier(attackModifier);
  }
}


// end of file
