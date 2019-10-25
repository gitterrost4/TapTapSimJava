package loadout.artifact;

import heroes.Hero;

public class MageNemesis extends AbstractArtifact {

  public MageNemesis() {
    super(ArtifactType.MAGENEMESIS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(0.152);
    hero.increaseAttack(114);
  }

}
