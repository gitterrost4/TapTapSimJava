// $Id $
// (C) cantamen/Paul Kramer 2019
package battle;

import heroes.Hero;

/**
 * The setting for the battle; basically only consisting of the two teams
 */
public class BattleSetting {
  private final Team attacker;
  private final Team defender;

  public BattleSetting(Team attacker, Team defender) {
    super();
    this.attacker=attacker;
    this.defender=defender;
    attacker.getHeroes().stream().forEach(h->h.initTeam(this));
    defender.getHeroes().stream().forEach(h->h.initTeam(this));
  }

  public Team getAttacker() {
    return attacker;
  }

  public Team getDefender() {
    return defender;
  }
  
  public Team getOwnTeam(Hero h) {
    if(attacker.getHeroes().stream().filter(hero->hero==h).findAny().isPresent()) {
      return attacker;
    } else {
      return defender;
    }
  }

  public Team getOpposingTeam(Hero h) {
    if(attacker.getHeroes().stream().filter(hero->hero==h).findAny().isPresent()) {
      return defender;
    } else {
      return attacker;
    }
  }

}

// end of file
