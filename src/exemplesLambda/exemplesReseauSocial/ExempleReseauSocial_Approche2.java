
package exemplesLambda.exemplesReseauSocial;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 * Exemple tire et adapte des tutoriels Java d'Oracle.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#brandProdName)
 * 
 * UTILISATION DE CLASSES ANONYMES
 * 
 * @author Melanie Lord
 * @version juillet 2020
 */
public class ExempleReseauSocial_Approche2 {
   
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

   public interface ITesteurMembre {
      /**
       * Teste si le membre est selectionne ou non.
       * @param m le membre a tester
       * @return true si le membre m est selectionne, false sinon.
       */
      boolean tester(Membre m);
   }

   /**
    * Affiche les membres du reseau donne s'ils sont selectionnes par le testeur 
    * donne.
    * @param reseau la liste des membres
    * @param testeur la methode pour selectionner ou non un membre.
    */
   public static void afficherMembresSelectionnes(List<Membre> reseau, 
                                                  ITesteurMembre testeur) {
      for (Membre m : reseau) {
         if (testeur.tester(m)) {
            m.afficher();
         }
      }
   }
   
   public static void main (String[] args) {
      
      //Creation d'un petit reseau social pour fin de tests.
      List<Membre> reseau = creerReseau();
      
      System.out.println("MEMBRES AGES DE PLUS DE 35 ANS");
      
      //Envoyer une instance d'une classe anonyme en parametre de la methode 
      //afficherMembresSelectionnes pour afficher les membres ayant plus de 35 ans
      
      afficherMembresSelectionnes(reseau, new ITesteurMembre() {
         @Override
         public boolean tester(Membre m) {
            return m.getAge() > 35;
         }
      });
      
      System.out.println("\nMEMBRES DONT LE GENRE EST FEMININ");
      
      //Creer une instance d'une classe anonyme et l'affecter a une variable.
      //Envoyer ensuite cette variable en parametre a la methode 
      //afficherMembresSelectionnes pour afficher les membres feminins.
      
      ITesteurMembre testeurGenre =  new ITesteurMembre() {
         @Override
         public boolean tester(Membre m) {
            return m.getGenre() == 'f';
         }
      };
      
      afficherMembresSelectionnes(reseau, testeurGenre);
   
   }
}
