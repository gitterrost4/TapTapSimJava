package battle.aura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import heroes.Hero;

public class AuraFinder {
  private static final List<Aura> allAuras = new ArrayList<>();
  static {
    allAuras.add(new Alliance());
    allAuras.add(new Ancient());
    allAuras.add(new Convert());
    allAuras.add(new Dire());
    allAuras.add(new Disaster());
    allAuras.add(new Divine());
    allAuras.add(new Elves());
    allAuras.add(new Evil());
    allAuras.add(new Heaven());
    allAuras.add(new Hell());
    allAuras.add(new Horde());
    allAuras.add(new Justice());
    allAuras.add(new Nova());
    allAuras.add(new Pure());
    allAuras.add(new Undead());
    allAuras.add(new Unity());
  }
  public static Optional<Aura> getAura(List<Hero> team) {
    return allAuras.stream().filter(aura->aura.isApplicable(team)).findFirst();
  }
}
