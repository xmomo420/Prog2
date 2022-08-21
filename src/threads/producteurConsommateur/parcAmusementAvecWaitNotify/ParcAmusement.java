
package threads.producteurConsommateur.parcAmusementAvecWaitNotify;

import java.util.Vector;

/**
 * Exemple du probleme producteur/consommateur dans le contexte d'un 
 * parc d'amusement. On simule la gestion d'un manege dans ce parc.
 * 
 * Le producteur est la tache d'accueillir les personnes desirant faire 
 * un tour de manege et de les placer dans une file d'attente.
 * 
 * Le consommateur est la tache de retirer les personnes de la file d'attente
 * pour remplir le manege leur faire faire un tour.
 * 
 * L'implemenation est faite avec le mecanisme wait / notify
 * 
 * @author Melanie Lord
 * @version Ete 2020
 */
public class ParcAmusement {

   public static void main(String args[]) {
      
      final int CAPACITE_FILE = 20;
      final int CAPACITE_MANEGE = 5;
      
      //Classe Vector : comme une ArrayList, mais synchronisee.
      //Note : cette collection est desuete. Nous verrons une autre maniere 
      //       de faire en utilisant BlockingQueue.
      Vector fileAttente = new Vector();

      //Creation les deux taches (Runnable) 
      
      //Represente la tache du producteur
      AccueilManege aManege
         = new AccueilManege(fileAttente, CAPACITE_FILE);

      //Represente la tache du consommateur   
      TourDeManege tManege
         = new TourDeManege(fileAttente, CAPACITE_FILE, CAPACITE_MANEGE);

      //Creer un thread avec chacune des taches
      Thread threadAccueilManege = new Thread(aManege, "Accueil manege");

      Thread threadTourManege
         = new Thread(tManege, "Tour de manege");

      //Demarrer les 2 threads
      threadAccueilManege.start();
      threadTourManege.start();
   }

}
