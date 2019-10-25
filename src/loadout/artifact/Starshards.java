package loadout.artifact;

import heroes.Hero;

public class Starshards extends AbstractArtifact {

  public Starshards() {
    super(ArtifactType.STARSHARDS);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseCurrentEnergy(50);
    hero.increaseSkillDamage(0.28);
  }

}
