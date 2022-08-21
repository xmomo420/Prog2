import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melanie lord
 * @version octobre 2014
 */
public class ExemplesParcoursRecursifsTabChaineListe {
   
   /************************
    * PARCOURS TABLEAU
    ************************/
   
   /**
    * Affiche les elements de tab a partir de l'indice i de tab
    * jusqu'à la fin de tab, dans l'ordre.
    * @param tab le tableau dont on veut afficher les elements.
    *        ANT : tab est non null, non vide et i est un indice valide dans 
    *              tab.
    * @param i l'indice dans tab a partir duquel on veut afficher les elements.
    * @throws RuntimeException si tab est null, vide ou si i est invalide.
    */
   public static void afficherTab (int[] tab, int i) {
      
      if (i < tab.length) {
         System.out.print(tab[i] + " ");
         afficherTab(tab, i + 1);
      }
      //cas de base : i >= tab.length, dans ce cas, la methode se termine
      //sans appel recursif.
   }
   
   /**
    * Affiche les elements de tab a partir de l'indice i de tab
    * jusqu'à la fin de tab, dans l'ordre INVERSE.
    * @param tab le tableau dont on veut afficher les elements.
    *            ANT : tab est non null, non vide et i est un indice valide dans 
    *                  tab.
    * @param i l'indice dans tab a partir duquel on veut afficher les elements, 
    *          de l'element i vers l'element 0.
    */
   public static void afficherTabInverse (int[] tab, int i) {
      if (i < tab.length) {
         afficherTabInverse(tab, i + 1);
         System.out.print(tab[i] + " ");
      }
      //cas de base : i >= tab.length, dans ce cas, la methode se termine
      //sans appel recursif. 
      
   }
   
   /**************************
    * PARCOURS CHAINE DE CAR
    **************************/
   
   /**
    * Affiche les caracteres de s separes par des espaces, dans l'ordre.
    * @param s la chaine dont on veut afficher les caracteres, un espace entre 
    *          chaque caractere.
    *          ANT : s n'est pas null.
    */
   public static void afficherChaine (String s) {
      if (s.length() > 0) {
         System.out.print(s.charAt(0) + " ");
         afficherChaine(s.substring(1));
      }
      //cas de base : s.length == 0, la methode se termine.
   }
   
   /**
    * Affiche les caracteres de s separes par des espaces, dans l'ordre INVERSE.
    * @param s la chaine dont on veut afficher les caracteres, un espace entre 
    *          chaque caractere.
    *          ANT : s n'est pas null.
    */
   public static void afficherChaineInverse (String s) {
      if (s.length() > 0) {
         afficherChaineInverse(s.substring(1));
         System.out.print(s.charAt(0) + " ");
      }
      //cas de base : s.length == 0, la methode se termine.
   }
   
   /**************************
    * PARCOURS LIST 
    **************************/
   
   /**
    * Affiche les elements de liste, separes par des espaces, dans l'ordre.
    * Apres l'appel de cette methode, liste ne doit pas avoir ete modifiee.
    * @param liste la liste dont on veut afficher les elements
    *              ANT : liste n'est pas null.
    */
   public static void afficherListe (List<Integer> liste) {
      if (liste.size() > 0) {
         System.out.print(liste.get(0) + " ");
         afficherListe(liste.subList(1, liste.size()));
      }
      //cas de base : liste.size() == 0, la methode se termine.
   }
   
   /**
    * Affiche les elements de liste, separes par des espaces, dans l'ordre.
    * Apres l'appel de cette methode, liste ne doit pas avoir ete modifiee.
    * @param liste la liste dont on veut afficher les elements
    *              ANT : liste n'est pas null.
    */
   public static void afficherListe2 (ArrayList<Integer> liste) {
      Integer element;
      if (liste.size() > 0) {
         element = liste.remove(0);
         System.out.print(element + " ");
         afficherListe2(liste);
         liste.add(0, element);
      }
      //cas de base : liste.size() == 0, la methode se termine.
   }
   
   /**
    * Affiche les elements de liste, separes par des espaces, dans l'ordre INVERSE.
    * Apres l'appel de cette methode, liste ne doit pas avoir ete modifiee.
    * @param liste la liste dont on veut afficher les elements
    *              ANT : liste n'est pas null.
    */
   public static void afficherListeInverse (List<Integer> liste) {
      if (liste.size() > 0) {
         afficherListeInverse(liste.subList(1, liste.size()));
         System.out.print(liste.get(0) + " ");
      }
      //cas de base : liste.size() == 0, la methode se termine.
   }
   
