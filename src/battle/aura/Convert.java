package battle.aura;

import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Convert implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.ALLIANCE)).count() == 3
        && team.stream().filter(h -> h.getFaction().equals(Faction.UNDEAD)).count() == 3;
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.095);
    hero.addMaxHPModifier(0.09);
  }

}
