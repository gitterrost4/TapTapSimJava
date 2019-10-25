package loadout.runes;

import heroes.Hero;

/**
 * implementation of the skilldmg rune
 * 
 * @author gitterrost4
 */
public class SkilldmgRune extends AbstractRune {

  private double skillDamageBonus;
  private double hitRateBonus;

  public SkilldmgRune(RuneRarity rarity) {
    super(RuneType.SKILLDMG, rarity);
    switch (rarity) {
    case PURPLE1:
      skillDamageBonus = 0.104;
      hitRateBonus = 0.031;
      break;
    case PURPLE2:
      skillDamageBonus = 0.12;
      hitRateBonus = 0.042;
      break;
    case PURPLE3:
      skillDamageBonus = 0.147;
      hitRateBonus = 0.053;
      break;
    case ORANGE1:
      skillDamageBonus = 0.164;
      hitRateBonus = 0.074;
      break;
    case ORANGE2:
      skillDamageBonus = 0.18;
      hitRateBonus = 0.085;
      break;
    case ORANGE3:
      skillDamageBonus = 0.197;
      hitRateBonus = 0.096;
      break;
    case ORANGE4:
      skillDamageBonus = 0.214;
      hitRateBonus = 0.107;
      break;
    case RED1:
      skillDamageBonus = 0.258;
      hitRateBonus = 0.129;
      break;
    case RED2:
      skillDamageBonus = 0.281;
      hitRateBonus = 0.14;
      break;
    default:
      skillDamageBonus = 0;
      hitRateBonus = 0;
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseSkillDamage(skillDamageBonus);
    hero.increaseHitRate(hitRateBonus);
  }
}
