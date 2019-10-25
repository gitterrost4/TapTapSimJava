package loadout.artifact;

import heroes.Hero;

public class Mirage extends AbstractArtifact {

  public Mirage() {
    super(ArtifactType.MIRAGE);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(0.29);
    hero.increaseAttack(218);
  }

}
