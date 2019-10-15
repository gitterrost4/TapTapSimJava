package heroes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract implementation of a hero that contains basic stuff such as stats,
 * equipment, and so on
 */
public abstract class AbstractHero implements Hero {
  
  private final static Map<Integer, Integer> speedModifierPerLevel = new HashMap<>();
  static {
    speedModifierPerLevel.put(1,0);
    speedModifierPerLevel.put(2,2);
    speedModifierPerLevel.put(3,4);
    speedModifierPerLevel.put(4,6);
    speedModifierPerLevel.put(5,8);
    speedModifierPerLevel.put(6,10);
    speedModifierPerLevel.put(7,12);
    speedModifierPerLevel.put(8,14);
    speedModifierPerLevel.put(9,16);
    speedModifierPerLevel.put(10,18);
    speedModifierPerLevel.put(11,20);
    speedModifierPerLevel.put(12,22);
    speedModifierPerLevel.put(13,24);
    speedModifierPerLevel.put(14,26);
    speedModifierPerLevel.put(15,28);
    speedModifierPerLevel.put(16,30);
    speedModifierPerLevel.put(17,32);
    speedModifierPerLevel.put(18,34);
    speedModifierPerLevel.put(19,36);
    speedModifierPerLevel.put(20,38);
    speedModifierPerLevel.put(21,40);
    speedModifierPerLevel.put(22,42);
    speedModifierPerLevel.put(23,44);
    speedModifierPerLevel.put(24,46);
    speedModifierPerLevel.put(25,48);
    speedModifierPerLevel.put(26,50);
    speedModifierPerLevel.put(27,52);
    speedModifierPerLevel.put(28,54);
    speedModifierPerLevel.put(29,56);
    speedModifierPerLevel.put(30,58);
    speedModifierPerLevel.put(31,60);
    speedModifierPerLevel.put(32,62);
    speedModifierPerLevel.put(33,64);
    speedModifierPerLevel.put(34,66);
    speedModifierPerLevel.put(35,68);
    speedModifierPerLevel.put(36,71);
    speedModifierPerLevel.put(37,73);
    speedModifierPerLevel.put(38,75);
    speedModifierPerLevel.put(39,77);
    speedModifierPerLevel.put(40,79);
    speedModifierPerLevel.put(41,82);
    speedModifierPerLevel.put(42,84);
    speedModifierPerLevel.put(43,87);
    speedModifierPerLevel.put(44,89);
    speedModifierPerLevel.put(45,92);
    speedModifierPerLevel.put(46,94);
    speedModifierPerLevel.put(47,97);
    speedModifierPerLevel.put(48,99);
    speedModifierPerLevel.put(49,102);
    speedModifierPerLevel.put(50,104);
    speedModifierPerLevel.put(51,107);
    speedModifierPerLevel.put(52,109);
    speedModifierPerLevel.put(53,112);
    speedModifierPerLevel.put(54,114);
    speedModifierPerLevel.put(55,117);
    speedModifierPerLevel.put(56,120);
    speedModifierPerLevel.put(57,122);
    speedModifierPerLevel.put(58,125);
    speedModifierPerLevel.put(59,127);
    speedModifierPerLevel.put(60,130);
    speedModifierPerLevel.put(61,133);
    speedModifierPerLevel.put(62,135);
    speedModifierPerLevel.put(63,138);
    speedModifierPerLevel.put(64,141);
    speedModifierPerLevel.put(65,144);
    speedModifierPerLevel.put(66,147);
    speedModifierPerLevel.put(67,149);
    speedModifierPerLevel.put(68,152);
    speedModifierPerLevel.put(69,155);
    speedModifierPerLevel.put(70,158);
    speedModifierPerLevel.put(71,161);
    speedModifierPerLevel.put(72,163);
    speedModifierPerLevel.put(73,166);
    speedModifierPerLevel.put(74,169);
    speedModifierPerLevel.put(75,172);
    speedModifierPerLevel.put(76,175);
    speedModifierPerLevel.put(77,177);
    speedModifierPerLevel.put(78,180);
    speedModifierPerLevel.put(79,183);
    speedModifierPerLevel.put(80,186);
    speedModifierPerLevel.put(81,189);
    speedModifierPerLevel.put(82,192);
    speedModifierPerLevel.put(83,195);
    speedModifierPerLevel.put(84,198);
    speedModifierPerLevel.put(85,201);
    speedModifierPerLevel.put(86,204);
    speedModifierPerLevel.put(87,207);
    speedModifierPerLevel.put(88,210);
    speedModifierPerLevel.put(89,213);
    speedModifierPerLevel.put(90,216);
    speedModifierPerLevel.put(91,219);
    speedModifierPerLevel.put(92,222);
    speedModifierPerLevel.put(93,225);
    speedModifierPerLevel.put(94,228);
    speedModifierPerLevel.put(95,231);
    speedModifierPerLevel.put(96,234);
    speedModifierPerLevel.put(97,237);
    speedModifierPerLevel.put(98,240);
    speedModifierPerLevel.put(99,243);
    speedModifierPerLevel.put(100,246);
    speedModifierPerLevel.put(101,249);
    speedModifierPerLevel.put(102,252);
    speedModifierPerLevel.put(103,255);
    speedModifierPerLevel.put(104,258);
    speedModifierPerLevel.put(105,261);
    speedModifierPerLevel.put(106,265);
    speedModifierPerLevel.put(107,268);
    speedModifierPerLevel.put(108,271);
    speedModifierPerLevel.put(109,274);
    speedModifierPerLevel.put(110,277);
    speedModifierPerLevel.put(111,281);
    speedModifierPerLevel.put(112,284);
    speedModifierPerLevel.put(113,287);
    speedModifierPerLevel.put(114,290);
    speedModifierPerLevel.put(115,293);
    speedModifierPerLevel.put(116,297);
    speedModifierPerLevel.put(117,300);
    speedModifierPerLevel.put(118,303);
    speedModifierPerLevel.put(119,306);
    speedModifierPerLevel.put(120,309);
    speedModifierPerLevel.put(121,313);
    speedModifierPerLevel.put(122,316);
    speedModifierPerLevel.put(123,319);
    speedModifierPerLevel.put(124,322);
    speedModifierPerLevel.put(125,325);
    speedModifierPerLevel.put(126,329);
    speedModifierPerLevel.put(127,332);
    speedModifierPerLevel.put(128,335);
    speedModifierPerLevel.put(129,338);
    speedModifierPerLevel.put(130,341);
    speedModifierPerLevel.put(131,345);
    speedModifierPerLevel.put(132,348);
    speedModifierPerLevel.put(133,351);
    speedModifierPerLevel.put(134,354);
    speedModifierPerLevel.put(135,357);
    speedModifierPerLevel.put(136,361);
    speedModifierPerLevel.put(137,364);
    speedModifierPerLevel.put(138,367);
    speedModifierPerLevel.put(139,370);
    speedModifierPerLevel.put(140,373);
    speedModifierPerLevel.put(141,377);
    speedModifierPerLevel.put(142,380);
    speedModifierPerLevel.put(143,383);
    speedModifierPerLevel.put(144,386);
    speedModifierPerLevel.put(145,389);
    speedModifierPerLevel.put(146,393);
    speedModifierPerLevel.put(147,396);
    speedModifierPerLevel.put(148,399);
    speedModifierPerLevel.put(149,402);
    speedModifierPerLevel.put(150,405);
    speedModifierPerLevel.put(151,409);
    speedModifierPerLevel.put(152,412);
    speedModifierPerLevel.put(153,415);
    speedModifierPerLevel.put(154,418);
    speedModifierPerLevel.put(155,421);
    speedModifierPerLevel.put(156,425);
    speedModifierPerLevel.put(157,428);
    speedModifierPerLevel.put(158,431);
    speedModifierPerLevel.put(159,434);
    speedModifierPerLevel.put(160,437);
    speedModifierPerLevel.put(161,441);
    speedModifierPerLevel.put(162,444);
    speedModifierPerLevel.put(163,447);
    speedModifierPerLevel.put(164,450);
    speedModifierPerLevel.put(165,453);
    speedModifierPerLevel.put(166,456);
    speedModifierPerLevel.put(167,460);
    speedModifierPerLevel.put(168,463);
    speedModifierPerLevel.put(169,466);
    speedModifierPerLevel.put(170,469);
    speedModifierPerLevel.put(171,472);
    speedModifierPerLevel.put(172,476);
    speedModifierPerLevel.put(173,479);
    speedModifierPerLevel.put(174,482);
    speedModifierPerLevel.put(175,485);
    speedModifierPerLevel.put(176,488);
    speedModifierPerLevel.put(177,492);
    speedModifierPerLevel.put(178,495);
    speedModifierPerLevel.put(179,498);
    speedModifierPerLevel.put(180,501);
    speedModifierPerLevel.put(181,504);
    speedModifierPerLevel.put(182,508);
    speedModifierPerLevel.put(183,511);
    speedModifierPerLevel.put(184,514);
    speedModifierPerLevel.put(185,517);
    speedModifierPerLevel.put(186,520);
    speedModifierPerLevel.put(187,524);
    speedModifierPerLevel.put(188,527);
    speedModifierPerLevel.put(189,530);
    speedModifierPerLevel.put(190,533);
    speedModifierPerLevel.put(191,537);
    speedModifierPerLevel.put(192,540);
    speedModifierPerLevel.put(193,543);
    speedModifierPerLevel.put(194,546);
    speedModifierPerLevel.put(195,549);
    speedModifierPerLevel.put(196,553);
    speedModifierPerLevel.put(197,556);
    speedModifierPerLevel.put(198,559);
    speedModifierPerLevel.put(199,562);
    speedModifierPerLevel.put(200,565);
    speedModifierPerLevel.put(201,569);
    speedModifierPerLevel.put(202,572);
    speedModifierPerLevel.put(203,575);
    speedModifierPerLevel.put(204,579);
    speedModifierPerLevel.put(205,582);
    speedModifierPerLevel.put(206,585);
    speedModifierPerLevel.put(207,588);
    speedModifierPerLevel.put(208,592);
    speedModifierPerLevel.put(209,595);
    speedModifierPerLevel.put(210,598);
    speedModifierPerLevel.put(211,602);
    speedModifierPerLevel.put(212,605);
    speedModifierPerLevel.put(213,608);
    speedModifierPerLevel.put(214,611);
    speedModifierPerLevel.put(215,615);
    speedModifierPerLevel.put(216,618);
    speedModifierPerLevel.put(217,621);
    speedModifierPerLevel.put(218,625);
    speedModifierPerLevel.put(219,628);
    speedModifierPerLevel.put(220,631);
    speedModifierPerLevel.put(221,635);
    speedModifierPerLevel.put(222,638);
    speedModifierPerLevel.put(223,641);
    speedModifierPerLevel.put(224,644);
    speedModifierPerLevel.put(225,648);
    speedModifierPerLevel.put(226,651);
    speedModifierPerLevel.put(227,654);
    speedModifierPerLevel.put(228,658);
    speedModifierPerLevel.put(229,661);
    speedModifierPerLevel.put(230,664);
    speedModifierPerLevel.put(231,668);
    speedModifierPerLevel.put(232,671);
    speedModifierPerLevel.put(233,674);
    speedModifierPerLevel.put(234,677);
    speedModifierPerLevel.put(235,681);
    speedModifierPerLevel.put(236,684);
    speedModifierPerLevel.put(237,687);
    speedModifierPerLevel.put(238,691);
    speedModifierPerLevel.put(239,694);
    speedModifierPerLevel.put(240,697);
    speedModifierPerLevel.put(241,701);
    speedModifierPerLevel.put(242,704);
    speedModifierPerLevel.put(243,707);
    speedModifierPerLevel.put(244,710);
    speedModifierPerLevel.put(245,714);
    speedModifierPerLevel.put(246,717);
    speedModifierPerLevel.put(247,720);
    speedModifierPerLevel.put(248,724);
    speedModifierPerLevel.put(249,727);
    speedModifierPerLevel.put(250,730);
  }

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

