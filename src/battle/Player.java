// $Id $
// (C) cantamen/Paul Kramer 2019
package battle;

/** 
 * TODO documentation
 *
 */
public class Player {
  private final GuildTech guildTech;

  public Player(GuildTech guildTech) {
    super();
    this.guildTech=guildTech;
  }

  /**
   * get the guild tech of the player
   * 
   * @return
   */
  public GuildTech getGuildTech() {
    return guildTech;
  }
  
}


// end of file
