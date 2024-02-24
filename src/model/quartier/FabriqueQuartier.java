package model.quartier;

import java.util.*;

public class FabriqueQuartier{
  public static List<Quartier> getCartesQuartier(int i){
    List<Quartier> ret = new ArrayList<Quartier>();
    //TODO ajout de i quartiers aléatoires à la liste ret
    Collections.shuffle(ret);
    return ret;
  }
}
