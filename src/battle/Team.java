// $Id $
package battle;

import java.util.ArrayList;
import java.util.Collections;
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
import player.Familiars.AbstractFamiliar;
import player.Player;

/**
 * describes a full team of heroes
 */
public class Team {
  /**
   * an (ordered) list of heroes. this list should always contain six values. If a
   * spot in the team is empty, the entry will be an empty optional
   */
  private final List<Optional<Hero>> heroes;
  /** the player belonging to this team */
  private final Player player;

  /**
   * create a team with six heroes (null if a spot is empty) and the player this team
   * belongs to
   * 
   * @param first
   *        the hero in the first (tank) spot or null if empty
   * @param second
   *        the hero in the second spot or null if empty
   * @param third
   *        the hero in the third spot or null if empty
   * @param fourth
   *        the hero in the fourth spot or null if empty
   * @param fifth
   *        the hero in the fifth spot or null if empty
   * @param sixth
   *        the hero in the sixth spot or null if empty
   * @param player
   *        the player this team belongs to
   */
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

  /**
   * return the heroes of the team in an ordered list (ignoring empty spots)
   * 
   * @param skipDead
   *        don't return the heroes that are dead
   * @param skipDying
   *        don't return the heroes that are dying *or* dead
   * @return the list of heroes
   */
  public List<Hero> getHeroes(Boolean skipDead, Boolean skipDying) {
    return heroes.stream().filter(Optional::isPresent).map(Optional::get)
        .filter(h -> (!skipDead || !h.isDead()) && (!skipDying || !h.isDying())).collect(Collectors.toList());
  }

  /**
   * Get the hero in the specified position. Empty if none is present
   * 
   * @param pos
   *        positon (1-6) of the desired hero
   * @return An Optional containing the hero or empty if the position is empty
   */
  public Optional<Hero> getHeroInPosition(int pos) {
    if (pos < 0 || pos >= heroes.size()) {
      return Optional.empty();
    }
    return heroes.get(pos);
  }

  /**
   * @return true iff the whole team is dead
   */
  public boolean isDead() {
    return getHeroes().stream().allMatch(Hero::isDead);
  }

  /**
   * @return a log item containing textual information about the team
   */
  public LogItem getInformation() {
    Log log = new Log();
    IntStream.range(0, 6).forEach(i -> {
      log.addMessage(new Integer(i + 1) + ":");
      log.addItem(heroes.get(i).map(Hero::getInformation).orElse(new LogMessage("Empty slot")));
    });
    return log;
  }

  /**
   * @return the hero of the team with the lowest health that is not dying or dead
   *         (or empty if all heroes are dead)
   */
  public Optional<Hero> getLowestHealthHero() {
    return getHeroes(true,true).stream()
      .sorted((h1,h2) -> new Integer(h1.getCurrentHP() - h1.getMaxHP())
        .compareTo(new Integer(h2.getCurrentHP() - h2.getMaxHP())))
      .findFirst();
  }

  /**
   * get a list of random alive heroes containing `count` elements (or fewer if only
   * fewer are alive)
   * 
   * @param count
   *        the number of heroes needed
   * @return list of random heroes
   */
  public List<Hero> getRandomHeroes(int count) {
    List<Hero> shuffled = new ArrayList<>(getHeroes(true, true)); // copy the list before shuffling
    Collections.shuffle(shuffled);
    return shuffled.subList(0, Math.min(count, shuffled.size()));
  }

  /**
   * @return the player this team belongs to
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * @return the active familiar of the team
   */
  public AbstractFamiliar getActiveFamiliar() {
    return player.getFamiliars().getActiveFamiliar();
  }

}

// end of file
