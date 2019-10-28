// $Id $
package battle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import battle.logging.Log;
import battle.logging.LogItem;
import heroes.Hero;
import player.Familiars.AbstractFamiliar;

/**
 * The setting for the battle; basically only consisting of the two teams
 */
public class BattleSetting {
  private final Team attacker;
  private final Team defender;

  public BattleSetting(Team attacker, Team defender) {
    super();
    this.attacker = attacker;
    this.defender = defender;
    attacker.getHeroes().stream().forEach(h -> {
      h.initTeam(this);
      h.setAttacker();
      h.setCurrentHPToMaxHP();
    });
    defender.getHeroes().stream().forEach(h -> {
      h.initTeam(this);
      h.setDefender();
      h.setCurrentHPToMaxHP();
    });
    attacker.getActiveFamiliar().setAttacker();
    attacker.getActiveFamiliar().setDefender();
  }

  public Team getAttacker() {
    return attacker;
  }

  public Team getDefender() {
    return defender;
  }

  public List<Hero> getSpeedSortedHeroList() {
    return Stream.concat(attacker.getHeroes().stream(), defender.getHeroes().stream())
        .sorted((h1, h2) -> h2.getSpeed().compareTo(h1.getSpeed())).collect(Collectors.toList());
  }

  public Team getOwnTeam(Hero h) {
    if (attacker.getHeroes().stream().filter(hero -> hero == h).findAny().isPresent()) {
      return attacker;
    } else {
      return defender;
    }
  }

  public Team getOpposingTeam(Hero h) {
    if (attacker.getHeroes().stream().filter(hero -> hero == h).findAny().isPresent()) {
      return defender;
    } else {
      return attacker;
    }
  }

  /**
   * return the opposing team for a familiar
   * 
   * @param f the familiar in question
   * @return the team object of the attacker or defender, depending on which side the familiar is on
   */
  public Team getOpposingTeam(AbstractFamiliar f) {
    if (attacker.getPlayer().getFamiliars().getActiveFamiliar()==f) {
      return defender;
    } else {
      return attacker;
    }
  }

  /**
   * @param f the familiar in question
   * @return true, iff the familiar is on the active team
   */
  public boolean isAttacker(AbstractFamiliar f) {
    return attacker.getPlayer().getFamiliars().getActiveFamiliar()==f;
  }

  public LogItem getInformation() {
    Log log = new Log();
    log.addMessage("Attacking Team:");
    log.addItem(attacker.getInformation());
    log.addMessage("Defending Team:");
    log.addItem(defender.getInformation());
    return log;
  }

  public Log checkHeroesDied() {
    Log log = new Log();
    attacker.getHeroes(true, false).stream().filter(h -> h.getCurrentHP() <= 0).forEach(h -> log.addItem(h.die(this)));
    defender.getHeroes(true, false).stream().filter(h -> h.getCurrentHP() <= 0).forEach(h -> log.addItem(h.die(this)));
    if (!log.isEmpty()) {
      log.merge(checkHeroesDied());
    }
    return log;
  }

}

// end of file
