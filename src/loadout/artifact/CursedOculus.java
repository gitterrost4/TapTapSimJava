package loadout.artifact;

import heroes.Hero;

public class CursedOculus extends AbstractArtifact {

  public CursedOculus() {
    super(ArtifactType.CURSEDOCULUS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.085);
    hero.increaseClericDamageModifier(0.88);
  }

}
