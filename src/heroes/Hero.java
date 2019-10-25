// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

import battle.BattleSetting;
import battle.logging.LogItem;
import battle.logging.LogMessage;
import effects.TemporaryEffect;

/**
 * Interface for the basic hero functions
 *
 */
public interface Hero {

  /**
   * Let the hero take damage
   * 
   * @param source   source of the damage whose stats are used for calculation
   * @param modifier the amount of damage that the hero should take
   * @return
   */
  public LogItem damage(Integer amount);

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
   * get the current Energy (0-100) of a hero
   * 
   * @return
   */
  public BigDecimal getCurrentEnergy();

  /**
   * Increase the attack of a hero.
   * 
   * @param amount amount to increase. Pass a negative number to decrease the
   *               attack
   * @return
   */
  public LogItem increaseAttack(int amount);

  /**
   * Increase the maxHP of a hero.
   * 
   * @param amount amount to increase. Pass a negative number to decrease the
   *               maxHP
   * @return
   */
  public LogItem increaseMaxHP(int amount);

  /**
   * Add a multiplicator for the attack
   * 
   * @param modifier
   */
  public LogItem addAttackModifier(BigDecimal modifier);

  /**
   * Add a multiplicator for the hp
   * 
   * @param modifier
   */
  public LogItem addMaxHPModifier(BigDecimal modifier);

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
  public LogItem increaseCritRate(BigDecimal amount);

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
  public LogItem increaseCritDamage(BigDecimal amount);

  /**
   * return the dodge chance of the hero
   * 
   * @return
   */
  public BigDecimal getDodgeChance();

  /**
   * increase the dodge chance of a hero by an amount
   * 
   * @param amount
   */
  public LogItem increaseDodgeChance(BigDecimal amount);

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
  public LogItem increaseSkillDamage(BigDecimal amount);

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
  public LogItem increaseDefenseBreak(BigDecimal amount);

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
  public LogItem increaseHitRate(BigDecimal amount);

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
  public LogItem increaseSpeed(Integer amount);

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
  public LogItem increaseDefense(Integer amount);

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
  public LogItem increaseTrueDamage(BigDecimal amount);

  /**
   * get the control resist of the hero
   * 
   * @return
   */
  public BigDecimal getControlResist();

  /**
   * increase the control resist of the hero by an amount
   * 
   * @param amount
   */
  public LogItem increaseControlResist(BigDecimal amount);

  /**
   * get the silence resistance
   * 
   * @return
   */
  public BigDecimal getSilenceResistance();

  /**
   * increase the silence resist of the hero by an amount
   * 
   * @param amount
   */
  public LogItem increaseSilenceResistance(BigDecimal amount);

  /**
   * increase the energy of the hero by an amount
   * 
   * @param amount
   */
  public LogItem increaseEnergy(BigDecimal amount);

  /**
   * add ExDMGToAssassin to the hero
   * 
   * @param bigDecimal
   */
  public LogItem increaseAssassinDamageModifier(BigDecimal amount);

  /**
   * get the ExDMGToAssassin stat
   * 
   * @return
   */
  public BigDecimal getAssassinDamageModifier();

  /**
   * add ExDMGToWarrior to the hero
   * 
   * @param bigDecimal
   */
  public LogItem increaseWarriorDamageModifier(BigDecimal amount);

  /**
   * get the ExDMGToWarrior stat
   * 
   * @return
   */
  public BigDecimal getWarriorDamageModifier();

  /**
   * add ExDMGToWanderer to the hero
   * 
   * @param bigDecimal
   */
  public LogItem increaseWandererDamageModifier(BigDecimal amount);

  /**
   * get the ExDMGToWanderer stat
   * 
   * @return
   */
  public BigDecimal getWandererDamageModifier();

  /**
   * add ExDMGToMage to the hero
   * 
   * @param bigDecimal
   */
  public LogItem increaseMageDamageModifier(BigDecimal amount);

  /**
   * get the ExDMGToMage stat
   * 
   * @return
   */
  public BigDecimal getMageDamageModifier();

  /**
   * add ExDMGToCleric to the hero
   * 
   * @param bigDecimal
   */
  public LogItem increaseClericDamageModifier(BigDecimal amount);

  /**
   * get the ExDMGToCleric stat
   * 
   * @return
   */
  public BigDecimal getClericDamageModifier();

  /**
   * get the DamageReduce stat for the hero
   * 
   * @return
   */
  public BigDecimal getDamageReduce();

  /**
   * increase the damage reduce stat for the hero
   * 
   * @param bigDecimal
   */
  public LogItem increaseDamageReduce(BigDecimal amount);

  /**
   * add an onDeath Effect to the hero
   * 
   * @param action
   */
  public void addOnDeathAction(Function<BattleSetting, LogItem> action);

  public void initTeam(BattleSetting setting);

  public LogItem addTemporaryEffect(TemporaryEffect effect);

  public LogItem triggerTemporaryEffects();

  public LogItem basicAttack(BattleSetting setting);

  public LogItem skillAttack(BattleSetting setting);

  public boolean isDead();

  public boolean isDying();

  public String getName();

  public String getFullName();

  public void setPosition(Integer pos);

  /**
   * execute an attack. The implementing class decides for itself what type of
   * attack it is
   * 
   * @param setting the current battle setting to act upon
   */
  public LogItem doAttack(BattleSetting setting);

  public void setAttacker();

  public void setDefender();

  public LogItem zeroEnergy();

  LogMessage logMessage(String message);

  LogItem getInformation();

  public LogItem die(BattleSetting setting);

  public LogItem heal(Integer baseStat,BigDecimal modifier);

  public void addOnHitAction(BiFunction<BattleSetting,Hero,LogItem> action);
  
  public void setCurrentHPToMaxHP();

  LogItem receiveAttack(BattleSetting setting,Hero source,BigDecimal skillStrength,boolean isActiveSkill,
    boolean canBeDodged,Function<Hero,LogItem> onHitAction);
  
}

// end of file
