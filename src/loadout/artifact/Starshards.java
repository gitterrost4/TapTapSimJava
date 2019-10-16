package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Starshards extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseEnergy(50);
    hero.increaseSkillDamage(new BigDecimal("0.28"));
  }

}
