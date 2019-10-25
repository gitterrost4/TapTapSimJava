package loadout.artifact;

import heroes.Hero;

public class SoulsWhisper extends AbstractArtifact {

  public SoulsWhisper() {
    super(ArtifactType.SOULSWHISPER);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAssassinDamageModifier(0.29);
    hero.increaseAttack(218);
  }

}
