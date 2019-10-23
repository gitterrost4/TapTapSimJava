package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class CursedOculus extends AbstractArtifact {

  public CursedOculus() {
    super(ArtifactType.CURSEDOCULUS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.085"));
    hero.increaseClericDamageModifier(new BigDecimal("0.88"));
  }

}
