package heroes;

/**
 * container class for the basic stats of a hero
 */
public class BaseStats {
  /**
   * base attack stat of the hero
   */
  public final Integer attack;

  /**
   * base maxHP stat of the hero
   */
  public final Integer maxHP;

  /**
   * base speed stat of the hero
   */
  public final Integer speed;

  /**
   * base defense stat of the hero
   */
  public final Integer defense;

  /**
   * constructor specifying the stats
   * 
   * @param maxHP
   *        base maxHP stat of the hero
   * @param attack
   *        base attack stat of the hero
   * @param defense
   *        base defense stat of the hero
   * @param speed
   *        base speed stat of the hero
   */
  public BaseStats(Integer maxHP, Integer attack, Integer defense, Integer speed) {
    super();
    this.attack = attack;
    this.maxHP = maxHP;
    this.speed = speed;
    this.defense = defense;
  }
}
