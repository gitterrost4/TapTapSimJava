package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class SoulTorrent extends AbstractArtifact {

  public SoulTorrent() {
    super(ArtifactType.SOULTORRENT);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.126"));
    hero.increaseHitRate(new BigDecimal("0.084"));
    if (hero.getFaction().equals(Faction.UNDEAD)) {
      hero.increaseSkillDamage(new BigDecimal("0.262"));
    }
  }

}
