import battle.Battle;
import battle.BattleSetting;
import battle.Team;
import battle.logging.LogItem;
import heroes.AbstractHero;
import heroes.HeroParameters;
import heroes.Reaper;
import heroes.Rlyeh;
import loadout.Loadout;
import loadout.artifact.ArtifactType;
import loadout.equipment.EquipmentRarity;
import loadout.runes.RuneRarity;
import loadout.runes.RuneType;
import player.Familiars;
import player.Familiars.Edison;
import player.Familiars.FamiliarType;
import player.Familiars.Raphael;
import player.Familiars.Vinci;
import player.GuildTech;
import player.GuildTech.AssassinTech;
import player.GuildTech.ClericTech;
import player.GuildTech.MageTech;
import player.GuildTech.WandererTech;
import player.GuildTech.WarriorTech;
import player.Player;

/**
 * Just a dummy main class for now
 *
 */
public class MainClass {

  public static void main(String[] args) {
    AbstractHero heroA1 = new Rlyeh(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.STARSHARDS)));
    AbstractHero heroA2 = new Rlyeh(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroA3 = new Rlyeh(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroA4 = new Rlyeh(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.RED2, RuneType.SPEED, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroA5 = new Rlyeh(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroA6 = new Rlyeh(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Player playerA = new Player(new GuildTech(new WarriorTech(80, 60, 59, 50, 40), new AssassinTech(42, 24, 10, 11, 3),
        new WandererTech(80, 60, 60, 50, 35), new ClericTech(81, 60, 60, 50, 40), new MageTech(100, 60, 60, 50, 40)),
        new Familiars(new Edison(152, 23, 1, 1, 0), new Vinci(120, 3, 1, 1, 0), new Raphael(200, 118, 20, 20, 20),
            FamiliarType.RAPHAEL));
    Team attacker = new Team(heroA1, heroA2, heroA3, heroA4, heroA5, heroA6, playerA);
    AbstractHero heroD1 = new Reaper(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.STARSHARDS)));
    AbstractHero heroD2 = new Reaper(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroD3 = new Reaper(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroD4 = new Reaper(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroD5 = new Reaper(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.RED2, RuneType.SPEED, ArtifactType.EYEOFHEAVEN)));
    AbstractHero heroD6 = new Reaper(new HeroParameters(250, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Player playerD = new Player(new GuildTech(new WarriorTech(80, 60, 59, 50, 40), new AssassinTech(42, 24, 10, 11, 3),
        new WandererTech(80, 60, 60, 50, 35), new ClericTech(81, 60, 60, 50, 40), new MageTech(100, 60, 60, 50, 40)),
        new Familiars(new Edison(152, 23, 1, 1, 0), new Vinci(120, 3, 1, 1, 0), new Raphael(200, 118, 20, 20, 20),
            FamiliarType.RAPHAEL));
    Team defender = new Team(heroD1, heroD2, heroD3, heroD4, heroD5, heroD6, playerD);
    BattleSetting setting = new BattleSetting(attacker, defender);
    Battle battle = new Battle(setting);
    LogItem log = battle.doBattle();
    System.err.println(log.prettyPrint());

  }

}

// end of file
