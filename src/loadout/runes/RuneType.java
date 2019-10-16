// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.util.function.Function;

/** 
 * TODO documentation
 *
 */
public enum RuneType {
  NONE(rarity->new EmptyRune(rarity)),
  VITALITY(rarity->new VitalityRune(rarity)),
  ACCURACY(rarity->new AccuracyRune(rarity))
  ;

  private Function<RuneRarity,AbstractRune> creator;
  private RuneType(Function<RuneRarity,AbstractRune> creator) {
    this.creator=creator;
  }
  
  public AbstractRune create(RuneRarity rarity) {
    return creator.apply(rarity);
  }
}


// end of file
