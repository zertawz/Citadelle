package launchers;

import model.quartier.*;
import model.joueur.*;

public class launcher2{

  public static void main(String[] arg){
    TestJoueur();
  }

  public static void TestQuartier(){
    List<Quartier> pioche = FabriqueQuartier.getCartesQuartier(60);
    List<Quartier> main = new ArrayList<Quartier>();
    Quartier q = new Quartier(QuartierType.Commercant, 2, "marche");
    main.add(new Quartier(QuartierType.Noble, "Manoir"));
    main.add(q);
    main.add(new Quartier(QuartierType.Religieux, 12, "Bibliotheque"));
    main.add(new Quartier(QuartierType.Merveille, 5, "Pyramide"));
    Joueur j1 = new ConcreteJoueur(15, main);
    System.out.println(j1);
    j1.construire(q);
    System.out.println(j1);
    j1.piocher(pioche, 2);
    System.out.println(j1);
    j1.toucherSalaire();
  }
}
