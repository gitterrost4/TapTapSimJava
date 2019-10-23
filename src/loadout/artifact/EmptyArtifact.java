package loadout.artifact;

import heroes.Hero;

public class EmptyArtifact extends AbstractArtifact {

  public EmptyArtifact() {
    super(ArtifactType.NONE);
  }

  @Override
  public void apply(Hero hero) {
    // do nothing
  }

}
