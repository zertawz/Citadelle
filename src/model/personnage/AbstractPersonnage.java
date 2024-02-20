package model.personnage;

public abstract class AbstractPersonnage implements Personnage{
  private int ordre;
  protected Joueur joueur;
  private boolean actif = true;

  public AbstractPersonnage(int ordre){
    this.ordre = ordre;
    joueur = null;
  }
  public AbstractPersonnage(int ordre, joueur J){
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
  public boolean estActif(){
    //TODO
  }
}
