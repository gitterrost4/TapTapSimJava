package loadout;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import heroes.Hero;
import loadout.equipment.AbstractEquipment;
import loadout.equipment.Accessory;
import loadout.equipment.Armor;
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

  public Loadout(Weapon weapon, Armor armor, Accessory accessory, Helmet helmet, RuneRarity runeRarity, RuneType runeType) {
    super();
    this.weapon=weapon;
    this.armor=armor;
    this.accessory=accessory;
    this.helmet=helmet;
    this.rune=runeType.create(runeRarity);
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
