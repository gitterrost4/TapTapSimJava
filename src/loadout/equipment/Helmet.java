package loadout.equipment;

import heroes.Hero;

/** 
 * TODO documentation
 *
 */
public class Helmet extends AbstractEquipment {
  
  private final Integer hpIncrease;
  
  public Helmet(EquipmentRarity rarity) {
    super(rarity);
    switch(rarity) {
    case GREEN2:
      hpIncrease=30;
      break;
    case BLUE1:
      hpIncrease=58;
      break;
    case BLUE2:
      hpIncrease=75;
      break;
    case YELLOW1:
      hpIncrease=165;
      break;
    case YELLOW2:
      hpIncrease=213;
      break;
    case YELLOW3:
      hpIncrease=261;
      break;
    case PURPLE1:
      hpIncrease=446;
      break;
    case PURPLE2:
      hpIncrease=551;
      break;
    case PURPLE3:
      hpIncrease=634;
      break;
    case PURPLE4:
      hpIncrease=729;
      break;
    case ORANGE1:
      hpIncrease=1074;
      break;
    case ORANGE2:
      hpIncrease=1309;
      break;
    case ORANGE3:
      hpIncrease=1545;
      break;
    case ORANGE4:
      hpIncrease=1780;
      break;
    default:
      hpIncrease=0;
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMaxHP(hpIncrease);
  }
  
}


// end of file
