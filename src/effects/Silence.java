// $Id $
// (C) cantamen/Paul Kramer 2019
package effects;

/** 
 * This (empty) effect represents silence. If it's present in a hero, the hero is not able to skill attack
 *
 */
public class Silence extends TemporaryEffect {

  public Silence(int length) {
    super(h->{},h->{},h->{},length);
  }

}


// end of file
