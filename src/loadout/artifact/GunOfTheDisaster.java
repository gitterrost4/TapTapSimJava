package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class GunOfTheDisaster extends AbstractArtifact {

  public GunOfTheDisaster() {
    super(ArtifactType.GUNOFTHEDISASTER);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.105);
    hero.increaseSpeed(42);
    if (hero.getFaction().equals(Faction.HORDE)) {
      hero.increaseCritRate(0.094);
    }
  }

}
