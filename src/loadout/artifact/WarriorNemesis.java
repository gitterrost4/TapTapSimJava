package loadout.artifact;

import heroes.Hero;

public class WarriorNemesis extends AbstractArtifact {

  public WarriorNemesis() {
    super(ArtifactType.WARRIORNEMESIS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.152);
    hero.increaseAttack(114);
  }

}
