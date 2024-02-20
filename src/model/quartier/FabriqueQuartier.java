package model.quartier;

public class FabriqueQuartier{
  public static List<Quartier> getCartesQuartier(int i){
    List<Quartier> ret = new ArrayList<Quartier>();
    //TODO ajout de i quartiers aléatoires à la liste ret
    Collection.shuffle(ret);
    return ret;
  }
}
