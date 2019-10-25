package loadout.artifact;

import heroes.Hero;

public class Shadow extends AbstractArtifact {

  public Shadow() {
    super(ArtifactType.SHADOW);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAssassinDamageModifier(0.205);
    hero.increaseAttack(154);
  }

}
