package model.joueur;

import java.util.*;
import model.quartier.*;
import model.personnage.*;

public class ConcreteJoueur implements Joueur{
  private static final int NB_QUARTIERS_FIN = 7;
  private static final int NB_PIECES_DEBUT = 2;
  private static Joueur premier = null;
  private static int numJoueur = 1;

  private int age;
  private String nom;
  private Set<Quartier> quartiersJoues;
  private List<Quartier> main;
  private int pieces;

  public ConcreteJoueur(int age, List<Quartier> main){
    this("Joueur "+ numJoueur, age, main);
  }

  public ConcreteJoueur(String nom, int age, List<Quartier> main){
    quartiersJoues = new HashSet<Quartier>();
    this.nom = nom;
    this.age = age;
    this.main = new ArrayList<Quartier>();
    this.main = addAll(main);
    pieces =  NB_PIECES_DEBUT;
    numJoueur++;
  }

  @Override
  public int compareTo(Joueur j){
    return age-j.getAge();
  }

  public int getAge(){
    return age;
  }

  public int getScore(){
    int score = 0;
    Set<QuartierType> typesQuartiers = new HashSet<QuartierType>();
    for(Quartier q: quartiersJoues) {
      score+= q.getValeur();
      typesQuartiers.add(q.getType());
    }
    if(typesQuartiers.size()==QuartierType.values().length) {
      score+=3;
    }
    if(this == premier) {
      score += 4;
    }
    else if(aFiniSaCite()) {
      score +=2;
    }
    return score;
  }

  @Override
  public boolean aFiniSaCite(){
    return quartiersJoues.size()>=NB_QUARTIERS_FIN;
  }

  @Override
  public String toString(){
    String ret = "Joueur "+nom+" (score: "+getScore()+", pieces: "+pieces+")\nQuartiers Joues:\n";
    ret+=quartiersToString(quartiersJoues);
    ret+="Main:\n";
    ret+=quartiersToString(main);
    return ret;
  }

  private String quartiersToString(Collections<Quartier> quartiers){
    String ret = "";
    for (Quartier q: quartiers){
      ret += "\t * "+q+"\n";
    }
    return ret;
  }

  private void finDuJeu(){
    if (aFiniSaCite() && premier == null){
      premier = this;
    }
  }

  public boolean construire(Quartier q){
    boolean ret = false;
    if (main.contains(q) && q.getValeur()<=pieces && !
      quartiersJoues.contains(q)) {
      main.remove(q);
      quartiersJoues.add(q);
      pieces = pieces - q.getValeur();
      ret = true;
    }
    return ret;
  }

  @Override
  public boolean piocher(List<Quartier> pioche, int nbCarte){
    boolean ret = true ;
    if(nbcarte>pioche.size()){
      ret = false;
      nbCarte = pioche.size();
    }
    for (int i=0; i<nbCarte; i++){
      main.add(pioche.remove(0));
    }
    return ret;
  }

  @Override
  public void toucherSalaire(){
    pieces += 2;
  }

  @Override
  public void choisirPersonnage(List<Personnage> persoAChoisir){
    Collections.shuffle(persoAChoisir);
    persoAChoisir.remove(0).setJoueur(this);
  }

  @Override
  public String getNom(){
    return nom;
  }
}
