package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class DemonWhisperer extends AbstractArtifact {

  @Override
  public void apply(Hero hero) {
    hero.addAttackModifier(new BigDecimal("0.09"));
    hero.addMaxHPModifier(new BigDecimal("0.07"));
    hero.increaseSilenceResistance(new BigDecimal("1"));
  }

}
