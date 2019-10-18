package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class LightPace extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(new BigDecimal("0.126"));
    hero.increaseSpeed(42);
  }

}
