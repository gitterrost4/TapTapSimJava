package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class SoulTorrent extends AbstractArtifact {

  public SoulTorrent() {
    super(ArtifactType.SOULTORRENT);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
    if (hero.getFaction().equals(Faction.UNDEAD)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
