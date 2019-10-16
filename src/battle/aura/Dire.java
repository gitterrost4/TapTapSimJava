package battle.aura;

import java.math.BigDecimal;
import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Dire implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.HORDE)).count() == 2
        && team.stream().filter(h -> h.getFaction().equals(Faction.UNDEAD)).count() == 2
        && team.stream().filter(h -> h.getFaction().equals(Faction.HELL)).count() == 2
    ;
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.12"));
    hero.addMaxHPModifier(new BigDecimal("0.12"));
  }

}
