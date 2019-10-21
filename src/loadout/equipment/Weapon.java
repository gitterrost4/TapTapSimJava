package loadout.equipment;

import heroes.Hero;

/**
 * representation of the weapon equipment slot
 *
 */
public class Weapon extends AbstractEquipment {

  private final Integer atkIncrease;

  public Weapon(EquipmentRarity rarity) {
    super(rarity);
    switch (rarity) {
    case NONE:
      atkIncrease = 0;
      break;
    case GREEN2:
      atkIncrease = 11;
      break;
    case BLUE1:
      atkIncrease = 19;
      break;
    case BLUE2:
      atkIncrease = 24;
      break;
    case YELLOW1:
      atkIncrease = 45;
      break;
    case YELLOW2:
      atkIncrease = 58;
      break;
    case YELLOW3:
      atkIncrease = 68;
      break;
    case PURPLE1:
      atkIncrease = 108;
      break;
    case PURPLE2:
      atkIncrease = 131;
      break;
    case PURPLE3:
      atkIncrease = 153;
      break;
    case PURPLE4:
      atkIncrease = 176;
      break;
    case ORANGE1:
      atkIncrease = 235;
      break;
    case ORANGE2:
      atkIncrease = 286;
      break;
    case ORANGE3:
      atkIncrease = 337;
      break;
    case ORANGE4:
      atkIncrease = 388;
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
