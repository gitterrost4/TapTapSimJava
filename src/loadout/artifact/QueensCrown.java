package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class QueensCrown extends AbstractArtifact {

  public QueensCrown() {
    super(ArtifactType.QUEENSCROWN);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(0.105);
    hero.increaseSpeed(42);
    if (hero.getFaction().equals(Faction.ELF))
      hero.increaseCritRate(0.094);
  }

}
