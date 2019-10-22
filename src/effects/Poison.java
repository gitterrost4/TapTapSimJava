package effects;

import java.math.BigDecimal;

import heroes.Hero;

/** 
 * Poison effect
 *
 */
public class Poison extends TemporaryEffect {
  
  public Poison(Integer remainingRounds, Hero source, BigDecimal strength) {
    super(h->h.damage(source, strength), h->h.damage(source, strength), h->{}, remainingRounds);
  }

}


// end of file
