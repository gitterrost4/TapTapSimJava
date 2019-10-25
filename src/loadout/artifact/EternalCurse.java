package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class EternalCurse extends AbstractArtifact {

  public EternalCurse() {
    super(ArtifactType.ETERNALCURSE);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
    if (hero.getFaction().equals(Faction.HELL)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
