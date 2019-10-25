package battle;

import battle.logging.Log;
import battle.logging.LogItem;
import battle.logging.LogMessage;

public class Battle {
  private BattleSetting setting;
  private Integer roundCounter = 1;

  public Battle(BattleSetting setting) {
    super();
    this.setting = setting;
  }

  public LogItem doBattle() {
    Log log = new Log();
    log.addMessage("Battle setup:");
    log.addItem(setting.getInformation());
    log.addMessage("Starting Battle");
    while (roundCounter < 16 && !setting.getAttacker().isDead() && !setting.getDefender().isDead()) {
      log.addItem(processRound());
      roundCounter++;
    }
    if (setting.getAttacker().isDead()) {
      log.addMessage("Battle finished. Attacker lost because of death.");
    } else if (setting.getDefender().isDead()) {
      log.addMessage("Battle finished. Attacker won because of Defender's death.");
    } else if (roundCounter > 15) {
      log.addMessage("Battle finished. Attacker lost because of round limit.");
    } else {
      log.addMessage("Battle finished for some other unforseen reason.");
    }

    return log;
  }

  private LogItem processRound() {
    Log log = new Log();
    log.addItem(new LogMessage("Starting round " + roundCounter));
    setting.getSpeedSortedHeroList().forEach(hero -> {
      if (!hero.isDead() && !setting.getAttacker().isDead() && !setting.getDefender().isDead()) {
        log.addItem(hero.doAttack(setting));
        hero.triggerTemporaryEffects();
        //TODO: Process Temporary effects each round
      }
    });
    log.addItem(new LogMessage("Ending round " + roundCounter));
    return log;
  }
}
