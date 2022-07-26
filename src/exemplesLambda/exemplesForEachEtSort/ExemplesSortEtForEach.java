
package exemplesLambda.exemplesForEachEtSort;

import java.util.Arrays;
import java.util.List;

/**
 * 1) Exemples d'utilisation d'expressions lambda de type Consumer<T> avec la methode
 *    forEach de Iterable
 * 2) Exemples d'utilisation d'expressions lambda de type Comparator<T> avec la methode
 *    sort de List.
 * @author Melanie Lord
 * @version juin 2020
 */
public class ExemplesSortEtForEach {
   private static Etudiant e1 = new Etudiant("nom3", "prenom1", 19, "AAAA00000000", 2.8);
   private static Etudiant e2 = new Etudiant("nom1", "prenom2", 23, "DDDD00000000", 3.7);
   private static Etudiant e3 = new Etudiant("nom5", "prenom3", 32, "BBBB00000000", 2.5);
   private static Etudiant e4 = new Etudiant("nom2", "prenom4", 21, "GGGG00000000", 4.15);
   private static Etudiant e5 = new Etudiant("nom4", "prenom5", 28, "CCCC00000000", 4.0);
   
   /**
    * Exemples de l'utilisation de la methode forEach de l'interface List, avec des 
    * expressions lambda.
    */
   public static void exemplesForEach() {
      
      List<Etudiant> listeEtudiants;

      System.out.println("\nEXEMPLES DE L'UTILISATION DE LA METHODE FOR EACH\n");

      listeEtudiants = Arrays.asList(e1, e2, e3, e4, e5);
      System.out.println("AFFICHER LE NOM DE CHAQUE ETUDIANT");

      //afficher le nom des étudiants dans la liste
      listeEtudiants.forEach(e -> System.out.print(e.getNom() + " "));

      System.out.println("\n----------------------------------");

      System.out.println("AUGMENTER DE 0.1 LA  MOY. CUMUL. DE CHAQUE ETUDIANT DONT LA MOY. CUMUL. < 3");

      //Augmenter la moyenne cumulative de 0.1 pour tous les etudiants dont la 
      //moyenne cumulative est plus petite que 3.
      listeEtudiants.forEach(e -> {
         if (e.getMoyCumul() < 3) 
            e.setMoyCumul(e.getMoyCumul() + 0.1);
      });

      //Afficher la liste pour voir le resultat
      listeEtudiants.forEach(e -> System.out.print(e + " | "));
      System.out.println();
   }
   
   /**
    * Exemples de l'utilisation de la methode sort de l'interface List, avec des 
    * expressions lambda.
    */
   public static void exemplesSort() {
      List<Etudiant> listeEtudiants;
      
      System.out.println("\nEXEMPLES DE L'UTILISATION DE LA METHODE SORT\n");
      
      listeEtudiants = Arrays.asList(e1, e2, e3, e4, e5);
      System.out.println("TRIER PAR NOM...");
      System.out.println("Liste avant : " + listeEtudiants);
      
      //trier par nom
      listeEtudiants.sort(
         (etud1, etud2) -> etud1.getNom().compareTo(etud2.getNom())
      );

      System.out.println("Liste apres : " + listeEtudiants);
      
      System.out.println("----------------------------------");

      listeEtudiants = Arrays.asList(e1, e2, e3, e4, e5);
      System.out.println("TRIER PAR MOYENNE CUMULATIVE...");
      System.out.println("Liste avant : " + listeEtudiants);

      //trier par moyenne cumulative
      listeEtudiants.sort(
         (etud1, etud2) -> {
            int rep = 1;

            if (etud1.getMoyCumul() < etud2.getMoyCumul())
               rep = -1;
            else if (etud1.getMoyCumul() == etud2.getMoyCumul())
               rep = 0;

            return rep;
         }
      );

      System.out.println("Liste apres : " + listeEtudiants);
      
      System.out.println("----------------------------------");

      listeEtudiants = Arrays.asList(e1, e2, e3, e4, e5);
      System.out.println("TRIER PAR AGE...");
      System.out.println("Liste avant : " + listeEtudiants);

      //trier par age
      listeEtudiants.sort(
         (etud1, etud2) -> {
            int rep = 1;

            if (etud1.getAge() < etud2.getAge())
               rep = -1;
            else if (etud1.getAge() == etud2.getAge())
               rep = 0;

            return rep;
         }
      );

      System.out.println("Liste apres : " + listeEtudiants);

   }
   
   public static void main(String[] args) {
      
      exemplesForEach();
      
      exemplesSort();
   }
   
}


