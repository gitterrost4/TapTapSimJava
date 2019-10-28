// $Id $
package player;

import heroes.Hero;
import player.Familiars.FamiliarType;

/**
 * Class encapsulating all player-based buffs
 *
 */
public class Player {
  private final GuildTech guildTech;
  private final Familiars familiars;

  /**
   * create a player object by giving it the tech and familiar information
   * 
   * @param guildTech the guild tech of the player 
   * @param familiars information about all the familiars of the player
   */
  public Player(GuildTech guildTech, Familiars familiars) {
    super();
    this.guildTech = guildTech;
    this.familiars = familiars;
  }

  /**
   * create a maxed out player by specifying which familiar is active
   * 
   * @param activeFamiliar the name of the active familiar
   * @return a maxed player object
   */
  public static Player max(FamiliarType activeFamiliar) {
    return new Player(GuildTech.max(), Familiars.max(activeFamiliar));
  }

  /**
   * apply the passive bonuses from familiars and guild tech to a hero
   * 
   * @param hero the hero the bonuses should be applied to
   */
  public void apply(Hero hero) {
    guildTech.apply(hero);
    familiars.apply(hero);
  }

  /**
   * @return the familiars of the player
   */
  public Familiars getFamiliars() {
    return familiars;
  }
}

// end of file
