package loadout.runes;

import heroes.Hero;

/**
 * Implementation of the defense rune
 * 
 * @author gitterrost4
 */
public class DefenseRune extends AbstractRune {

  private double maxHPModifier;
  private double damageReduceBonus;

  public DefenseRune(RuneRarity rarity) {
    super(RuneType.DEFENSE, rarity);
    switch (rarity) {
    case RED1:
      damageReduceBonus = 0.108;
      maxHPModifier = 0.14;
      break;
    case RED2:
      damageReduceBonus = 0.119;
      maxHPModifier = 0.157;
      break;
    default:
      damageReduceBonus = 0;
      maxHPModifier = 0;
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(maxHPModifier);
    hero.increaseDamageReduce(damageReduceBonus);
  }
}
