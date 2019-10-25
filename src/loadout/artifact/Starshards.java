package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Starshards extends AbstractArtifact {

  public Starshards() {
    super(ArtifactType.STARSHARDS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseEnergy(new BigDecimal("50"));
    hero.increaseSkillDamage(new BigDecimal("0.28"));
  }

}
