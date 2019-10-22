package loadout.runes;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * TODO: Documentation
 * 
 * @author gitterrost4
 *
 */
public class DefenseRune extends AbstractRune {

  private BigDecimal maxHPModifier;
  private BigDecimal damageReduceBonus;

  public DefenseRune(RuneRarity rarity) {
    switch (rarity) {
    case RED1:
      damageReduceBonus = new BigDecimal("0.108");
      maxHPModifier = new BigDecimal("0.14");
      break;
    case RED2:
      damageReduceBonus = new BigDecimal("0.119");
      maxHPModifier = new BigDecimal("0.157");
      break;
    default:
      damageReduceBonus = new BigDecimal("0");
      maxHPModifier = new BigDecimal("0");
      break;
    }
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(maxHPModifier);
    hero.increaseDamageReduce(damageReduceBonus);
  }
}
