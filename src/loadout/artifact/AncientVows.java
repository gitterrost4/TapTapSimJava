package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class AncientVows extends AbstractArtifact {

  public AncientVows() {
    super(ArtifactType.ANCIENTVOWS);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(new BigDecimal("0.105"));
    hero.increaseSpeed(42);
    if (hero.getFaction().equals(Faction.ALLIANCE)) {
      hero.increaseCritRate(new BigDecimal("0.094"));
    }
  }

}
