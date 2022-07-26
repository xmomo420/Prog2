
/**
 * Techniques de recherche.
 *
 * @author Melanie Lord
 * @version novembre 2013
 */
public class TechniquesRecherche {

   /**
    * Effectue une fouille sequentielle dans un tableau non ordonne.
    *
    * @param elem l'element a chercher
    * @param tab le tableau ou chercher
    * @return la position de la premiere occurrence dans tab ou se trouve elem,
    * -1 si absent
    */
   public static int rechercheSeqNonOrdonnee(int elem, int[] tab) {
      int i = 0;
      int reponse = -1;

      if (tab != null && tab.length > 0) {
         while (i < tab.length && tab[i] != elem) {
            
            //affiche les elements consultes (pour tests)
            System.out.print(tab[i] + "  ");
            
            i++;
         }
         if (i < tab.length) {
            reponse = i;
            
            //affiche le dernier element consulte (pour tests)
            System.out.print(tab[i] + "  ");
         }
      }
      System.out.println();
      return reponse;
   }

   /**
    * Effectue une fouille sequentielle dans un tableau ordonne (croissant).
    *
    * @param elem l'element a chercher
    * @param tab le tableau ou chercher Antecedent : tab doit etre trie en ordre
    * croissant.
    * @return la position de la premiere occurrence dans tab ou se trouve elem,
    * -1 si absent.
    */
   public static int rechercheSeqOrdonnee(int elem, int[] tab) {
      int reponse = -1;
      int i = 0;
      if (tab != null && tab.length > 0) {
         while (i < tab.length && tab[i] < elem) {
            
            //affiche les elements consultes (pour tests)
            System.out.print(tab[i] + "  ");
            i++;
         }
         
         //affiche le dernier element consulte (pour tests)
         if (i < tab.length) {
            System.out.print(tab[i] + "  ");
         }

         if (i < tab.length && tab[i] == elem) {
            reponse = i;
         }
      }
      System.out.println();
      return reponse;
   }

   /**
    * Effectue une fouille binaire dans un tableau ordonne (croissant). Version
    * itérative.
    *
    * @param elem l'element a chercher
    * @param tab le tableau ou chercher Antecedent : tab doit etre trie en ordre
    * croissant.
    * @return la position d'une occurrence dans tab ou se trouve elem, -1 si
    * absent
    */
   public static int rechercheBinaire(int elem, int[] tab) {
      int premier = 0;
      int dernier = tab.length - 1;
      int milieu = -1;
      boolean trouve = false;

      while (premier <= dernier && !trouve) {
         milieu = (premier + dernier) / 2;

         //afficher l'element consulte (pour tests)
         System.out.print(tab[milieu] + "  ");

         if (tab[milieu] == elem) {
            trouve = true;
         } else if (tab[milieu] < elem) {
            premier = milieu + 1;
         } else {
            dernier = milieu - 1;
         }
      }

      if (!trouve) {
         milieu = -1;
      }

      System.out.println();
      return milieu;
   }

   /**
    * Effectue une fouille binaire dans un tableau ordonne (croissant).
    *
    * --- Version récursive ---
    *
    * @param elem l'element a chercher
    * @param tab le tableau ou chercher Antecedent : tab doit etre trie en ordre
    * croissant
    * @param premier l'indice du premier element de la portion du tab traitee
    * @param dernier l'indice du dernier element de la portion du tab traitee
    * @return la position d'une occurrence dans tab ou se trouve elem, -1 si
    * absent
    */
   public static int rechercheBinaireRec(int elem, int[] tab, int premier, int dernier) {

      int milieu = (premier + dernier) / 2;

      if (premier <= dernier) {

         //affiche l'element consulte (pour tests)
         System.out.print(tab[milieu] + "  ");

         if (tab[milieu] > elem) {
            milieu = rechercheBinaireRec(elem, tab, premier, milieu - 1);

         } else if (tab[milieu] < elem) {
            milieu = rechercheBinaireRec(elem, tab, milieu + 1, dernier);
         }

      } else {
         milieu = -1;
      }

      return milieu;
   }

   //pour tests
   public static void main(String[] args) {
      /*
      int[] t = new int[900];
      for (int i = 0; i < 900; i++) {
         t[i] = i;
      }

      rechercheBinaire(660, t);
      */
      
      int[] tab = {12, 3, 45, 2, 6, 7, 8, 2, 4, 12, 34, 7, 19, 23};
      int[] tab2 = {1, 3, 4, 10, 23, 24, 25, 32, 33, 38, 41, 44, 59, 60};
      int[] tab3 = new int[15];
      int[] tab4 = new int[100000];

      for (int i = 1; i < tab4.length; i++) {
         if (i < 15) {
            tab3[i] = i;
         }
         tab4[i] = i;
      }

      System.out.println("\nRECHERCHE SEQ NON ORDONNEE :\n");
      System.out.println(rechercheSeqNonOrdonnee(12, tab)); //12 
      //0

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqNonOrdonnee(23, tab)); 
      //12  3  45  2  6  7  8  2  4  12  34  7  19  23 
      //13

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqNonOrdonnee(7, tab));  
      //12  3  45  2  6  7  
      //5

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqNonOrdonnee(11, tab)); 
      //12  3  45  2  6  7  8  2  4  12  34  7  19  23 
      //-1
      System.out.println("\nRECHERCHE SEQ ORDONNEE :\n");
      System.out.println(rechercheSeqOrdonnee(1, tab2));  
      //1
      //0                            

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqOrdonnee(60, tab2)); 
      //1  3  4  10  23  24  25  32  33  38  41  44  59  60
      //13

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqOrdonnee(25, tab2)); 
      //1  3  4  10  23  24  25
      //6

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqOrdonnee(11, tab2));  
      //1  3  4  10  23
      //-1

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheSeqOrdonnee(-1, tab2));  
      //1
      //-1

      System.out.println("\nRECHERCHE BINAIRE :\n");
      
      System.out.println(rechercheBinaire(1, tab2));
      System.out.println(rechercheBinaireRec(1, tab2, 0, 13));

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheBinaire(60, tab2));
      System.out.println(rechercheBinaireRec(60, tab2, 0, 13));

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheBinaire(25, tab2));
      System.out.println(rechercheBinaireRec(25, tab2, 0, 13));

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheBinaire(11, tab2));
      System.out.println(rechercheBinaireRec(11, tab2, 0, 13));

      System.out.println("-----------------------------------\n");
      System.out.println(rechercheBinaire(-1, tab2));
      System.out.println(rechercheBinaireRec(-1, tab2, 0, 13));

      System.out.println("-----------------------------------\n");
      rechercheBinaire(20, tab3);
      
      System.out.println("-----------------------------------\n");
      rechercheBinaire(100200, tab4);
      
      int[] tt = {6, 10, 11, 13, 20, 21, 22, 27, 29, 33, 35, 36, 43, 44, 50, 57, 58, 59, 62, 65};
      rechercheBinaire(12, tt);
   }
}
