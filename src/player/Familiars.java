package player;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import heroes.Hero;
import util.Utilities;

/**
 * class representing the three familiars
 * @author gitterrost4
 *
 */
public class Familiars {
  private final Edison edison;
  private final Vinci vinci;
  private final Raphael raphael;
  private final AbstractFamiliar activeFamiliar;
  
  public Familiars(Edison edison, Vinci vinci, Raphael raphael, FamiliarType activeFamiliar) {
    super();
    this.edison = edison;
    this.vinci = vinci;
    this.raphael = raphael;
    switch(activeFamiliar) {
    case EDISON:
      this.activeFamiliar=edison;
      break;
    case RAPHAEL:
      this.activeFamiliar=raphael;
      break;
    case VINCI:
      this.activeFamiliar=vinci;
      break;
    default:
      this.activeFamiliar=raphael;
      break;
      
    }
  }
  
  public void apply(Hero hero) {
    Stream.of(vinci, edison, raphael).forEach(familiar->familiar.applyPassive(hero));
    activeFamiliar.applyActive(hero);
  }
  
  public enum FamiliarType{
    VINCI,EDISON,RAPHAEL;
  }
  
  public static Familiars max(FamiliarType activeFamiliar) {
    return new Familiars(Edison.max(), Vinci.max(), Raphael.max(), activeFamiliar);
  }
  
  public static abstract class AbstractFamiliar{
    
    protected final Integer level;
    protected final Integer levelSkill1;
    protected final Integer levelSkill2;
    protected final Integer levelSkill3;
    protected final Integer levelSkill4;

    private AbstractFamiliar(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3,
        Integer levelSkill4) {
      super();
      this.level = level;
      this.levelSkill1 = levelSkill1;
      this.levelSkill2 = levelSkill2;
      this.levelSkill3 = levelSkill3;
      this.levelSkill4 = levelSkill4;
    }
    
    protected abstract void applyPassive(Hero hero);
    protected abstract void applyActive(Hero hero);
    
  }
  public static class Vinci extends AbstractFamiliar{

    private final static Map<Integer,Integer> knownHPBonus=new HashMap<>();
    private final static Map<Integer,Integer> knownAttackBonus = new HashMap<>();

    static {
      knownHPBonus.put(1,125);
      knownHPBonus.put(120, 2520);
      knownHPBonus.put(200, 13720);

      knownAttackBonus.put(1, 6);
      knownAttackBonus.put(120, 127);
      knownAttackBonus.put(200, 687);
    }

    public Vinci(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level, levelSkill1, levelSkill2, levelSkill3, levelSkill4);
    }
    
    public static Vinci max() {
      return new Vinci(200, 120, 20, 20, 20);
    }

    @Override
    protected void applyPassive(Hero hero) {
      hero.increaseMaxHP(Utilities.interpolateStatsLinearly(knownHPBonus, level));
      hero.increaseAttack(Utilities.interpolateStatsLinearly(knownAttackBonus, level));
    }

    @Override
    protected void applyActive(Hero hero) {
      hero.increaseSkillDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkill2)));
      hero.increaseHitRate(new BigDecimal(0.005).multiply(new BigDecimal(levelSkill3)));
      hero.increaseSpeed(2*levelSkill4);
    }
    
  }
  
  public static class Edison extends AbstractFamiliar{
    private final static Map<Integer,Integer> knownHPBonus=new HashMap<>();
    private final static Map<Integer,Integer> knownAttackBonus = new HashMap<>();

    static {
      knownHPBonus.put(1, 137);
      knownHPBonus.put(152, 5126);
      knownHPBonus.put(200, 15092);

      knownAttackBonus.put(1,3);
      knownAttackBonus.put(152, 140);
      knownAttackBonus.put(200, 412);
    }

    public Edison(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level, levelSkill1, levelSkill2, levelSkill3, levelSkill4);
    }
    
    public static Edison max() {
      return new Edison(200, 120, 20, 20, 20);
    }

    @Override
    protected void applyPassive(Hero hero) {
      hero.increaseMaxHP(Utilities.interpolateStatsLinearly(knownHPBonus, level));
      hero.increaseAttack(Utilities.interpolateStatsLinearly(knownAttackBonus, level));
    }

    @Override
    protected void applyActive(Hero hero) {
      hero.increaseCritRate(new BigDecimal(0.005).multiply(new BigDecimal(levelSkill2)));
      hero.increaseCritDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkill3)));
      hero.increaseSpeed(2*levelSkill4);
    }
  
  }
  
  public static class Raphael extends AbstractFamiliar{
    private final static Map<Integer,Integer> knownHPBonus=new HashMap<>();
    private final static Map<Integer,Integer> knownAttackBonus = new HashMap<>();

    static {
      knownHPBonus.put(158, 4707);
      knownHPBonus.put(200, 12348);

      knownAttackBonus.put(158,366);
      knownAttackBonus.put(200, 961);
    }

    public Raphael(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level, levelSkill1, levelSkill2, levelSkill3, levelSkill4);
    }
    
    public static Raphael max() {
      return new Raphael(200, 120, 20, 20, 20);
    }

    @Override
    protected void applyPassive(Hero hero) {
      hero.increaseMaxHP(Utilities.interpolateStatsLinearly(knownHPBonus, level));
      hero.increaseAttack(Utilities.interpolateStatsLinearly(knownAttackBonus, level));
    }

    @Override
    protected void applyActive(Hero hero) {
      hero.increaseTrueDamage(new BigDecimal(0.01).multiply(new BigDecimal(levelSkill2)));
      hero.increaseDodgeChance(new BigDecimal(0.005).multiply(new BigDecimal(levelSkill3)));
      hero.increaseSpeed(2*levelSkill4);
    }
    
  }
}
