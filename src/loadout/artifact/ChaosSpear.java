package loadout.artifact;

import heroes.Hero;

public class ChaosSpear extends AbstractArtifact {

  public ChaosSpear() {
    super(ArtifactType.CHAOSSPEAR);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.085);
    hero.increaseWandererDamageModifier(0.88);
  }

}
