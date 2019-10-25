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

  public Player(GuildTech guildTech, Familiars familiars) {
    super();
    this.guildTech = guildTech;
    this.familiars = familiars;
  }

  public static Player max(FamiliarType activeFamiliar) {
    return new Player(GuildTech.max(), Familiars.max(activeFamiliar));
  }

  public void apply(Hero hero) {
    guildTech.apply(hero);
    familiars.apply(hero);
  }
}

// end of file
