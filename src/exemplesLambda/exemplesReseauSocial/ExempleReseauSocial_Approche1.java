
package exemplesLambda.exemplesReseauSocial;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 * Exemple tire et adapte des tutoriels Java d'Oracle.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#brandProdName)
 * 
 * APPROCHE NAIVE...
 * 
 * @author Melanie Lord
 * @version juillet 2020
 */
public class ExempleReseauSocial_Approche1 {
   
   //Pour tests
   private static List<Membre> creerReseau () {
      List<Membre> reseau = new ArrayList<>();
      reseau.add(new Membre("Nom1", LocalDate.parse("1987-02-12"), 'f', "c1@server.com"));
      reseau.add(new Membre("Nom2", LocalDate.parse("2011-11-23"), 'm', "c2@server.com"));
      reseau.add(new Membre("Nom3", LocalDate.parse("1991-05-04"), 'm', "c3@server.com"));
      reseau.add(new Membre("Nom4", LocalDate.parse("1978-07-09"), 'm', "c4@server.com"));
      reseau.add(new Membre("Nom5", LocalDate.parse("1981-12-01"), 'f', "c5@server.com"));
      reseau.add(new Membre("Nom6", LocalDate.parse("1990-09-29"), 'f', "c6@server.com"));
      reseau.add(new Membre("Nom7", LocalDate.parse("1981-06-14"), 'm', "c7@server.com"));
      reseau.add(new Membre("Nom8", LocalDate.parse("1973-02-27"), 'f', "c8@server.com"));
      reseau.add(new Membre("Nom9", LocalDate.parse("1995-08-19"), 'm', "c9@server.com"));
      reseau.add(new Membre("Nom10", LocalDate.parse("1996-04-03"), 'f', "c10@server.com"));
      
      return reseau;
   }
   
   /**
    * Affiche tous les membres du reseau qui sont plus ages que l'age donne.
    * @param reseau la liste des membres
    * @param age l'age minimum (non inclus) des membres affiches
    */
   public static void afficherMembrePlusAgeQue(List<Membre> reseau, int age) {
      for (Membre m : reseau) {
         if (m.getAge() > age) {
            m.afficher();
         }
      }
   }
   
   /**
    * Affiche tous les membres du reseau qui sont du genre donne.
    * @param reseau la liste des membres
    * @param genre le genre des membres affiches
    */
   public static void afficherMembreDontLeGenreEst(List<Membre> reseau, char genre) {
      for (Membre m : reseau) {
         if (m.getGenre() == genre) {
            m.afficher();
         }
      }
   }
   
   //etc.
   
   public static void main (String[] args) {
      //Creation d'un petit reseau social pour fin de tests.
      List<Membre> reseau = creerReseau();
      
      System.out.println("MEMBRES AGES DE PLUS DE 35 ANS");
      afficherMembrePlusAgeQue(reseau, 35);
      
      System.out.println("\nMEMBRES DONT LE GENRE EST FEMININ");
      afficherMembreDontLeGenreEst(reseau, 'f');
   
   }
 
   
   
}
