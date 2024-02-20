package model.personnage;

public abstract class AbstractPersonnage implement Personnage{
  private int ordre;
  public AbstractPersonnage(int ordre){
    this.ordre = ordre;
  }

  @Override
  public int compareTo(Personnage p){
    //TODO
  }

  public int getOrdre {return ordre;}

  @Override
  public String toString() {return getOrdre() + " " + getClass().getSimpleName();}
  
  protected abstract void action(Personnage p);

  @Override
  public boolean estActif(){
    //TODO
  }
}
