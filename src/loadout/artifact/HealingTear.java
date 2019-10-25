package loadout.artifact;

import heroes.Hero;

public class HealingTear extends AbstractArtifact {

  public HealingTear() {
    super(ArtifactType.HEALINGTEAR);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(0.205);
    hero.increaseAttack(154);
  }

}
