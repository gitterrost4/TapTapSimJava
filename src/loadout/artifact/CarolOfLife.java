package loadout.artifact;

import heroes.Hero;

public class CarolOfLife extends AbstractArtifact {

  public CarolOfLife() {
    super(ArtifactType.CAROLOFLIFE);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(0.29);
    hero.increaseAttack(218);
  }

}
