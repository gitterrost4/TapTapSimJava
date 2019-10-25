package loadout.artifact;

import heroes.Hero;

public class DarkDestroyer extends AbstractArtifact {

  public DarkDestroyer() {
    super(ArtifactType.DARKDESTROYER);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(0.44);
    hero.increaseAttack(335);
  }

}
