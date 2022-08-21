
package threads.producteurConsommateur.parcAmusementAvecBlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Cette classe represente le producteur dans le probleme du 
 * producteur / consommateur.
 * 
 * Cette classe implemente Runnable et la methode run simule l'accueil de 
 * personnes voulant faire un tour de manege, en les placant dans la zone (file)
 * d'attente partagee avec le consommateur (TourDeManege).
 * 
 * @author Melanie Lord
 * @version Ete 2020
 */
public class AccueilManege implements Runnable {
   
   //File d'attente partagee pour les personnes en attente de faire 
   //un tour de manege.
   private final BlockingQueue FILE_ATTENTE;

   //Utilise pour calculer une duree aleatoire
   private static final int DELAI = 20;
   
   /**
    * Constructeur qui construit un AccueilManege avec la fileAttente
    * donnee.
    * 
    * @param fileAttente la file d'attente (partagee) dans laquelle placer les
    *        personnes se presentant a l'accueil pour faire un tour de manege.
    */
   public AccueilManege (BlockingQueue fileAttente) {
      this.FILE_ATTENTE = fileAttente;
   }
   
   /**
    * Accueille les personnes interessees a faire un tour de manege.
    * Implementation de l'interface Runnable.
    */
   @Override
   public void run() {
      int i = 0;
      
      //Les personnes sont ici representees par des nombres (i). 
      
      while(true) {
         i++;
         
         System.out.println("Arrivee de la personne " + i);
         
         try {
            //Simule l'arrivee des personnes a l'accueil, a des intervalles 
            //de temps irreguliers
            Thread.sleep((int) (DELAI * Math.random()));
            
            //On accueille i en le placant dans la zone d'attente si celle-ci
            //n'est pas pleine.
            FILE_ATTENTE.put(i);  //attend automatiquement si file est pleine

         } catch (InterruptedException ex) {
            System.out.println("\n*** ERREUR SEVERE dans methode run de "
               + this.getClass().getSimpleName() + "\n");
         }
      }
   }
}
