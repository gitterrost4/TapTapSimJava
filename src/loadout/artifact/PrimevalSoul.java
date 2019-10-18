package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class PrimevalSoul extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.increaseWarriorDamageModifier(new BigDecimal("0.44"));
    hero.increaseAttack(335);
    if (hero.getFaction().equals(Faction.HORDE)) {
      hero.increaseCritRate(new BigDecimal("0.094"));
    }
  }

}
