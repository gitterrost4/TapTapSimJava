package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class CursedGun extends AbstractArtifact {

  public CursedGun() {
    super(ArtifactType.CURSEDGUN);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseMageDamageModifier(0.44);
    hero.increaseAttack(335);
    if (hero.getFaction().equals(Faction.UNDEAD)) {
      hero.increaseSkillDamage(0.262);
    }
  }

}
