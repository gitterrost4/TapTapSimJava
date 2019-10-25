package battle.aura;

import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Horde implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.HORDE)).count() == 6;
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.15);
    hero.addMaxHPModifier(0.195);
  }

}
