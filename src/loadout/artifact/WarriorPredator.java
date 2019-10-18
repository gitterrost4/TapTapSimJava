package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class WarriorPredator extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(new BigDecimal("0.101"));
    hero.increaseAttack(76);
  }

}
