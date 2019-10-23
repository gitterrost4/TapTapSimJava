package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class SatansPower extends AbstractArtifact {

  public SatansPower() {
    super(ArtifactType.SATANSPOWER);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(new BigDecimal("0.44"));
    hero.increaseAttack(335);
  }

}
