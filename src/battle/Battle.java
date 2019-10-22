package battle;

public class Battle {
  private BattleSetting setting;
  private Integer roundCounter = 0;
  private BattleLog log = new BattleLog();

  public Battle(BattleSetting setting) {
    super();
    this.setting = setting;
  }

  public BattleLog doBattle() {
    roundCounter++;
    while (roundCounter < 16 && !setting.getAttacker().isDead() && !setting.getDefender().isDead()) {
      processRound();
    }
    return log;
  }

  private void processRound() {
    setting.getSpeedSortedHeroList().forEach(hero -> {
      hero.doAttack(setting);
    });
  }
}
