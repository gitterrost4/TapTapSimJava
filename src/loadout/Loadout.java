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
  /** the equipped weapon */
  private final Weapon weapon;
  /** the equipped armor (chest) */
  private final Armor armor;
  /** the equipped accessory (ring or amulet) */
  private final Accessory accessory;
  /** the equipped helmet */
  private final Helmet helmet;
  /** the equipped rune */
  private final AbstractRune rune;
  /** the equipped artifact */
  private final AbstractArtifact artifact;

  /**
   * create a loadout specifying each single part of the equipment
   * 
   * @param weapon
   *        the rarity of the equipped weapon
   * @param armor
   *        the rarity of the equipped armor
   * @param accessory
   *        the rarity of the equipped accessory
   * @param helmet
   *        the rarity of the equipped helmet
   * @param runeRarity
   *        the rarity of the equipped rune
   * @param runeType
   *        the type of the equipped rune
   * @param artifact
   *        the type (name) of the equipped artifact
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
   *        the rarity that all the equipment slots should receive
   * @param runeRarity
   *        the rarity of the equipped rune
   * @param runeType
   *        the type of the equipped rune
   * @param artifact
   *        the type (name) of the equipped artifact
   */
  public Loadout(EquipmentRarity equipmentRarity, RuneRarity runeRarity, RuneType runeType, ArtifactType artifact) {
    this(equipmentRarity, equipmentRarity, equipmentRarity, equipmentRarity, runeRarity, runeType, artifact);
  }

  /**
   * initialize a maximized loadout with a specific rune and artifact
   * 
   * @param runeType
   *        the rune the loadout should contain
   * @param artifact
   *        the artifact the loadout should contain
   * @return the desired maximized loadout
   */
  public static Loadout max(RuneType runeType, ArtifactType artifact) {
    return new Loadout(EquipmentRarity.ORANGE4, RuneRarity.RED2, runeType, artifact);
  }

  /**
   * @return an empty loadout with nothing equipped
   */
  public static Loadout empty() {
    return new Loadout(EquipmentRarity.NONE, RuneRarity.NONE, RuneType.NONE, ArtifactType.NONE);
  }

  /**
   * apply the bonuses of the complete loadout to a hero
   * 
   * @param hero
   *        the hero to apply the bonuses to
   */
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

  /**
   * @return a log item containing textual information about the loadout
   */
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
