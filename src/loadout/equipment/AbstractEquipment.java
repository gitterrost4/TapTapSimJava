// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.equipment;

import loadout.HeroModifier;

/** 
 * Base class for the equipment pieces (helmet, armor, accessory, weapon)
 *
 * @author (C) cantamen/Paul Kramer 2019
 * @version $Id $
 */
public abstract class AbstractEquipment implements HeroModifier {
  private final EquipmentRarity rarity;

  public AbstractEquipment(EquipmentRarity rarity) {
    super();
    this.rarity=rarity;
  }

  public EquipmentRarity getRarity() {
    return rarity;
  }
  
}


// end of file
