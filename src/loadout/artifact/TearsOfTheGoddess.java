package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class TearsOfTheGoddess extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.105"));
    hero.addMaxHPModifier(new BigDecimal("0.084"));
    hero.increaseEnergy(50);
  }

}
