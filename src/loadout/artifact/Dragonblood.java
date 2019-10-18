package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Dragonblood extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseTrueDamage(new BigDecimal("0.126"));
    hero.addAttackModifier(new BigDecimal("0.084"));
  }

}
