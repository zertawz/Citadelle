package model.joueur;

import model.quartier.*;
import model.personnage.*;
import java.util.*;

public interface Joueur extends Comparable<Joueur>{
  public int getScore();
  public boolean aFiniSaCite();
  public boolean construire(Quartier q);
  public boolean piocher(List<Quartier> pioche, int nbCarte);
  public void toucherSalaire();
  public int getAge();
  public void choisirPersonnage(List<Personnage> persoAChoisir);
  public String getNom();
}
