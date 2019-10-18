package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class WarriorNemesis extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(new BigDecimal("0.152"));
    hero.increaseAttack(114);
  }

}
