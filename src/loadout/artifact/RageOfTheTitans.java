package loadout.artifact;

import heroes.Hero;

public class RageOfTheTitans extends AbstractArtifact {

  public RageOfTheTitans() {
    super(ArtifactType.RAGEOFTHETITANS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.085);
    hero.increaseWarriorDamageModifier(0.88);
  }

}
