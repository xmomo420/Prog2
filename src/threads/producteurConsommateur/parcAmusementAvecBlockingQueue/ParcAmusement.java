
package threads.producteurConsommateur.parcAmusementAvecBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
 * L'implemenation est faite avec une BlockingQueue.
 * 
 * @author Melanie Lord
 * @version Ete 2020
 */
public class ParcAmusement {

   public static void main(String args[]) {
      
      final int CAPACITE_FILE = 20;
      final int CAPACITE_MANEGE = 5;
      
      //File d'attente partagee de capacite CAPACITE_FILE
      BlockingQueue fileAttente = new LinkedBlockingQueue(CAPACITE_FILE);
      
      //Creation les deux taches (Runnable) 
      
      //Represente la tache du producteur
      AccueilManege aManege
         = new AccueilManege(fileAttente);

      //Represente la tache du consommateur
      TourDeManege tManege
         = new TourDeManege(fileAttente, CAPACITE_MANEGE);

      //Creer un thread avec chacune des taches
      Thread threadAccueilManege = new Thread(aManege, "Accueil manege");

      Thread threadTourManege
         = new Thread(tManege, "Tour de manege");

      //Demarrer les 2 threads
      threadAccueilManege.start();
      threadTourManege.start();
   }

}
