package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class GospelSong extends AbstractArtifact {

  public GospelSong() {
    super(ArtifactType.GOSPELSONG);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
    if (hero.getFaction().equals(Faction.ALLIANCE)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
