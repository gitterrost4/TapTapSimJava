package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class GiantLizard extends AbstractArtifact {

  public GiantLizard() {
    super(ArtifactType.GIANTLIZARD);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.105"));
    hero.increaseCritRate(new BigDecimal("0.105"));
    hero.increaseCritDamage(new BigDecimal("0.262"));
  }

}
