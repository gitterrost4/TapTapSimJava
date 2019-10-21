// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.util.function.Function;

/** 
 * enumeration of all rune types
 *
 */
public enum RuneType {
  NONE(rarity->new EmptyRune(rarity)),
  VITALITY(rarity->new VitalityRune(rarity)),
  HP(rarity->new HPRune(rarity)),
  ATTACK(rarity->new AttackRune(rarity)),
  BREAK(rarity->new BreakRune(rarity)),
  CRITDMG(rarity->new CritdmgRune(rarity)),
  CRITRATE(rarity->new CritrateRune(rarity)),
  DEFENSE(rarity->new DefenseRune(rarity)),
  EVASION(rarity->new EvasionRune(rarity)),
  SKILLDMG(rarity->new SkilldmgRune(rarity)),
  SPEED(rarity->new SpeedRune(rarity)),
  STORMATTACK(rarity->new StormAttackRune(rarity)),
  TRUE(rarity->new TrueRune(rarity)),
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
