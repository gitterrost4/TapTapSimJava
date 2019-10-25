package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class TearsOfTheGoddess extends AbstractArtifact {

  public TearsOfTheGoddess() {
    super(ArtifactType.TEARSOFTHEGODDESS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.105"));
    hero.addMaxHPModifier(new BigDecimal("0.084"));
    hero.increaseCurrentEnergy(new BigDecimal("50"));
  }

}
