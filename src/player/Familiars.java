package player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import battle.BattleSetting;
import battle.logging.Log;
import battle.logging.LogItem;
import battle.logging.LogMessage;
import heroes.Hero;
import util.Tuple;

/**
 * class representing the three familiars that a player has
 */
public class Familiars {
  /** the edison familiar */
  private final Edison edison;
  /** the vinci familiar */
  private final Vinci vinci;
  /** the raphael familiar */
  private final Raphael raphael;
  /** reference to the familiar that's active in the team */
  private final AbstractFamiliar activeFamiliar;

  /**
   * create the familiar container by providing the three familiars and which of
   * them
   * is active
   * 
   * @param edison
   *          the edison familiar
   * @param vinci
   *          the vinci familiar
   * @param raphael
   *          the raphael familiar
   * @param activeFamiliar
   *          which of the familiars is the active one
   */
  public Familiars(Edison edison, Vinci vinci, Raphael raphael, FamiliarType activeFamiliar) {
    super();
    this.edison=edison;
    this.vinci=vinci;
    this.raphael=raphael;
    switch (activeFamiliar) {
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

  /**
   * apply the passive bonuses of all heroes and the passive skill bonuses of
   * the
   * active familiar to a hero
   * 
   * @param hero
   *          hero the bonuses will be applied to
   */
  public void apply(Hero hero) {
    Stream.of(vinci,edison,raphael).forEach(familiar -> familiar.applyPassiveBonus(hero));
    activeFamiliar.applyPassiveSkills(hero);
  }

  /**
   * enum with a value for each familiar
   */
  public enum FamiliarType {
    /** Vinci */
    VINCI("Vinci"),
    /** Edison */
    EDISON("Edison"),
    /** Raphael */
    RAPHAEL("Raphael");
    
    private final String name;

    private FamiliarType(String name) {
      this.name=name;
    }

    public String getName() {
      return name;
    }
    
  }

  /**
   * create a set of maxed familiars by providing which of them should be active
   * 
   * @param activeFamiliar
   *          which familiar will be the active one
   * @return a maxed set of familiars
   */
  public static Familiars max(FamiliarType activeFamiliar) {
    return new Familiars(Edison.max(),Vinci.max(),Raphael.max(),activeFamiliar);
  }

  /**
   * @return the active familiar
   */
  public AbstractFamiliar getActiveFamiliar() {
    return activeFamiliar;
  }

  /**
   * the base class for the familiars
   */
  public static abstract class AbstractFamiliar {
    /**
     * a map specifying the maxHP bonus that's added to the base value for each
     * familiar's level
     */
    private final static Map<Integer,Integer> maxHPIncreasePerLevel=new HashMap<>();
    /**
     * a map specifying the attack bonus that's added to the base value for each
     * familiar's level
     */
    private final static Map<Integer,Integer> attackIncreasePerLevel=new HashMap<>();
    
    /**
     * a map specifying the number of targets (_0) and the damage done (_1) by the active pet skill for each skill level
     */
    private final static Map<Integer,Tuple<Integer,Integer>> skillDamageAndTargetPerSkillLevel = new HashMap<>();

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
      
      skillDamageAndTargetPerSkillLevel.put(1,new Tuple<>(2,250));
      skillDamageAndTargetPerSkillLevel.put(2,new Tuple<>(2,325));
      skillDamageAndTargetPerSkillLevel.put(3,new Tuple<>(2,400));
      skillDamageAndTargetPerSkillLevel.put(4,new Tuple<>(2,475));
      skillDamageAndTargetPerSkillLevel.put(5,new Tuple<>(2,550));
      skillDamageAndTargetPerSkillLevel.put(6,new Tuple<>(2,625));
      skillDamageAndTargetPerSkillLevel.put(7,new Tuple<>(2,700));
      skillDamageAndTargetPerSkillLevel.put(8,new Tuple<>(2,775));
      skillDamageAndTargetPerSkillLevel.put(9,new Tuple<>(2,850));
      skillDamageAndTargetPerSkillLevel.put(10,new Tuple<>(2,925));
      skillDamageAndTargetPerSkillLevel.put(11,new Tuple<>(2,1025));
      skillDamageAndTargetPerSkillLevel.put(12,new Tuple<>(2,1125));
      skillDamageAndTargetPerSkillLevel.put(13,new Tuple<>(2,1225));
      skillDamageAndTargetPerSkillLevel.put(14,new Tuple<>(2,1325));
      skillDamageAndTargetPerSkillLevel.put(15,new Tuple<>(2,1425));
      skillDamageAndTargetPerSkillLevel.put(16,new Tuple<>(2,1525));
      skillDamageAndTargetPerSkillLevel.put(17,new Tuple<>(2,1625));
      skillDamageAndTargetPerSkillLevel.put(18,new Tuple<>(2,1725));
      skillDamageAndTargetPerSkillLevel.put(19,new Tuple<>(2,1825));
      skillDamageAndTargetPerSkillLevel.put(20,new Tuple<>(2,1925));
      skillDamageAndTargetPerSkillLevel.put(21,new Tuple<>(2,2050));
      skillDamageAndTargetPerSkillLevel.put(22,new Tuple<>(2,2175));
      skillDamageAndTargetPerSkillLevel.put(23,new Tuple<>(2,2300));
      skillDamageAndTargetPerSkillLevel.put(24,new Tuple<>(2,2425));
      skillDamageAndTargetPerSkillLevel.put(25,new Tuple<>(2,2550));
      skillDamageAndTargetPerSkillLevel.put(26,new Tuple<>(2,2675));
      skillDamageAndTargetPerSkillLevel.put(27,new Tuple<>(2,2800));
      skillDamageAndTargetPerSkillLevel.put(28,new Tuple<>(2,2925));
      skillDamageAndTargetPerSkillLevel.put(29,new Tuple<>(2,3050));
      skillDamageAndTargetPerSkillLevel.put(30,new Tuple<>(2,3175));
      skillDamageAndTargetPerSkillLevel.put(31,new Tuple<>(3,3375));
      skillDamageAndTargetPerSkillLevel.put(32,new Tuple<>(3,3575));
      skillDamageAndTargetPerSkillLevel.put(33,new Tuple<>(3,3775));
      skillDamageAndTargetPerSkillLevel.put(34,new Tuple<>(3,3975));
      skillDamageAndTargetPerSkillLevel.put(35,new Tuple<>(3,4175));
      skillDamageAndTargetPerSkillLevel.put(36,new Tuple<>(3,4375));
      skillDamageAndTargetPerSkillLevel.put(37,new Tuple<>(3,4575));
      skillDamageAndTargetPerSkillLevel.put(38,new Tuple<>(3,4775));
      skillDamageAndTargetPerSkillLevel.put(39,new Tuple<>(3,4975));
      skillDamageAndTargetPerSkillLevel.put(40,new Tuple<>(3,5175));
      skillDamageAndTargetPerSkillLevel.put(41,new Tuple<>(3,5425));
      skillDamageAndTargetPerSkillLevel.put(42,new Tuple<>(3,5675));
      skillDamageAndTargetPerSkillLevel.put(43,new Tuple<>(3,5925));
      skillDamageAndTargetPerSkillLevel.put(44,new Tuple<>(3,6175));
      skillDamageAndTargetPerSkillLevel.put(45,new Tuple<>(3,6425));
      skillDamageAndTargetPerSkillLevel.put(46,new Tuple<>(3,6675));
      skillDamageAndTargetPerSkillLevel.put(47,new Tuple<>(3,6925));
      skillDamageAndTargetPerSkillLevel.put(48,new Tuple<>(3,7175));
      skillDamageAndTargetPerSkillLevel.put(49,new Tuple<>(3,7425));
      skillDamageAndTargetPerSkillLevel.put(50,new Tuple<>(3,7675));
      skillDamageAndTargetPerSkillLevel.put(51,new Tuple<>(3,7975));
      skillDamageAndTargetPerSkillLevel.put(52,new Tuple<>(3,8275));
      skillDamageAndTargetPerSkillLevel.put(53,new Tuple<>(3,8575));
      skillDamageAndTargetPerSkillLevel.put(54,new Tuple<>(3,8875));
      skillDamageAndTargetPerSkillLevel.put(55,new Tuple<>(3,9175));
      skillDamageAndTargetPerSkillLevel.put(56,new Tuple<>(3,9475));
      skillDamageAndTargetPerSkillLevel.put(57,new Tuple<>(3,9775));
      skillDamageAndTargetPerSkillLevel.put(58,new Tuple<>(3,10075));
      skillDamageAndTargetPerSkillLevel.put(59,new Tuple<>(3,10375));
      skillDamageAndTargetPerSkillLevel.put(60,new Tuple<>(3,10675));
      skillDamageAndTargetPerSkillLevel.put(61,new Tuple<>(4,11075));
      skillDamageAndTargetPerSkillLevel.put(62,new Tuple<>(4,11475));
      skillDamageAndTargetPerSkillLevel.put(63,new Tuple<>(4,11875));
      skillDamageAndTargetPerSkillLevel.put(64,new Tuple<>(4,12275));
      skillDamageAndTargetPerSkillLevel.put(65,new Tuple<>(4,12675));
      skillDamageAndTargetPerSkillLevel.put(66,new Tuple<>(4,13075));
      skillDamageAndTargetPerSkillLevel.put(67,new Tuple<>(4,13475));
      skillDamageAndTargetPerSkillLevel.put(68,new Tuple<>(4,13875));
      skillDamageAndTargetPerSkillLevel.put(69,new Tuple<>(4,14275));
      skillDamageAndTargetPerSkillLevel.put(70,new Tuple<>(4,14675));
      skillDamageAndTargetPerSkillLevel.put(71,new Tuple<>(4,15175));
      skillDamageAndTargetPerSkillLevel.put(72,new Tuple<>(4,15675));
      skillDamageAndTargetPerSkillLevel.put(73,new Tuple<>(4,16175));
      skillDamageAndTargetPerSkillLevel.put(74,new Tuple<>(4,16675));
      skillDamageAndTargetPerSkillLevel.put(75,new Tuple<>(4,17175));
      skillDamageAndTargetPerSkillLevel.put(76,new Tuple<>(4,17675));
      skillDamageAndTargetPerSkillLevel.put(77,new Tuple<>(4,18175));
      skillDamageAndTargetPerSkillLevel.put(78,new Tuple<>(4,18675));
      skillDamageAndTargetPerSkillLevel.put(79,new Tuple<>(4,19175));
      skillDamageAndTargetPerSkillLevel.put(80,new Tuple<>(4,19675));
      skillDamageAndTargetPerSkillLevel.put(81,new Tuple<>(4,20275));
      skillDamageAndTargetPerSkillLevel.put(82,new Tuple<>(4,20875));
      skillDamageAndTargetPerSkillLevel.put(83,new Tuple<>(4,21475));
      skillDamageAndTargetPerSkillLevel.put(84,new Tuple<>(4,22075));
      skillDamageAndTargetPerSkillLevel.put(85,new Tuple<>(4,22675));
      skillDamageAndTargetPerSkillLevel.put(86,new Tuple<>(4,23275));
      skillDamageAndTargetPerSkillLevel.put(87,new Tuple<>(4,23875));
      skillDamageAndTargetPerSkillLevel.put(88,new Tuple<>(4,24475));
      skillDamageAndTargetPerSkillLevel.put(89,new Tuple<>(4,25075));
      skillDamageAndTargetPerSkillLevel.put(90,new Tuple<>(4,25675));
      skillDamageAndTargetPerSkillLevel.put(91,new Tuple<>(4,26425));
      skillDamageAndTargetPerSkillLevel.put(92,new Tuple<>(4,27175));
      skillDamageAndTargetPerSkillLevel.put(93,new Tuple<>(4,27925));
      skillDamageAndTargetPerSkillLevel.put(94,new Tuple<>(4,28675));
      skillDamageAndTargetPerSkillLevel.put(95,new Tuple<>(4,29425));
      skillDamageAndTargetPerSkillLevel.put(96,new Tuple<>(4,30175));
      skillDamageAndTargetPerSkillLevel.put(97,new Tuple<>(4,30925));
      skillDamageAndTargetPerSkillLevel.put(98,new Tuple<>(4,31675));
      skillDamageAndTargetPerSkillLevel.put(99,new Tuple<>(4,32425));
      skillDamageAndTargetPerSkillLevel.put(100,new Tuple<>(4,33175));
      skillDamageAndTargetPerSkillLevel.put(101,new Tuple<>(4,34075));
      skillDamageAndTargetPerSkillLevel.put(102,new Tuple<>(4,34975));
      skillDamageAndTargetPerSkillLevel.put(103,new Tuple<>(4,35875));
      skillDamageAndTargetPerSkillLevel.put(104,new Tuple<>(4,36775));
      skillDamageAndTargetPerSkillLevel.put(105,new Tuple<>(4,37675));
      skillDamageAndTargetPerSkillLevel.put(106,new Tuple<>(4,38575));
      skillDamageAndTargetPerSkillLevel.put(107,new Tuple<>(4,39475));
      skillDamageAndTargetPerSkillLevel.put(108,new Tuple<>(4,40375));
      skillDamageAndTargetPerSkillLevel.put(109,new Tuple<>(4,41275));
      skillDamageAndTargetPerSkillLevel.put(110,new Tuple<>(4,42175));
      skillDamageAndTargetPerSkillLevel.put(111,new Tuple<>(4,43225));
      skillDamageAndTargetPerSkillLevel.put(112,new Tuple<>(4,44275));
      skillDamageAndTargetPerSkillLevel.put(113,new Tuple<>(4,45325));
      skillDamageAndTargetPerSkillLevel.put(114,new Tuple<>(4,46375));
      skillDamageAndTargetPerSkillLevel.put(115,new Tuple<>(4,47425));
      skillDamageAndTargetPerSkillLevel.put(116,new Tuple<>(4,48475));
      skillDamageAndTargetPerSkillLevel.put(117,new Tuple<>(4,49525));
      skillDamageAndTargetPerSkillLevel.put(118,new Tuple<>(4,50575));
      skillDamageAndTargetPerSkillLevel.put(119,new Tuple<>(4,51625));
      skillDamageAndTargetPerSkillLevel.put(120,new Tuple<>(4,52675));
    }
    /** the level of the familiar */
    protected final Integer level;
    /** the level of the first skill of the familiar */
    protected final Integer levelSkill1;
    /** the level of the second skill of the familiar */
    protected final Integer levelSkill2;
    /** the level of the third skill of the familiar */
    protected final Integer levelSkill3;
    /** the level of the fourth skill of the familiar */
    protected final Integer levelSkill4;
    
    protected Optional<Boolean> isAttacker = Optional.empty();
    
    private final FamiliarType name;

    /**
     * base constructor setting all the levels
     * 
     * @param level
     *          level of the familiar
     * @param levelSkill1
     *          level of the first skill of the familiar
     * @param levelSkill2
     *          level of the second skill of the familiar
     * @param levelSkill3
     *          level of the third skill of the familiar
     * @param levelSkill4
     *          level of the fourth skill of the familiar
     */
    private AbstractFamiliar(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3,
      Integer levelSkill4, FamiliarType name) {
      super();
      this.level=level;
      this.levelSkill1=levelSkill1;
      this.levelSkill2=levelSkill2;
      this.levelSkill3=levelSkill3;
      this.levelSkill4=levelSkill4;
      this.name = name;
    }

    /**
     * apply the passive hp and attack bonuses that just come from the level of
     * the
     * familiar
     * 
     * @param hero
     *          the hero that the bonuses will be applied to
     */
    protected void applyPassiveBonus(Hero hero) {
      hero.increaseMaxHP(getHPBonus());
      hero.increaseAttack(getAttackBonus());
    }

    /**
     * apply the passive skills of the familiar to a hero
     * 
     * @param hero
     *          the hero that the skill bonuses will be applied to
     */
    protected abstract void applyPassiveSkills(Hero hero);

    /**
     * @return the maxHP multiplier for the Familiar (fixed for each familiar)
     */
    protected abstract double getMaxHPMultiplier();

    /**
     * @return the attack multiplier for the Familiar (fixed for each familiar)
     */
    protected abstract double getAttackMultiplier();

    /**
     * @return the maxHP bonus this familiar gives the hero in the end
     */
    protected Integer getHPBonus() {
      return new Double(getMaxHPMultiplier() * (getTierHPBonus() + getLevelHPBonus())).intValue();
    }

    /**
     * @return the hp bonus based on the tier. I assume that a familiar is
     *         instantly
     *         tiered up. The simulator can't handle a familiar at level 80
     *         that's not
     *         tiered up for example
     */
    private Integer getTierHPBonus() {
      if (level < 80) {
        return 0;
      }
      if (level < 120) {
        return 155;
      }
      if (level < 160) {
        return 550;
      }
      return 1600;
    }

    /**
     * @return the hp bonus provided by just the level of the familiar
     */
    private Integer getLevelHPBonus() {
      return maxHPIncreasePerLevel.get(level);
    }

    /**
     * @return the attack bonus this familiar gives the hero in the end
     */
    protected Integer getAttackBonus() {
      return new Double(getAttackMultiplier() * (getTierAttackBonus() + getLevelAttackBonus())).intValue();
    }

    /**
     * @return the attack bonus provided by the tier of the familiar
     */
    private Integer getTierAttackBonus() {
      if (level < 80) {
        return 0;
      }
      if (level < 120) {
        return 8;
      }
      if (level < 160) {
        return 28;
      }
      return 81;
    }

    /**
     * @return the attack bonus provided by just the level of the familiar
     */
    private Integer getLevelAttackBonus() {
      return attackIncreasePerLevel.get(level);
    }

    /**
     * Do a skill attack
     * 
     * @param setting
     *          the complete battle setting
     * @return a log item containing logs of this operation
     */
    public LogItem activeAttack(BattleSetting setting) {
      Log log=new Log();
      Integer targetCount=skillDamageAndTargetPerSkillLevel.get(level)._0;
      Integer damage=skillDamageAndTargetPerSkillLevel.get(level)._1;
      List<Hero> attackedHeroes = setting.getOpposingTeam(this).getRandomHeroes(targetCount);
      log.addItem(logMessage("Attacking "+targetCount+" enemies for "+damage+" damage each."));
      attackedHeroes.stream().map(h->h.damage(damage)).forEach(log::addItem);
      return log;
    }

    public LogMessage logMessage(String message) {
      return new LogMessage(isAttacker.map(iA->iA?"A":"D").orElse("U")+":"+name.getName() + ": " + message);
    }
    
    public void setAttacker() {
      this.isAttacker = Optional.of(true);
    }

    public void setDefender() {
      this.isAttacker = Optional.of(false);
    }

  }

  /**
   * implementation of the vinci pet
   */
  public static class Vinci extends AbstractFamiliar {
    /**
     * the (fixed) maxHP multiplier for vinci
     */
    private final static double maxHPMultiplier=1.0;

    /**
     * the (fixed) attack multiplier for vinci
     */
    private final static double attackMultiplier=1.0;

    /**
     * create a vinci by providing its levels
     * 
     * @param level
     *          level of vinci
     * @param levelSkill1
     *          level of the first skill of vinci
     * @param levelSkill2
     *          level of the second skill of vinci
     * @param levelSkill3
     *          level of the third skill of vinci
     * @param levelSkill4
     *          level of the fourth skill of vinci
     */
    public Vinci(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level,levelSkill1,levelSkill2,levelSkill3,levelSkill4,FamiliarType.VINCI);
    }

    /**
     * create a maxed out vinci
     * 
     * @return a maxed vinci
     */
    public static Vinci max() {
      return new Vinci(200,120,20,20,20);
    }

    @Override
    protected void applyPassiveSkills(Hero hero) {
      hero.increaseSkillDamage(0.01 * levelSkill2);
      hero.increaseHitRate(0.005 * levelSkill3);
      hero.increaseSpeed(2 * levelSkill4);
    }

    @Override
    protected double getMaxHPMultiplier() {
      return maxHPMultiplier;
    }

    @Override
    protected double getAttackMultiplier() {
      return attackMultiplier;
    }

  }

