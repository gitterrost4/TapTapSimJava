package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class MageNemesis extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(new BigDecimal("0.152"));
    hero.increaseAttack(114);
  }

}
