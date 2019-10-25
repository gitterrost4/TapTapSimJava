// $Id $
package effects;

/**
 * This (empty) effect represents silence. If it's present in a hero, the hero
 * is not able to skill attack
 *
 */
public class Stun extends TemporaryEffect {

  public Stun(int length) {
    super(h -> null, h -> null, h -> null, "Silence", length);
  }

}

// end of file
