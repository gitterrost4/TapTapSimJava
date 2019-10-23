package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class WandererNemesis extends AbstractArtifact {

  public WandererNemesis() {
    super(ArtifactType.WANDERERNEMESIS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWandererDamageModifier(new BigDecimal("0.152"));
    hero.increaseAttack(114);
  }

}
