package battle.aura;

import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Hell implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.HELL)).count() == 6;
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseControlResist(0.3);
    hero.addMaxHPModifier(0.195);
  }

}
