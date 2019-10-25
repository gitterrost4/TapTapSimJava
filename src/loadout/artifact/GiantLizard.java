package loadout.artifact;

import heroes.Hero;

public class GiantLizard extends AbstractArtifact {

  public GiantLizard() {
    super(ArtifactType.GIANTLIZARD);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.105);
    hero.increaseCritRate(0.105);
    hero.increaseCritDamage(0.262);
  }

}
