package loadout.artifact;

import heroes.Hero;

public class EyeOfHeaven extends AbstractArtifact {

  public EyeOfHeaven() {
    super(ArtifactType.EYEOFHEAVEN);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
  }

}
