package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class SoulsWhisper extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseAssassinDamageModifier(new BigDecimal("0.29"));
    hero.increaseAttack(218);
  }

}
