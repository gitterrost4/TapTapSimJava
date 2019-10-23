package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class ChaosSpear extends AbstractArtifact {

  public ChaosSpear() {
    super(ArtifactType.CHAOSSPEAR);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.085"));
    hero.increaseWandererDamageModifier(new BigDecimal("0.88"));
  }

}
