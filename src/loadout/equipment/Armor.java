package loadout.equipment;

import heroes.Hero;

/**
 * class representing the armor slot (chestpiece) of the equipment
 *
 */
public class Armor extends AbstractEquipment {

  private final Integer hpIncrease;

  public Armor(EquipmentRarity rarity) {
    super(rarity);
    switch (rarity) {
    case NONE:
      hpIncrease = 0;
      break;
    case GREEN2:
      hpIncrease = 44;
      break;
    case BLUE1:
      hpIncrease = 87;
      break;
    case BLUE2:
      hpIncrease = 111;
      break;
    case YELLOW1:
      hpIncrease = 246;
      break;
    case YELLOW2:
      hpIncrease = 318;
      break;
    case YELLOW3:
      hpIncrease = 390;
      break;
    case PURPLE1:
      hpIncrease = 666;
      break;
    case PURPLE2:
      hpIncrease = 807;
      break;
    case PURPLE3:
      hpIncrease = 948;
      break;
    case PURPLE4:
      hpIncrease = 1090;
      break;
    case ORANGE1:
      hpIncrease = 1607;
      break;
    case ORANGE2:
      hpIncrease = 1960;
      break;
    case ORANGE3:
      hpIncrease = 2313;
      break;
    case ORANGE4:
      hpIncrease = 2666;
      break;
    default:
      hpIncrease = 0;
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMaxHP(hpIncrease);
  }

}

// end of file
