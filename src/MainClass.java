import heroes.HeroParameters;
import heroes.Reaper;
import loadout.Loadout;

// $Id $
// (C) cantamen/Paul Kramer 2019

/** 
 * TODO documentation
 *
 * @author (C) cantamen/Paul Kramer 2019
 * @version $Id $
 */
public class MainClass {

  public static void main(String[] args) {
    Reaper reaper = new Reaper(new HeroParameters(140, 6, Loadout.empty()));
    System.err.println(reaper.toString());
    // TODO Auto-generated method stub

  }

}


// end of file
