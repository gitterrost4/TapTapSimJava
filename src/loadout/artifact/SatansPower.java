package loadout.artifact;

import heroes.Hero;

public class SatansPower extends AbstractArtifact {

  public SatansPower() {
    super(ArtifactType.SATANSPOWER);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.44);
    hero.increaseAttack(335);
  }

}
