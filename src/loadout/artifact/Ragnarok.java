package loadout.artifact;

import heroes.Hero;

public class Ragnarok extends AbstractArtifact {
  public Ragnarok() {
    super(ArtifactType.RAGNAROK);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseTrueDamage(0.2);
    hero.addMaxHPModifier(0.1);
    hero.increaseDefenseBreak(8);
  }

}
