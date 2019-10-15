package heroes;

import java.math.BigDecimal;

/** 
 * Abstract implementation of a hero that contains basic stuff such as stats, equipment, and so on
 *
 */
/** 
 * 
 *
 */
public abstract class AbstractHero implements Hero{
  /**
   * the maximum amount of HP this hero can have
   */
  public final Integer maxHP;
  
  /**
   * the current amount of HP this hero has (different to maxHP if the hero is damaged)
   */
  private Integer currentHP;
  
  /**
   * currentEnergy a hero has
   */
  private Integer currentEnergy;

  /**
   * attack stat of the hero
   */
  private Integer attack;
 
  /**
   * dodge stat of the hero
   */
  private BigDecimal dodge;

  /**
   * armor stat of the hero
   */
  private Integer armor;
  
  public AbstractHero(Integer maxHP) {
    super();
    this.maxHP=maxHP;
    this.currentHP=maxHP;
    this.currentEnergy=50;
  }

  @Override
  public void damage(Integer amount) {
    this.currentHP = Math.max(0,this.currentHP-amount);    
  }

  @Override
  public Integer getCurrentHP() {
    return currentHP;
  }

  @Override
  public Integer getMaxHP() {
    return maxHP;
  }

  @Override
  public Integer getAttack() {
    return attack;
  }

  @Override
  public BigDecimal getDodge() {
    return dodge;
  }

  @Override
  public Integer getArmor() {
    return armor;
  }

  @Override
  public Integer getCurrentEnergy() {
    return currentEnergy;
  }
  
}


// end of file
