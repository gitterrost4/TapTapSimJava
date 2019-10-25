package loadout.artifact;

import heroes.Hero;

public class DemonWhisperer extends AbstractArtifact {

  public DemonWhisperer() {
    super(ArtifactType.DEMONWHISPERER);
  }

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(0.09);
    hero.addMaxHPModifier(0.07);
    hero.increaseSilenceResistance(1);
  }

}
