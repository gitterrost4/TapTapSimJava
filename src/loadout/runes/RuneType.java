// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

import java.util.function.Function;

/** 
 * enumeration of all rune types
 *
 */
public enum RuneType {
  NONE("None", rarity->new EmptyRune(rarity)),
  VITALITY("Vitality Rune", rarity->new VitalityRune(rarity)),
  HP("HP Rune", rarity->new HPRune(rarity)),
  ATTACK("Attack Rune", rarity->new AttackRune(rarity)),
  BREAK("Break Rune", rarity->new BreakRune(rarity)),
  CRITDMG("Critdmg Rune", rarity->new CritdmgRune(rarity)),
  CRITRATE("Critrate Rune", rarity->new CritrateRune(rarity)),
  DEFENSE("Defense Rune", rarity->new DefenseRune(rarity)),
  EVASION("Evasion Rune", rarity->new EvasionRune(rarity)),
  SKILLDMG("Skilldmg Rune", rarity->new SkilldmgRune(rarity)),
  SPEED("Speed Rune", rarity->new SpeedRune(rarity)),
  STORMATTACK("Storm Attack Rune", rarity->new StormAttackRune(rarity)),
  TRUE("True Rune", rarity->new TrueRune(rarity)),
  ACCURACY("Accuracy Rune", rarity->new AccuracyRune(rarity))
  ;

  private Function<RuneRarity,AbstractRune> creator;
  private String theName;
  
  private RuneType(String name, Function<RuneRarity,AbstractRune> creator) {
    this.theName=name;
    this.creator=creator;
  }
  
  public AbstractRune create(RuneRarity rarity) {
    return creator.apply(rarity);
  }

  public String getName() {
    return theName;
  }
}


// end of file
