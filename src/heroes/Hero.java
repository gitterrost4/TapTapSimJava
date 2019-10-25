// $Id $
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
 */
public interface Hero {

  /**
   * Let the hero take damage
   * 
   * @param amount
   *        amount of damage the hero should take
   * @return A log item containing the logged information of this operation
   */
  public LogItem damage(Integer amount);

  /**
   * @return the current HP of the hero
   */
  public Integer getCurrentHP();

  /**
   * @return the maximum HP of the hero (including all current bonuses)
   */
  public Integer getMaxHP();

  /**
   * @return the attack stat of the hero (including all current bonuses)
   */
  public Integer getAttack();

  /**
   * @return get the currentEnergy of the hero (can go above 100 because of the
   *         internal buffer; TODO: Check if this works like this)
   */
  public BigDecimal getCurrentEnergy();

  /**
   * Increase the attack of a hero.
   * 
   * @param amount
   *        amount to increase. Pass a negative number to decrease the attack
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseAttack(int amount);

  /**
   * Increase the maxHP of a hero.
   * 
   * @param amount
   *        amount to increase. Pass a negative number to decrease the maxHP
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseMaxHP(int amount);

  /**
   * Add a multiplicator for the attack
   * 
   * @param modifier
   *        the modifier to be added to the attack stat
   * @return A log item containing the logged information of this operation
   */
  public LogItem addAttackModifier(BigDecimal modifier);

  /**
   * Add a multiplicator for the hp
   * 
   * @param modifier
   *        the modifier to be added to the maxHP stat
   * @return A log item containing the logged information of this operation
   */
  public LogItem addMaxHPModifier(BigDecimal modifier);

  /**
   * @return the faction of the hero
   */
  public Faction getFaction();

  /**
   * @return the class of the hero
   */
  public HeroClass getHeroClass();

  /**
   * @return the level of the hero
   */
  public Integer getLevel();

  /**
   * @return the critRate stat of the hero
   */
  public BigDecimal getCritRate();

  /**
   * Increase the crit rate of a hero by an amount
   * 
   * @param amount
   *        amount to increase critRate by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseCritRate(BigDecimal amount);

  /**
   * @return the critDamage stat of the hero
   */
  public BigDecimal getCritDamage();

  /**
   * Increase the critDamage of a hero by an amount
   * 
   * @param amount
   *        amount to increase the critDamage by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseCritDamage(BigDecimal amount);

  /**
   * @return the dodge chance of the hero
   */
  public BigDecimal getDodgeChance();

  /**
   * increase the dodge chance of a hero by an amount
   * 
   * @param amount
   *        amount to increase the dodge chance by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseDodgeChance(BigDecimal amount);

  /**
   * @return the skillDamage stat of the hero
   */
  public BigDecimal getSkillDamage();

  /**
   * increase the skillDamage stat of a hero by an amount
   * 
   * @param amount
   *        amount to increase the skillDamage stat by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseSkillDamage(BigDecimal amount);

  /**
   * @return the defenseBreak (sometimes armorBreak) stat of the hero
   */
  public BigDecimal getDefenseBreak();

  /**
   * increase the defenseBreak (sometimes armorBreak) stat of a hero by an amount
   * 
   * @param amount
   *        amount to increase defenseBreak by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseDefenseBreak(BigDecimal amount);

  /**
   * @return the hitRate stat of the hero
   */
  public BigDecimal getHitRate();

  /**
   * increase the hitRate stat of a hero by an amount
   * 
   * @param amount
   *        amount to increase hitRate by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseHitRate(BigDecimal amount);

  /**
   * @return the speed stat of the hero
   */
  public Integer getSpeed();

  /**
   * increase the speed stat of a hero by an amount
   * 
   * @param amount
   *        to increase speed by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseSpeed(Integer amount);

  /**
   * @return the defense (sometimes armor) stat of the hero
   */
  public Integer getDefense();

  /**
   * increase the defense (sometimes armor) stat of the hero by an amount
   * 
   * @param amount
   *        amount to increase defense by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseDefense(Integer amount);

  /**
   * @return the trueDamage stat of the hero
   */
  public BigDecimal getTrueDamage();

  /**
   * increase the trueDamage stat of the hero by an amount
   * 
   * @param amount
   *        amount to increase trueDamage by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseTrueDamage(BigDecimal amount);

  /**
   * @return the controlResist stat of the hero
   */
  public BigDecimal getControlResist();

  /**
   * increase the controlResist stat of the hero by an amount
   * 
   * @param amount
   *        amount to increase controlResist by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseControlResist(BigDecimal amount);

  /**
   * @return the silenceResistance stat
   */
  public BigDecimal getSilenceResistance();