   /**
    * Affiche les elements de liste, separes par des espaces, dans l'ordre INVERSE.
    * Apres l'appel de cette methode, liste ne doit pas avoir ete modifiee.
    * @param liste la liste dont on veut afficher les elements
    *              ANT : liste n'est pas null.
    */
   public static void afficherListeInverse2 (ArrayList<Integer> liste) {
      Integer element;
      if (liste.size() > 0) {
         element = liste.remove(0);
         afficherListeInverse2(liste);
         System.out.print(element + " ");
         liste.add(0, element);
      }
      //cas de base : liste.size() == 0, la methode se termine.
   }
   
 
   /**
    * TESTS
    * @param args tableau vide 
    */
   public static void main (String [] args) {

      int [] t3 = {3};
      int [] t4 = {1, 2, 3, 4};
      String s1 = "";
      String s2 = "a";
      String s3 = "abcd";
      ArrayList<Integer> l1 = new ArrayList<>();
      ArrayList<Integer> l2 = new ArrayList<>();
      l2.add(1);
      ArrayList<Integer> l3 = new ArrayList<>();
      l3.add(1);
      l3.add(2);
      l3.add(3);
      l3.add(4);
      l3.add(null);
      
      System.out.println("AFFICHER TAB\n");
      afficherTab(t3, 0);     
      System.out.println(" (3 )");
      afficherTab(t4, 0);    
      System.out.println(" (1 2 3 4 )");
      afficherTab(t4, 1);     
      System.out.println(" (2 3 4 )");
      afficherTab(t4, 2);     
      System.out.println(" (3 4 )");
      afficherTab(t4, 3);     
      System.out.println(" (4 )");
      
      System.out.println("\nAFFICHER TAB INVERSE\n");
      afficherTabInverse(t3, 0);     
      System.out.println(" (3 )");
      afficherTabInverse(t4, 0);     
      System.out.println(" (4 3 2 1 )");
      afficherTabInverse(t4, 1);     
      System.out.println(" (4 3 2 )");
      afficherTabInverse(t4, 2);     
      System.out.println(" (4 3 )");
      afficherTabInverse(t4, 3);     
      System.out.println(" (4 )");
      
      System.out.println("\nAFFICHER CHAINE\n");
      afficherChaine(s1);     
      System.out.println("(n'affiche rien)");
      afficherChaine(s2);     
      System.out.println(" (a )");
      afficherChaine(s3);     
      System.out.println(" (a b c d )");
      
      System.out.println("\nAFFICHER CHAINE INVERSE\n");
      afficherChaineInverse(s1);     
      System.out.println("(n'affiche rien)");
      afficherChaineInverse(s2);     
      System.out.println(" (a )");
      afficherChaineInverse(s3);     
      System.out.println(" (d c b a )");
       
      System.out.println("\nAFFICHER LISTE\n");
      afficherListe(l1);     
      System.out.println("(n'affiche rien)");
      afficherListe(l2);     
      System.out.println(" (1 )");
      afficherListe(l3);     
      System.out.println(" (1 2 3 4 null )");
      
      
      System.out.println("\nAFFICHER LISTE 2\n");
      afficherListe2(l1);     
      System.out.println("(n'affiche rien)");
      afficherListe2(l2);     
      System.out.println(" (1 )");
      afficherListe2(l3);     
      System.out.println(" (1 2 3 4 null )");
      
      
      System.out.println("\nAFFICHER LISTE INVERSE\n");
      afficherListeInverse(l1);     
      System.out.println("(n'affiche rien)");
      afficherListeInverse(l2);     
      System.out.println(" (1 )");
      afficherListeInverse(l3);     
      System.out.println(" (null 4 3 2 1 )");
      
      
      System.out.println("\nAFFICHER LISTE INVERSE 2\n");
      afficherListeInverse2(l1);     
      System.out.println("(n'affiche rien)");
      afficherListeInverse2(l2);     
      System.out.println(" (1 )");
      afficherListeInverse2(l3);     
      System.out.println(" (null 4 3 2 1 )");
      
   }
   
}
