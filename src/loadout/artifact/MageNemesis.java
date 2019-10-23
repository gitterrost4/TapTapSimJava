package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class MageNemesis extends AbstractArtifact {

  public MageNemesis() {
    super(ArtifactType.MAGENEMESIS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(new BigDecimal("0.152"));
    hero.increaseAttack(114);
  }

}
