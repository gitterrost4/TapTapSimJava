// $Id $
package loadout.artifact;

import battle.logging.LogItem;
import battle.logging.LogMessage;
import loadout.HeroModifier;

/**
 * An abstract representation of artifacts
 */
public abstract class AbstractArtifact implements HeroModifier {

  /** The type (name) of the artifact */
  private final ArtifactType artifactType;

  /**
   * create a new artifact and store the name of it
   * 
   * @param artifactType
   *        the type (name) of the artifact
   */
  public AbstractArtifact(ArtifactType artifactType) {
    super();
    this.artifactType = artifactType;
  }

  /**
   * @return a log item containing textual information about the artifact
   */
  public LogItem getInformation() {
    return new LogMessage(artifactType.getName());
  }

}

// end of file
