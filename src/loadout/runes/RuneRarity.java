// $Id $
// (C) cantamen/Paul Kramer 2019
package loadout.runes;

/**
 * enumeration of all rune rarities
 *
 */
public enum RuneRarity {
  NONE("None"), 
  BLUE1("Blue 1★"), 
  BLUE2("Blue 1★"), 
  GREEN1("Green 1★"), 
  GREEN2("Green 2★"), 
  GOLD1("Gold 1★"), 
  GOLD2("Gold 2★"), 
  GOLD3("Gold 3★"), 
  PURPLE1("Purple 1★"), 
  PURPLE2("Purple 2★"), 
  PURPLE3("Purple 3★"), 
  ORANGE1("Orange 1★"), 
  ORANGE2("Orange 2★"), 
  ORANGE3("Orange 3★"),
  ORANGE4("Orange 4★"), 
  RED1("Red 1★"), 
  RED2("Red 2★");

  private final String theName;

  private RuneRarity(String name) {
    this.theName = name;
  }

  public String getName() {
    return theName;
  }
}

// end of file
