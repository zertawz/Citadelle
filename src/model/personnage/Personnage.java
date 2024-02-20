package model.personnage;

public interface Personnage extend Comparable<Personnage>{
  public void jouer();
  public boolean estActif();
  public int getOrdre();
}
