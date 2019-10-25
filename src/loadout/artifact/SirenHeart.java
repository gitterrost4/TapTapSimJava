package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class SirenHeart extends AbstractArtifact {

  public SirenHeart() {
    super(ArtifactType.SIRENHEART);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.105);
    hero.increaseSpeed(42);
    if (hero.getFaction().equals(Faction.UNDEAD)) {
      hero.increaseCritRate(0.094);
    }
  }

}
