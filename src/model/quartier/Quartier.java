package model.quartier;

public class Quartier{
  private static int MIN_VALUE = 1;
  private static int MAX_VALUE = 8;
  private static int DEFAULT_VALUE = 3;
  private QuartierType type;
  private int valeur;
  private String nom;
	
	public Quartier(QuartierType type, int valeur, String nom){
    this.setQuartier(type);
    this.setValeur(valeur);
    this.setNom(nom);
	}
	
	public Quartier(QuartierType type, String nom){
    this(type, DEFAULT_VALUE, nom);
	}
	
	protected void setNom(String nom){
	  if (nom.length()>0){
	    if (Character.isLowerCase(nom.charAt(0))){
	      this.nom = Character.toUpperCase(nom.charAt(0))+nom.substring(1);
	    }
	    else {this.nom = nom;}
	  }
	  else {this.nom = "Sans Nom";}
	}
	
	private void setQuartier(QuartierType type){
	  this.type = type;
	}
	
	protected void setValeur(int v){
    valeur = DEFAULT_VALUE;
    if (v>=MIN_VALUE && v<=MAX_VALUE) {
      valeur = v;
    }
	}
	
	public QuartierType getType() {return type;}
	
	public int getValeur() {return valeur;}
	
	public String getNom() {return nom;}
	
	@Override
	public String toString(){
	  return getNom()+ " ("+ getType() + ", valeur: " + "*".repeat(getValeur())+")";
	}
	
	@Override
	public int hashCode(){
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	  result = prime * result + ((type == null) ? 0 : type.hashCode());
	  result = prime * result + valeur;
	  return result;
	}
	
	@Override
	public boolean equals(Object obj){
	  if (this == obj){
	    return true;
	  }
	  if (!(obj instanceof Quartier)) {return false;}
	  Quartier other = (Quartier) obj;
	  if (nom == null){
	    if (other.nom != null){
	      return false;
	    }
	  }
	  else if (!nom.equals(other.nom)){
	    return false;
	  }
	  if (type != other.type){
	    return false;
	  }
	  if (valeur != other.valeur){
	    return false;
	  }
	  return true;
	}
}
