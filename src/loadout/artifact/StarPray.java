package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class StarPray extends AbstractArtifact {

  public StarPray() {
    super(ArtifactType.STARPRAY);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.126);
    hero.increaseHitRate(0.084);
    if (hero.getFaction().equals(Faction.ELF)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
