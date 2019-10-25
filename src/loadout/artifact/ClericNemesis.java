package loadout.artifact;

import heroes.Hero;

public class ClericNemesis extends AbstractArtifact {

  public ClericNemesis() {
    super(ArtifactType.CLERICNEMESIS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(0.152);
    hero.increaseAttack(114);
  }

}
