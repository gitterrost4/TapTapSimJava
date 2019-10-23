package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class StarPray extends AbstractArtifact {

  public StarPray() {
    super(ArtifactType.STARPRAY);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.126"));
    hero.increaseHitRate(new BigDecimal("0.084"));
    if (hero.getFaction().equals(Faction.ELF)) {
      hero.increaseSkillDamage(new BigDecimal("0.262"));
    }
  }

}
