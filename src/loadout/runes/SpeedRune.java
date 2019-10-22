package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * implementation of the speed rune
 * 
 * @author gitterrost4
 *
 */
public class SpeedRune extends AbstractRune {

  private Integer speedBonus;
  private BigDecimal maxHPModifier;

  public SpeedRune(RuneRarity rarity) {
    switch (rarity) {
    case RED1:
      speedBonus = 55;
      maxHPModifier = new BigDecimal("0.14");
      break;
    case RED2:
      speedBonus = 70;
      maxHPModifier = new BigDecimal("0.157");
      break;
    default:
      speedBonus = 0;
      maxHPModifier = new BigDecimal("0");
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseSpeed(speedBonus);
    hero.addMaxHPModifier(maxHPModifier);
  }
}
