// $Id $
package heroes;

/**
 * Enumeration of all hero factions
 *
 */
public enum Faction {
  ALLIANCE, HORDE, ELF, UNDEAD, HEAVEN, HELL;

  /**
   * Returns the faction that this faction has an advantage over
   * 
   * @return
   */
  public Faction getAdvantageFaction() {
    switch (this) {
    case ALLIANCE:
      return HORDE;
    case ELF:
      return UNDEAD;
    case HEAVEN:
      return HELL;
    case HELL:
      return HEAVEN;
    case HORDE:
      return ELF;
    case UNDEAD:
      return ALLIANCE;
    default:
      throw new IllegalStateException("Faction not handled"); // not possible to get here
    }
  }
}

// end of file
