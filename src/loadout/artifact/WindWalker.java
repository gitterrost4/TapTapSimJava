package loadout.artifact;

import heroes.Hero;

public class WindWalker extends AbstractArtifact {

  public WindWalker() {
    super(ArtifactType.WINDWALKER);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.026);
    hero.increaseSpeed(22);
  }

}
