package loadout.artifact;

import heroes.Hero;

public class ForestPsalm extends AbstractArtifact {

  public ForestPsalm() {
    super(ArtifactType.FORESTPSALM);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(0.205);
    hero.increaseAttack(154);
  }

}
