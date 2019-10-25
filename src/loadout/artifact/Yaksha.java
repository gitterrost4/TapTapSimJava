package loadout.artifact;

import heroes.Hero;

public class Yaksha extends AbstractArtifact {

  public Yaksha() {
    super(ArtifactType.YAKSHA);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAssassinDamageModifier(0.239);
    hero.increaseAttack(177);
  }

}
