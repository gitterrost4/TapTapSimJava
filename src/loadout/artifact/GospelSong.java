package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class GospelSong extends AbstractArtifact {

  public GospelSong() {
    super(ArtifactType.GOSPELSONG);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.126"));
    hero.increaseHitRate(new BigDecimal("0.084"));
    if (hero.getFaction().equals(Faction.ALLIANCE)) {
      hero.increaseSkillDamage(new BigDecimal("0.262"));
    }
  }

}
