package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class DarkDestroyer extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(new BigDecimal("0.44"));
    hero.increaseAttack(335);
  }

}
