package battle.aura;

import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Elves implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.ELF)).count() == 6;
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseCritRate(0.09);
    hero.addMaxHPModifier(0.195);
  }

}
