package heroes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import battle.logging.LogMessage;
import effects.TemporaryEffect;
import effects.TemporaryEffectCollection;
import loadout.Loadout;

/**
 * Abstract implementation of a hero that contains basic stuff such as stats,
 * equipment, and so on
 */
public abstract class AbstractHero implements Hero {

  private final static Map<Integer, Integer> speedModifierPerLevel = new HashMap<>();
  static {
    speedModifierPerLevel.put(1, 0);
    speedModifierPerLevel.put(2, 2);
    speedModifierPerLevel.put(3, 4);
    speedModifierPerLevel.put(4, 6);
    speedModifierPerLevel.put(5, 8);
    speedModifierPerLevel.put(6, 10);
    speedModifierPerLevel.put(7, 12);
    speedModifierPerLevel.put(8, 14);
    speedModifierPerLevel.put(9, 16);
    speedModifierPerLevel.put(10, 18);
    speedModifierPerLevel.put(11, 20);
    speedModifierPerLevel.put(12, 22);
    speedModifierPerLevel.put(13, 24);
    speedModifierPerLevel.put(14, 26);
    speedModifierPerLevel.put(15, 28);
    speedModifierPerLevel.put(16, 30);
    speedModifierPerLevel.put(17, 32);
    speedModifierPerLevel.put(18, 34);
    speedModifierPerLevel.put(19, 36);
    speedModifierPerLevel.put(20, 38);
    speedModifierPerLevel.put(21, 40);
    speedModifierPerLevel.put(22, 42);
    speedModifierPerLevel.put(23, 44);
    speedModifierPerLevel.put(24, 46);
    speedModifierPerLevel.put(25, 48);
    speedModifierPerLevel.put(26, 50);
    speedModifierPerLevel.put(27, 52);
    speedModifierPerLevel.put(28, 54);
    speedModifierPerLevel.put(29, 56);
    speedModifierPerLevel.put(30, 58);
    speedModifierPerLevel.put(31, 60);
    speedModifierPerLevel.put(32, 62);
    speedModifierPerLevel.put(33, 64);
    speedModifierPerLevel.put(34, 66);
    speedModifierPerLevel.put(35, 68);
    speedModifierPerLevel.put(36, 71);
    speedModifierPerLevel.put(37, 73);
    speedModifierPerLevel.put(38, 75);
    speedModifierPerLevel.put(39, 77);
    speedModifierPerLevel.put(40, 79);
    speedModifierPerLevel.put(41, 82);
    speedModifierPerLevel.put(42, 84);
    speedModifierPerLevel.put(43, 87);
    speedModifierPerLevel.put(44, 89);
    speedModifierPerLevel.put(45, 92);
    speedModifierPerLevel.put(46, 94);
    speedModifierPerLevel.put(47, 97);
    speedModifierPerLevel.put(48, 99);
    speedModifierPerLevel.put(49, 102);
    speedModifierPerLevel.put(50, 104);
    speedModifierPerLevel.put(51, 107);
    speedModifierPerLevel.put(52, 109);
    speedModifierPerLevel.put(53, 112);
    speedModifierPerLevel.put(54, 114);
    speedModifierPerLevel.put(55, 117);
    speedModifierPerLevel.put(56, 120);
    speedModifierPerLevel.put(57, 122);
    speedModifierPerLevel.put(58, 125);
    speedModifierPerLevel.put(59, 127);
    speedModifierPerLevel.put(60, 130);
    speedModifierPerLevel.put(61, 133);
    speedModifierPerLevel.put(62, 135);
    speedModifierPerLevel.put(63, 138);
    speedModifierPerLevel.put(64, 141);
    speedModifierPerLevel.put(65, 144);
    speedModifierPerLevel.put(66, 147);
    speedModifierPerLevel.put(67, 149);
    speedModifierPerLevel.put(68, 152);
    speedModifierPerLevel.put(69, 155);
    speedModifierPerLevel.put(70, 158);
    speedModifierPerLevel.put(71, 161);
    speedModifierPerLevel.put(72, 163);
    speedModifierPerLevel.put(73, 166);
    speedModifierPerLevel.put(74, 169);
    speedModifierPerLevel.put(75, 172);
    speedModifierPerLevel.put(76, 175);
    speedModifierPerLevel.put(77, 177);
    speedModifierPerLevel.put(78, 180);
    speedModifierPerLevel.put(79, 183);
    speedModifierPerLevel.put(80, 186);
    speedModifierPerLevel.put(81, 189);
    speedModifierPerLevel.put(82, 192);
    speedModifierPerLevel.put(83, 195);
    speedModifierPerLevel.put(84, 198);
    speedModifierPerLevel.put(85, 201);
    speedModifierPerLevel.put(86, 204);
    speedModifierPerLevel.put(87, 207);
    speedModifierPerLevel.put(88, 210);
    speedModifierPerLevel.put(89, 213);
    speedModifierPerLevel.put(90, 216);
    speedModifierPerLevel.put(91, 219);
    speedModifierPerLevel.put(92, 222);
    speedModifierPerLevel.put(93, 225);
    speedModifierPerLevel.put(94, 228);
    speedModifierPerLevel.put(95, 231);
    speedModifierPerLevel.put(96, 234);
    speedModifierPerLevel.put(97, 237);
    speedModifierPerLevel.put(98, 240);
    speedModifierPerLevel.put(99, 243);
    speedModifierPerLevel.put(100, 246);
    speedModifierPerLevel.put(101, 249);
    speedModifierPerLevel.put(102, 252);
    speedModifierPerLevel.put(103, 255);
    speedModifierPerLevel.put(104, 258);
    speedModifierPerLevel.put(105, 261);
    speedModifierPerLevel.put(106, 265);
    speedModifierPerLevel.put(107, 268);
    speedModifierPerLevel.put(108, 271);
    speedModifierPerLevel.put(109, 274);
    speedModifierPerLevel.put(110, 277);
    speedModifierPerLevel.put(111, 281);
    speedModifierPerLevel.put(112, 284);
    speedModifierPerLevel.put(113, 287);
    speedModifierPerLevel.put(114, 290);
    speedModifierPerLevel.put(115, 293);
    speedModifierPerLevel.put(116, 297);
    speedModifierPerLevel.put(117, 300);
    speedModifierPerLevel.put(118, 303);
    speedModifierPerLevel.put(119, 306);
    speedModifierPerLevel.put(120, 309);
    speedModifierPerLevel.put(121, 313);
    speedModifierPerLevel.put(122, 316);
    speedModifierPerLevel.put(123, 319);
    speedModifierPerLevel.put(124, 322);
    speedModifierPerLevel.put(125, 325);
    speedModifierPerLevel.put(126, 329);
    speedModifierPerLevel.put(127, 332);
    speedModifierPerLevel.put(128, 335);
    speedModifierPerLevel.put(129, 338);
    speedModifierPerLevel.put(130, 341);
    speedModifierPerLevel.put(131, 345);
    speedModifierPerLevel.put(132, 348);
    speedModifierPerLevel.put(133, 351);
    speedModifierPerLevel.put(134, 354);
    speedModifierPerLevel.put(135, 357);
    speedModifierPerLevel.put(136, 361);
    speedModifierPerLevel.put(137, 364);
    speedModifierPerLevel.put(138, 367);
    speedModifierPerLevel.put(139, 370);
    speedModifierPerLevel.put(140, 373);
    speedModifierPerLevel.put(141, 377);
    speedModifierPerLevel.put(142, 380);
    speedModifierPerLevel.put(143, 383);
    speedModifierPerLevel.put(144, 386);
    speedModifierPerLevel.put(145, 389);
    speedModifierPerLevel.put(146, 393);
    speedModifierPerLevel.put(147, 396);
    speedModifierPerLevel.put(148, 399);
    speedModifierPerLevel.put(149, 402);
    speedModifierPerLevel.put(150, 405);
    speedModifierPerLevel.put(151, 409);
    speedModifierPerLevel.put(152, 412);
    speedModifierPerLevel.put(153, 415);
    speedModifierPerLevel.put(154, 418);
    speedModifierPerLevel.put(155, 421);
    speedModifierPerLevel.put(156, 425);
    speedModifierPerLevel.put(157, 428);
    speedModifierPerLevel.put(158, 431);
    speedModifierPerLevel.put(159, 434);
    speedModifierPerLevel.put(160, 437);
    speedModifierPerLevel.put(161, 441);
    speedModifierPerLevel.put(162, 444);
    speedModifierPerLevel.put(163, 447);
    speedModifierPerLevel.put(164, 450);
    speedModifierPerLevel.put(165, 453);
    speedModifierPerLevel.put(166, 456);
    speedModifierPerLevel.put(167, 460);
    speedModifierPerLevel.put(168, 463);
    speedModifierPerLevel.put(169, 466);
    speedModifierPerLevel.put(170, 469);
    speedModifierPerLevel.put(171, 472);
    speedModifierPerLevel.put(172, 476);
    speedModifierPerLevel.put(173, 479);
    speedModifierPerLevel.put(174, 482);
    speedModifierPerLevel.put(175, 485);
    speedModifierPerLevel.put(176, 488);
    speedModifierPerLevel.put(177, 492);
    speedModifierPerLevel.put(178, 495);
    speedModifierPerLevel.put(179, 498);
    speedModifierPerLevel.put(180, 501);
    speedModifierPerLevel.put(181, 504);
    speedModifierPerLevel.put(182, 508);
    speedModifierPerLevel.put(183, 511);
    speedModifierPerLevel.put(184, 514);
    speedModifierPerLevel.put(185, 517);
    speedModifierPerLevel.put(186, 520);
    speedModifierPerLevel.put(187, 524);
    speedModifierPerLevel.put(188, 527);
    speedModifierPerLevel.put(189, 530);
    speedModifierPerLevel.put(190, 533);
    speedModifierPerLevel.put(191, 537);
    speedModifierPerLevel.put(192, 540);
    speedModifierPerLevel.put(193, 543);
    speedModifierPerLevel.put(194, 546);
    speedModifierPerLevel.put(195, 549);
    speedModifierPerLevel.put(196, 553);
    speedModifierPerLevel.put(197, 556);
    speedModifierPerLevel.put(198, 559);
    speedModifierPerLevel.put(199, 562);
    speedModifierPerLevel.put(200, 565);
    speedModifierPerLevel.put(201, 569);
    speedModifierPerLevel.put(202, 572);
    speedModifierPerLevel.put(203, 575);
    speedModifierPerLevel.put(204, 579);
    speedModifierPerLevel.put(205, 582);
    speedModifierPerLevel.put(206, 585);
    speedModifierPerLevel.put(207, 588);
    speedModifierPerLevel.put(208, 592);
    speedModifierPerLevel.put(209, 595);
    speedModifierPerLevel.put(210, 598);
    speedModifierPerLevel.put(211, 602);
    speedModifierPerLevel.put(212, 605);
    speedModifierPerLevel.put(213, 608);
    speedModifierPerLevel.put(214, 611);
    speedModifierPerLevel.put(215, 615);
    speedModifierPerLevel.put(216, 618);
    speedModifierPerLevel.put(217, 621);
    speedModifierPerLevel.put(218, 625);
    speedModifierPerLevel.put(219, 628);
    speedModifierPerLevel.put(220, 631);
    speedModifierPerLevel.put(221, 635);
    speedModifierPerLevel.put(222, 638);
    speedModifierPerLevel.put(223, 641);
    speedModifierPerLevel.put(224, 644);
    speedModifierPerLevel.put(225, 648);
    speedModifierPerLevel.put(226, 651);
    speedModifierPerLevel.put(227, 654);
    speedModifierPerLevel.put(228, 658);
    speedModifierPerLevel.put(229, 661);
    speedModifierPerLevel.put(230, 664);
    speedModifierPerLevel.put(231, 668);
    speedModifierPerLevel.put(232, 671);
    speedModifierPerLevel.put(233, 674);
    speedModifierPerLevel.put(234, 677);
    speedModifierPerLevel.put(235, 681);
    speedModifierPerLevel.put(236, 684);
    speedModifierPerLevel.put(237, 687);
    speedModifierPerLevel.put(238, 691);
    speedModifierPerLevel.put(239, 694);
    speedModifierPerLevel.put(240, 697);
    speedModifierPerLevel.put(241, 701);
    speedModifierPerLevel.put(242, 704);
    speedModifierPerLevel.put(243, 707);
    speedModifierPerLevel.put(244, 710);
    speedModifierPerLevel.put(245, 714);
    speedModifierPerLevel.put(246, 717);
    speedModifierPerLevel.put(247, 720);
    speedModifierPerLevel.put(248, 724);
    speedModifierPerLevel.put(249, 727);
    speedModifierPerLevel.put(250, 730);
  }

