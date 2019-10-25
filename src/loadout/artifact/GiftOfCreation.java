package loadout.artifact;

import heroes.Faction;
import heroes.Hero;

public class GiftOfCreation extends AbstractArtifact {

  public GiftOfCreation() {
    super(ArtifactType.GIFTOFCREATION);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseDamageReduce(0.157);
    hero.addMaxHPModifier(0.105);
    if (hero.getFaction().equals(Faction.HEAVEN)) {
      hero.increaseTrueDamage(0.126);
    }
  }

}
