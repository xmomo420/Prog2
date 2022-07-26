
/**
 * Exemples d'utilisation des methodes de fouille de la classe TechniquesRecherche.
 * 
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemples {
   
   public static final int [] tab1 = {23, 4, 10, 25, 9, 3, 9, 11, 32, 8, 13, 1, 7};
   public static final int [] tab2 = {3, 6, 7, 11, 14, 15, 16, 23, 29, 32, 45, 47, 50}; //13 elements
   public static final int [] tab3 = {3, 6, 7, 11, 14, 15, 16, 23, 29, 32, 45, 47, 50, 
         56, 58, 59, 61, 64, 68, 70, 75, 84, 92, 101, 102, 123}; //26 elemens
   
   /**
    * Les elements consultes pendant les recherches sont affiches.
    * 
    * @param args 
    */
   public static void main (String [] args){
      
      //RECH. SEQ. NON ORDONNEE
      TechniquesRecherche.rechercheSeqNonOrdonnee(23, tab1);
      //23
      
      TechniquesRecherche.rechercheSeqNonOrdonnee(7, tab1);
      //23  4  10  25  9  3  9  11  32  8  13  1  7 
      
      TechniquesRecherche.rechercheSeqNonOrdonnee(9, tab1);
      //23  4  10  25  9 
      
      TechniquesRecherche.rechercheSeqNonOrdonnee(0, tab1);
      //23  4  10  25  9  3  9  11  32  8  13  1  7 
      
      
      TechniquesRecherche.rechercheSeqNonOrdonnee(27, tab2);
      //3  6  7  11  14  15  16  23  29  32  45  47  50
      
      System.out.println("\n--------------------------------------/n");
      
      //RECH. SEQ. ORDONNEE
      TechniquesRecherche.rechercheSeqOrdonnee(27, tab2); //pas dans tab
      //3  6  7  11  14  15  16  23  29
      
      TechniquesRecherche.rechercheSeqOrdonnee(3, tab2);
      //3 
      
      TechniquesRecherche.rechercheSeqOrdonnee(50, tab2);
      //3  6  7  11  14  15  16  23  29  32  45  47  50 
      
      TechniquesRecherche.rechercheSeqOrdonnee(16, tab2);
      //3  6  7  11  14  15  16
      
      System.out.println("\n--------------------------------------/n");
      
      //RECH. BINAIRE
      TechniquesRecherche.rechercheBinaire(27, tab2); //pas dans tab
      //16  32  23  29
      
      TechniquesRecherche.rechercheBinaire(3, tab2);
      //16  7  3
      
      TechniquesRecherche.rechercheBinaire(50, tab2);
      //16  32  47  50
      
      TechniquesRecherche.rechercheBinaire(16, tab2);
      //16
      
      
      
      
      TechniquesRecherche.rechercheBinaire(3, tab3);
      //50  15  7  3 
      
      TechniquesRecherche.rechercheBinaire(123, tab3);
      //50  70  92  102  123
      
      TechniquesRecherche.rechercheBinaire(92, tab3);
      //50  70  92 
      
      System.out.println("\n--------------------------------------/n");
      
      //RECH. BINAIRE RECURSIVE
      TechniquesRecherche.rechercheBinaireRec(27, tab2, 0, 12); //pas dans tab
      //16  32  23  29
      
      System.out.println();
      
      TechniquesRecherche.rechercheBinaireRec(3, tab2, 0, 12);
      //16  7  3
      
      System.out.println();
      
      TechniquesRecherche.rechercheBinaireRec(50, tab2, 0, 12);
      //16  32  47  50
      
      System.out.println();
      
      TechniquesRecherche.rechercheBinaireRec(16, tab2, 0, 12);
      //16
      
      System.out.println();
      
      TechniquesRecherche.rechercheBinaireRec(3, tab3, 0, 25);
      //50  15  7  3 
      
      System.out.println();
      
      TechniquesRecherche.rechercheBinaireRec(123, tab3, 0, 25);
      //50  70  92  102  123
      
      System.out.println();
      
      TechniquesRecherche.rechercheBinaireRec(92, tab3, 0, 25);
      //50  70  92 
      
      System.out.println();
      
      
   }
   
}
