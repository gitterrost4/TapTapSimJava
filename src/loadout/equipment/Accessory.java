package loadout.equipment;

import heroes.Hero;

/**
 * Class representing the accessory slot (amulets and rings) of the equipment
 */
public class Accessory extends AbstractEquipment {

  /**
   * the flat attack bonus of the accessory
   */
  private final Integer atkIncrease;

  /**
   * constructor creating an Accessory from rarity
   * 
   * @param rarity
   *        the rarity of the Accessory
   */
  public Accessory(EquipmentRarity rarity) {
    super(rarity);
    switch (rarity) {
    case NONE:
      atkIncrease = 0;
      break;
    case GREEN2:
      atkIncrease = 8;
      break;
    case BLUE1:
      atkIncrease = 13;
      break;
    case BLUE2:
      atkIncrease = 17;
      break;
    case YELLOW1:
      atkIncrease = 31;
      break;
    case YELLOW2:
      atkIncrease = 40;
      break;
    case YELLOW3:
      atkIncrease = 49;
      break;
    case PURPLE1:
      atkIncrease = 74;
      break;
    case PURPLE2:
      atkIncrease = 89;
      break;
    case PURPLE3:
      atkIncrease = 104;
      break;
    case PURPLE4:
      atkIncrease = 119;
      break;
    case ORANGE1:
      atkIncrease = 159;
      break;
    case ORANGE2:
      atkIncrease = 193;
      break;
    case ORANGE3:
      atkIncrease = 227;
      break;
    case ORANGE4:
      atkIncrease = 262;
      break;
    default:
      atkIncrease = 0;
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAttack(atkIncrease);
  }

}

// end of file
