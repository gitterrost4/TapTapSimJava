// $Id $
package effects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import battle.logging.Log;
import battle.logging.LogItem;
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
    this.hero = hero;
  }

  List<TemporaryEffect> effects = new ArrayList<>();

  public LogItem addEffect(TemporaryEffect effect) {
    Log log = new Log();
    effects.add(effect);
    effect.apply(hero).ifPresent(log::addItem);
    return log;
  }

  public LogItem trigger() {
    Log log = new Log();
    effects.stream().forEach(effect -> {
      if (effect.isOver()) {
        log.addItem(hero.logMessage("Ending effect " + effect));
        effect.end(hero).ifPresent(log::addItem);
      } else {
        effect.trigger(hero).ifPresent(log::addItem);
      }
    });
    effects = effects.stream().filter(effect -> !effect.isOver()).collect(Collectors.toList());
    return log;
  }

  public boolean containsSilence() {
    return effects.stream().anyMatch(e -> e instanceof Silence);
  }

  public boolean containsPoison() {
    return effects.stream().anyMatch(e -> e instanceof Poison);
  }

  public boolean containsBleed() {
    return effects.stream().anyMatch(e -> e instanceof Bleed);
  }

  public boolean containsPetrify() {
    return effects.stream().anyMatch(e -> e instanceof Petrify);
  }

  public boolean containsBurn() {
    return effects.stream().anyMatch(e -> e instanceof Burn);
  }

  public boolean containsFreeze() {
    return effects.stream().anyMatch(e -> e instanceof Freeze);
  }

  public boolean containsStun() {
    return effects.stream().anyMatch(e -> e instanceof Stun);
  }

}

// end of file
