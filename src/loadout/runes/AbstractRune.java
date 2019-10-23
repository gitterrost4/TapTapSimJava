// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import battle.logging.LogItem;
import battle.logging.LogMessage;
import loadout.HeroModifier;

/**
 * An abstract representation of a rune
 *
 */
public abstract class AbstractRune implements HeroModifier {
  private final RuneType runeType;
  private final RuneRarity runeRarity;

  AbstractRune(RuneType runeType, RuneRarity runeRarity) {
    this.runeType = runeType;
    this.runeRarity = runeRarity;
  }

  public LogItem getInformation() {
    return new LogMessage(runeRarity.getName() + " " + runeType.getName());
  }
}

// end of file
