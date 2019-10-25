package loadout.artifact;

import heroes.Hero;

public class WandererPredator extends AbstractArtifact {

  public WandererPredator() {
    super(ArtifactType.WANDERERPREDATOR);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(0.101);
    hero.increaseAttack(76);
  }

}
