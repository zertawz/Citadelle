package model.personnage;

import model.joueur.*;

public abstract class AbstractPersonnage implements Personnage{
  private int ordre;
  protected Joueur joueur;
  private boolean actif = true;

  public AbstractPersonnage(int ordre){
    this.ordre = ordre;
    joueur = null;
  }
  public AbstractPersonnage(int ordre, Joueur j){
    this.ordre = ordre;
    joueur = j;
  }

  @Override
  public int compareTo(Personnage p) {return ordre - p.getOrdre();}

  public int getOrdre() {return ordre;}

  @Override
  public String toString() {return getOrdre() + " " + getClass().getSimpleName();}
  
  protected abstract void action(Personnage p);

  @Override
  public boolean estActif(){return actif ;}

  public void setActif(boolean b) {actif = b;}
  
  @Override
  public final void jouer()
    if(joueur==null) {
      System.out.println("Pas de joueur pour "+getClass().getSimpleName());
    }
    else {
      System.out.println(getClass().getSimpleName() +" est le joueur " + joueur.getNom() );
      if(!this.estActif()) {System.out.println(" mais il ne peut pas jouer");}
      //TODO
      //else {
        //this.action(. . . . . .);
      }
    }
  }
}
