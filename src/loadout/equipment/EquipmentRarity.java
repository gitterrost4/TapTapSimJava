package loadout.equipment;

import heroes.Hero;

/**
 * This describes all armor rarities
 */
public enum EquipmentRarity {
  /** no equipment */
  NONE("None", 0, 0, 0),
  /** green 2 star */
  GREEN2("Green 2★", 0, 0, 0),
  /** blue 1 star */
  BLUE1("Blue 1★", 0, 0, 0),
  /** blue 2 star */
  BLUE2("Blue 2★", 0, 0, 0),
  /** yellow 1 star */
  YELLOW1("Yellow 1★", 0, 0, 0),
  /** yellow 2 star */
  YELLOW2("Yellow 2★", 0, 0, 0),
  /** yellow 3 star */
  YELLOW3("Yellow 3★", 0.025, 0.0305, 0.005),
  /** purple 1 star */
  PURPLE1("Purple 1★", 0.045, 0.051, 0.015),
  /** purple 2 star */
  PURPLE2("Purple 2★", 0.055, 0.0715, 0.035),
  /** purple 3 star */
  PURPLE3("Purple 3★", 0.075, 0.092, 0.035),
  /** purple 4 star */
  PURPLE4("Purple 4★", 0.085, 0.1125, 0.045),
  /** orange 1 star */
  ORANGE1("Orange 1★", 0.105, 0.133, 0.045),
  /** orange 2 star */
  ORANGE2("Orange 2★", 0.115, 0.1535, 0.055),
  /** orange 3 star */
  ORANGE3("Orange 3★", 0.125, 0.174, 0.065),
  /** orange 4 star */
  ORANGE4("Orange 4★", 0.145, 0.1945, 0.065),;

  /** the hp bonus a set of two equipment items of this rarity yields */
  private final double twoSetHPBonus;
  /** the attack bonus a set of three equipment items of this rarity yields */
  private final double threeSetAttackBonus;
  /** the hp bonus a set of four equipment items of this rarity yields */
  private final double fourSetHPBonus;
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
  private EquipmentRarity(String name, double twoSetBonus, double threeSetBonus, double fourSetBonus) {
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
    double maxHPModifier = 0;
    double attackModifier = 0;
    if (numberOfPieces >= 2) {
      maxHPModifier += twoSetHPBonus;
    }
    if (numberOfPieces >= 3) {
      attackModifier += threeSetAttackBonus;
    }
    if (numberOfPieces >= 4) {
      maxHPModifier += fourSetHPBonus;
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
