package loadout.artifact;

import heroes.Hero;

public class BoneGrip extends AbstractArtifact {

  public BoneGrip() {
    super(ArtifactType.BONEGRIP);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.157);
    hero.increaseDamageReduce(0.157);
  }

}
