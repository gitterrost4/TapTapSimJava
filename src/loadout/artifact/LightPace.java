package loadout.artifact;

import heroes.Hero;

public class LightPace extends AbstractArtifact {

  public LightPace() {
    super(ArtifactType.LIGHTPACE);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.126);
    hero.increaseSpeed(42);
  }

}
