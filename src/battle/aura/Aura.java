package battle.aura;

import java.util.List;

import heroes.Hero;

public interface Aura {
  boolean isApplicable(List<Hero> team);
  public void apply(Hero hero);
}
