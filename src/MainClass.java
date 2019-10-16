import java.math.BigDecimal;

import battle.Team;
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
 * TODO documentation
 *
 * @author (C) cantamen/Paul Kramer 2019
 * @version $Id $
 */
public class MainClass {

  public static void main(String[] args) {
    Reaper reaper = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.STARSHARDS)));
    Reaper reaper2 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Reaper reaper3 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Reaper reaper4 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Reaper reaper5 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Reaper reaper6 = new Reaper(new HeroParameters(244, 10,
        new Loadout(EquipmentRarity.ORANGE2, RuneRarity.ORANGE2, RuneType.VITALITY, ArtifactType.EYEOFHEAVEN)));
    Player player = new Player(
        new GuildTech(
            new WarriorTech(80, 60, 59, 50, 40), 
            new AssassinTech(42, 24, 10, 11, 3),
            new WandererTech(80, 60, 60, 50, 35), 
            new ClericTech(81, 60, 60, 50, 40),
            new MageTech(100, 60, 60, 50, 40)),
        new Familiars(
            new Edison(152, 23, 1, 1, 0), 
            new Vinci(120, 3, 1, 1, 0), 
            new Raphael(200, 118, 20, 20, 20),
            FamiliarType.RAPHAEL));
    new Team(reaper, reaper2, reaper3, reaper4, reaper5, reaper6,
        player);
    reaper.addMaxHPModifier(new BigDecimal("0.3"));
    reaper.addAttackModifier(new BigDecimal("0.3"));
    System.err.println(reaper.toString());

  }

}

// end of file
