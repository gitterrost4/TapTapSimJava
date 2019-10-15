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
   * return the faction of the hero
   * 
   * @return
   */
  public Faction getFaction();

  /**
   * return the class of the hero
   * 
   * @return
   */
  public HeroClass getHeroClass();

  /**
   * return the level of the hero
   * 
   * @return
   */
  public Integer getLevel();
  
  /**
   * return the crit rate of the hero
   * 
   * @return
   */
  public BigDecimal getCritRate();

  /**
   * Increase the crit rate of a hero by an amount
   * 
   * @param amount
   */
  public void increaseCritRate(BigDecimal amount);
  
  /**
   * return the crit rate of the hero
   * 
   * @return
   */
  public BigDecimal getCritDamage();

  /**
   * Increase the crit rate of a hero by an amount
   * 
   * @param amount
   */
  public void increaseCritDamage(BigDecimal amount);
  
  /**
   * return the dodge chance of the hero
   * 
   * @return
   */
  public BigDecimal getDodgeRate();
  
  /**
   * increase the dodge chance of a hero by an amount
   * 
   * @param amount
   */
  public void increaseDodgeChance(BigDecimal amount);

  /**
   * return the skill damage of the hero
   * 
   * @return
   */
  public BigDecimal getSkillDamage();
  
  /**
   * increase the skill damage of a hero by an amount
   * 
   * @param amount
   */
  public void increaseSkillDamage(BigDecimal amount);

  /**
   * return the defense break of the hero
   * 
   * @return
   */
  public BigDecimal getDefenseBreak();
  
  /**
   * increase the defense break of a hero by an amount
   * 
   * @param amount
   */
  public void increaseDefenseBreak(BigDecimal amount);

  /**
   * return the hit rate of the hero
   * 
   * @return
   */
  public BigDecimal getHitRate();
  
  /**
   * increase the hit rate of a hero by an amount
   * 
   * @param amount
   */
  public void increaseHitRate(BigDecimal amount);

  /**
   * return the hit rate of the hero
   * 
   * @return
   */
  public Integer getSpeed();
  
  /**
   * increase the hit rate of a hero by an amount
   * 
   * @param amount
   */
  public void increaseSpeed(Integer amount);
  
  /**
   * return the defense of the hero
   * 
   * @return
   */
  public Integer getDefense();
  
  /**
   * increase the defense of the hero by an amount
   * 
   * @param amount
   */
  public void increaseDefense(Integer amount);
  
  /**
   * return the true damage of the hero
   * 
   * @return
   */
  public BigDecimal getTrueDamage();
  
  /**
   * increase the true damage of the hero by an amount
   * 
   * @param amount
   */
  public void increaseTrueDamage(BigDecimal amount);
  

}


// end of file
