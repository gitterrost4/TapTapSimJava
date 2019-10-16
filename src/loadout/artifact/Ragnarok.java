package loadout.artifact;

import java.math.BigDecimal;

import heroes.Hero;

public class Ragnarok extends AbstractArtifact {
  @Override
  public void apply(Hero hero) {
    hero.increaseTrueDamage(new BigDecimal("0.2"));
    hero.addMaxHPModifier(new BigDecimal("0.1"));
    hero.increaseDefenseBreak(new BigDecimal("8"));
  }

}
