// $Id $
package effects;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import battle.logging.Log;
import battle.logging.LogItem;
import heroes.Hero;

/**
 * This class represents all the effects one hero can have. Basically it's a
 * collection of effects that remembers the hero the effects are applied to and has
 * some convenient methods
 */
public class TemporaryEffectCollection {

  /** the hero that the contained effects are applied to */
  private final Hero hero;

  /**
   * create a new temporaryEffect collection
   * 
   * @param hero
   *        the hero that the contained effects are applied to
   */
  public TemporaryEffectCollection(Hero hero) {
    super();
    this.hero = hero;
  }

  /** the list of all effects assigned to a hero */
  List<TemporaryEffect> effects = new ArrayList<>();

  /**
   * add an effect and trigger it's starting action
   * 
   * @param effect
   *        effect to be added
   * @return A log item containing the logged information of this operation
   */
  public LogItem addEffect(TemporaryEffect effect) {
    Log log = new Log();
    effects.add(effect);
    effect.apply(hero).ifPresent(log::addItem);
    return log;
  }

  /**
   * Trigger all effects (executing their trigger action) and count down their round
   * counter. if the effect is over, trigger their ending action. This also removes
   * any ended effect from the collection
   * 
   * @return A log item containing the logged information of this operation
   */
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

  /**
   * @return true if the collection contains a Silence effect
   */
  public boolean containsSilence() {
    return effects.stream().anyMatch(e -> e instanceof Silence);
  }

  /**
   * @return true if the collection contains a Poison effect
   */
  public boolean containsPoison() {
    return effects.stream().anyMatch(e -> e instanceof Poison);
  }

  /**
   * @return true if the collection contains a Bleeding effect
   */
  public boolean containsBleed() {
    return effects.stream().anyMatch(e -> e instanceof Bleed);
  }

  /**
   * @return true if the collection contains a Petrify effect
   */
  public boolean containsPetrify() {
    return effects.stream().anyMatch(e -> e instanceof Petrify);
  }

  /**
   * @return true if the collection contains a Burn effect
   */
  public boolean containsBurn() {
    return effects.stream().anyMatch(e -> e instanceof Burn);
  }

  /**
   * @return true if the collection contains a Freeze effect
   */
  public boolean containsFreeze() {
    return effects.stream().anyMatch(e -> e instanceof Freeze);
  }

  /**
   * @return true if the collection contains a Stun effect
   */
  public boolean containsStun() {
    return effects.stream().anyMatch(e -> e instanceof Stun);
  }

  /**
   * @param filter
   *        predicate to filter the effects by
   * @return true if there is at least one effect satisfying the filter
   */
  public boolean hasEffect(Predicate<TemporaryEffect> filter) {
    return effects.stream().anyMatch(filter);
  }

}

// end of file
