package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class SunsHymn extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(new BigDecimal("0.44"));
    hero.increaseAttack(335);
  }

}
