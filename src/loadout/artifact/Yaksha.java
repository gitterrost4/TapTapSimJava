package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Yaksha extends AbstractArtifact {

  public Yaksha() {
    super(ArtifactType.YAKSHA);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAssassinDamageModifier(new BigDecimal("0.239"));
    hero.increaseAttack(177);
  }

}
