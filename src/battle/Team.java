// $Id $
package battle;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import battle.aura.AuraFinder;
import battle.logging.Log;
import battle.logging.LogItem;
import battle.logging.LogMessage;
import heroes.Hero;
import player.Player;

/**
 * describes a full team of heroes
 */
public class Team {
  /**
   * an (ordered) list of heroes.
   */
  private final List<Optional<Hero>> heroes;
  private final Player player;

  public Team(Hero first, Hero second, Hero third, Hero fourth, Hero fifth, Hero sixth, Player player) {
    this.player = player;
    this.heroes = Stream.of(first, second, third, fourth, fifth, sixth).map(Optional::ofNullable)
        .collect(Collectors.toList());
    IntStream.range(0, heroes.size()).forEach(i -> heroes.get(i).ifPresent(h -> h.setPosition(i)));
    getHeroes().stream().filter(hero -> hero != null).forEach(hero -> {
      // apply player based buffs (guild tech, pets)
      this.player.apply(hero);
      // apply aura
      AuraFinder.getAura(getHeroes()).ifPresent(aura -> aura.apply(hero));
    });
  }

  /**
   * @return the heroes
   */
  public List<Hero> getHeroes() {
    return getHeroes(false, false);
  }

  public List<Hero> getHeroes(Boolean skipDead, Boolean skipDying) {
    return heroes.stream().filter(Optional::isPresent).map(Optional::get)
        .filter(h -> (!skipDead || !h.isDead()) && (!skipDying || !h.isDying())).collect(Collectors.toList());
  }

  /**
   * Get the hero in the specified position. Empty if none is present
   * 
   * @param pos
   * @return
   */
  public Optional<Hero> getHeroInPosition(int pos) {
    if (pos < 0 || pos >= heroes.size()) {
      return Optional.empty();
    }
    return heroes.get(pos);
  }

  /**
   * @return true if the whole team is dead
   */
  public boolean isDead() {
    return getHeroes().stream().allMatch(Hero::isDead);
  }

  public LogItem getInformation() {
    Log log = new Log();
    IntStream.range(0, 6).forEach(i -> {
      log.addMessage(new Integer(i + 1) + ":");
      log.addItem(heroes.get(i).map(Hero::getInformation).orElse(new LogMessage("Empty slot")));
    });
    return log;
  }

  public Optional<Hero> getLowestHealthHero() {
    return getHeroes(true, true).stream().sorted((h1, h2) -> h1.getCurrentHP().compareTo(h2.getCurrentHP()))
        .findFirst();
  }
}

// end of file
