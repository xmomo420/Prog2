package laboListesChainees.partie2;

public class TestsListe {

   public static void afficherListe(Liste liste, String contenu) {
      System.out.println("liste devrait contenir : " + contenu);
      System.out.print("liste contient         : ");
      for (int i = 0; i < liste.longueur(); i++) {
         System.out.print(liste.elementPosition(i) + "  ");
      }
      System.out.println();
   }

   public static void main(String[] params) {

      // appeler le constructeur correspondant a la classe voulue
      Liste<Integer> liste = new ListeSimple<>();
      Liste<String> liste2 = new ListeSimple<>();

      //Pour tester d'autres implementations de Liste
      
      //Liste<Integer> liste = new ListeSimpleAvecTete<>();
      //Liste<String> liste2 = new ListeSimpleAvecTete<>();
      
      //Liste<Integer> liste = new ListeSimpleAvecRemorque<>();
      //Liste<String> liste2 = new ListeSimpleAvecRemorque<>();
      
      // test liste vide
      System.out.println("liste.estVide() = " + liste.estVide());
      System.out.println("liste.longueur() = " + liste.longueur());

      // creer la liste ( 7, 6, 5, 4, 3, 2, 1, 0 )
      for (int i = 0; i < 8; i++) {
         liste.insererDebut(i);
      }

      afficherListe(liste, "7, 6, 5, 4, 3, 2, 1, 0");
      System.out.println();

      liste.insererFin(999);

      afficherListe(liste, "7, 6, 5, 4, 3, 2, 1, 0, 999");
      System.out.println();

      liste.insererPosition(-1, 0);

      afficherListe(liste, "-1, 7, 6, 5, 4, 3, 2, 1, 0, 999");
      System.out.println();

      liste.insererPosition(444, 4);

      afficherListe(liste, "-1, 7, 6, 5, 444, 4, 3, 2, 1, 0, 999");
      System.out.println();

      liste.insererPosition(99999, liste.longueur());

      afficherListe(liste, "-1, 7, 6, 5, 444, 4, 3, 2, 1, 0, 999, 99999");
      System.out.println();

      liste.retirerDebut();

      afficherListe(liste, "7, 6, 5, 444, 4, 3, 2, 1, 0, 999, 99999");
      System.out.println();

      liste.retirerFin();

      afficherListe(liste, "7, 6, 5, 444, 4, 3, 2, 1, 0, 999");
      System.out.println();

      liste.retirerPosition(0);

      afficherListe(liste, "6, 5, 444, 4, 3, 2, 1, 0, 999");
      System.out.println();

      liste.retirerPosition(liste.longueur() - 1);

      afficherListe(liste, "6, 5, 444, 4, 3, 2, 1, 0");
      System.out.println();

      liste.retirerPosition(2);

      afficherListe(liste, "6, 5, 4, 3, 2, 1, 0");
      System.out.println();

      liste.retirerPosition(5);

      afficherListe(liste, "6, 5, 4, 3, 2, 0");
      System.out.println();

      System.out.println("liste.estVide() = " + liste.estVide());
      System.out.println("liste.longueur() = " + liste.longueur());
      System.out.println();

      liste2.insererDebut("bonjour");
      liste2.insererDebut("table");
      liste2.insererDebut("chat");

      afficherListe(liste2, "chat, table, bonjour");

      System.out.println();
      System.out.println("liste.estVide() = " + liste2.estVide());
      System.out.println("liste.longueur() = " + liste2.longueur());
   }
}
