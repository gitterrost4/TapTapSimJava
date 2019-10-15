// $Id $
// (C) cantamen/Paul Kramer 2019
package player;

import java.math.BigDecimal;

import heroes.Hero;

/** 
 * TODO documentation
 *
 */
public class GuildTech {
  private final WarriorTech warriorTech;
  private final AssassinTech assassinTech;
  private final WandererTech wandererTech;
  private final ClericTech clericTech;
  private final MageTech mageTech;
  
  public GuildTech(WarriorTech warriorTech, AssassinTech assassinTech, WandererTech wandererTech, ClericTech clericTech,
    MageTech mageTech) {
    super();
    this.warriorTech=warriorTech;
    this.assassinTech=assassinTech;
    this.wandererTech=wandererTech;
    this.clericTech=clericTech;
    this.mageTech=mageTech;
  }
  
  public static GuildTech max() {
    return new GuildTech(WarriorTech.max(),AssassinTech.max(),WandererTech.max(),ClericTech.max(),MageTech.max());
  } 
  
  public void apply(Hero hero) {
    switch(hero.getHeroClass()) {
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

  public static class WarriorTech{
    private final int levelHP;
    private final int levelAttack;
    private final int levelCritRate;
    private final int levelDodge;
    private final int levelSkillDamage;

    public WarriorTech(int levelHP, int levelAttack, int levelCritRate, int levelDodge, int levelSkillDamage) {
      super();
      this.levelHP=levelHP;
      this.levelAttack=levelAttack;
      this.levelCritRate=levelCritRate;
      this.levelDodge=levelDodge;
      this.levelSkillDamage=levelSkillDamage;
    }
    
    public static WarriorTech max() {
      return new WarriorTech(100,60,60,50,40);
    }
  
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelHP))));
      hero.addAttackModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelAttack))));
      hero.increaseCritRate(new BigDecimal(0.005).multiply(new BigDecimal(levelCritRate)));
      hero.increaseDodgeChance(new BigDecimal(0.005).multiply(new BigDecimal(levelDodge)));
      hero.increaseSkillDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkillDamage)));
    }
  
  }

  public static class AssassinTech{
    private final int levelHP;
    private final int levelAttack;
    private final int levelCritRate;
    private final int levelDefenseBreak;
    private final int levelSkillDamage;

    public AssassinTech(int levelHP, int levelAttack, int levelCritRate, int levelDefenseBreak, int levelSkillDamage) {
      super();
      this.levelHP=levelHP;
      this.levelAttack=levelAttack;
      this.levelCritRate=levelCritRate;
      this.levelDefenseBreak=levelDefenseBreak;
      this.levelSkillDamage=levelSkillDamage;
    }
    
    public static AssassinTech max() {
      return new AssassinTech(100,60,60,50,40);
    }
  
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelHP))));
      hero.addAttackModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelAttack))));
      hero.increaseCritRate(new BigDecimal(0.005).multiply(new BigDecimal(levelCritRate)));
      hero.increaseDefenseBreak(new BigDecimal(0.15).multiply(new BigDecimal(levelDefenseBreak)));
      hero.increaseSkillDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkillDamage)));
    }
  
  }

  public static class WandererTech{
    private final int levelHP;
    private final int levelAttack;
    private final int levelDodge;
    private final int levelHitRate;
    private final int levelSkillDamage;

    public WandererTech(int levelHP, int levelAttack, int levelDodge, int levelHitRate, int levelSkillDamage) {
      super();
      this.levelHP=levelHP;
      this.levelAttack=levelAttack;
      this.levelDodge=levelDodge;
      this.levelHitRate=levelHitRate;
      this.levelSkillDamage=levelSkillDamage;
    }
    
    public static WandererTech max() {
      return new WandererTech(100,60,60,50,40);
    }
  
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelHP))));
      hero.addAttackModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelAttack))));
      hero.increaseHitRate(new BigDecimal(0.005).multiply(new BigDecimal(levelHitRate)));
      hero.increaseDodgeChance(new BigDecimal(0.005).multiply(new BigDecimal(levelDodge)));
      hero.increaseSkillDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkillDamage)));
    }
  
  }

  public static class ClericTech{
    private final int levelHP;
    private final int levelDodge;
    private final int levelCritRate;
    private final int levelSpeed;
    private final int levelSkillDamage;

    public ClericTech(int levelHP, int levelDodge, int levelCritRate, int levelSpeed, int levelSkillDamage) {
      super();
      this.levelHP=levelHP;
      this.levelDodge=levelDodge;
      this.levelCritRate=levelCritRate;
      this.levelSpeed=levelSpeed;
      this.levelSkillDamage=levelSkillDamage;
    }
    
    public static ClericTech max() {
      return new ClericTech(100,60,60,50,40);
    }
  
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelHP))));
      hero.increaseCritRate(new BigDecimal(0.005).multiply(new BigDecimal(levelCritRate)));
      hero.increaseDodgeChance(new BigDecimal(0.005).multiply(new BigDecimal(levelDodge)));
      hero.increaseSkillDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkillDamage)));
      hero.increaseSpeed(2*levelSpeed);
   }
  
  }

  public static class MageTech{
    private final int levelHP;
    private final int levelAttack;
    private final int levelCritRate;
    private final int levelHitRate;
    private final int levelSkillDamage;

    public MageTech(int levelHP, int levelAttack, int levelCritRate, int levelHitRate, int levelSkillDamage) {
      super();
      this.levelHP=levelHP;
      this.levelAttack=levelAttack;
      this.levelCritRate=levelCritRate;
      this.levelHitRate=levelHitRate;
      this.levelSkillDamage=levelSkillDamage;
    }
    
    public static MageTech max() {
      return new MageTech(100,60,60,50,40);
    }
    
    private void apply(Hero hero) {
      hero.addMaxHPModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelHP))));
      hero.addAttackModifier(new BigDecimal(1).add(new BigDecimal(0.005).multiply(new BigDecimal(levelAttack))));
      hero.increaseCritRate(new BigDecimal(0.005).multiply(new BigDecimal(levelCritRate)));
      hero.increaseHitRate(new BigDecimal(0.005).multiply(new BigDecimal(levelHitRate)));
      hero.increaseSkillDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkillDamage)));
    }
  
  }
}


// end of file
