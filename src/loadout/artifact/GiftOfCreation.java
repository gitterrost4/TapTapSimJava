package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class GiftOfCreation extends AbstractArtifact {

  public GiftOfCreation() {
    super(ArtifactType.GIFTOFCREATION);
  }

  @Override
  public void apply(Hero hero) {
    hero.increaseDamageReduce(new BigDecimal("0.157"));
    hero.addMaxHPModifier(new BigDecimal("0.105"));
    if (hero.getFaction().equals(Faction.HEAVEN)) {
      hero.increaseTrueDamage(new BigDecimal("0.126"));
    }
  }

}
