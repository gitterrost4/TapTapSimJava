package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Radiance extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(new BigDecimal("0.29"));
    hero.increaseAttack(218);
  }

}
