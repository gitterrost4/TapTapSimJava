package loadout.artifact;

import heroes.Hero;

public class TearsOfTheGoddess extends AbstractArtifact {

  public TearsOfTheGoddess() {
    super(ArtifactType.TEARSOFTHEGODDESS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.105);
    hero.addMaxHPModifier(0.084);
    hero.increaseCurrentEnergy(50);
  }

}
