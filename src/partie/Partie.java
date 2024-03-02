package partie;

public class Partie {
  private Set<Joueur> joueurs;
  private Set<Personnage> personnages;
  private List<Quartier> pioche;
  private int tour = 1;
  private Joueur roiActuel;
  
  public Partie(Map<String,Integer> nomJoueursAge) {
    pioche = FabriqueQuartier.getCartesQuartier(60);
    creerJoueurs(nomJoueursAge);
    roiActuel = getPlusAge();
    creerPersonnages();
  }
  
  private void creerPersonnages() {
    personnages = new TreeSet<Personnage>();
    personnages.add(new Roi(roiActuel));
    personnages.add(new Voleur());
    personnages.add(new Assassin());
    personnages.add(new Magicien());
    personnages.add(new Marchand());
    personnages.add(new Eveque());
    personnages.add(new Architecte());
    personnages.add(new Condottiere());
  }
  
  private void creerJoueurs(Map<String,Integer> joueursAge) {;
    joueurs = new LinkedHashSet<Joueur>();
    for(Map.Entry<String,Integer> entree: joueursAge.entrySet()) {
      List<Quartier> main = pioche.subList(0, 4);
        if(entree.getKey().equals("")) {
          joueurs.add(new ConcreteJoueur(entree.getValue(), main));
        }
        else {
          joueurs.add(); //TODO
        }
        pioche.removeAll(main);
      }
    }
    
  public String toString() {
    String ret = "--- Partie --- (tour "+tour+") ---\n"+"Personnages: \n";
    for (Personnage p : personnages) {
      ret = ret +p+"\n";
    }
    return ret;
  }
  
  public void lancerPartie() {
    //POUR SIMPLIFIER, UNIQUEMENT 3 TOURS
    /*
    Joueur j = joueurs.iterator().next();
    while(!j.aFiniSaCite()) {*/
    nouveauTour();
    System.out.println(this);
    nouveauTour();
    System.out.println(this);
    nouveauTour();
    System.out.println(this);
  //}
  }
  
  private Joueur getPlusAge() {
  //TODO
  }
  
  private final void nouveauTour() {
    tour++;
    choisirPerso();
    jouer();
  }
  
  private void jouer() {
    for(Personnage p:personnages) {
      p.jouer();
    }
  }
  
  private void choisirPerso() {
    //suppression des affectations de joueur aux personnages
    for(Personnage p: personnages) {
      p.setJoueur(null);
      p.setActif(true);
    }
    //copie des personnages dans une liste
    List<Personnage> persoAChoisir = new ArrayList<Personnage>(personnages);
    //on mélange la liste (c'est pour pouvoir mélanger qu'on utilise une liste et pas un set)
    Collections.shuffle(persoAChoisir);
    //on retire le premier personnage de persoAChoisir mais pas si c'est le roi (il faut recommencer l'opération tant que c'est le cas)
    //TODO

    //TODO
    //copie des joueurs dans une liste pour faciliter la navigation
    List<Joueur> lesJoueursOrdonnes = new ArrayList<Joueur>(joueurs);
    //recherche de la place du joueur actuellement roi
    int placeRoi = lesJoueursOrdonnes.indexOf(roiActuel);

    //choix d'un personnage pour chaque joueur
    for(int i=placeRoi; i<joueurs.size();i++) {
      lesJoueursOrdonnes.get(i).choisirPersonnage(persoAChoisir);
    }
    for(int i=0; i<placeRoi;i++) {
      lesJoueursOrdonnes.get(i).choisirPersonnage(persoAChoisir);
    }
  }
}
