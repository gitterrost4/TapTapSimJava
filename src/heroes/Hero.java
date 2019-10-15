// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.math.BigDecimal;

/** 
 * Interface for the basic hero functions
 *
 */
public interface Hero {
  
  /**
   * Let the hero take damage
   * 
   * @param amount the amount of damage that the hero should take
   */
  public void damage(Integer amount);
  
  /**
   * get the current hp of a hero
   * 
   * @return
   */
  public Integer getCurrentHP();
  
  /**
   * get the maximum amount of HP of a Hero
   * 
   * @return
   */
  public Integer getMaxHP();
  
  /**
   * get the attack stat of a hero
   * 
   * @return
   */
  public Integer getAttack();
  
  /**
   * get the dodge stat of a hero
   * 0.2 means a 20% chance of dodging
   * 
   * @return
   */
  public BigDecimal getDodge();
  
  /**
   * get the armor stat of a hero
   * 
   * @return
   */
  public Integer getArmor();
  
  /**
   * get the current Energy (0-100) of a hero
   * 
   * @return
   */
  public Integer getCurrentEnergy();
  
  /**
   * Increase the attack of a hero. 
   * 
   * @param amount amount to increase. Pass a negative number to decrease the attack
   * @return
   */
  public void increaseAttack(int amount);

  /**
   * Increase the maxHP of a hero. 
   * 
   * @param amount amount to increase. Pass a negative number to decrease the maxHP
   * @return
   */
  public void increaseMaxHP(int amount);

  /**
   * Add a multiplicator for the attack
   * 
   * @param modifier
   */
  public void addAttackModifier(BigDecimal modifier);
  
  /**
   * Add a multiplicator for the hp
   * 
   * @param modifier
   */
  public void addMaxHPModifier(BigDecimal modifier);
  
  /**
   * Increase the hit rate stat
   * 
   * @param amount
   */
  public void increaseHitRate(int amount);
}


// end of file