  /**
   * level of the hero
   */
  private final Integer level;

  /**
   * the class of the hero
   */
  private final HeroClass heroClass;

  private final HeroType heroType;

  /**
   * the faction of the hero
   */
  private final Faction faction;

  private final Loadout loadout;

  private Optional<Integer> position = Optional.empty();

  private Optional<Boolean> isAttacker = Optional.empty();

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
   * hit rate of the hero.
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

  private BigDecimal controlResist;

  private BigDecimal silenceResistance;

  private BigDecimal assassinDamageModifier;
  private BigDecimal clericDamageModifier;
  private BigDecimal warriorDamageModifier;
  private BigDecimal wandererDamageModifier;
  private BigDecimal mageDamageModifier;

  private BigDecimal damageReduce;

  private TemporaryEffectCollection activeEffects = new TemporaryEffectCollection(this);

  protected final List<Function<BattleSetting, LogItem>> onDeathAction = new ArrayList<>();

  protected Integer star;

  private boolean isDead = false;

  public AbstractHero(HeroParameters parameters, Map<Integer, BaseStats> baseStats, HeroClass heroClass,
      Faction faction, HeroType heroType) {
    super();
    this.level = parameters.level;
    this.heroType = heroType;
    this.heroClass = heroClass;
    this.faction = faction;
    this.star = parameters.star;
    this.loadout = parameters.loadout;
    computeStats(parameters, baseStats);
    this.currentEnergy = 50;
    this.hitRate = new BigDecimal(0);
    this.dodge = new BigDecimal(0);
    this.critRate = new BigDecimal(0);
    this.critDamage = new BigDecimal(0);
    this.controlResist = new BigDecimal(0);
    this.defenseBreak = new BigDecimal(0);
    this.skillDamage = new BigDecimal(1);
    this.attackModifier = new BigDecimal(1);
    this.maxHPModifier = new BigDecimal(1);
    this.trueDamage = new BigDecimal(1);
    this.assassinDamageModifier = new BigDecimal(0);
    this.wandererDamageModifier = new BigDecimal(0);
    this.clericDamageModifier = new BigDecimal(0);
    this.mageDamageModifier = new BigDecimal(0);
    this.warriorDamageModifier = new BigDecimal(0);
    this.damageReduce = new BigDecimal(0);
    parameters.loadout.apply(this);
    this.currentHP = getMaxHP();
  }

