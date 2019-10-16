package player;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import heroes.Hero;

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
    private final static Map<Integer, Integer> maxHPIncreasePerLevel = new HashMap<>();
    private final static Map<Integer, Integer> attackIncreasePerLevel = new HashMap<>();

    static {
      maxHPIncreasePerLevel.put(1,125);
      maxHPIncreasePerLevel.put(2,130);
      maxHPIncreasePerLevel.put(3,135);
      maxHPIncreasePerLevel.put(4,140);
      maxHPIncreasePerLevel.put(5,145);
      maxHPIncreasePerLevel.put(6,150);
      maxHPIncreasePerLevel.put(7,155);
      maxHPIncreasePerLevel.put(8,160);
      maxHPIncreasePerLevel.put(9,165);
      maxHPIncreasePerLevel.put(10,170);
      maxHPIncreasePerLevel.put(11,176);
      maxHPIncreasePerLevel.put(12,183);
      maxHPIncreasePerLevel.put(13,189);
      maxHPIncreasePerLevel.put(14,195);
      maxHPIncreasePerLevel.put(15,201);
      maxHPIncreasePerLevel.put(16,208);
      maxHPIncreasePerLevel.put(17,214);
      maxHPIncreasePerLevel.put(18,220);
      maxHPIncreasePerLevel.put(19,226);
      maxHPIncreasePerLevel.put(20,233);
      maxHPIncreasePerLevel.put(21,240);
      maxHPIncreasePerLevel.put(22,248);
      maxHPIncreasePerLevel.put(23,255);
      maxHPIncreasePerLevel.put(24,263);
      maxHPIncreasePerLevel.put(25,270);
      maxHPIncreasePerLevel.put(26,278);
      maxHPIncreasePerLevel.put(27,285);
      maxHPIncreasePerLevel.put(28,293);
      maxHPIncreasePerLevel.put(29,300);
      maxHPIncreasePerLevel.put(30,308);
      maxHPIncreasePerLevel.put(31,316);
      maxHPIncreasePerLevel.put(32,325);
      maxHPIncreasePerLevel.put(33,334);
      maxHPIncreasePerLevel.put(34,343);
      maxHPIncreasePerLevel.put(35,351);
      maxHPIncreasePerLevel.put(36,360);
      maxHPIncreasePerLevel.put(37,369);
      maxHPIncreasePerLevel.put(38,378);
      maxHPIncreasePerLevel.put(39,386);
      maxHPIncreasePerLevel.put(40,395);
      maxHPIncreasePerLevel.put(41,405);
      maxHPIncreasePerLevel.put(42,415);
      maxHPIncreasePerLevel.put(43,425);
      maxHPIncreasePerLevel.put(44,435);
      maxHPIncreasePerLevel.put(45,445);
      maxHPIncreasePerLevel.put(46,455);
      maxHPIncreasePerLevel.put(47,465);
      maxHPIncreasePerLevel.put(48,475);
      maxHPIncreasePerLevel.put(49,485);
      maxHPIncreasePerLevel.put(50,495);
      maxHPIncreasePerLevel.put(51,506);
      maxHPIncreasePerLevel.put(52,518);
      maxHPIncreasePerLevel.put(53,529);
      maxHPIncreasePerLevel.put(54,540);
      maxHPIncreasePerLevel.put(55,551);
      maxHPIncreasePerLevel.put(56,563);
      maxHPIncreasePerLevel.put(57,574);
      maxHPIncreasePerLevel.put(58,585);
      maxHPIncreasePerLevel.put(59,596);
      maxHPIncreasePerLevel.put(60,608);
      maxHPIncreasePerLevel.put(61,620);
      maxHPIncreasePerLevel.put(62,633);
      maxHPIncreasePerLevel.put(63,645);
      maxHPIncreasePerLevel.put(64,658);
      maxHPIncreasePerLevel.put(65,670);
      maxHPIncreasePerLevel.put(66,683);
      maxHPIncreasePerLevel.put(67,695);
      maxHPIncreasePerLevel.put(68,708);
      maxHPIncreasePerLevel.put(69,720);
      maxHPIncreasePerLevel.put(70,733);
      maxHPIncreasePerLevel.put(71,746);
      maxHPIncreasePerLevel.put(72,760);
      maxHPIncreasePerLevel.put(73,774);
      maxHPIncreasePerLevel.put(74,788);
      maxHPIncreasePerLevel.put(75,801);
      maxHPIncreasePerLevel.put(76,815);
      maxHPIncreasePerLevel.put(77,829);
      maxHPIncreasePerLevel.put(78,843);
      maxHPIncreasePerLevel.put(79,856);
      maxHPIncreasePerLevel.put(80,870);
      maxHPIncreasePerLevel.put(81,890);
      maxHPIncreasePerLevel.put(82,910);
      maxHPIncreasePerLevel.put(83,930);
      maxHPIncreasePerLevel.put(84,950);
      maxHPIncreasePerLevel.put(85,970);
      maxHPIncreasePerLevel.put(86,990);
      maxHPIncreasePerLevel.put(87,1010);
      maxHPIncreasePerLevel.put(88,1030);
      maxHPIncreasePerLevel.put(89,1050);
      maxHPIncreasePerLevel.put(90,1070);
      maxHPIncreasePerLevel.put(91,1095);
      maxHPIncreasePerLevel.put(92,1120);
      maxHPIncreasePerLevel.put(93,1145);
      maxHPIncreasePerLevel.put(94,1170);
      maxHPIncreasePerLevel.put(95,1195);
      maxHPIncreasePerLevel.put(96,1220);
      maxHPIncreasePerLevel.put(97,1245);
      maxHPIncreasePerLevel.put(98,1270);
      maxHPIncreasePerLevel.put(99,1295);
      maxHPIncreasePerLevel.put(100,1320);
      maxHPIncreasePerLevel.put(101,1350);
      maxHPIncreasePerLevel.put(102,1380);
      maxHPIncreasePerLevel.put(103,1410);
      maxHPIncreasePerLevel.put(104,1440);
      maxHPIncreasePerLevel.put(105,1470);
      maxHPIncreasePerLevel.put(106,1500);
      maxHPIncreasePerLevel.put(107,1530);
      maxHPIncreasePerLevel.put(108,1560);
      maxHPIncreasePerLevel.put(109,1590);
      maxHPIncreasePerLevel.put(110,1620);
      maxHPIncreasePerLevel.put(111,1655);
      maxHPIncreasePerLevel.put(112,1690);
      maxHPIncreasePerLevel.put(113,1725);
      maxHPIncreasePerLevel.put(114,1760);
      maxHPIncreasePerLevel.put(115,1795);
      maxHPIncreasePerLevel.put(116,1830);
      maxHPIncreasePerLevel.put(117,1865);
      maxHPIncreasePerLevel.put(118,1900);
      maxHPIncreasePerLevel.put(119,1935);
      maxHPIncreasePerLevel.put(120,1970);
      maxHPIncreasePerLevel.put(121,2020);
      maxHPIncreasePerLevel.put(122,2070);
      maxHPIncreasePerLevel.put(123,2120);
      maxHPIncreasePerLevel.put(124,2170);
      maxHPIncreasePerLevel.put(125,2220);
      maxHPIncreasePerLevel.put(126,2270);
      maxHPIncreasePerLevel.put(127,2320);
      maxHPIncreasePerLevel.put(128,2370);
      maxHPIncreasePerLevel.put(129,2420);
      maxHPIncreasePerLevel.put(130,2470);
      maxHPIncreasePerLevel.put(131,2535);
      maxHPIncreasePerLevel.put(132,2600);
      maxHPIncreasePerLevel.put(133,2665);
      maxHPIncreasePerLevel.put(134,2730);
      maxHPIncreasePerLevel.put(135,2795);
      maxHPIncreasePerLevel.put(136,2860);
      maxHPIncreasePerLevel.put(137,2925);
      maxHPIncreasePerLevel.put(138,2990);
      maxHPIncreasePerLevel.put(139,3055);
      maxHPIncreasePerLevel.put(140,3120);
      maxHPIncreasePerLevel.put(141,3200);
      maxHPIncreasePerLevel.put(142,3280);
      maxHPIncreasePerLevel.put(143,3360);
      maxHPIncreasePerLevel.put(144,3440);
      maxHPIncreasePerLevel.put(145,3520);
      maxHPIncreasePerLevel.put(146,3600);
      maxHPIncreasePerLevel.put(147,3680);
      maxHPIncreasePerLevel.put(148,3760);
      maxHPIncreasePerLevel.put(149,3840);
      maxHPIncreasePerLevel.put(150,3920);
      maxHPIncreasePerLevel.put(151,4015);
      maxHPIncreasePerLevel.put(152,4110);
      maxHPIncreasePerLevel.put(153,4205);
      maxHPIncreasePerLevel.put(154,4300);
      maxHPIncreasePerLevel.put(155,4395);
      maxHPIncreasePerLevel.put(156,4490);
      maxHPIncreasePerLevel.put(157,4585);
      maxHPIncreasePerLevel.put(158,4680);
      maxHPIncreasePerLevel.put(159,4775);
      maxHPIncreasePerLevel.put(160,4870);
      maxHPIncreasePerLevel.put(161,4995);
      maxHPIncreasePerLevel.put(162,5120);
      maxHPIncreasePerLevel.put(163,5245);
      maxHPIncreasePerLevel.put(164,5370);
      maxHPIncreasePerLevel.put(165,5495);
      maxHPIncreasePerLevel.put(166,5620);
      maxHPIncreasePerLevel.put(167,5745);
      maxHPIncreasePerLevel.put(168,5870);
      maxHPIncreasePerLevel.put(169,5995);
      maxHPIncreasePerLevel.put(170,6120);
      maxHPIncreasePerLevel.put(171,6283);
      maxHPIncreasePerLevel.put(172,6445);
      maxHPIncreasePerLevel.put(173,6608);
      maxHPIncreasePerLevel.put(174,6770);
      maxHPIncreasePerLevel.put(175,6933);
      maxHPIncreasePerLevel.put(176,7095);
      maxHPIncreasePerLevel.put(177,7258);
      maxHPIncreasePerLevel.put(178,7420);
      maxHPIncreasePerLevel.put(179,7583);
      maxHPIncreasePerLevel.put(180,7745);
      maxHPIncreasePerLevel.put(181,7945);
      maxHPIncreasePerLevel.put(182,8145);
      maxHPIncreasePerLevel.put(183,8345);
      maxHPIncreasePerLevel.put(184,8545);
      maxHPIncreasePerLevel.put(185,8745);
      maxHPIncreasePerLevel.put(186,8945);
      maxHPIncreasePerLevel.put(187,9145);
      maxHPIncreasePerLevel.put(188,9345);
      maxHPIncreasePerLevel.put(189,9545);
      maxHPIncreasePerLevel.put(190,9745);
      maxHPIncreasePerLevel.put(191,9983);
      maxHPIncreasePerLevel.put(192,10220);
      maxHPIncreasePerLevel.put(193,10458);
      maxHPIncreasePerLevel.put(194,10695);
      maxHPIncreasePerLevel.put(195,10933);
      maxHPIncreasePerLevel.put(196,11170);
      maxHPIncreasePerLevel.put(197,11408);
      maxHPIncreasePerLevel.put(198,11645);
      maxHPIncreasePerLevel.put(199,11883);
      maxHPIncreasePerLevel.put(200,12120);

      attackIncreasePerLevel.put(1,6);
      attackIncreasePerLevel.put(2,7);
      attackIncreasePerLevel.put(3,7);
      attackIncreasePerLevel.put(4,7);
      attackIncreasePerLevel.put(5,7);
      attackIncreasePerLevel.put(6,8);
      attackIncreasePerLevel.put(7,8);
      attackIncreasePerLevel.put(8,8);
      attackIncreasePerLevel.put(9,8);
      attackIncreasePerLevel.put(10,9);
      attackIncreasePerLevel.put(11,9);
      attackIncreasePerLevel.put(12,9);
      attackIncreasePerLevel.put(13,9);
      attackIncreasePerLevel.put(14,10);
      attackIncreasePerLevel.put(15,10);
      attackIncreasePerLevel.put(16,10);
      attackIncreasePerLevel.put(17,11);
      attackIncreasePerLevel.put(18,11);
      attackIncreasePerLevel.put(19,11);
      attackIncreasePerLevel.put(20,12);
      attackIncreasePerLevel.put(21,12);
      attackIncreasePerLevel.put(22,12);
      attackIncreasePerLevel.put(23,13);
      attackIncreasePerLevel.put(24,13);
      attackIncreasePerLevel.put(25,14);
      attackIncreasePerLevel.put(26,14);
      attackIncreasePerLevel.put(27,14);
      attackIncreasePerLevel.put(28,15);
      attackIncreasePerLevel.put(29,15);
      attackIncreasePerLevel.put(30,15);
      attackIncreasePerLevel.put(31,16);
      attackIncreasePerLevel.put(32,16);
      attackIncreasePerLevel.put(33,17);
      attackIncreasePerLevel.put(34,17);
      attackIncreasePerLevel.put(35,18);
      attackIncreasePerLevel.put(36,18);
      attackIncreasePerLevel.put(37,18);
      attackIncreasePerLevel.put(38,19);
      attackIncreasePerLevel.put(39,19);
      attackIncreasePerLevel.put(40,20);
      attackIncreasePerLevel.put(41,20);
      attackIncreasePerLevel.put(42,21);
      attackIncreasePerLevel.put(43,21);
      attackIncreasePerLevel.put(44,22);
      attackIncreasePerLevel.put(45,22);
      attackIncreasePerLevel.put(46,23);
      attackIncreasePerLevel.put(47,23);
      attackIncreasePerLevel.put(48,24);
      attackIncreasePerLevel.put(49,24);
      attackIncreasePerLevel.put(50,25);
      attackIncreasePerLevel.put(51,25);
      attackIncreasePerLevel.put(52,26);
      attackIncreasePerLevel.put(53,26);
      attackIncreasePerLevel.put(54,27);
      attackIncreasePerLevel.put(55,28);
      attackIncreasePerLevel.put(56,28);
      attackIncreasePerLevel.put(57,29);
      attackIncreasePerLevel.put(58,29);
      attackIncreasePerLevel.put(59,30);
      attackIncreasePerLevel.put(60,30);
      attackIncreasePerLevel.put(61,31);
      attackIncreasePerLevel.put(62,32);
      attackIncreasePerLevel.put(63,32);
      attackIncreasePerLevel.put(64,33);
      attackIncreasePerLevel.put(65,34);
      attackIncreasePerLevel.put(66,34);
      attackIncreasePerLevel.put(67,35);
      attackIncreasePerLevel.put(68,35);
      attackIncreasePerLevel.put(69,36);
      attackIncreasePerLevel.put(70,37);
      attackIncreasePerLevel.put(71,37);
      attackIncreasePerLevel.put(72,38);
      attackIncreasePerLevel.put(73,39);
      attackIncreasePerLevel.put(74,39);
      attackIncreasePerLevel.put(75,40);
      attackIncreasePerLevel.put(76,41);
      attackIncreasePerLevel.put(77,41);
      attackIncreasePerLevel.put(78,42);
      attackIncreasePerLevel.put(79,43);
      attackIncreasePerLevel.put(80,44);
      attackIncreasePerLevel.put(81,45);
      attackIncreasePerLevel.put(82,46);
      attackIncreasePerLevel.put(83,47);
      attackIncreasePerLevel.put(84,48);
      attackIncreasePerLevel.put(85,49);
      attackIncreasePerLevel.put(86,50);
      attackIncreasePerLevel.put(87,51);
      attackIncreasePerLevel.put(88,52);
      attackIncreasePerLevel.put(89,53);
      attackIncreasePerLevel.put(90,54);
      attackIncreasePerLevel.put(91,55);
      attackIncreasePerLevel.put(92,56);
      attackIncreasePerLevel.put(93,57);
      attackIncreasePerLevel.put(94,59);
      attackIncreasePerLevel.put(95,60);
      attackIncreasePerLevel.put(96,61);
      attackIncreasePerLevel.put(97,62);
      attackIncreasePerLevel.put(98,64);
      attackIncreasePerLevel.put(99,65);
      attackIncreasePerLevel.put(100,66);
      attackIncreasePerLevel.put(101,68);
      attackIncreasePerLevel.put(102,69);
      attackIncreasePerLevel.put(103,71);
      attackIncreasePerLevel.put(104,72);
      attackIncreasePerLevel.put(105,74);
      attackIncreasePerLevel.put(106,75);
      attackIncreasePerLevel.put(107,77);
      attackIncreasePerLevel.put(108,78);
      attackIncreasePerLevel.put(109,80);
      attackIncreasePerLevel.put(110,81);
      attackIncreasePerLevel.put(111,83);
      attackIncreasePerLevel.put(112,85);
      attackIncreasePerLevel.put(113,86);
      attackIncreasePerLevel.put(114,88);
      attackIncreasePerLevel.put(115,90);
      attackIncreasePerLevel.put(116,92);
      attackIncreasePerLevel.put(117,93);
      attackIncreasePerLevel.put(118,95);
      attackIncreasePerLevel.put(119,97);
      attackIncreasePerLevel.put(120,99);
      attackIncreasePerLevel.put(121,101);
      attackIncreasePerLevel.put(122,104);
      attackIncreasePerLevel.put(123,106);
      attackIncreasePerLevel.put(124,109);
      attackIncreasePerLevel.put(125,111);
      attackIncreasePerLevel.put(126,114);
      attackIncreasePerLevel.put(127,116);
      attackIncreasePerLevel.put(128,119);
      attackIncreasePerLevel.put(129,121);
      attackIncreasePerLevel.put(130,124);
      attackIncreasePerLevel.put(131,127);
      attackIncreasePerLevel.put(132,130);
      attackIncreasePerLevel.put(133,133);
      attackIncreasePerLevel.put(134,137);
      attackIncreasePerLevel.put(135,140);
      attackIncreasePerLevel.put(136,143);
      attackIncreasePerLevel.put(137,146);
      attackIncreasePerLevel.put(138,150);
      attackIncreasePerLevel.put(139,153);
      attackIncreasePerLevel.put(140,156);
      attackIncreasePerLevel.put(141,160);
      attackIncreasePerLevel.put(142,164);
      attackIncreasePerLevel.put(143,168);
      attackIncreasePerLevel.put(144,172);
      attackIncreasePerLevel.put(145,176);
      attackIncreasePerLevel.put(146,180);
      attackIncreasePerLevel.put(147,184);
      attackIncreasePerLevel.put(148,188);
      attackIncreasePerLevel.put(149,192);
      attackIncreasePerLevel.put(150,196);
      attackIncreasePerLevel.put(151,201);
      attackIncreasePerLevel.put(152,206);
      attackIncreasePerLevel.put(153,210);
      attackIncreasePerLevel.put(154,215);
      attackIncreasePerLevel.put(155,220);
      attackIncreasePerLevel.put(156,225);
      attackIncreasePerLevel.put(157,229);
      attackIncreasePerLevel.put(158,234);
      attackIncreasePerLevel.put(159,239);
      attackIncreasePerLevel.put(160,244);
      attackIncreasePerLevel.put(161,250);
      attackIncreasePerLevel.put(162,256);
      attackIncreasePerLevel.put(163,262);
      attackIncreasePerLevel.put(164,269);
      attackIncreasePerLevel.put(165,275);
      attackIncreasePerLevel.put(166,281);
      attackIncreasePerLevel.put(167,287);
      attackIncreasePerLevel.put(168,294);
      attackIncreasePerLevel.put(169,300);
      attackIncreasePerLevel.put(170,306);
      attackIncreasePerLevel.put(171,314);
      attackIncreasePerLevel.put(172,322);
      attackIncreasePerLevel.put(173,330);
      attackIncreasePerLevel.put(174,339);
      attackIncreasePerLevel.put(175,347);
      attackIncreasePerLevel.put(176,355);
      attackIncreasePerLevel.put(177,363);
      attackIncreasePerLevel.put(178,371);
      attackIncreasePerLevel.put(179,379);
      attackIncreasePerLevel.put(180,387);
      attackIncreasePerLevel.put(181,397);
      attackIncreasePerLevel.put(182,407);
      attackIncreasePerLevel.put(183,417);
      attackIncreasePerLevel.put(184,427);
      attackIncreasePerLevel.put(185,437);
      attackIncreasePerLevel.put(186,447);
      attackIncreasePerLevel.put(187,457);
      attackIncreasePerLevel.put(188,467);
      attackIncreasePerLevel.put(189,477);
      attackIncreasePerLevel.put(190,487);
      attackIncreasePerLevel.put(191,499);
      attackIncreasePerLevel.put(192,511);
      attackIncreasePerLevel.put(193,523);
      attackIncreasePerLevel.put(194,535);
      attackIncreasePerLevel.put(195,547);
      attackIncreasePerLevel.put(196,559);
      attackIncreasePerLevel.put(197,570);
      attackIncreasePerLevel.put(198,582);
      attackIncreasePerLevel.put(199,594);
      attackIncreasePerLevel.put(200,606);
    }
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
    
    protected void applyPassive(Hero hero) {
      hero.increaseMaxHP(getHPBonus());
      hero.increaseAttack(getAttackBonus());
    }
    protected abstract void applyActive(Hero hero);
    protected abstract BigDecimal getMaxHPMultiplier();
    protected abstract BigDecimal getAttackMultiplier();
    
    protected Integer getHPBonus() {
      return getMaxHPMultiplier().multiply(new BigDecimal(getTierHPBonus() + getLevelHPBonus())).intValue();
    }
    
    private Integer getTierHPBonus() {
      if(level<80) {
        return 0;
      }
      if(level<120) {
        return 155;
      }
      if(level<160) {
        return 550;
      }
      return 1600;
    }
    
    private Integer getLevelHPBonus() {
      return maxHPIncreasePerLevel.get(level);
    }
    
    protected Integer getAttackBonus() {
      return getAttackMultiplier().multiply(new BigDecimal(getTierAttackBonus() + getLevelAttackBonus())).intValue();
    }
    
    private Integer getTierAttackBonus() {
      if(level<80) {
        return 0;
      }
      if(level<120) {
        return 8;
      }
      if(level<160) {
        return 28;
      }
      return 81;
    }
    
    private Integer getLevelAttackBonus() {
      return attackIncreasePerLevel.get(level);
    }
    
  }
  public static class Vinci extends AbstractFamiliar{
    private final static BigDecimal maxHPMultiplier = new BigDecimal("1.0");
    private final static BigDecimal attackMultiplier = new BigDecimal("1.0");

    public Vinci(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level, levelSkill1, levelSkill2, levelSkill3, levelSkill4);
    }
    
    public static Vinci max() {
      return new Vinci(200, 120, 20, 20, 20);
    }

    @Override
    protected void applyActive(Hero hero) {
      hero.increaseSkillDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkill2)));
      hero.increaseHitRate(new BigDecimal("0.005").multiply(new BigDecimal(levelSkill3)));
      hero.increaseSpeed(2*levelSkill4);
    }

    @Override
    protected BigDecimal getMaxHPMultiplier() {
      return maxHPMultiplier;
    }

    @Override
    protected BigDecimal getAttackMultiplier() {
      return attackMultiplier;
    }
    
    
  }
  
  public static class Edison extends AbstractFamiliar{
    private final static BigDecimal maxHPMultiplier = new BigDecimal("1.1");
    private final static BigDecimal attackMultiplier = new BigDecimal("0.6");

    public Edison(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level, levelSkill1, levelSkill2, levelSkill3, levelSkill4);
    }
    
    public static Edison max() {
      return new Edison(200, 120, 20, 20, 20);
    }

    @Override
    protected void applyActive(Hero hero) {
      hero.increaseCritRate(new BigDecimal("0.005").multiply(new BigDecimal(levelSkill2)));
      hero.increaseCritDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkill3)));
      hero.increaseSpeed(2*levelSkill4);
    }
  
    @Override
    protected BigDecimal getMaxHPMultiplier() {
      return maxHPMultiplier;
    }

    @Override
    protected BigDecimal getAttackMultiplier() {
      return attackMultiplier;
    }
    
  }
  
  public static class Raphael extends AbstractFamiliar{
    private final static BigDecimal maxHPMultiplier = new BigDecimal("0.9");
    private final static BigDecimal attackMultiplier = new BigDecimal("1.4");

    public Raphael(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level, levelSkill1, levelSkill2, levelSkill3, levelSkill4);
    }
    
    public static Raphael max() {
      return new Raphael(200, 120, 20, 20, 20);
    }

    @Override
    protected void applyActive(Hero hero) {
      hero.increaseTrueDamage(new BigDecimal("0.01").multiply(new BigDecimal(levelSkill2)));
      hero.increaseDodgeChance(new BigDecimal("0.005").multiply(new BigDecimal(levelSkill3)));
      hero.increaseSpeed(2*levelSkill4);
    }
    
    @Override
    protected BigDecimal getMaxHPMultiplier() {
      return maxHPMultiplier;
    }

    @Override
    protected BigDecimal getAttackMultiplier() {
      return attackMultiplier;
    }
    
  }
}
