package loadout.artifact;

import heroes.Hero;

public class AssassinNemesis extends AbstractArtifact {

  public AssassinNemesis() {
    super(ArtifactType.ASSASSINNEMESIS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseAttack(114);
    hero.increaseAssassinDamageModifier(0.152);
  }

}
