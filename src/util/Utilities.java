package util;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Utilities {

  /**
   * Tries to interpolate an integer stat from known data points. if the level
   * is between two known levels, it interpolates it linearly. Otherwise it
   * takes the highest or lowest bound
   * 
   * @param knownStats
   * @param level
   * @return
   */
  public static Integer interpolateStatsLinearly(Map<Integer,Integer> knownStats,int level) {
    return Optional.ofNullable(knownStats.get(level)).orElseGet(() -> {
      Set<Integer> knownLevels=knownStats.keySet();
      // find the highest lower bound
      Optional<Integer> lowerLevel=knownLevels.stream().filter(l -> l < level).sorted((a,b) -> b.compareTo(a))
        .findFirst();
      // find the lowest upper bound
      Optional<Integer> higherLevel=knownLevels.stream().filter(l -> l > level).sorted().findFirst();
      // interpolate linearly inbetween
      return lowerLevel
        .map(l -> higherLevel.map(h -> ((knownStats.get(h) - knownStats.get(l)) * level) / (h - l))
          .orElseGet(() -> knownStats.get(l)))
        .orElseGet(() -> higherLevel.map(knownStats::get).orElse(0));
    });
  }

}
