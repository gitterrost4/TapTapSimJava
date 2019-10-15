// $Id $
// (C) cantamen/Paul Kramer 2019
package battle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import heroes.Hero;
import player.Player;

/**
 * describes a full team of heroes
 */
public class Team {
  /**
   * an (ordered) list of heroes.
   */
  private final List<Hero> heroes;
  private final Player player;

  public Team(Hero first, Hero second, Hero third, Hero fourth, Hero fifth, Hero sixth, Player player) {
    this.player=player;
    this.heroes=Stream.of(first,second,third,fourth,fifth,sixth).collect(Collectors.toList());
    //apply player based buffs (guild tech, pets)
    heroes.stream().forEach(h->this.player.getGuildTech().apply(h));
  }
}

// end of file