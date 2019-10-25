package util;

import java.math.BigDecimal;

/**
 * Utilities class containing various methods that are needed throughout the
 * project
 */
public class Utilities {

  /**
   * Do a random coin toss with a certain probability to be true
   * 
   * @param chance
   *        chance for this toss to be true
   * @return true if the coin toss was successful
   */
  public static boolean getRandomThrow(BigDecimal chance) {
    return new BigDecimal(Math.random()).compareTo(chance) <= 0;
  }

}
