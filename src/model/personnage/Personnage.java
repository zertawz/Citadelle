package model.personnage;

import model.joueur.*;

public interface Personnage extends Comparable<Personnage>{
  public void jouer();
  public boolean estActif();
  public int getOrdre();
  public void setJoueur(Joueur j);
  public void setActif(boolean b);
}
