
package exemplesLambda.exemplesReseauSocial;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;

/**
 * Exemple tire et adapte des tutoriels Java d'Oracle.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#brandProdName)
 * 
 * UTILISATION SE L'INTERFACE FONCTIONNELLE CONSUMER
 * 
 * @author Melanie Lord
 * @version juillet 2020
 */
public class ExempleReseauSocial_AvecConsumer {
   
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
    * On applique le traitement donne a tous les membres du reseau donne qui 
    * sont selectionnes par le testeur donne.
    * @param reseau la liste des membres
    * @param testeur methode de test pour selectionne un membre
    * @param traitement traitement a applique aux membres selectionnes
    */
   public static void traiterMembresSelectionnes(List<Membre> reseau, 
                                                 Predicate<Membre> testeur,
                                                 Consumer<Membre> traitement) {
      for (Membre m : reseau) {
         if (testeur.test(m)) {
            traitement.accept(m);  //traite m 
         }
      }
   }
   
   public static void main (String[] args) {
      
      //Creation d'un petit reseau social pour fin de tests.
      List<Membre> reseau = creerReseau();
      List<Membre> membresSelectionnes = new ArrayList<>();

      System.out.println("AFFICHER LES MEMBRES AGES DE PLUS DE 35 ANS");
      traiterMembresSelectionnes(reseau, 
         m -> m.getAge() > 35, 
         m -> m.afficher());

      System.out.println("STOCKER LES MEMBRES AGES DE PLUS DE 35 ANS DANS UNE LISTE");
      traiterMembresSelectionnes(reseau, 
         m -> m.getAge() > 35, 
         m -> membresSelectionnes.add(m));

      System.out.println("AFFICHAGE DES MEMBRES DANS LA LISTE DES MEMBRES SELECTIONNES");
      System.out.println(membresSelectionnes);
   }   
}
