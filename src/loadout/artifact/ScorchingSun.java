package loadout.artifact;

import heroes.Hero;

public class ScorchingSun extends AbstractArtifact {

  public ScorchingSun() {
    super(ArtifactType.SCORCHINGSUN);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseDamageReduce(0.126);
    hero.addMaxHPModifier(0.084);
  }

}
