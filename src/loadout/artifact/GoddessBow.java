package loadout.artifact;

import heroes.Hero;

public class GoddessBow extends AbstractArtifact {

  public GoddessBow() {
    super(ArtifactType.GODDESSBOW);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.083);
    hero.increaseHitRate(0.031);
  }

}
