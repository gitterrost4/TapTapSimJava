package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

public class HPRune extends AbstractRune {
  private final Integer maxHPBonus;
  private final BigDecimal maxHPModifier;

  public HPRune(RuneRarity rarity) {
    super(RuneType.HP, rarity);
    switch (rarity) {
    case BLUE1:
      maxHPBonus = 113;
      maxHPModifier = new BigDecimal("0");
      break;
    case BLUE2:
      maxHPBonus = 147;
      maxHPModifier = new BigDecimal("0");
      break;
    case GREEN1:
      maxHPBonus = 223;
      maxHPModifier = new BigDecimal("0");
      break;
    case GREEN2:
      maxHPBonus = 286;
      maxHPModifier = new BigDecimal("0");
      break;
    case GOLD1:
      maxHPBonus = 379;
      maxHPModifier = new BigDecimal("0.072");
      break;
    case GOLD2:
      maxHPBonus = 505;
      maxHPModifier = new BigDecimal("0.082");
      break;
    case GOLD3:
      maxHPBonus = 631;
      maxHPModifier = new BigDecimal("0.093");
      break;
    case PURPLE1:
      maxHPBonus = 848;
      maxHPModifier = new BigDecimal("0.114");
      break;
    case PURPLE2:
      maxHPBonus = 962;
      maxHPModifier = new BigDecimal("0.136");
      break;
    case PURPLE3:
      maxHPBonus = 1082;
      maxHPModifier = new BigDecimal("0.158");
      break;
    case ORANGE1:
      maxHPBonus = 1271;
      maxHPModifier = new BigDecimal("0.19");
      break;
    case ORANGE2:
      maxHPBonus = 1436;
      maxHPModifier = new BigDecimal("0.212");
      break;
    case ORANGE3:
      maxHPBonus = 1630;
      maxHPModifier = new BigDecimal("0.234");
      break;
    case ORANGE4:
      maxHPBonus = 1851;
      maxHPModifier = new BigDecimal("0.257");
      break;
    case RED1:
      maxHPBonus = 2102;
      maxHPModifier = new BigDecimal("0.29");
      break;
    case RED2:
      maxHPBonus = 2419;
      maxHPModifier = new BigDecimal("0.313");
      break;
    default:
      maxHPBonus = 0;
      maxHPModifier = new BigDecimal("0");
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(maxHPModifier);
    hero.increaseMaxHP(maxHPBonus);
  }
}
