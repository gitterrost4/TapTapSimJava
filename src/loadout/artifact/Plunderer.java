package loadout.artifact;

import heroes.Hero;

public class Plunderer extends AbstractArtifact {

  public Plunderer() {
    super(ArtifactType.PLUNDERER);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.205);
    hero.increaseAttack(154);
  }

}
