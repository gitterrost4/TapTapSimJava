// $Id $
// (C) cantamen/Paul Kramer 2019
package effects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import heroes.Hero;

/**
 * This class represents all the effects one hero can have. Basically it's a
 * collection of effects that remembers the hero the effects are applied to and
 * has some convenient methods
 */
public class TemporaryEffectCollection {

  private final Hero hero;

  public TemporaryEffectCollection(Hero hero) {
    super();
    this.hero=hero;
  }

  List<TemporaryEffect> effects=new ArrayList<>();

  public void addEffect(TemporaryEffect effect) {
    effects.add(effect);
    effect.apply(hero);
  }

  public void trigger() {
    effects.stream().forEach(effect -> {
      effect.trigger(hero);
      if (effect.isOver()) {
        effect.end(hero);
      }
    });
    effects=effects.stream().filter(effect -> !effect.isOver()).collect(Collectors.toList());
  }

  public boolean containsSilence() {
    return effects.stream().anyMatch(e -> e instanceof Silence);
  }

}

// end of file
