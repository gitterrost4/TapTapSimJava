package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class KnightsVow extends AbstractArtifact {

  public KnightsVow() {
    super(ArtifactType.KNIGHTSVOW);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseClericDamageModifier(0.44);
    hero.increaseAttack(335);
    if (hero.getFaction().equals(Faction.ALLIANCE)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
