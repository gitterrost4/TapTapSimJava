// $Id $
// (C) cantamen/Paul Kramer 2019
package effects;

/**
 * This (empty) effect represents silence. If it's present in a hero, the hero
 * is not able to skill attack
 *
 */
public class Silence extends TemporaryEffect {

  public Silence(int length) {
    super(h -> null, h -> null, h -> null, "Silence", length);
  }

}

// end of file
