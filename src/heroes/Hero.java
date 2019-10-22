// $Id $
// (C) cantamen/Paul Kramer 2019
package heroes;

import java.math.BigDecimal;
import java.util.function.Consumer;

import battle.BattleSetting;
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
   */
  public void damage(Hero source, BigDecimal modifier);

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
   * @param amount amount to increase. Pass a negative number to decrease the
   *               attack
   * @return
   */
  public void increaseAttack(int amount);

  /**
   * Increase the maxHP of a hero.
   * 
   * @param amount amount to increase. Pass a negative number to decrease the
   *               maxHP
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
  public BigDecimal getDodgeChance();

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
  public void increaseControlResist(BigDecimal amount);

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
  public void increaseSilenceResistance(BigDecimal amount);

  /**
   * increase the energy of the hero by an amount
   * 
   * @param amount
   */
  public void increaseEnergy(Integer amount);

  /**
   * add ExDMGToAssassin to the hero
   * 
   * @param bigDecimal
   */
  public void increaseAssassinDamageModifier(BigDecimal amount);

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
  public void increaseWarriorDamageModifier(BigDecimal amount);

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
  public void increaseWandererDamageModifier(BigDecimal amount);

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
  public void increaseMageDamageModifier(BigDecimal amount);

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
  public void increaseClericDamageModifier(BigDecimal amount);

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
  public void increaseDamageReduce(BigDecimal amount);

  /**
   * add an onDeath Effect to the hero
   * 
   * @param effect
   */
  public void addOnDeathAction(Consumer<BattleSetting> effect);

  public void initTeam(BattleSetting setting);

  public void addTemporaryEffect(TemporaryEffect effect);

  public void basicAttack(BattleSetting setting);

  public void skillAttack(BattleSetting setting);

  public boolean isDead();

  /**
   * execute an attack. The implementing class decides for itself what type of
   * attack it is
   * 
   * @param setting the current battle setting to act upon
   */
  public void doAttack(BattleSetting setting);
}

// end of file
