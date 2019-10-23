package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class GoddessBow extends AbstractArtifact {

  public GoddessBow() {
    super(ArtifactType.GODDESSBOW);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.083"));
    hero.increaseHitRate(new BigDecimal("0.031"));
  }

}
