package loadout.artifact;

import heroes.Hero;

public class PegasusBoots extends AbstractArtifact {

  public PegasusBoots() {
    super(ArtifactType.PEGASUSBOOTS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.062);
    hero.increaseSpeed(24);
  }

}
