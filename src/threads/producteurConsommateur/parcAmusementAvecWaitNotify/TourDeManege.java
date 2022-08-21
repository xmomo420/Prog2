
package threads.producteurConsommateur.parcAmusementAvecWaitNotify;

import java.util.Vector;

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
   
   
   //File d'attente pour les personnes en attente de faire un tour de manege.
   private final Vector FILE_ATTENTE; //donnee partagee entre plusieurs threads
   
   //La capacite de la file d'attente
   private final int CAPACITE_FILE;
   
   //La capacite du maneige
   private final int CAPACITE_MANEGE;
   
   //Utilise pour calculer une duree aleatoire
   public static final int DELAI = 100;

   public TourDeManege(Vector fileAttente, int capaciteFile, 
                       int capaciteManege) {
      this.FILE_ATTENTE = fileAttente;
      this.CAPACITE_FILE = capaciteFile;
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
            
            System.out.println("\nTOUR DE MANEGE des personnes : " 
               + tourDeManege() + "\n");

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
    * @return une chaine contenant les personnes defilees.
    * @throws InterruptedException si un thread interrompt le thread courant
    */
   private String tourDeManege() throws InterruptedException {
      
      String personnesDansManege;
      
      //Attend si la file d'attente ne contient pas au moins CAPACITE_MANEGE 
      //personnes 
      while (FILE_ATTENTE.size() < CAPACITE_MANEGE) {  //condition d'attente
         
         synchronized (FILE_ATTENTE) {
            
            System.out.println("\nLa file d'attente ne contient pas au moins " 
               + CAPACITE_MANEGE + " personnes (" 
               + FILE_ATTENTE.size() + ") !\n  => "
               + Thread.currentThread().getName() + " est en attente\n");

            FILE_ATTENTE.wait();
         }
      }

      //Sinon, on defile CAPACITE_MANEGE personnes pour leur faire faire un 
      //tour de manege
      synchronized (FILE_ATTENTE) {
         personnesDansManege = "";
         
         //defiler CAPACITE_MANEGE personnes de la file d'attente
         //et former une chaine contenant les personnes pour retourner 
         //l'information.
         for (int i = 1 ; i <= CAPACITE_MANEGE ; i++) {
            personnesDansManege = personnesDansManege 
               + FILE_ATTENTE.remove(0) + ", ";
         }
         
         FILE_ATTENTE.notifyAll();  //Notifer les autres threads en attente
         
         //Seulement pour que la methode appelante obtienne l'information des 
         //personnes defilees et puisse les afficher.
         return personnesDansManege.substring(0, personnesDansManege.length() - 2);         
      }
   }
   
}
