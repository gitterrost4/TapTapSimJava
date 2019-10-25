package loadout.runes;

import heroes.Hero;

/**
 * Representation of a Critdmg rune
 * 
 * @author gitterrost4
 */
public class CritdmgRune extends AbstractRune {

  private double critRateBonus;
  private double critDamageBonus;

  public CritdmgRune(RuneRarity rarity) {
    super(RuneType.CRITDMG, rarity);
    switch (rarity) {
    case PURPLE1:
      critDamageBonus = 0.104;
      critRateBonus = 0.031;
      break;
    case PURPLE2:
      critDamageBonus = 0.146;
      critRateBonus = 0.042;
      break;
    case PURPLE3:
      critDamageBonus = 0.189;
      critRateBonus = 0.053;
      break;
    case ORANGE1:
      critDamageBonus = 0.253;
      critRateBonus = 0.074;
      break;
    case ORANGE2:
      critDamageBonus = 0.276;
      critRateBonus = 0.085;
      break;
    case ORANGE3:
      critDamageBonus = 0.32;
      critRateBonus = 0.096;
      break;
    case ORANGE4:
      critDamageBonus = 0.364;
      critRateBonus = 0.107;
      break;
    case RED1:
      critDamageBonus = 0.43;
      critRateBonus = 0.129;
      break;
    case RED2:
      critDamageBonus = 0.475;
      critRateBonus = 0.14;
      break;
    default:
      critDamageBonus = 0;
      critRateBonus = 0;
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseCritDamage(critDamageBonus);
    hero.increaseCritRate(critRateBonus);
  }
}
