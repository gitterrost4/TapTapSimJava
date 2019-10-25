package heroes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroTier {
  public static final List<HeroTier> ALL = Stream.of(new HeroTier(0, 1, 1, 0), new HeroTier(30, 1.2, 1.2, 23),
      new HeroTier(40, 1.4, 1.4, 50), new HeroTier(50, 1.6, 1.6, 80), new HeroTier(60, 1.8, 1.8, 112),
      new HeroTier(80, 2.0, 2.0, 147), new HeroTier(100, 2.25, 2.25, 197)).collect(Collectors.toList());
  public final Integer minLevel;
  public final double maxHPModifier;
  public final double attackModifier;
  public final Integer speedIncrease;

  public HeroTier(Integer minLevel, double maxHPModifier, double attackModifier, Integer speedIncrease) {
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
