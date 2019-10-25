package loadout.artifact;

import heroes.Hero;

public class Radiance extends AbstractArtifact {

  public Radiance() {
    super(ArtifactType.RADIANCE);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(0.29);
    hero.increaseAttack(218);
  }

}
