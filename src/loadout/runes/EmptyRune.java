// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import heroes.Hero;

/**
 * implementation of the accuracy rune
 *
 */
public class EmptyRune extends AbstractRune {
  public EmptyRune(RuneRarity rarity) {
    super(RuneType.NONE, rarity);
  }

  @Override
  public void apply(Hero hero) {
  }

}

// end of file
