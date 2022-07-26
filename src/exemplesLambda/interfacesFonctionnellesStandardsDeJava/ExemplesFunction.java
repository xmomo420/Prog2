
package exemplesLambda.interfacesFonctionnellesStandardsDeJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Exemples d'utilisation d'expression lambda de type Function (methode qui prend 
 * un parametre de type T et retourne un resultat de type R)
 * @author Melanie Lord
 * @version juin 2020
 */
public class ExemplesFunction {
   
   /**
    * Exemple avec la methode fonctionnelle apply.
    */
   public static void exemple1() {
      
      //Creation d'une liste d'entiers
      List<Integer> liste = Arrays.asList(100, 123, 45, 10, 23, 23, 37, 99, 56);
      
      //fonction qui calcule l'aire d'un cercler de rayon r
      Function<Integer, Double> aireCercle = r -> Math.PI * Math.pow(r, 2);
      
      //Calcul et affichage de l'aire d'un cercle de rayon 12
      System.out.println("Aire cercle : " + aireCercle.apply(12));
      
      System.out.println("------------------------------");
      
      //fonction qui calcule la moyenne des entiers contenus dans une List
      //On suppose l non null.
      Function<List<Integer>, Double> moyenne = l -> {
         int somme = 0;
         double moy = 0;
         int cpt = 0;
         
         for (int i = 0 ; i < l.size() ; i++) {
            if (l.get(i) != null) {
               somme = somme + l.get(i);
               cpt++;
            }
         }
         
         if (cpt != 0) {
            moy = (double)somme / cpt;
         }
         
         return moy;
      };
      
      //Calcul et affichage de la moyenne des elements de liste
      System.out.println("Moyenne : " + moyenne.apply(liste));
   }
   
   /**
    * Exemples avec la methode par defaut andThen.
    */
   public static void exemple2() {
   
      Function<Double, Double> auCarre = x -> Math.pow(x, 2);
      Function<Double, Double> moinsUn = x -> x - 1;
      
      Function<Double, Double> moinsUnEtAuCarre = auCarre.compose(moinsUn);
      Function<Double, Double> auCarreEtMoinsUn = auCarre.andThen(moinsUn);
      Function<Double, Double> auCarreEtMoinsUnEtAuCarre = 
                                          auCarreEtMoinsUn.andThen(auCarre);
      
      System.out.println(auCarreEtMoinsUn.apply(4.0) );  //4.0 au carre - 1 = 15.0
   
      System.out.println(moinsUnEtAuCarre.apply(4.0) );  //(4.0 - 1) au carre = 9.0

      System.out.println(auCarreEtMoinsUnEtAuCarre.apply(4.0) );  //4.0 au carre - 1 = 15.0
                                                                  //15.0 au carre = 225.0
   }
   
   
   
   public static void main(String [] args) {
      
      System.out.println("EXEMPLE 1");
      exemple1();
      
      System.out.println("\nEXEMPLE 2");
      exemple2();
   }

   
}
