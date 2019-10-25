package loadout.runes;

import heroes.Hero;

/**
 * implementation of the speed rune
 * 
 * @author gitterrost4
 */
public class SpeedRune extends AbstractRune {

  private Integer speedBonus;
  private double maxHPModifier;

  public SpeedRune(RuneRarity rarity) {
    super(RuneType.SPEED, rarity);
    switch (rarity) {
    case RED1:
      speedBonus = 55;
      maxHPModifier = 0.14;
      break;
    case RED2:
      speedBonus = 70;
      maxHPModifier = 0.157;
      break;
    default:
      speedBonus = 0;
      maxHPModifier = 0;
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseSpeed(speedBonus);
    hero.addMaxHPModifier(maxHPModifier);
  }
}
