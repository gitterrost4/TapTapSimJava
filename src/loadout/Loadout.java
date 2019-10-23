package loadout;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import battle.logging.Log;
import battle.logging.LogItem;
import heroes.Hero;
import loadout.artifact.AbstractArtifact;
import loadout.artifact.ArtifactType;
import loadout.equipment.AbstractEquipment;
import loadout.equipment.Accessory;
import loadout.equipment.Armor;
import loadout.equipment.EquipmentRarity;
import loadout.equipment.Helmet;
import loadout.equipment.Weapon;
import loadout.runes.AbstractRune;
import loadout.runes.RuneRarity;
import loadout.runes.RuneType;

/**
 * Class describing a complete set of Equipment for a hero
 */
public class Loadout {
  private final Weapon weapon;
  private final Armor armor;
  private final Accessory accessory;
  private final Helmet helmet;
  private final AbstractRune rune;
  private final AbstractArtifact artifact;

  /**
   * create a loadout specifying each single part of the equipment
   * 
   * @param weapon
   * @param armor
   * @param accessory
   * @param helmet
   * @param runeRarity
   * @param runeType
   */
  public Loadout(EquipmentRarity weapon, EquipmentRarity armor, EquipmentRarity accessory, EquipmentRarity helmet,
      RuneRarity runeRarity, RuneType runeType, ArtifactType artifact) {
    super();
    this.weapon = new Weapon(weapon);
    this.armor = new Armor(armor);
    this.accessory = new Accessory(accessory);
    this.helmet = new Helmet(helmet);
    this.rune = runeType.create(runeRarity);
    this.artifact = artifact.create();
  }

  /**
   * create a loadout that has all equipment at the same rarity
   * 
   * @param equipmentRarity
   * @param runeRarity
   * @param runeType
   */
  public Loadout(EquipmentRarity equipmentRarity, RuneRarity runeRarity, RuneType runeType, ArtifactType artifact) {
    this(equipmentRarity, equipmentRarity, equipmentRarity, equipmentRarity, runeRarity, runeType, artifact);
  }

  /**
   * initialize a maximized loadout with a specific rune
   * 
   * @param runeType
   * @return
   */
  public static Loadout max(RuneType runeType, ArtifactType artifact) {
    return new Loadout(EquipmentRarity.ORANGE4, RuneRarity.RED2, runeType, artifact);
  }

  public static Loadout empty() {
    return new Loadout(EquipmentRarity.NONE, RuneRarity.NONE, RuneType.NONE, ArtifactType.NONE);
  }

  public void apply(Hero hero) {
    // apply the armor bonuses first
    weapon.apply(hero);
    armor.apply(hero);
    accessory.apply(hero);
    helmet.apply(hero);

    // apply the set bonuses
    Stream.of(weapon, armor, accessory, helmet).map(AbstractEquipment::getRarity)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .forEach((rarity, count) -> rarity.applyBonus(hero, count));
    ;

    // apply rune bonus
    rune.apply(hero);

    // apply artifact bonus
    artifact.apply(hero);
  }

  public LogItem getInformation() {
    Log log = new Log();
    log.addMessage("Weapon:" + weapon.getRarity().getName());
    log.addMessage("Armor:" + armor.getRarity().getName());
    log.addMessage("Helmet:" + helmet.getRarity().getName());
    log.addMessage("Accessory:" + accessory.getRarity().getName());
    log.addItem(rune.getInformation());
    log.addItem(artifact.getInformation());
    return log;
  }
}

// end of file