  public AbstractHero(HeroParameters parameters, Map<Integer,BaseStats> baseStats, HeroClass heroClass, Faction faction) {
    super();
    this.level=parameters.level;
    this.heroClass=heroClass;
    this.faction=faction;
    computeStats(parameters, baseStats);
    this.currentEnergy=50;
    this.critRate=new BigDecimal(0);
    this.critDamage=new BigDecimal(0);
    this.defenseBreak=new BigDecimal(0);
    this.skillDamage=new BigDecimal(1);
    this.attackModifier=new BigDecimal(1);
    this.maxHPModifier=new BigDecimal(1);
    this.trueDamage=new BigDecimal(1);
    parameters.loadout.apply(this);
    this.currentHP=getMaxHP();
  }
  
  private void computeStats(HeroParameters parameters, Map<Integer,BaseStats> baseStats) {
    BaseStats base = baseStats.get(parameters.star);
    HeroTier tier = HeroTier.getTierForLevel(parameters.level);
    this.maxHP=new BigDecimal(base.maxHP*(1+(parameters.level-1)*0.1)).multiply(tier.maxHPModifier).intValue();
    this.attack=new BigDecimal(base.attack*(1+(parameters.level-1)*0.1)).multiply(tier.attackModifier).intValue();
    this.speed=base.speed+speedModifierPerLevel.get(parameters.level)+tier.speedIncrease;
    this.armor=base.armor;
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

  @Override
  public String toString() {
    return "AbstractHero [level=" + level + ", heroClass=" + heroClass + ", faction=" + faction + ", maxHP=" + maxHP
        + ", maxHPModifier=" + maxHPModifier + ", currentHP=" + currentHP + ", currentEnergy=" + currentEnergy
        + ", attack=" + attack + ", attackModifier=" + attackModifier + ", dodge=" + dodge + ", armor=" + armor
        + ", hitRate=" + hitRate + ", critRate=" + critRate + ", skillDamage=" + skillDamage + ", speed=" + speed
        + ", defense=" + defense + ", defenseBreak=" + defenseBreak + ", trueDamage=" + trueDamage + ", critDamage="
        + critDamage + "]";
  }

  
}

// end of file
