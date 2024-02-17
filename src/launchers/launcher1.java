public class Launcher{
  public static void TestQuartier(){
    Quartier q1 = new Quartier(QuartierType.Noble, "Manoir");
    Quartier q2 = new Quartier(QuartierType.Commercant, 4, "port");
    Quartier q3 = new Quartier(QuartierType.Religieux, "Bibliotheque");
    Quartier q4 = new Quartier(QuartierType.Religieux, "bibliotheque");
    Quartier q5 = new Quartier(QuartierType.Religieux, "");

    System.out.println(q1);
    System.out.println(q2);
    System.out.println(q3);
    System.out.println(q4);
    System.out.println(q5);

    System.out.println(q1 == q4);
    System.out.println(q1.equals(q4));
    System.out.println(q3 == q4);
    System.out.println(q3.equals(q4));
    System.out.println(q3.equals(q5));

    public static void main(String[] arg){
      TestQuartier();
    }
  }
}
