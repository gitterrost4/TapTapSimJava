package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class WandererPredator extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(new BigDecimal("0.101"));
    hero.increaseAttack(76);
  }

}
