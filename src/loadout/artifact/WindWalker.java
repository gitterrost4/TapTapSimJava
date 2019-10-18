package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class WindWalker extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(new BigDecimal("0.026"));
    hero.increaseSpeed(22);
  }

}
