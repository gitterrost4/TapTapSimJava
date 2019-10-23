import battle.Battle;
import battle.BattleSetting;
import battle.Team;
import battle.logging.LogItem;
import heroes.AbstractHero;
import heroes.HeroParameters;
import heroes.Reaper;
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

// $Id $
// (C) cantamen/Paul Kramer 2019

/**
 * Just a dummy main class for now
 *
 * @author (C) cantamen/Paul Kramer 2019
 * @version $Id $
 */
public class MainClass {

  public static void main(String[] args) {
    AbstractHero reaper = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.STARSHARDS)));
    AbstractHero reaper2 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper3 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper4 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.RED2, RuneType.SPEED, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper5 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper6 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Player player = new Player(new GuildTech(new WarriorTech(80, 60, 59, 50, 40), new AssassinTech(42, 24, 10, 11, 3),
        new WandererTech(80, 60, 60, 50, 35), new ClericTech(81, 60, 60, 50, 40), new MageTech(100, 60, 60, 50, 40)),
        new Familiars(new Edison(152, 23, 1, 1, 0), new Vinci(120, 3, 1, 1, 0), new Raphael(200, 118, 20, 20, 20),
            FamiliarType.RAPHAEL));
    Team attacker = new Team(reaper, reaper2, reaper3, reaper4, reaper5, reaper6, player);
    AbstractHero reaper7 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.STARSHARDS)));
    AbstractHero reaper8 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper9 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper10 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper11 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.RED2, RuneType.SPEED, ArtifactType.EYEOFHEAVEN)));
    AbstractHero reaper12 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Player player2 = new Player(new GuildTech(new WarriorTech(80, 60, 59, 50, 40), new AssassinTech(42, 24, 10, 11, 3),
        new WandererTech(80, 60, 60, 50, 35), new ClericTech(81, 60, 60, 50, 40), new MageTech(100, 60, 60, 50, 40)),
        new Familiars(new Edison(152, 23, 1, 1, 0), new Vinci(120, 3, 1, 1, 0), new Raphael(200, 118, 20, 20, 20),
            FamiliarType.RAPHAEL));
    Team defender = new Team(reaper7, reaper8, reaper9, reaper10, reaper11, reaper12, player2);
    BattleSetting setting = new BattleSetting(attacker, defender);
    Battle battle = new Battle(setting);
    LogItem log = battle.doBattle();
    System.err.println(log.prettyPrint());

  }

}

// end of file
