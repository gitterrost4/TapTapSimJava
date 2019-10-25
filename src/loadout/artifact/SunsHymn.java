package loadout.artifact;

import heroes.Hero;

public class SunsHymn extends AbstractArtifact {

  public SunsHymn() {
    super(ArtifactType.SUNSHYMN);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(0.44);
    hero.increaseAttack(335);
  }

}
