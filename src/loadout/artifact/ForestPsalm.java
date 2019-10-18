package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class ForestPsalm extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(new BigDecimal("0.205"));
    hero.increaseAttack(154);
  }

}
