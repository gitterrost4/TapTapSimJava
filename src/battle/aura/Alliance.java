package battle.aura;

import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Alliance implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.ALLIANCE)).count() == 6;
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseDefense(6);
    hero.addMaxHPModifier(0.195);
  }

}
