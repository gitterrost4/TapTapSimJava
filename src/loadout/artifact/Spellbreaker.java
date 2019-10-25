package loadout.artifact;

import heroes.Hero;

public class Spellbreaker extends AbstractArtifact {

  public Spellbreaker() {
    super(ArtifactType.SPELLBREAKER);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.085);
    hero.increaseMageDamageModifier(0.88);
  }

}
