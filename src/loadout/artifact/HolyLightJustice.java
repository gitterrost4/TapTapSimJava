package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class HolyLightJustice extends AbstractArtifact {

  public HolyLightJustice() {
    super(ArtifactType.HOLYLIGHTJUSTICE);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.126"));
    hero.increaseHitRate(new BigDecimal("0.084"));
    if (hero.getFaction().equals(Faction.HEAVEN)) {
      hero.increaseSkillDamage(new BigDecimal("0.262"));
    }
  }

}
