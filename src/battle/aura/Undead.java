package battle.aura;

import java.math.BigDecimal;
import java.util.List;

import heroes.Faction;
import heroes.Hero;

public class Undead implements Aura {

  @Override
  public boolean isApplicable(List<Hero> team) {
    return team.stream().filter(h->h.getFaction().equals(Faction.UNDEAD)).count() == 6;
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseDefenseBreak(new BigDecimal("6"));
    hero.addMaxHPModifier(new BigDecimal("0.195"));
  }

}
