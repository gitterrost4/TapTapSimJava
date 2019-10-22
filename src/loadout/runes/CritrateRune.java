package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * Implementation of the critrate rune
 * 
 * @author gitterrost4
 *
 */
public class CritrateRune extends AbstractRune {
  private final BigDecimal critRateBonus;
  private final Integer maxHPBonus;
  private final BigDecimal maxHPModifier;
  public CritrateRune(RuneRarity rarity) {
    switch (rarity) {
    case GREEN1:
      critRateBonus=new BigDecimal("0.02");
      maxHPBonus=76;
      maxHPModifier=new BigDecimal("0");
      break;
    case GREEN2:
      critRateBonus=new BigDecimal("0.031");
      maxHPBonus=153;
      maxHPModifier=new BigDecimal("0");
      break;
    case GOLD1:
      critRateBonus=new BigDecimal("0.051");
      maxHPBonus=236;
      maxHPModifier=new BigDecimal("0");
      break;
    case GOLD2:
      critRateBonus=new BigDecimal("0.062");
      maxHPBonus=309;
      maxHPModifier=new BigDecimal("0");
      break;
    case GOLD3:
      critRateBonus=new BigDecimal("0.072");
      maxHPBonus=383;
      maxHPModifier=new BigDecimal("0");
      break;
    case PURPLE1:
      critRateBonus=new BigDecimal("0.094");
      maxHPBonus=437;
      maxHPModifier=new BigDecimal("0");
      break;
    case PURPLE2:
      critRateBonus=new BigDecimal("0.105");
      maxHPBonus=517;
      maxHPModifier=new BigDecimal("0");
      break;
    case PURPLE3:
      critRateBonus=new BigDecimal("0.116");
      maxHPBonus=599;
      maxHPModifier=new BigDecimal("0");
      break;
    case ORANGE1:
      critRateBonus=new BigDecimal("0.137");
      maxHPBonus=786;
      maxHPModifier=new BigDecimal("0");
      break;
    case ORANGE2:
      critRateBonus=new BigDecimal("0.148");
      maxHPBonus=917;
      maxHPModifier=new BigDecimal("0");
      break;
    case ORANGE3:
      critRateBonus=new BigDecimal("0.16");
      maxHPBonus=1060;
      maxHPModifier=new BigDecimal("0");
      break;
    case ORANGE4:
      critRateBonus=new BigDecimal("0.171");
      maxHPBonus=1204;
      maxHPModifier=new BigDecimal("0");
      break;
    case RED1:
      critRateBonus=new BigDecimal("0.194");
      maxHPBonus=0;
      maxHPModifier=new BigDecimal("0.108");
      break;
    case RED2:
      critRateBonus=new BigDecimal("0.205");
      maxHPBonus=0;
      maxHPModifier=new BigDecimal("0.14");
      break;
    default:
      critRateBonus=new BigDecimal("0.");
      maxHPBonus=0;
      maxHPModifier=new BigDecimal("0");
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseCritRate(critRateBonus);
    hero.increaseMaxHP(maxHPBonus);
    hero.addMaxHPModifier(maxHPModifier);
  }
}
