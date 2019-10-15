package loadout;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import heroes.Hero;
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
  public Loadout(EquipmentRarity weapon, EquipmentRarity armor, EquipmentRarity accessory, EquipmentRarity helmet, RuneRarity runeRarity, RuneType runeType) {
    super();
    this.weapon=new Weapon(weapon);
    this.armor=new Armor(armor);
    this.accessory=new Accessory(accessory);
    this.helmet=new Helmet(helmet);
    this.rune=runeType.create(runeRarity);
  }
  
  /**
   * create a loadout that has all equipment at the same rarity
   * 
   * @param equipmentRarity
   * @param runeRarity
   * @param runeType
   */
  public Loadout(EquipmentRarity equipmentRarity, RuneRarity runeRarity, RuneType runeType) {
    this(equipmentRarity,equipmentRarity,equipmentRarity,equipmentRarity,runeRarity,runeType);
  }

  public void apply(Hero hero) {
    // apply the armor bonuses first
    weapon.apply(hero);
    armor.apply(hero);
    accessory.apply(hero);
    helmet.apply(hero);

    // apply the set bonuses
    Stream.of(weapon,armor,accessory,helmet).map(AbstractEquipment::getRarity)
      .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
      .forEach((rarity,count) -> rarity.applyBonus(hero,count));
    ;
    
    // apply rune bonus
    rune.apply(hero);
  }
}

// end of file