  /**
   * implementation of the edison pet
   */
  public static class Edison extends AbstractFamiliar {
    /**
     * the (fixed) maxHP multiplier for edison
     */
    private final static double maxHPMultiplier=1.1;

    /**
     * the (fixed) attack multiplier for edison
     */
    private final static double attackMultiplier=0.6;

    /**
     * create a edison by providing its levels
     * 
     * @param level
     *          level of edison
     * @param levelSkill1
     *          level of the first skill of edison
     * @param levelSkill2
     *          level of the second skill of edison
     * @param levelSkill3
     *          level of the third skill of edison
     * @param levelSkill4
     *          level of the fourth skill of edison
     */
    public Edison(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level,levelSkill1,levelSkill2,levelSkill3,levelSkill4,FamiliarType.EDISON);
    }

    /**
     * create a maxed out edison
     * 
     * @return a maxed edison
     */
    public static Edison max() {
      return new Edison(200,120,20,20,20);
    }

    @Override
    protected void applyPassiveSkills(Hero hero) {
      hero.increaseCritRate(0.005 * levelSkill2);
      hero.increaseCritDamage(0.01 * levelSkill3);
      hero.increaseSpeed(2 * levelSkill4);
    }

    @Override
    protected double getMaxHPMultiplier() {
      return maxHPMultiplier;
    }

