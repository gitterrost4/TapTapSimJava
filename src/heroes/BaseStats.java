package heroes;

public class BaseStats {
  public final Integer attack;
  public final Integer maxHP;
  public final Integer speed;
  public final Integer defense;
  public BaseStats(Integer maxHP, Integer attack, Integer defense, Integer speed) {
    super();
    this.attack = attack;
    this.maxHP = maxHP;
    this.speed = speed;
    this.defense = defense;
  }
}
