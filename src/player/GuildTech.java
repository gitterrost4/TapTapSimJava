// $Id $
package player;

import java.math.BigDecimal;

import heroes.Hero;

/**
 * Class containing all guild tech information
 */
public class GuildTech {
  /** the warrior tech of this guild tech */
  private final WarriorTech warriorTech;
  /** the assassin tech of this guild tech */
  private final AssassinTech assassinTech;
  /** the wanderer tech of this guild tech */
  private final WandererTech wandererTech;
  /** the cleric tech of this guild tech */
  private final ClericTech clericTech;
  /** the mage tech of this guild tech */
  private final MageTech mageTech;

  /**
   * create a guild tech by giving all the tech for the five classes
   * 
   * @param warriorTech
   *        the warrior tech to add
   * @param assassinTech
   *        the assassin tech to add
   * @param wandererTech
   *        the wanderer tech to add
   * @param clericTech
   *        the cleric tech to add
   * @param mageTech
   *        the mage tech to add
   */
  public GuildTech(WarriorTech warriorTech, AssassinTech assassinTech, WandererTech wandererTech, ClericTech clericTech,
      MageTech mageTech) {
    super();
    this.warriorTech = warriorTech;
    this.assassinTech = assassinTech;
    this.wandererTech = wandererTech;
    this.clericTech = clericTech;
    this.mageTech = mageTech;
  }

  /**
   * @return a completely maxed guild tech
   */
  public static GuildTech max() {
    return new GuildTech(WarriorTech.max(), AssassinTech.max(), WandererTech.max(), ClericTech.max(), MageTech.max());
  }

  /**
   * apply the guild tech to a specific hero
   * 
   * @param hero
   *        hero the tech should be applied to
   */
  public void apply(Hero hero) {
    switch (hero.getHeroClass()) {
    case ASSASSIN:
      assassinTech.apply(hero);
      break;
    case CLERIC:
      clericTech.apply(hero);
      break;
    case MAGE:
      mageTech.apply(hero);
      break;
    case WANDERER:
      wandererTech.apply(hero);
      break;
    case WARRIOR:
      warriorTech.apply(hero);
      break;
    }
  }

  /**
   * the warrior tech tree
   */
  public static class WarriorTech {
    /** the level of the first tech item */
    private final int levelHP;
    /** the level of the second tech item */
    private final int levelAttack;
    /** the level of the third tech item */
    private final int levelCritRate;
    /** the level of the fourth tech item */
    private final int levelDodge;
    /** the level of the fifth tech item */
    private final int levelSkillDamage;

    /**
     * create the tech tree by specifying its levels
     * 
     * @param levelHP
     *        the level of the first tech item
     * @param levelAttack
     *        the level of the second tech item
     * @param levelCritRate
     *        the level of the third tech item
     * @param levelDodge
     *        the level of the fourth tech item
     * @param levelSkillDamage
     *        the level of the fifith tech item
     */
    public WarriorTech(int levelHP, int levelAttack, int levelCritRate, int levelDodge, int levelSkillDamage) {
      super();
      this.levelHP = levelHP;
      this.levelAttack = levelAttack;
      this.levelCritRate = levelCritRate;
      this.levelDodge = levelDodge;
      this.levelSkillDamage = levelSkillDamage;
    }

    /**
     * @return a maxed tech
     */
    public static WarriorTech max() {
      return new WarriorTech(100, 60, 60, 50, 40);
    }

