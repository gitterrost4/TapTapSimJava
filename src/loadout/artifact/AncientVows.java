package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class AncientVows extends AbstractArtifact {

  public AncientVows() {
    super(ArtifactType.ANCIENTVOWS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.105);
    hero.increaseSpeed(42);
    if (hero.getFaction().equals(Faction.ALLIANCE)) {
      hero.increaseCritRate(0.094);
    }
  }

}
