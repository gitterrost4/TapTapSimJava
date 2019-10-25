package loadout.artifact;

import heroes.Hero;

public class BrokenOne extends AbstractArtifact {

  public BrokenOne() {
    super(ArtifactType.BROKENONE);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.29);
    hero.increaseAttack(218);
  }

}
