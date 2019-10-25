// $Id $
package loadout.runes;

import battle.logging.LogItem;
import battle.logging.LogMessage;
import loadout.HeroModifier;

/**
 * An abstract representation of a rune
 */
public abstract class AbstractRune implements HeroModifier {
  /** the type of the rune */
  private final RuneType runeType;
  /** the rarity of the rune */
  private final RuneRarity runeRarity;

  /**
   * constructor setting the type and rarity
   * 
   * @param runeType
   *        the type of the rune
   * @param runeRarity
   *        the rarity of the rune
   */
  AbstractRune(RuneType runeType, RuneRarity runeRarity) {
    this.runeType = runeType;
    this.runeRarity = runeRarity;
  }

  /**
   * @return a log item containing identifying information about the rune
   */
  public LogItem getInformation() {
    return new LogMessage(runeRarity.getName() + " " + runeType.getName());
  }
}

// end of file
