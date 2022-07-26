
package exemplesLambda.interfacesFonctionnellesStandardsDeJava;

import java.util.function.Predicate; 

/**
 * Exemple d'utilisation d'expression lambda de type Predicate (methode qui prend 
 * un parametre de type T et retourne un booleen)
 * @author Melanie Lord
 * @version juin 2020
 */
public class ExemplesPredicate { 
   
   /**
    * Utilisation de la methode test.
    */
   public static void exemple1() {

      //Creer un predicat qui teste si un Integer est paire.
      Predicate<Integer> estPaire = i -> (i % 2 == 0);

      //Appel de la methode test du predicat
      System.out.println(estPaire.test(10));  //true
      System.out.println(estPaire.test(9));   //false
   }

   /**
    * Utilisation de la methode "and" qui represente un "et logique" court-circuit 
    * entre deux predicats, et de la methode "negate" qui retourne un predicat 
    * representant la negation logique du predicat sur lequel elle est appelee.
    */
   public static void exemple2() {
      boolean resultat;
      
      //Creer deux predicats
      Predicate<Integer> plusGrandQueCinq = (i) -> i > 5;
      Predicate<Integer> plusPetitQueCinquante = (i) -> i < 50;
      
      //Appel de la methode and du predicat et test avec 15
      resultat = plusGrandQueCinq.and(plusPetitQueCinquante).test(15);
      System.out.println(resultat);  //true

      //Appel de la methode and du predicat, puis de la methode negate du predicat
      //resultant, et test avec 15 (chainage)
      resultat = plusGrandQueCinq.and(plusPetitQueCinquante).negate().test(15);
      System.out.println(resultat);  //false
   } 
   
   /**
    * Utilisation de la methode "or" qui represente un "ou logique" court-circuit 
    * entre deux predicats.
    */
   public static void exemple3() {
      boolean resultat;
      
      //Creer deux predicats
      Predicate<String> contientLettreA = (s) -> s.contains("A");
      Predicate<String> estDeLongueur10OuPlus = (s) -> s.length() >= 10;
      
      //Appel de la methode or du predicat
      resultat = contientLettreA.or(estDeLongueur10OuPlus).test("Allo");
      System.out.println(resultat);  //true

      //Appel de la methode or du predicat
      resultat = contientLettreA.or(estDeLongueur10OuPlus).test("Coucou");
      System.out.println(resultat);  //false
   } 
   
   private static void tester(String chaine, Predicate<String> predicat) {

      if (predicat.test(chaine)) {
         System.out.println("chaine OK");
      } else {
         System.out.println("chaine pas OK");
      }
   }

   /**
    * Passer un predicat en parametre a la methode tester.
    */
   public static void exemple4() {
      
      //Creer un predicat qui verifie que la chaine s n'est pas null, que sa longueur
      //est plus grande que 0 et qu'elle ne contient que des caracteres alphabetiques.
      Predicate<String> p = s -> {
         int i = 0;
         boolean ok = s != null && s.length() > 0;

         while (ok && i < s.length()) {
            ok = Character.isLetter(s.charAt(i));
            i++;
         }
         
         return ok;
      };
      
      //Tester plusieurs chaines avec p
      tester("albatros55", p);  //chaine pas OK
      tester("bazar", p);       //chaine OK   
      tester(null, p);          //chaine pas OK   
      
      //envoyer en parametre une expression lambda dont le type est infere 
      //selon le type du deuxieme parametre de la methode tester (Predicat<String>)
      tester("froid", s -> s != null && s.length() > 3);  //chaine OK
   } 

   public static void main(String [] args) {
      
      System.out.println("EXEMPLE 1");
      exemple1();
      
      System.out.println("\nEXEMPLE 2");
      exemple2();
      
      System.out.println("\nEXEMPLE 3");
      exemple3();
      
      System.out.println("\nEXEMPLE 4");
      exemple4();
   
   }

}
