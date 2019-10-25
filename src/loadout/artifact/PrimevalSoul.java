package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class PrimevalSoul extends AbstractArtifact {

  public PrimevalSoul() {
    super(ArtifactType.PRIMEVALSOUL);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(0.44);
    hero.increaseAttack(335);
    if (hero.getFaction().equals(Faction.HORDE)) {
      hero.increaseCritRate(0.094);
    }
  }

}
