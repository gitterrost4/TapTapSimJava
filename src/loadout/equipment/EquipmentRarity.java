package loadout.equipment;

import java.math.BigDecimal;
import java.util.function.Consumer;

import heroes.Hero;

/** 
 * This describes all armor rarities
 *
 */
public enum EquipmentRarity {
  NONE(hero->{},hero->{},hero->{}),
  GREEN2(hero->{},hero->{},hero->{}),
  BLUE1(hero->{},hero->{},hero->{}),
  BLUE2(hero->{},hero->{},hero->{}),
  YELLOW1(hero->{},hero->{},hero->{}),
  YELLOW2(hero->{},hero->{},hero->{}),
  YELLOW3(hero->hero.addMaxHPModifier(new BigDecimal(1.025)),hero->hero.addAttackModifier(new BigDecimal(1.0305)),hero->hero.addMaxHPModifier(new BigDecimal(1.005))),
  PURPLE1(hero->hero.addMaxHPModifier(new BigDecimal(1.045)),hero->hero.addAttackModifier(new BigDecimal(1.051)),hero->hero.addMaxHPModifier(new BigDecimal(1.015))),
  PURPLE2(hero->hero.addMaxHPModifier(new BigDecimal(1.055)),hero->hero.addAttackModifier(new BigDecimal(1.0715)),hero->hero.addMaxHPModifier(new BigDecimal(1.035))),
  PURPLE3(hero->hero.addMaxHPModifier(new BigDecimal(1.075)),hero->hero.addAttackModifier(new BigDecimal(1.092)),hero->hero.addMaxHPModifier(new BigDecimal(1.035))),
  PURPLE4(hero->hero.addMaxHPModifier(new BigDecimal(1.085)),hero->hero.addAttackModifier(new BigDecimal(1.1125)),hero->hero.addMaxHPModifier(new BigDecimal(1.045))),
  ORANGE1(hero->hero.addMaxHPModifier(new BigDecimal(1.105)),hero->hero.addAttackModifier(new BigDecimal(1.133)),hero->hero.addMaxHPModifier(new BigDecimal(1.045))),
  ORANGE2(hero->hero.addMaxHPModifier(new BigDecimal(1.115)),hero->hero.addAttackModifier(new BigDecimal(1.1535)),hero->hero.addMaxHPModifier(new BigDecimal(1.055))),
  ORANGE3(hero->hero.addMaxHPModifier(new BigDecimal(1.125)),hero->hero.addAttackModifier(new BigDecimal(1.174)),hero->hero.addMaxHPModifier(new BigDecimal(1.065))),
  ORANGE4(hero->hero.addMaxHPModifier(new BigDecimal(1.145)),hero->hero.addAttackModifier(new BigDecimal(1.1945)),hero->hero.addMaxHPModifier(new BigDecimal(1.065))),
  ;
  private final Consumer<Hero> twoSetBonus;
  private final Consumer<Hero> threeSetBonus;
  private final Consumer<Hero> fourSetBonus;
  
  private EquipmentRarity(Consumer<Hero> twoSetBonus, Consumer<Hero> threeSetBonus, Consumer<Hero> fourSetBonus) {
    this.twoSetBonus=twoSetBonus;
    this.threeSetBonus=threeSetBonus;
    this.fourSetBonus=fourSetBonus;
  }
  
  /**
   * Apply the set bonus for a number of set pieces
   * 
   * @param hero
   * @param numberOfPieces
   */
  public void applyBonus(Hero hero,long numberOfPieces) {
    if(numberOfPieces>=2) {
      twoSetBonus.accept(hero);
    }
    if(numberOfPieces>=3) {
      threeSetBonus.accept(hero);
    }
    if(numberOfPieces>=4) {
      fourSetBonus.accept(hero);
    }
  }
}


// end of file