  private void computeStats(HeroParameters parameters, Map<Integer, BaseStats> baseStats) {
    BaseStats base = baseStats.get(parameters.star);
    HeroTier tier = HeroTier.getTierForLevel(parameters.level);
    this.maxHP = new BigDecimal(base.maxHP)
        .multiply(new BigDecimal(1).add(new BigDecimal(parameters.level - 1).multiply(new BigDecimal("0.1"))))
        .multiply(tier.maxHPModifier).intValue();
    this.attack = new BigDecimal(base.attack)
        .multiply(new BigDecimal(1).add(new BigDecimal(parameters.level - 1).multiply(new BigDecimal("0.1"))))
        .multiply(tier.attackModifier).intValue();
    this.speed = base.speed + speedModifierPerLevel.get(parameters.level) + tier.speedIncrease;
    this.armor = base.armor;
  }

  @Override
  public BigDecimal getSkillDamage() {
    return skillDamage;
  }

  @Override
  public LogItem increaseSkillDamage(BigDecimal amount) {
    Log log = new Log();
    this.skillDamage = this.skillDamage.add(amount);
    log.addItem(logMessage("Increasing SkillDamage by " + amount + "; now SkillDamage=" + this.skillDamage));
    return log;
  }

  @Override
  public LogItem damage(BattleSetting setting, Hero source, BigDecimal modifier) {
    Log log = new Log();
    int damage = modifier.multiply(new BigDecimal(source.getAttack())).intValue();
    this.currentHP = Math.max(0, this.currentHP - damage);
    log.addItem(logMessage("Taking " + damage + " Damage; Now currentHP=" + this.currentHP));
    return log;
  }

