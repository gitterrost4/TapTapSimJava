package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class BurningSoul extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(new BigDecimal("0.44"));
    hero.increaseAttack(335);
  }

}
