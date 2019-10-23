package loadout.artifact;

import java.math.BigDecimal;

import heroes.Faction;
import heroes.Hero;

public class HellDisaster extends AbstractArtifact {

  public HellDisaster() {
    super(ArtifactType.HELLDISASTER);
  }

  @Override
  public void apply(Hero hero) {
    hero.addMaxHPModifier(new BigDecimal("0.105"));
    hero.increaseSpeed(42);
    if (hero.getFaction().equals(Faction.HELL)) {
      hero.increaseCritRate(new BigDecimal("0.094"));
    }
  }

}
