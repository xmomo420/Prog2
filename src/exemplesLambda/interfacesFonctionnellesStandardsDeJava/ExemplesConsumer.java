
package exemplesLambda.interfacesFonctionnellesStandardsDeJava;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Exemple d'utilisation d'expression lambda de type Consumer (methode qui prend 
 * un parametre et ne retourne rien)
 * @author Melanie Lord
 * @version juin 2020
 */
public class ExemplesConsumer {
   
   public static void exemple1() {
      
      Consumer<String> afficherAllo = s -> System.out.println("Allo " + s);
      Consumer<Integer> multPar2 = i -> System.out.println(i * 2);
      
      afficherAllo.accept("Bette");  //Allo Bette
      multPar2.accept(34);           //68
      
      //chainage de traitement
      afficherAllo.andThen(s -> System.out.println("Aurevoir " + s)).accept("Marcel");
      //Allo Marcel
      //Aurevoir Marcel
   }
   
   public static void exemple2() {
      
      List<Integer> listeExemple;
      
      //Elever chaque element de liste a la puissance 2
      Consumer<List<Integer>> puissance2 = liste -> {
         for (int i = 0 ; i < liste.size() ; i++) {
            liste.set(i, (int)Math.pow(liste.get(i), 2));
         }
      };
      
      //Retirer les elements plus grands que 100 de liste
      Consumer<List<Integer>> retirerPlusGrandsQue100 = liste -> {
         Iterator<Integer> it = liste.iterator();
         
         while (it.hasNext()) {
            if (it.next() > 100) {
               it.remove();
            }
         }
      };
      
      //Afficher les elements de la liste
      Consumer<List<Integer>> afficherTous = liste -> {
         for (Integer i : liste) {
            System.out.print(i + " ");
         }
      };

      listeExemple = creerListe(9, 4, 16, 8, 10, 15, 44, 1);
      
      //chainage de traitement
      puissance2.andThen(retirerPlusGrandsQue100).andThen(afficherTous)
         .accept(listeExemple);
      
   }
   
   //La methode suivante est une methode generique.
   //Methode generique : methode qui introduit ses propres types generiques de
   //parametres. Les parametres generiques n'existent que pour la methode 
   //dans laquelle ils sont declares.
   
   /**
    * Construit une List avec les elements recus.
    * @param <T> le type des elements recus
    * @param elements les elements a ajouter a la liste retournee.
    * @return une liste contenant les elements recus en parametres.
    */
   private static<T> List<T> creerListe(T... elements) {
      List<T> liste = new ArrayList<>();
      
      for (T elt : elements)
         liste.add(elt);
      
      return liste;
   }
   
   public static void main (String [] args) {
      System.out.println("EXEMPLE 1");
      exemple1();
      
      System.out.println("\nEXEMPLE 2");
      exemple2();
   }
   
}
