package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class BoneGrip extends AbstractArtifact {

  public BoneGrip() {
    super(ArtifactType.BONEGRIP);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(new BigDecimal("0.157"));
    hero.increaseDamageReduce(new BigDecimal("0.157"));
  }

}
