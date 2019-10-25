package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class HolyLightJustice extends AbstractArtifact {

  public HolyLightJustice() {
    super(ArtifactType.HOLYLIGHTJUSTICE);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
    if (hero.getFaction().equals(Faction.HEAVEN)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
