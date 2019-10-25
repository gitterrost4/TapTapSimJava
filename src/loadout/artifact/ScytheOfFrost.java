package loadout.artifact;

import heroes.Hero;

public class ScytheOfFrost extends AbstractArtifact {

  public ScytheOfFrost() {
    super(ArtifactType.SCYTHEOFFROST);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.085);
    hero.increaseAssassinDamageModifier(0.88);
  }

}
