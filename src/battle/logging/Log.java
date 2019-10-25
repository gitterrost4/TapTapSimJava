package battle.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Log implements LogItem {

  private List<LogItem> items = new ArrayList<>();

  public Log addItem(LogItem item) {
    Optional.ofNullable(item).ifPresent(items::add);
    return this;
  }

  public Log addMessage(String message) {
    items.add(new LogMessage(message));
    return this;
  }

  public List<LogItem> getItems() {
    return items;
  }

  public Log merge(Log other) {
    this.items.addAll(other.getItems());
    return this;
  }

  @Override
  public String prettyPrint() {
    return prettyPrint(0);
  }

  public boolean isEmpty() {
    return items.isEmpty();
  }

  @Override
  public String prettyPrint(int indent) {
    return items.stream().map(item -> item.prettyPrint(indent + 1)).collect(Collectors.joining());
  }

  @Override
  public String toString() {
    return "Log [items=" + items + "]";
  }
}
