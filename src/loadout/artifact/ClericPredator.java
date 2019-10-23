package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class ClericPredator extends AbstractArtifact {

  public ClericPredator() {
    super(ArtifactType.CLERICPREDATOR);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(new BigDecimal("0.101"));
    hero.increaseAttack(76);
  }

}
