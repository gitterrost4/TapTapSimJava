package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Shadow extends AbstractArtifact {

  public Shadow() {
    super(ArtifactType.SHADOW);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAssassinDamageModifier(new BigDecimal("0.205"));
    hero.increaseAttack(154);
  }

}
