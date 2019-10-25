package loadout.equipment;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * This describes all armor rarities
 */
public enum EquipmentRarity {
  /** no equipment */
  NONE("None", new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
  /** green 2 star */
  GREEN2("Green 2★", new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
  /** blue 1 star */
  BLUE1("Blue 1★", new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
  /** blue 2 star */
  BLUE2("Blue 2★", new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
  /** yellow 1 star */
  YELLOW1("Yellow 1★", new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
  /** yellow 2 star */
  YELLOW2("Yellow 2★", new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0")),
  /** yellow 3 star */
  YELLOW3("Yellow 3★", new BigDecimal("0.025"), new BigDecimal("0.0305"), new BigDecimal("0.005")),
  /** purple 1 star */
  PURPLE1("Purple 1★", new BigDecimal("0.045"), new BigDecimal("0.051"), new BigDecimal("0.015")),
  /** purple 2 star */
  PURPLE2("Purple 2★", new BigDecimal("0.055"), new BigDecimal("0.0715"), new BigDecimal("0.035")),
  /** purple 3 star */
  PURPLE3("Purple 3★", new BigDecimal("0.075"), new BigDecimal("0.092"), new BigDecimal("0.035")),
  /** purple 4 star */
  PURPLE4("Purple 4★", new BigDecimal("0.085"), new BigDecimal("0.1125"), new BigDecimal("0.045")),
  /** orange 1 star */
  ORANGE1("Orange 1★", new BigDecimal("0.105"), new BigDecimal("0.133"), new BigDecimal("0.045")),
  /** orange 2 star */
  ORANGE2("Orange 2★", new BigDecimal("0.115"), new BigDecimal("0.1535"), new BigDecimal("0.055")),
  /** orange 3 star */
  ORANGE3("Orange 3★", new BigDecimal("0.125"), new BigDecimal("0.174"), new BigDecimal("0.065")),
  /** orange 4 star */
  ORANGE4("Orange 4★", new BigDecimal("0.145"), new BigDecimal("0.1945"), new BigDecimal("0.065")),;

  /** the hp bonus a set of two equipment items of this rarity yields */
  private final BigDecimal twoSetHPBonus;
  /** the attack bonus a set of three equipment items of this rarity yields */
  private final BigDecimal threeSetAttackBonus;
  /** the hp bonus a set of four equipment items of this rarity yields */
  private final BigDecimal fourSetHPBonus;
  /** the human-readable name of this rarity */
  private final String name;

  /**
   * Constructor setting all the properties
   * 
   * @param name
   *        human readable name of the rarity
   * @param twoSetBonus
   *        the hp bonus a set of two equipment items of this rarity yields
   * @param threeSetBonus
   *        the attack bonus a set of three equipment items of this rarity yields
   * @param fourSetBonus
   *        hp bonus a set of four equipment items of this rarity yields
   */
  private EquipmentRarity(String name, BigDecimal twoSetBonus, BigDecimal threeSetBonus, BigDecimal fourSetBonus) {
    this.name = name;
    this.twoSetHPBonus = twoSetBonus;
    this.threeSetAttackBonus = threeSetBonus;
    this.fourSetHPBonus = fourSetBonus;
  }

  /**
   * Apply the set bonus for a number of set pieces
   * 
   * @param hero
   *        hero to apply the set bonus to
   * @param numberOfPieces
   *        number of pieces equipped of this rarity
   */
  public void applyBonus(Hero hero, long numberOfPieces) {
    BigDecimal maxHPModifier = new BigDecimal(0);
    BigDecimal attackModifier = new BigDecimal(0);
    if (numberOfPieces >= 2) {
      maxHPModifier = maxHPModifier.add(twoSetHPBonus);
    }
    if (numberOfPieces >= 3) {
      attackModifier = attackModifier.add(threeSetAttackBonus);
    }
    if (numberOfPieces >= 4) {
      maxHPModifier = maxHPModifier.add(fourSetHPBonus);
    }
    hero.addMaxHPModifier(maxHPModifier);
    hero.addAttackModifier(attackModifier);
  }

  /**
   * @return the human-readable name of this rarity
   */
  public String getName() {
    return name;
  }

}

// end of file
