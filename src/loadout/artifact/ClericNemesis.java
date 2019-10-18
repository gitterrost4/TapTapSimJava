package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class ClericNemesis extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(new BigDecimal("0.152"));
    hero.increaseAttack(114);
  }

}