    @Override
    protected double getAttackMultiplier() {
      return attackMultiplier;
    }

  }

  /**
   * implementation of the raphael pet
   */
  public static class Raphael extends AbstractFamiliar {
    /**
     * the (fixed) maxHP multiplier for raphael
     */
    private final static double maxHPMultiplier=0.9;
    /**
     * the (fixed) attack multiplier for raphael
     */
    private final static double attackMultiplier=1.4;

    /**
     * create a raphael by providing its levels
     * 
     * @param level
     *          level of raphael
     * @param levelSkill1
     *          level of the first skill of raphael
     * @param levelSkill2
     *          level of the second skill of raphael
     * @param levelSkill3
     *          level of the third skill of raphael
     * @param levelSkill4
     *          level of the fourth skill of raphael
     */
    public Raphael(Integer level, Integer levelSkill1, Integer levelSkill2, Integer levelSkill3, Integer levelSkill4) {
      super(level,levelSkill1,levelSkill2,levelSkill3,levelSkill4,FamiliarType.RAPHAEL);
    }

    /**
     * create a maxed out raphael
     * 
     * @return a maxed raphael
     */
    public static Raphael max() {
      return new Raphael(200,120,20,20,20);
    }

    @Override
    protected void applyPassiveSkills(Hero hero) {
      hero.increaseTrueDamage(0.01 * levelSkill2);
      hero.increaseDodgeChance(0.005 * levelSkill3);
      hero.increaseSpeed(2 * levelSkill4);
    }

    @Override
    protected double getMaxHPMultiplier() {
      return maxHPMultiplier;
    }

    @Override
    protected double getAttackMultiplier() {
      return attackMultiplier;
    }

  }
}