  @Override
  public LogItem die(BattleSetting setting) {
    Log log = new Log();
    log.addItem(logMessage("Hero died. Triggering possible onDeath effects."));
    isDead = true;
    onDeathAction.stream().map(action -> Optional.ofNullable(action.apply(setting))).filter(Optional::isPresent)
        .map(Optional::get).forEach(log::addItem);
    return log;
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
  public LogItem increaseAttack(int amount) {
    Log log = new Log();
    this.attack += amount;
    log.addItem(logMessage("Increasing attack by " + amount + " (times modifier); Now attack=" + this.getAttack()));
    return log;
  }

  @Override
  public LogItem increaseMaxHP(int amount) {
    Log log = new Log();
    this.maxHP += amount;
    log.addItem(logMessage("Increasing maxHP by " + amount + " (times modifier); Now maxHP=" + this.getMaxHP()));
    return log;
  }

  @Override
  public LogItem addAttackModifier(BigDecimal modifier) {
    Log log = new Log();
    this.attackModifier = this.attackModifier.multiply(new BigDecimal(1).add(modifier));
    log.addItem(logMessage(
        "Increasing attack by " + modifier.multiply(new BigDecimal(100)) + "%; Now attack=" + this.getAttack()));
    return log;
  }

  @Override
  public LogItem addMaxHPModifier(BigDecimal modifier) {
    Log log = new Log();
    this.maxHPModifier = this.maxHPModifier.multiply(new BigDecimal(1).add(modifier));
    log.addItem(logMessage(
        "Increasing maxHP by " + modifier.multiply(new BigDecimal(100)) + "%; Now maxHp=" + this.getMaxHP()));
    return log;
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
  public LogItem increaseCritRate(BigDecimal amount) {
    Log log = new Log();
    this.critRate = this.critRate.add(amount);
    log.addItem(logMessage(
        "Increasing CritRate by " + amount.multiply(new BigDecimal(100)) + "%; Now critRate=" + this.getCritRate()));
    return log;
  }

  @Override
  public BigDecimal getCritDamage() {
    return critDamage;
  }

  @Override
  public LogItem increaseCritDamage(BigDecimal amount) {
    Log log = new Log();
    this.critDamage = this.critDamage.add(amount);
    log.addItem(logMessage("Increasing CritDamage by " + amount.multiply(new BigDecimal(100)) + "%; Now critDamage="
        + this.getCritDamage()));
    return log;
  }

  @Override
  public BigDecimal getDodgeChance() {
    return dodge;
  }

  @Override
  public LogItem increaseDodgeChance(BigDecimal amount) {
    Log log = new Log();
    this.dodge = this.dodge.add(amount);
    log.addItem(logMessage("Increasing DodgeChance by " + amount.multiply(new BigDecimal(100)) + "%; Now DodgeChance="
        + this.getDodgeChance()));
    return log;
  }

  @Override
  public BigDecimal getDefenseBreak() {
    return defenseBreak;
  }

  @Override
  public LogItem increaseDefenseBreak(BigDecimal amount) {
    Log log = new Log();
    this.defenseBreak = this.defenseBreak.add(amount);
    log.addItem(logMessage("Increasing DefenseBreak by " + amount + "; Now DefenseBreak=" + this.getDefenseBreak()));
    return log;
  }

  @Override
  public BigDecimal getHitRate() {
    return hitRate;
  }

  @Override
  public LogItem increaseHitRate(BigDecimal amount) {
    Log log = new Log();
    this.hitRate = this.hitRate.add(amount);
    log.addItem(logMessage(
        "Increasing HitRate by " + amount.multiply(new BigDecimal(100)) + "%; Now HitRate=" + this.getHitRate()));
    return log;
  }

  @Override
  public Integer getSpeed() {
    return speed;
  }

  @Override
  public LogItem increaseSpeed(Integer amount) {
    Log log = new Log();
    this.speed += amount;
    log.addItem(logMessage("Increasing Speed by " + amount + "; Now Speed=" + this.getSpeed()));
    return log;
  }

  @Override
  public Integer getDefense() {
    return defense;
  }

  @Override
  public LogItem increaseDefense(Integer amount) {
    Log log = new Log();
    this.defense += amount;
    log.addItem(logMessage("Increasing Defense by " + amount + "; Now Defense=" + this.getDefense()));
    return log;
  }

  @Override
  public BigDecimal getTrueDamage() {
    return trueDamage;
  }

  @Override
  public LogItem increaseTrueDamage(BigDecimal amount) {
    Log log = new Log();
    this.trueDamage = this.trueDamage.add(amount);
    log.addItem(logMessage("Increasing TrueDamage by " + amount.multiply(new BigDecimal(100)) + "%; Now TrueDamage="
        + this.getTrueDamage()));
    return log;
  }

  @Override
  public BigDecimal getControlResist() {
    return controlResist;
  }

  @Override
  public LogItem increaseControlResist(BigDecimal amount) {
    Log log = new Log();
    this.controlResist = this.controlResist.add(amount);
    log.addItem(logMessage("Increasing ControlResist by " + amount.multiply(new BigDecimal(100))
        + "%; Now ControlResist=" + this.getTrueDamage()));
    return log;
  }

  @Override
  public BigDecimal getSilenceResistance() {
    return silenceResistance;
  }

  @Override
  public LogItem increaseSilenceResistance(BigDecimal amount) {
    Log log = new Log();
    this.silenceResistance = this.silenceResistance.add(amount);
    log.addItem(logMessage("Increasing SilenceResist by " + amount.multiply(new BigDecimal(100))
        + "%; Now SilenceResist=" + this.getSilenceResistance()));
    return log;
  }

  @Override
  public LogItem increaseEnergy(Integer amount) {
    Log log = new Log();
    this.currentEnergy += amount;
    log.addItem(logMessage("Increasing Energy by " + amount + "; Now Energy=" + this.getCurrentEnergy()));
    return log;
  }

  @Override
  public LogItem increaseAssassinDamageModifier(BigDecimal amount) {
    Log log = new Log();
    this.assassinDamageModifier = this.assassinDamageModifier.add(amount);
    log.addItem(logMessage("Increasing ExDmgToAssassin by " + amount.multiply(new BigDecimal(100))
        + "%; Now ExDmgToAssassin=" + this.getAssassinDamageModifier()));
    return log;
  }

  @Override
  public BigDecimal getAssassinDamageModifier() {
    return assassinDamageModifier;
  }

  @Override
  public LogItem increaseWarriorDamageModifier(BigDecimal amount) {
    Log log = new Log();
    this.warriorDamageModifier = this.warriorDamageModifier.add(amount);
    log.addItem(logMessage("Increasing ExDmgToWarrior by " + amount.multiply(new BigDecimal(100))
        + "%; Now ExDmgToWarrior=" + this.getWarriorDamageModifier()));
    return log;
  }

  @Override
  public BigDecimal getWarriorDamageModifier() {
    return warriorDamageModifier;
  }

  @Override
  public LogItem increaseWandererDamageModifier(BigDecimal amount) {
    Log log = new Log();
    this.wandererDamageModifier = this.wandererDamageModifier.add(amount);
    log.addItem(logMessage("Increasing ExDmgToWanderer by " + amount.multiply(new BigDecimal(100))
        + "%; Now ExDmgToWanderer=" + this.getWandererDamageModifier()));
    return log;
  }

  @Override
  public BigDecimal getWandererDamageModifier() {
    return wandererDamageModifier;
  }

  @Override
  public LogItem increaseMageDamageModifier(BigDecimal amount) {
    Log log = new Log();
    this.mageDamageModifier = this.mageDamageModifier.add(amount);
    log.addItem(logMessage("Increasing ExDmgToMage by " + amount.multiply(new BigDecimal(100)) + "%; Now ExDmgToMage="
        + this.getMageDamageModifier()));
    return log;
  }

  @Override
  public BigDecimal getMageDamageModifier() {
    return mageDamageModifier;
  }

  @Override
  public LogItem increaseClericDamageModifier(BigDecimal amount) {
    Log log = new Log();
    this.clericDamageModifier = this.clericDamageModifier.add(amount);
    log.addItem(logMessage("Increasing ExDmgToCleric by " + amount.multiply(new BigDecimal(100))
        + "%; Now ExDmgToCleric=" + this.getClericDamageModifier()));
    return log;
  }

  @Override
  public BigDecimal getClericDamageModifier() {
    return clericDamageModifier;
  }

  @Override
  public BigDecimal getDamageReduce() {
    return damageReduce;
  }

  @Override
  public LogItem increaseDamageReduce(BigDecimal amount) {
    Log log = new Log();
    this.damageReduce = this.damageReduce.add(amount);
    log.addItem(logMessage("Increasing DamageReduce by " + amount.multiply(new BigDecimal(100)) + "%; Now DamageReduce="
        + this.getDamageReduce()));
    return log;
  }

  @Override
  public void addOnDeathAction(Function<BattleSetting, LogItem> action) {
    onDeathAction.add(action);
  }

  @Override
  public LogItem addTemporaryEffect(TemporaryEffect effect) {
    Log log = new Log();
    log.addItem(logMessage("Adding temporary effect " + effect));
    activeEffects.addEffect(effect);
    return log;
  }

  @Override
  public LogItem basicAttack(BattleSetting setting) {
    Log log = new Log();
    Hero attackedHero = setting.getOpposingTeam(this).getHeroes().get(0);
    log.addItem(logMessage("Basic attack at " + attackedHero.getFullName()));
    log.addItem(attackedHero.damage(setting, this, new BigDecimal("1")));
    log.addItem(increaseEnergy(50));
    return log;
  }

  @Override
  public boolean isDead() {
    return isDead;
  }

  @Override
  public boolean isDying() {
    return currentHP <= 0;
  }

  @Override
  public LogItem doAttack(BattleSetting setting) {
    Log log = new Log();
    if (getCurrentEnergy() < 100) {
      log.addItem(basicAttack(setting));
    } else {
      log.addItem(doSkillAttack(setting));
    }
    log.addItem(setting.checkHeroesDied());
    return log;
  }

  private LogItem doSkillAttack(BattleSetting setting) {
    Log log = new Log();
    log.addItem(logMessage("initiating active skill"));
    log.addItem(skillAttack(setting));
    log.addItem(zeroEnergy());
    return log;
  }

  @Override
  public LogMessage logMessage(String message) {
    return new LogMessage(getFullName() + ": " + message);
  }

  @Override
  public String getName() {
    return heroType.getName();
  }

  @Override
  public String getFullName() {
    return isAttacker.map(b -> b ? "A" : "D").orElse("U") + ":"
        + position.map(p -> new Integer(p + 1).toString()).orElse("U") + ":" + getName();
  }

  @Override
  public void setPosition(Integer pos) {
    this.position = Optional.ofNullable(pos);
  }

  @Override
  public void setAttacker() {
    isAttacker = Optional.of(true);
  }

  @Override
  public void setDefender() {
    isAttacker = Optional.of(false);
  }

  @Override
  public LogItem zeroEnergy() {
    Log log = new Log();
    currentEnergy = 0;
    log.addItem(logMessage("Setting currentEnergy to 0"));
    return log;
  }

  @Override
  public LogItem getInformation() {
    Log log = new Log();
    log.addMessage("Level " + level + " " + heroType.getName());
    log.addMessage("Loadout:");
    log.addItem(loadout.getInformation());
    return log;
  }

  @Override
  public String toString() {
    return "AbstractHero [level=" + level + ", heroClass=" + heroClass + ", faction=" + faction + ", maxHP=" + maxHP
        + ", maxHPModifier=" + maxHPModifier + ", currentHP=" + currentHP + ", currentEnergy=" + currentEnergy
        + ", attack=" + attack + ", attackModifier=" + attackModifier + ", dodge=" + dodge + ", armor=" + armor
        + ", hitRate=" + hitRate + ", critRate=" + critRate + ", skillDamage=" + skillDamage + ", speed=" + speed
        + ", defense=" + defense + ", defenseBreak=" + defenseBreak + ", trueDamage=" + trueDamage + ", critDamage="
        + critDamage + ", controlResist=" + controlResist + ", getMaxHP()=" + getMaxHP() + ", getAttack()="
        + getAttack() + "]";
  }

}

// end of file
