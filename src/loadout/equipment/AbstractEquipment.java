// $Id $
package loadout.equipment;

import loadout.HeroModifier;

/**
 * Base class for the equipment pieces (helmet, armor, accessory, weapon)
 */
public abstract class AbstractEquipment implements HeroModifier {
  /** the rarity of the equipment item */
  private final EquipmentRarity rarity;

  /**
   * create a new equipment item, storing its rarity
   * 
   * @param rarity
   *        the rarity of the equipment item
   */
  public AbstractEquipment(EquipmentRarity rarity) {
    super();
    this.rarity = rarity;
  }

  /**
   * @return the rarity of the equipment item
   */
  public EquipmentRarity getRarity() {
    return rarity;
  }

}

// end of file
