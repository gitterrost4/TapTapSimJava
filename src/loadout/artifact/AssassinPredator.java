package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class AssassinPredator extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseAttack(72);
    hero.increaseAssassinDamageModifier(new BigDecimal("0.101"));
  }

}
