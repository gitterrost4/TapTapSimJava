package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class EyeOfHeaven extends AbstractArtifact {

  public EyeOfHeaven() {
    super(ArtifactType.EYEOFHEAVEN);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.126"));
    hero.increaseHitRate(new BigDecimal("0.084"));
  }

}
