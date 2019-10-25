package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class SnowDance extends AbstractArtifact {

  public SnowDance() {
    super(ArtifactType.SNOWDANCE);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.44);
    hero.increaseAttack(335);
    if (hero.getFaction().equals(Faction.ELF)) {
      hero.increaseCritRate(0.094);
    }
  }

}
