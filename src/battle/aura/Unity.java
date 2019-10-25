package battle.aura;

import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Unity implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.ALLIANCE)).count() == 1
        && team.stream().filter(h -> h.getFaction().equals(Faction.HORDE)).count() == 1
        && team.stream().filter(h -> h.getFaction().equals(Faction.ELF)).count() == 1
        && team.stream().filter(h -> h.getFaction().equals(Faction.UNDEAD)).count() == 1
        && team.stream().filter(h -> h.getFaction().equals(Faction.HEAVEN)).count() == 1
        && team.stream().filter(h -> h.getFaction().equals(Faction.HELL)).count() == 1;
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.1);
    hero.addMaxHPModifier(0.1);
  }

}
