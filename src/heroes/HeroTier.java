package heroes;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroTier {
  public static final List<HeroTier> ALL = Stream.of(new HeroTier(0, new BigDecimal(1), new BigDecimal(1), 0),
      new HeroTier(30, new BigDecimal("1.2"), new BigDecimal("1.2"), 23),
      new HeroTier(40, new BigDecimal("1.4"), new BigDecimal("1.4"), 50),
      new HeroTier(50, new BigDecimal("1.6"), new BigDecimal("1.6"), 80),
      new HeroTier(60, new BigDecimal("1.8"), new BigDecimal("1.8"), 112),
      new HeroTier(80, new BigDecimal("2.0"), new BigDecimal("2.0"), 147),
      new HeroTier(100, new BigDecimal("2.25"), new BigDecimal("2.25"), 197)).collect(Collectors.toList());
  public final Integer minLevel;
  public final BigDecimal maxHPModifier;
  public final BigDecimal attackModifier;
  public final Integer speedIncrease;

  public HeroTier(Integer minLevel, BigDecimal maxHPModifier, BigDecimal attackModifier, Integer speedIncrease) {
    super();
    this.minLevel = minLevel;
    this.maxHPModifier = maxHPModifier;
    this.attackModifier = attackModifier;
    this.speedIncrease = speedIncrease;
  }

  public static HeroTier getTierForLevel(Integer level) {
    return ALL.stream().filter(x -> x.minLevel <= level).sorted((x, y) -> y.minLevel.compareTo(x.minLevel)).findFirst()
        .orElseThrow(() -> new IllegalStateException("level range out of bounds"));
  }

}
