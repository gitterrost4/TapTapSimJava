package loadout.artifact;

import heroes.Hero;

public class WarriorPredator extends AbstractArtifact {

  public WarriorPredator() {
    super(ArtifactType.WARRIORPREDATOR);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.101);
    hero.increaseAttack(76);
  }

}
