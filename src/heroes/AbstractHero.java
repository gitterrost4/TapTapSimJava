package heroes;

import java.math.BigDecimal;

import loadout.Loadout;

/**
 * Abstract implementation of a hero that contains basic stuff such as stats,
 * equipment, and so on
 */
public abstract class AbstractHero implements Hero {

  /**
   * level of the hero
   */
  private final Integer level;

  /**
   * the class of the hero
   */
  private final HeroClass heroClass;
  
  /**
   * the faction of the hero
   */
  private final Faction faction;
  
  /**
   * the maximum amount of HP this hero can have
   */
  private Integer maxHP;

  /**
   * the modifier that maxHP is multiplied by
   */
  private BigDecimal maxHPModifier;

  /**
   * the current amount of HP this hero has (different to maxHP if the hero is
   * damaged)
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
   * attack modifier that attack is multiplied by
   */
  private BigDecimal attackModifier;

  /**
   * dodge stat of the hero
   */
  private BigDecimal dodge;

  /**
   * armor stat of the hero
   */
  private Integer armor;

  /**
   * hit rate of the hero. TODO clarify if this is int and how this works from
   * Ashar's simulator
   */
  private BigDecimal hitRate;

  /**
   * crit rate of the hero
   */
  private BigDecimal critRate;

  /**
   * crit rate of the hero
   */
  private BigDecimal skillDamage;

  /**
   * speed of the hero
   */
  private Integer speed;

  /**
   * defense of the hero
   */
  private Integer defense;

  private BigDecimal defenseBreak;

  private BigDecimal trueDamage;

  private BigDecimal critDamage;

  public AbstractHero(Integer level, HeroClass heroClass, Faction faction, Integer maxHP, Integer attack, Integer speed, Integer defense, Loadout loadout) {
    super();
    this.level=level;
    this.heroClass=heroClass;
    this.faction=faction;
    this.maxHP=maxHP;
    this.attack=attack;
    this.speed=speed;
    this.defense=defense;

    this.currentEnergy=50;
    this.critRate=new BigDecimal(0);
    this.critDamage=new BigDecimal(0);
    this.defenseBreak=new BigDecimal(0);
    this.skillDamage=new BigDecimal(1);
    this.attackModifier=new BigDecimal(1);
    this.maxHPModifier=new BigDecimal(1);
    this.trueDamage=new BigDecimal(1);
    loadout.apply(this);
    this.currentHP=getMaxHP();
  }

  @Override
  public BigDecimal getSkillDamage() {
    return skillDamage;
  }

  @Override
  public void increaseSkillDamage(BigDecimal amount) {
    this.skillDamage=this.skillDamage.add(amount);
  }

  @Override
  public void damage(Integer amount) {
    this.currentHP=Math.max(0,this.currentHP - amount);
  }

  @Override
  public Integer getCurrentHP() {
    return currentHP;
  }

  @Override
  public Integer getMaxHP() {
    return maxHPModifier.multiply(new BigDecimal(maxHP)).intValue();
  }

  @Override
  public Integer getAttack() {
    return attackModifier.multiply(new BigDecimal(attack)).intValue();
  }

  @Override
  public Integer getArmor() {
    return armor;
  }

  @Override
  public Integer getCurrentEnergy() {
    return currentEnergy;
  }

  @Override
  public void increaseAttack(int amount) {
    this.attack+=amount;
  }

  @Override
  public void increaseMaxHP(int amount) {
    this.maxHP+=amount;
  }

  @Override
  public void addAttackModifier(BigDecimal modifier) {
    this.attackModifier=this.attackModifier.multiply(modifier);
  }

  @Override
  public void addMaxHPModifier(BigDecimal modifier) {
    this.maxHPModifier=this.maxHPModifier.multiply(modifier);
  }

  /**
   * get the level of the hero
   * 
   * @return
   */
  @Override
  public Integer getLevel() {
    return level;
  }

  /**
   * get the class of the hero
   * 
   * @return
   */
  @Override
  public HeroClass getHeroClass() {
    return heroClass;
  }

  /**
   * get the faction of the hero
   * 
   * @return
   */
  @Override
  public Faction getFaction() {
    return faction;
  }

  @Override
  public BigDecimal getCritRate() {
    return critRate;
  }
  
  @Override
  public void increaseCritRate(BigDecimal amount) {
    this.critRate = this.critRate.add(amount);
  }

  @Override
  public BigDecimal getCritDamage() {
    return critDamage;
  }
  
  @Override
  public void increaseCritDamage(BigDecimal amount) {
    this.critDamage = this.critDamage.add(amount);
  }

  @Override
  public BigDecimal getDodgeRate() {
    return dodge;
  }

  @Override
  public void increaseDodgeChance(BigDecimal amount) {
    this.dodge=this.dodge.add(amount);
  }

  @Override
  public BigDecimal getDefenseBreak() {
    return defenseBreak;
  }

  @Override
  public void increaseDefenseBreak(BigDecimal amount) {
    this.defenseBreak = this.defenseBreak.add(amount);
  }

  @Override
  public BigDecimal getHitRate() {
    return hitRate;
  }

  @Override
  public void increaseHitRate(BigDecimal amount) {
    this.hitRate = this.hitRate.add(amount);
  }

  @Override
  public Integer getSpeed() {
    return speed;
  }

  @Override
  public void increaseSpeed(Integer amount) {
    this.speed+=amount;
  }

  @Override
  public Integer getDefense() {
    return defense;
  }

  @Override
  public void increaseDefense(Integer amount) {
    this.defense+=amount;
  }

  @Override
  public BigDecimal getTrueDamage() {
    return trueDamage;
  }

  @Override
  public void increaseTrueDamage(BigDecimal amount) {
    this.trueDamage=this.trueDamage.add(amount);
  }

}

// end of file
