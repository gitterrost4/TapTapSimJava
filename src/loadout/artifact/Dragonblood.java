package loadout.artifact;

import heroes.Hero;

public class Dragonblood extends AbstractArtifact {

  public Dragonblood() {
    super(ArtifactType.DRAGONBLOOD);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseTrueDamage(0.126);
    hero.addAttackModifier(0.084);
  }

}
