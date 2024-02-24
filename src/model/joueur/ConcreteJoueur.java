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
    //TODO
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
    //TODO
    return ret;
  }

  @Override
  public boolean piocher(List<Quartier> pioche, int nbCarte){
    for (int i=0; i<nbCarte; i++){
      main.add(pioche.remove(0));
    }
    return true;
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
