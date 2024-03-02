package launchers;

import model.quartier.*;
import model.joueur.*;
import partie.*;

public class launcher3{

  public static void main(String[] arg){
    TestPartie();
  }

  public static void TestPartie(){
    Map<String,Integer> jAge = new LinkedHashMap<String, Integer>();
    jAge.put("Solène", 25);
    jAge.put("Yannick", 28);
    jAge.put("Alain", 20);
    jAge.put("Bruno", 18);
    jAge.put("", 30);
    Partie partie = new Partie(jAge);
    System.out.println(partie);
    partie.lancerPartie();
  }
}
