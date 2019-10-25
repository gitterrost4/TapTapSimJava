package battle.logging;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogMessage implements LogItem {
  public final String message;

  public LogMessage(String message) {
    super();
    this.message = message;
  }

  @Override
  public String prettyPrint() {
    return prettyPrint(0);
  }

  @Override
  public String prettyPrint(int indent) {
    String indentS = IntStream.range(0, indent - 1).mapToObj(unused -> "  ").collect(Collectors.joining());
    return indentS + message + "\n";
  }

  @Override
  public String toString() {
    return "LogMessage [message=" + message + "]";
  }

}
