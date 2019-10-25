package loadout.artifact;

import heroes.Hero;

public class ClericPredator extends AbstractArtifact {

  public ClericPredator() {
    super(ArtifactType.CLERICPREDATOR);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(0.101);
    hero.increaseAttack(76);
  }

}