  /**
   * increase the silenceResistance stat of the hero by an amount
   * 
   * @param amount
   *        amount to increase silenceResistance by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseSilenceResistance(BigDecimal amount);

  /**
   * increase the current energy of the hero by an amount
   * 
   * @param amount
   *        amount to increase energy by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseCurrentEnergy(BigDecimal amount);

  /**
   * increase the ExDMGToAssassin stat of the hero
   * 
   * @param amount
   *        amount to increase ExDMGToAssassin by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseAssassinDamageModifier(BigDecimal amount);

  /**
   * @return the ExDMGToAssassin stat of the hero
   */
  public BigDecimal getAssassinDamageModifier();

  /**
   * increase the ExDMGToWarrior stat of the hero
   * 
   * @param amount
   *        amount to increase ExDMGToWarrior by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseWarriorDamageModifier(BigDecimal amount);

  /**
   * @return the ExDMGToWarrior stat of the hero
   */
  public BigDecimal getWarriorDamageModifier();

  /**
   * increase the ExDMGToWanderer stat of the hero
   * 
   * @param amount
   *        amount to increase ExDMGToWanderer by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseWandererDamageModifier(BigDecimal amount);

  /**
   * @return the ExDMGToWanderer stat of the hero
   */
  public BigDecimal getWandererDamageModifier();

  /**
   * increase the ExDMGToMage stat of the hero
   * 
   * @param amount
   *        amount to increase ExDMGToMage by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseMageDamageModifier(BigDecimal amount);

  /**
   * @return the ExDMGToMage stat of the hero
   */
  public BigDecimal getMageDamageModifier();

  /**
   * increase the ExDMGToCleric stat of the hero
   * 
   * @param amount
   *        amount to increase ExDMGToCleric by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseClericDamageModifier(BigDecimal amount);

  /**
   * @return the ExDMGToCleric stat of the hero
   */
  public BigDecimal getClericDamageModifier();

  /**
   * @return the DamageReduce stat of the hero
   */
  public BigDecimal getDamageReduce();

  /**
   * increase the damageReduce stat for the hero
   * 
   * @param amount
   *        amount to increase the damageReduce stat by
   * @return A log item containing the logged information of this operation
   */
  public LogItem increaseDamageReduce(BigDecimal amount);

  /**
   * add an onDeath Effect to the hero
   * 
   * @param action
   *        Function to be executed when a hero dies that takes the complete
   *        battle setting and outputs a log item containing the logged
   *        information of that action
   */
  public void addOnDeathAction(Function<BattleSetting, LogItem> action);

  /**
   * initialize the team(s) in regard to this hero. This should be overridden by
   * each hero and contains stuff like Phoenix's passive skill increasing all
   * allies' Attack to burning enemies. Basically anything that the hero does to
   * its own team (or even the enemy team) goes in here
   * 
   * @param setting
   *        the complete battle setup
   */
  public void initTeam(BattleSetting setting);

  /**
   * add a temporary effect (poison, silence, etc...; also heal, or buffs that
   * last a number of rounds) to the hero.
   * 
   * @param effect
   *        the effect to be added
   * @return A log item containing the logged information of this operation
   */
  public LogItem addTemporaryEffect(TemporaryEffect effect);

  /**
   * trigger all temporary effects (at the end of a round for example)
   * 
   * @return A log item containing the logged information of this operation
   */
  public LogItem triggerTemporaryEffects();

  /**
   * Execute a basic attack. This can be overridden by each hero if they do
   * something special on a basic attack.
   * 
   * @param setting
   *        the complete battle setting
   * @return A log item containing the logged information of this operation
   */
  public LogItem basicAttack(BattleSetting setting);

  /**
   * Execute a skill attack (active skill #1). This must be overridden by each
   * hero.
   * 
   * @param setting
   *        the complete battle setting
   * @return A log item containing the logged information of this operation
   */
  public LogItem skillAttack(BattleSetting setting);

  /**
   * @return true if the hero is dead and all the death effects have triggered
   */
  public boolean isDead();

  /**
   * @return true if the hp of the hero are 0, but the death effects must not
   *         necessarily have triggered yet (very short amount of time). if
   *         Hero::isDead is true, this will always be true. The reverse does not
   *         apply
   */
  public boolean isDying();

  /**
   * @return the name of the hero in a human-readable form
   */
  public String getName();

  /**
   * @return the full identifier of the hero, including its name, team (A(ttacker)
   *         or D(efender) and position (1-6))
   */
  public String getFullName();

  /**
   * set the position of the hero in the team. This is numbered from 1 to 6 where
   * 1 is the "tank" position and the following numbers are the heroes that would
   * be attacked by a normal basic attack when all other heroes with a smaller
   * index are dead
   * 
   * @param pos
   *        position (1-6) the hero should be put in
   */
  public void setPosition(Integer pos);

