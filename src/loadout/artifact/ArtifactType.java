package loadout.artifact;

import java.util.function.Supplier;

/**
 * Enum containing all possible artifacts in the game
 */
public enum ArtifactType {
  /** None */
  NONE("None", () -> new EmptyArtifact()),
  /** Demon Whisperer */
  DEMONWHISPERER("Demon Whisperer", () -> new DemonWhisperer()),
  /** Ragnarok */
  RAGNAROK("Ragnarok", () -> new Ragnarok()),
  /** Starshards */
  STARSHARDS("Starshards", () -> new Starshards()),
  /** Cursed Oculus */
  CURSEDOCULUS("Cursed Oculus", () -> new CursedOculus()),
  /** Spellbreaker */
  SPELLBREAKER("Spellbreaker", () -> new Spellbreaker()),
  /** Chaos Spear */
  CHAOSSPEAR("Chaos Spear", () -> new ChaosSpear()),
  /** Scythe of Frost */
  SCYTHEOFFROST("Scythe of Frost", () -> new ScytheOfFrost()),
  /** Rage of the Titans */
  RAGEOFTHETITANS("Rage of the Titans", () -> new RageOfTheTitans()),
  /** Tears of the Goddess */
  TEARSOFTHEGODDESS("Tears of the Goddess", () -> new TearsOfTheGoddess()),
  /** Giant Lizard */
  GIANTLIZARD("Giant Lizard", () -> new GiantLizard()),
  /** Bone Grip */
  BONEGRIP("Bone Grip", () -> new BoneGrip()),
  /** Light Pace */
  LIGHTPACE("Light Pace", () -> new LightPace()),
  /** Dragonblood */
  DRAGONBLOOD("Dragonblood", () -> new Dragonblood()),
  /** Scorching Sun */
  SCORCHINGSUN("Scorching Sun", () -> new ScorchingSun()),
  /** Windwalker */
  WINDWALKER("Windwalker", () -> new WindWalker()),
  /** Eye of Heaven */
  EYEOFHEAVEN("Eye of Heaven", () -> new EyeOfHeaven()),
  /** Burning Soul */
  BURNINGSOUL("Burning Soul", () -> new BurningSoul()),
  /** Sun's Hymn */
  SUNSHYMN("Sun's Hymn", () -> new SunsHymn()),
  /** Dark Destroyer */
  DARKDESTROYER("Dark Destroyer", () -> new DarkDestroyer()),
  /** Yaksha */
  YAKSHA("Yaksha", () -> new Yaksha()),
  /** Satan's Power */
  SATANSPOWER("Satan's Power", () -> new SatansPower()),
  /** Gospel Song */
  GOSPELSONG("Gospel Song", () -> new GospelSong()),
  /** Ancient Vows */
  ANCIENTVOWS("Ancient Vows", () -> new AncientVows()),
  /** Knight's Vow */
  KNIGHTSVOW("Knight's Vow", () -> new KnightsVow()),
  /** Blood Medal */
  BLOODMEDAL("Blood Medal", () -> new BloodMedal()),
  /** Gun of the Disaster */
  GUNOFTHEDISASTER("Gun of the Disaster", () -> new GunOfTheDisaster()),
  /** Primeval Soul */
  PRIMEVALSOUL("Primeval Soul", () -> new PrimevalSoul()),
  /** Starpray */
  STARPRAY("Starpray", () -> new StarPray()),
  /** Snow Dance */
  SNOWDANCE("Snow Dance", () -> new SnowDance()),
  /** Queen's Crown */
  QUEENSCROWN("Queen's Crown", () -> new QueensCrown()),
  /** Siren Heart */
  SIRENHEART("Siren Heart", () -> new SirenHeart()),
  /** Cursed Gun */
  CURSEDGUN("Cursed Gun", () -> new CursedGun()),
  /** Soul Torrent */
  SOULTORRENT("Soul Torrent", () -> new SoulTorrent()),
  /** Holy Light Justice */
  HOLYLIGHTJUSTICE("Holy Light Justice", () -> new HolyLightJustice()),
  /** Gift of Creation */
  GIFTOFCREATION("Gift of Creation", () -> new GiftOfCreation()),
  /** Hell Disaster */
  HELLDISASTER("Hell Disaster", () -> new HellDisaster()),
  /** Eternal Curse */
  ETERNALCURSE("Eternal Curse", () -> new EternalCurse()),
  /** Pegasus Boots */
  PEGASUSBOOTS("Pegasus Boots", () -> new PegasusBoots()),
  /** Goddess' Bow */
  GODDESSBOW("Goddess' Bow", () -> new GoddessBow()),
  /** Mirage */
  MIRAGE("Mirage", () -> new Mirage()),
  /** Carol of Life */
  CAROLOFLIFE("Carol of Life", () -> new CarolOfLife()),
  /** Radiance */
  RADIANCE("Radiance", () -> new Radiance()),
  /** Soul's Whisper */
  SOULSWHISPER("Soul's Whisper", () -> new SoulsWhisper()),
  /** Broken One */
  BROKENONE("Broken One", () -> new BrokenOne()),
  /** Healing Tear */
  HEALINGTEAR("Healing Tear", () -> new HealingTear()),
  /** Forest Psalm */
  FORESTPSALM("Forest Psalm", () -> new ForestPsalm()),
  /** Crystal Sword */
  CRYSTALSWORD("Crystal Sword", () -> new CrystalSword()),
  /** Shadow */
  SHADOW("Shadow", () -> new Shadow()),
  /** Plunderer */
  PLUNDERER("Plunderer", () -> new Plunderer()),
  /** Mage Nemesis */
  MAGENEMESIS("Mage Nemesis", () -> new MageNemesis()),
  /** Cleric Nemesis */
  CLERICNEMESIS("Cleric Nemesis", () -> new ClericNemesis()),
  /** Wanderer Nemesis */
  WANDERERNEMESIS("Wanderer Nemesis", () -> new WandererNemesis()),
  /** Assassin Nemesis */
  ASSASSINNEMESIS("Assassin Nemesis", () -> new AssassinNemesis()),
  /** Warrior Nemesis */
  WARRIORNEMESIS("Warrior Nemesis", () -> new WarriorNemesis()),
  /** Mage Predator */
  MAGEPREDATOR("Mage Predator", () -> new MagePredator()),
  /** Cleric Predator */
  CLERICPREDATOR("Cleric Predator", () -> new ClericPredator()),
  /** Wanderer Predator */
  WANDERERPREDATOR("Wanderer Predator", () -> new WandererPredator()),
  /** Assassin Predator */
  ASSASSINPREDATOR("Assassin Predator", () -> new AssassinPredator()),
  /** Warrior Predator */
  WARRIORPREDATOR("Warrior Predator", () -> new WarriorPredator()),;

  /**
   * supplier that creates the actual object for this enum entry
   */
  private final Supplier<AbstractArtifact> creator;
  /**
   * human-readable name of the artifact
   */
  private final String theName;

  /**
   * constructor setting the object supplier and the name
   * 
   * @param name
   *        human-readable name of the artifact
   * @param creator
   *        supplier of the actual artifact object
   */
  private ArtifactType(String name, Supplier<AbstractArtifact> creator) {
    this.theName = name;
    this.creator = creator;
  }

  /**
   * @return the Artifact object corresponding to the enum entry
   */
  public AbstractArtifact create() {
    return this.creator.get();
  }

  /**
   * @return the human-readable name of the artifact
   */
  public String getName() {
    return theName;
  }

}