    /**
     * apply the guild tech to a specific hero
     * 
     * @param hero
     *        hero the tech should be applied to
     */
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelHP)));
      hero.addAttackModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelAttack)));
      hero.increaseCritRate(new BigDecimal("0.005").multiply(new BigDecimal(levelCritRate)));
      hero.increaseDodgeChance(new BigDecimal("0.005").multiply(new BigDecimal(levelDodge)));
      hero.increaseSkillDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkillDamage)));
    }

  }

  /**
   * the assassin tech tree
   */
  public static class AssassinTech {
    /** the level of the first tech item */
    private final int levelHP;
    /** the level of the second tech item */
    private final int levelAttack;
    /** the level of the third tech item */
    private final int levelCritRate;
    /** the level of the fourth tech item */
    private final int levelDefenseBreak;
    /** the level of the fifth tech item */
    private final int levelSkillDamage;

    /**
     * create the tech tree by specifying its levels
     * 
     * @param levelHP
     *        the level of the first tech item
     * @param levelAttack
     *        the level of the second tech item
     * @param levelCritRate
     *        the level of the third tech item
     * @param levelDefenseBreak
     *        the level of the fourth tech item
     * @param levelSkillDamage
     *        the level of the fifith tech item
     */
    public AssassinTech(int levelHP, int levelAttack, int levelCritRate, int levelDefenseBreak, int levelSkillDamage) {
      super();
      this.levelHP = levelHP;
      this.levelAttack = levelAttack;
      this.levelCritRate = levelCritRate;
      this.levelDefenseBreak = levelDefenseBreak;
      this.levelSkillDamage = levelSkillDamage;
    }

    /**
     * @return a maxed tech
     */
    public static AssassinTech max() {
      return new AssassinTech(100, 60, 60, 50, 40);
    }

    /**
     * apply the guild tech to a specific hero
     * 
     * @param hero
     *        hero the tech should be applied to
     */
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelHP)));
      hero.addAttackModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelAttack)));
      hero.increaseCritRate(new BigDecimal("0.005").multiply(new BigDecimal(levelCritRate)));
      hero.increaseDefenseBreak(new BigDecimal("0.15").multiply(new BigDecimal(levelDefenseBreak)));
      hero.increaseSkillDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkillDamage)));
    }

  }

  /**
   * the wanderer tech tree
   */
  public static class WandererTech {
    /** the level of the first tech item */
    private final int levelHP;
    /** the level of the second tech item */
    private final int levelAttack;
    /** the level of the third tech item */
    private final int levelDodge;
    /** the level of the fourth tech item */
    private final int levelHitRate;
    /** the level of the fifth tech item */
    private final int levelSkillDamage;

    /**
     * create the tech tree by specifying its levels
     * 
     * @param levelHP
     *        the level of the first tech item
     * @param levelAttack
     *        the level of the second tech item
     * @param levelDodge
     *        the level of the third tech item
     * @param levelHitRate
     *        the level of the fourth tech item
     * @param levelSkillDamage
     *        the level of the fifith tech item
     */
    public WandererTech(int levelHP, int levelAttack, int levelDodge, int levelHitRate, int levelSkillDamage) {
      super();
      this.levelHP = levelHP;
      this.levelAttack = levelAttack;
      this.levelDodge = levelDodge;
      this.levelHitRate = levelHitRate;
      this.levelSkillDamage = levelSkillDamage;
    }

    /**
     * @return a maxed tech
     */
    public static WandererTech max() {
      return new WandererTech(100, 60, 60, 50, 40);
    }

    /**
     * apply the guild tech to a specific hero
     * 
     * @param hero
     *        hero the tech should be applied to
     */
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelHP)));
      hero.addAttackModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelAttack)));
      hero.increaseHitRate(new BigDecimal("0.005").multiply(new BigDecimal(levelHitRate)));
      hero.increaseDodgeChance(new BigDecimal("0.005").multiply(new BigDecimal(levelDodge)));
      hero.increaseSkillDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkillDamage)));
    }

  }

  /**
   * the cleric tech tree
   */
  public static class ClericTech {
    /** the level of the first tech item */
    private final int levelHP;
    /** the level of the second tech item */
    private final int levelDodge;
    /** the level of the third tech item */
    private final int levelCritRate;
    /** the level of the fourth tech item */
    private final int levelSpeed;
    /** the level of the fifth tech item */
    private final int levelSkillDamage;

    /**
     * create the tech tree by specifying its levels
     * 
     * @param levelHP
     *        the level of the first tech item
     * @param levelDodge
     *        the level of the second tech item
     * @param levelCritRate
     *        the level of the third tech item
     * @param levelSpeed
     *        the level of the fourth tech item
     * @param levelSkillDamage
     *        the level of the fifith tech item
     */
    public ClericTech(int levelHP, int levelDodge, int levelCritRate, int levelSpeed, int levelSkillDamage) {
      super();
      this.levelHP = levelHP;
      this.levelDodge = levelDodge;
      this.levelCritRate = levelCritRate;
      this.levelSpeed = levelSpeed;
      this.levelSkillDamage = levelSkillDamage;
    }

    /**
     * @return a maxed tech
     */
    public static ClericTech max() {
      return new ClericTech(100, 60, 60, 50, 40);
    }

    /**
     * apply the guild tech to a specific hero
     * 
     * @param hero
     *        hero the tech should be applied to
     */
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelHP)));
      hero.increaseCritRate(new BigDecimal("0.005").multiply(new BigDecimal(levelCritRate)));
      hero.increaseDodgeChance(new BigDecimal("0.005").multiply(new BigDecimal(levelDodge)));
      hero.increaseSkillDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkillDamage)));
      hero.increaseSpeed(2 * levelSpeed);
    }

  }

  /**
   * the mage tech tree
   */
  public static class MageTech {
    /** the level of the first tech item */
    private final int levelHP;
    /** the level of the second tech item */
    private final int levelAttack;
    /** the level of the third tech item */
    private final int levelCritRate;
    /** the level of the fourth tech item */
    private final int levelHitRate;
    /** the level of the fifth tech item */
    private final int levelSkillDamage;

    /**
     * create the tech tree by specifying its levels
     * 
     * @param levelHP
     *        the level of the first tech item
     * @param levelAttack
     *        the level of the second tech item
     * @param levelCritRate
     *        the level of the third tech item
     * @param levelHitRate
     *        the level of the fourth tech item
     * @param levelSkillDamage
     *        the level of the fifith tech item
     */
    public MageTech(int levelHP, int levelAttack, int levelCritRate, int levelHitRate, int levelSkillDamage) {
      super();
      this.levelHP = levelHP;
      this.levelAttack = levelAttack;
      this.levelCritRate = levelCritRate;
      this.levelHitRate = levelHitRate;
      this.levelSkillDamage = levelSkillDamage;
    }

    /**
     * @return a maxed tech
     */
    public static MageTech max() {
      return new MageTech(100, 60, 60, 50, 40);
    }

    /**
     * apply the guild tech to a specific hero
     * 
     * @param hero
     *        hero the tech should be applied to
     */
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelHP)));
      hero.addAttackModifier(new BigDecimal("0.005").multiply(new BigDecimal(levelAttack)));
      hero.increaseCritRate(new BigDecimal("0.005").multiply(new BigDecimal(levelCritRate)));
      hero.increaseHitRate(new BigDecimal("0.005").multiply(new BigDecimal(levelHitRate)));
      hero.increaseSkillDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkillDamage)));
    }

  }
}

// end of file