  /**
   * execute an attack. The implementing class decides for itself what type of
   * attack it is (basic or skill)
   * 
   * @param setting
   *        the current battle setting to act upon
   * @return A log item containing the logged information of this operation
   */
  public LogItem doAttack(BattleSetting setting);

  /**
   * set this hero to be on the attacking team
   */
  public void setAttacker();

  /**
   * set this hero to be on the defending team
   */
  public void setDefender();

  /**
   * set the current energy of this hero to 0
   * 
   * @return A log item containing the logged information of this operation
   */
  public LogItem zeroEnergy();

  /**
   * Create a log message that includes information about the hero where this
   * message originates. You usually should use this method when logging anything
   * from within a hero
   * 
   * @param message
   *        the message to be formatted
   * @return a LogMessage object containing the hero information and the message
   */
  public LogMessage logMessage(String message);

  /**
   * @return a log item containing textual information about the hero like the
   *         name, the level, the equipment, etc.
   */
  public LogItem getInformation();

  /**
   * Let this hero die and trigger everything that's necessary when this hero
   * dies. The contract is that after calling this method, the method
   * Hero::isDead() returns a true value
   * 
   * @param setting
   *        the complete battle setting
   * @return A log item containing the logged information of this operation
   */
  public LogItem die(BattleSetting setting);

  /**
   * Heal the hero by an amount
   * 
   * @param baseStat
   *        the numerical value of the base stat used for calculating the restored
   *        HP (usually Attack of the healer)
   * @param modifier
   *        the modifier of the base stat (usually in the skill description like
   *        in "(130% of Attack)". (this would lead to a modifier of 1.3)
   * @return A log item containing the logged information of this operation
   */
  public LogItem heal(Integer baseStat, BigDecimal modifier);

  /**
   * add an onHit Effect to the hero
   * 
   * @param action
   *        BiFunction to be executed when a hero is hit that takes the complete
   *        battle setting and a reference to the source hero of the hit and
   *        outputs a log item containing the logged information of that action
   */
  public void addOnHitAction(BiFunction<BattleSetting, Hero, LogItem> action);

  /**
   * set the current HP of the hero to the maximum HP of the hero. This is
   * intended to be called after all modifiers to maxHP are calculated and before
   * the battle starts
   */
  public void setCurrentHPToMaxHP();

  /**
   * @return true iff the hero has a "burn" effect
   */
  public boolean isBurning();

  /**
   * @return true iff the hero has a "poison" effect
   */
  public boolean isPoisoned();

  /**
   * @return true iff the hero has a "petrify" effect
   */
  public boolean isPetrified();

  /**
   * @return true iff the hero has a "stun" effect
   */
  public boolean isStunned();

  /**
   * @return true iff the hero has a "bleed" effect
   */
  public boolean isBleeding();

  /**
   * @return true iff the hero has a "freeze" effect
   */
  public boolean isFrozen();

  /**
   * @return true iff the hero has a "silence" effect
   */
  public boolean isSilenced();

  /**
   * @return the ExDMGToBurning stat of the hero
   */
  public BigDecimal getBurningDamageModifier();

  /**
   * @return the ExDMGToPoisoned stat of the hero
   */
  public BigDecimal getPoisonedDamageModifier();

  /**
   * @return the ExDMGToPetrified stat of the hero
   */
  public BigDecimal getPetrifiedDamageModifier();

  /**
   * @return the ExDMGToBleeding stat of the hero
   */
  public BigDecimal getBleedingDamageModifier();

  /**
   * @return the ExDMGToFrozen stat of the hero
   */
  public BigDecimal getFrozenDamageModifier();

  /**
   * @return the ExDMGToSilenced stat of the hero
   */
  public BigDecimal getSilencedDamageModifier();

  /**
   * @return the ExDMGToStunned stat of the hero
   */
  public BigDecimal getStunnedDamageModifier();

  /**
   * Process being attacked (by any attack), calculate received damage, trigger
   * onHit actions, trigger potential additional effects of the skill, and so on
   * 
   * @param setting
   *        the complete battle setting
   * @param source
   *        a reference to the hero that initiated the attack
   * @param skillStrength
   *        The modifier used for damage calculation (displayed in skill
   *        descriptions as "(x% of Attack)")
   * @param isActiveSkill
   *        is this attack caused by an active skill?
   * @param canBeDodged
   *        can this attack be dodged?
   * @param onHitAction
   *        any additional action that this attack does to the receiving hero
   *        (like apply poison or reduce attack)
   * @return A log item containing the logged information of this operation
   */
  LogItem receiveAttack(BattleSetting setting, Hero source, BigDecimal skillStrength, boolean isActiveSkill,
      boolean canBeDodged, Function<Hero, LogItem> onHitAction);

}

// end of file
