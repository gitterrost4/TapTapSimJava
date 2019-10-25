// $Id $
package loadout.artifact;

import battle.logging.LogItem;
import battle.logging.LogMessage;
import loadout.HeroModifier;

/**
 * An abstract representatino of artifacts
 *
 */
public abstract class AbstractArtifact implements HeroModifier {

  private final ArtifactType artifactType;

  public AbstractArtifact(ArtifactType artifactType) {
    super();
    this.artifactType = artifactType;
  }

  public LogItem getInformation() {
    return new LogMessage(artifactType.getName());
  }

}

// end of file
