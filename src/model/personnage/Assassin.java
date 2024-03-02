package model.personnage;

public class Assassin extends AbstractPersonnage {
  public Assassin() {
    super(1);
  }
  public Assassin(Joueur j) {
    super(1,j);
  }
  @Override
  protected void action(Personnage p) {
    if(p!= null) {p.setActif(false);}
  }
}
