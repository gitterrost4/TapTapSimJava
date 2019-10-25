package loadout.runes;

import heroes.Hero;

/**
 * implementation of the true rune
 * 
 * @author gitterrost4
 */
public class TrueRune extends AbstractRune {

  private final double trueDamageBonus;
  private final Integer attackBonus;
  private final double maxHPModifier;

  public TrueRune(RuneRarity rarity) {
    super(RuneType.TRUE, rarity);
    switch (rarity) {
    case ORANGE1:
      trueDamageBonus = 0.116;
      attackBonus = 95;
      maxHPModifier = 0;
      break;
    case ORANGE2:
      trueDamageBonus = 0.138;
      attackBonus = 111;
      maxHPModifier = 0;
      break;
    case ORANGE3:
      trueDamageBonus = 0.16;
      attackBonus = 128;
      maxHPModifier = 0;
      break;
    case ORANGE4:
      trueDamageBonus = 0.182;
      attackBonus = 145;
      maxHPModifier = 0;
      break;
    case RED1:
      trueDamageBonus = 0.215;
      attackBonus = 167;
      maxHPModifier = 0.097;
      break;
    case RED2:
      trueDamageBonus = 0.238;
      attackBonus = 168;
      maxHPModifier = 0.13;
      break;
    default:
      trueDamageBonus = 0;
      attackBonus = 0;
      maxHPModifier = 0;
      break;

    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseTrueDamage(trueDamageBonus);
    hero.increaseAttack(attackBonus);
    hero.addMaxHPModifier(maxHPModifier);
  }
}
