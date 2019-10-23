package loadout.artifact;

import java.util.function.Supplier;

public enum ArtifactType {
  NONE("None", ()->new EmptyArtifact()),
  DEMONWHISPERER("Demon Whisperer", ()->new DemonWhisperer()),
  RAGNAROK("Ragnarok", ()->new Ragnarok()),
  STARSHARDS("Starshards", ()-> new Starshards()),
  CURSEDOCULUS("Cursed Oculus", ()->new CursedOculus()),
  SPELLBREAKER("Spellbreaker", ()->new Spellbreaker()),
  CHAOSSPEAR("Chaos Spear", ()->new ChaosSpear()),
  SCYTHEOFFROST("Scythe of Frost", ()->new ScytheOfFrost()),
  RAGEOFTHETITANS("Rage of the Titans", ()->new RageOfTheTitans()),
  TEARSOFTHEGODDESS("Tears of the Goddess", ()->new TearsOfTheGoddess()),
  GIANTLIZARD("Giant Lizard", ()->new GiantLizard()),
  BONEGRIP("Bone Grip", ()->new BoneGrip()),
  LIGHTPACE("Light Pace", ()->new LightPace()),
  DRAGONBLOOD("Dragonblood", ()->new Dragonblood()),
  SCORCHINGSUN("Scorching Sun", ()->new ScorchingSun()),
  WINDWALKER("Windwalker", ()->new WindWalker()),
  EYEOFHEAVEN("Eye of Heaven", ()->new EyeOfHeaven()),
  BURNINGSOUL("Burning Soul", ()->new BurningSoul()),
  SUNSHYMN("Sun's Hymn", ()->new SunsHymn()),
  DARKDESTROYER("Dark Destroyer", ()->new DarkDestroyer()),
  YAKSHA("Yaksha", ()->new Yaksha()),
  SATANSPOWER("Satan's Power", ()->new SatansPower()),
  GOSPELSONG("Gospel Song", ()->new GospelSong()),
  ANCIENTVOWS("Ancient Vows", ()->new AncientVows()),
  KNIGHTSVOW("Knight's Vow", ()->new KnightsVow()),
  BLOODMEDAL("Blood Medal", ()->new BloodMedal()),
  GUNOFTHEDISASTER("Gun of the Disaster", ()->new GunOfTheDisaster()),
  PRIMEVALSOUL("Primeval Soul", ()->new PrimevalSoul()),
  STARPRAY("Starpray", ()->new StarPray()),
  SNOWDANCE("Snow Dance", ()->new SnowDance()),
  QUEENSCROWN("Queen's Crown", ()->new QueensCrown()),
  SIRENHEART("Siren Heart", ()->new SirenHeart()),
  CURSEDGUN("Cursed Gun", ()->new CursedGun()),
  SOULTORRENT("Soul Torrent", ()->new SoulTorrent()),
  HOLYLIGHTJUSTICE("Holy Light Justice", ()->new HolyLightJustice()),
  GIFTOFCREATION("Gift of Creation", ()->new GiftOfCreation()),
  HELLDISASTER("Hell Disaster", ()->new HellDisaster()),
  ETERNALCURSE("Eternal Curse", ()->new EternalCurse()),
  PEGASUSBOOTS("Pegasus Boots", ()->new PegasusBoots()),
  GODDESSBOW("Goddess' Bow", ()->new GoddessBow()),
  MIRAGE("Mirage", ()->new Mirage()),
  CAROLOFLIFE("Carol of Life", ()->new CarolOfLife()),
  RADIANCE("Radiance", ()->new Radiance()),
  SOULSWHISPER("Soul's Whisper", ()->new SoulsWhisper()),
  BROKENONE("Broken One", ()->new BrokenOne()),
  HEALINGTEAR("Healing Tear", ()->new HealingTear()),
  FORESTPSALM("Forest Psalm", ()->new ForestPsalm()),
  CRYSTALSWORD("Crystal Sword", ()->new CrystalSword()),
  SHADOW("Shadow", ()->new Shadow()),
  PLUNDERER("Plunderer", ()->new Plunderer()),
  MAGENEMESIS("Mage Nemesis", ()->new MageNemesis()),
  CLERICNEMESIS("Cleric Nemesis", ()->new ClericNemesis()),
  WANDERERNEMESIS("Wanderer Nemesis", ()->new WandererNemesis()),
  ASSASSINNEMESIS("Assassin Nemesis", ()->new AssassinNemesis()),
  WARRIORNEMESIS("Warrior Nemesis", ()->new WarriorNemesis()),
  MAGEPREDATOR("Mage Predator", ()->new MagePredator()),
  CLERICPREDATOR("Cleric Predator", ()->new ClericPredator()),
  WANDERERPREDATOR("Wanderer Predator", ()->new WandererPredator()),
  ASSASSINPREDATOR("Assassin Predator", ()->new AssassinPredator()),
  WARRIORPREDATOR("Warrior Predator", ()->new WarriorPredator()),
  ;
  
  
  private final Supplier<AbstractArtifact> creator;
  private final String theName; 
  
  private ArtifactType(String name, Supplier<AbstractArtifact> creator) {
    this.theName = name;
    this.creator=creator;
  }
  
  public AbstractArtifact create() {
    return this.creator.get();
  }

  public String getName() {
    return theName;
  }
  
}
