package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class ScorchingSun extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseDamageReduce(new BigDecimal("0.126"));
    hero.addMaxHPModifier(new BigDecimal("0.084"));
  }

}
