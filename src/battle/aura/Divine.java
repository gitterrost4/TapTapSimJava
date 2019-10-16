package battle.aura;

import java.math.BigDecimal;
import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Divine implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h -> h.getFaction().equals(Faction.HEAVEN)).count() == 3
        && team.stream().filter(h -> h.getFaction().equals(Faction.HELL)).count() == 3
    ;
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.15"));
    hero.addMaxHPModifier(new BigDecimal("0.15"));
  }

}
