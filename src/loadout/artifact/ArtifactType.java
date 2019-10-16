package loadout.artifact;

import java.util.function.Supplier;

public enum ArtifactType {
  NONE(()->new EmptyArtifact()),
  DEMONWHISPERER(()->new DemonWhisperer()),
  RAGNAROK(()->new Ragnarok()),
  STARSHARDS(()-> new Starshards()),
  CURSEDOCULUS(()->new CursedOculus()),
  SPELLBREAKER(()->new Spellbreaker()),
  CHAOSSPEAR(()->new ChaosSpear()),
  SCYTHEOFFROST(()->new ScytheOfFrost()),
  RAGEOFTHETITANS(()->new RageOfTheTitans()),
  TEARSOFTHEGODDESS(()->new TearsOfTheGoddess()),
  GIANTLIZARD(()->new GiantLizard()),
  BONEGRIP(()->new BoneGrip()),
  LIGHTPACE(()->new LightPace()),
  DRAGONBLOOD(()->new Dragonblood()),
  SCORCHINGSUN(()->new ScorchingSun()),
  WINDWALKER(()->new WindWalker()),
  EYEOFHEAVEN(()->new EyeOfHeaven()),
  BURNINGSOUL(()->new BurningSoul()),
  SUNSHYMN(()->new SunsHymn()),
  DARKDESTROYER(()->new DarkDestroyer()),
  YAKSHA(()->new Yaksha()),
  SATANSPOWER(()->new SatansPower()),
  GOSPELSONG(()->new GospelSong()),
  ANCIENTVOWS(()->new AncientVows()),
  KNIGHTSVOW(()->new KnightsVow()),
  BLOODMEDAL(()->new BloodMedal()),
  GUNOFTHEDISASTER(()->new GunOfTheDisaster()),
  PRIMEVALSOUL(()->new PrimevalSoul()),
  STARPRAY(()->new StarPray()),
  SNOWDANCE(()->new SnowDance()),
  QUEENSCROWN(()->new QueensCrown()),
  SIRENHEART(()->new SirenHeart()),
  CURSEDGUN(()->new CursedGun()),
  SOULTORRENT(()->new SoulTorrent()),
  HOLYLIGHTJUSTICE(()->new HolyLightJustice()),
  GIFTOFCREATION(()->new GiftOfCreation()),
  HELLDISASTER(()->new HellDisaster()),
  ETERNALCURSE(()->new EternalCurse()),
  PEGASUSBOOTS(()->new PegasusBoots()),
  GODDESSBOW(()->new GoddessBow()),
  MIRAGE(()->new Mirage()),
  CAROLOFLIFE(()->new CarolOfLife()),
  RADIANCE(()->new Radiance()),
  SOULSWHISPER(()->new SoulsWhisper()),
  BROKENONE(()->new BrokenOne()),
  HEALINGTEAR(()->new HealingTear()),
  FORESTPSALM(()->new ForestPsalm()),
  CRYSTALSWORD(()->new CrystalSword()),
  SHADOW(()->new Shadow()),
  PLUNDERER(()->new Plunderer()),
  MAGENEMESIS(()->new MageNemesis()),
  CLERICNEMESIS(()->new ClericNemesis()),
  WANDERERNEMESIS(()->new WandererNemesis()),
  ASSASSINNEMESIS(()->new AssassinNemesis()),
  WARRIORNEMESIS(()->new WarriorNemesis()),
  MAGEPREDATOR(()->new MagePredator()),
  CLERICPREDATOR(()->new ClericPredator()),
  WANDERERPREDATOR(()->new WandererPredator()),
  ASSASSINPREDATOR(()->new AssassinPredator()),
  WARRIORPREDATOR(()->new WarriorPredator()),
  ;
  
  
  private final Supplier<AbstractArtifact> creator;
  private ArtifactType(Supplier<AbstractArtifact> creator) {
    this.creator=creator;
  }
  
  public AbstractArtifact create() {
    return this.creator.get();
  }
}
