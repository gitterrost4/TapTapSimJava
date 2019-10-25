package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class BloodMedal extends AbstractArtifact {

  public BloodMedal() {
    super(ArtifactType.BLOODMEDAL);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
    if (hero.getFaction().equals(Faction.HORDE)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
