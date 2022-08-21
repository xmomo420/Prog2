
package threads.producteurConsommateur.parcAmusementAvecBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Cette classe represente le consommateur dans le probleme du 
 * producteur / consommateur.
 * 
 * Cette classe implemente Runnable et la methode run simule les tours de manege
 * en retirant de la file d'attente partagee avec le producteur (AccueilManege), 
 * CAPACITE_MANEGE personnes a la fois pour remplir le manege et le faire 
 * tourner.
 * 
 * @author Melanie Lord
 * @version Ete 2020
 */
public class TourDeManege implements Runnable {

   //File d'attente partagee pour les personnes en attente de faire 
   //un tour de manege.
   private final BlockingQueue FILE_ATTENTE; 
   
   //La capacite du manege
   private final int CAPACITE_MANEGE;
   
   //Utilise pour calculer une duree aleatoire
   public static final int DELAI = 100;

   /**
    * Construit un TourDeManege avec la fileAttente et la capaciteManege 
    * donnees en parametres.
    * 
    * @param fileAttente la file d'attente qui contient les personnes en 
    *        attente de faire un tour de manege.
    * @param capaciteManege le nombre de personnes pour remplir le manege
    */
   public TourDeManege(BlockingQueue fileAttente, int capaciteManege) {
      this.FILE_ATTENTE = fileAttente;
      this.CAPACITE_MANEGE = capaciteManege;
   }

   /**
    * Fait faire un tour de manege a CAPACITE_MANEGES personnes se trouvant
    * dans la file d'attente (et les retire de la file).
    * Implementation de l'interface Runnable.
    */
   @Override
   public void run() {
      
      while (true) {
         try {
            //Simule la duree de l'entree des gens dans le maneige et 
            //le temps du tour de maneige
            Thread.sleep((int) (DELAI * Math.random()));
            
            System.out.println("\nTour de manege des personnes : " 
               + tourDeManege());

         } catch (InterruptedException ex) {
            System.out.println("\n*** ERREUR SEVERE dans methode run de "
               + this.getClass().getSimpleName() + "\n");
         }
      }
   }

   /**
    * Defile CAPACITE_MANEGE personnes de la file d'attente pour leur 
    * faire faire un tour de manege.
    * 
    * @return un chaine contenant les personnes defilees.
    * @throws InterruptedException si un thread interrompt le thread courant
    */
   private String tourDeManege() throws InterruptedException {
      
      String personnesDansManege;
      
      synchronized (FILE_ATTENTE) {
         
         personnesDansManege = "";

         //defiler CAPACITE_MANEGE personnes de la file d'attente
         //et former une chaine contenant les personnes pour retourner 
         //l'information.
         for (int i = 1 ; i <= CAPACITE_MANEGE ; i++) {
            personnesDansManege = personnesDansManege 
               + FILE_ATTENTE.take() + ", ";
         }
      }
      
      return personnesDansManege.substring(0, personnesDansManege.length() - 2);          

   }
   
}
