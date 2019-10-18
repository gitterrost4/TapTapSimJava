package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class CrystalSword extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(new BigDecimal("0.205"));
    hero.increaseAttack(154);
  }

}
