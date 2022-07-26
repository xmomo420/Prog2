
package exemplesLambda.interfacesFonctionnellesStandardsDeJava;


import java.util.function.Supplier;
import java.time.LocalDate;

/**
 * Exemple d'utilisation d'expression lambda de type Supplier (methode qui ne prend 
 * aucun parametre et retourne un resultat de type T)
 * @author Melanie Lord
 * @version juin 2020
 */
public class ExemplesSupplier {
   
   public static void exemples() {
      
      //retourne un nombre aleatoire entre 1 et 10
      Supplier<Integer> nombreAleaEntre1Et10 = 
            () -> (int)(Math.random() * (10 - 1) + 1.5);
      
      //Appel de la methode get de Supplier et affichage de la valeur retournee
      System.out.println("Nombre entre 1 et 10 : " + nombreAleaEntre1Et10.get());
      
      System.out.println("------------------------------");
      
      //Retourne le nom du jour actuel
      Supplier<String> jourActuel = 
            () -> {
               int jourNum = LocalDate.now().getDayOfWeek().getValue();
               String jour = "";
               
               switch(jourNum) {
                  case 1 : jour = "Lundi";
                     break;
                  case 2 : jour = "Mardi";
                     break;
                  case 3 : jour = "Mercredi";
                     break;
                  case 4 : jour = "Jeudi";
                     break;
                  case 5 : jour = "Vendredi";
                     break;
                  case 6 : jour = "Samedi";
                     break;
                  case 7 : jour = "Dimanche";
                     break;
               }
               return jour;
            };
      
      //Appel de la methode get de Supplier et affichage de la valeur retournee
      System.out.println("Nom du jour actuel : " + jourActuel.get());
   }

   public static void main (String [] args) {
      System.out.println("EXEMPLES\n");
      exemples();
      System.out.println();
   }
   
}
