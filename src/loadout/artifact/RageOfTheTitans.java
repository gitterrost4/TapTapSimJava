package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class RageOfTheTitans extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.085"));
    hero.increaseWarriorDamageModifier(new BigDecimal("0.88"));
  }

}
