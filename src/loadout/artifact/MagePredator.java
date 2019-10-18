package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class MagePredator extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(new BigDecimal("0.101"));
    hero.increaseAttack(76);
  }

}
