package model.personnage;

public class Marchand extends AbstractPersonnage {
  public Marchand() {
    super(6);
  }
  public Marchand(Joueur j) {
    super(6,j);
  }
  @Override
  protected void action(Personnage p) {
    joueur.toucherSalaire();
    joueur.toucherSalaire();
  //Par exemple : touche deux fois son salaire
  }
}
