
package threads.producteurConsommateur.parcAmusementAvecWaitNotify;

import java.util.Vector;

/**
 * Cette classe represente le producteur dans le probleme du 
 * producteur / consommateur.
 * 
 * Cette classe implemente Runnable et la methode run simule l'accueil de 
 * personnes voulant faire un tour de manege, en les placant dans la zone (file)
 * d'attente partagee avec le consommateur (TourDeManege).
 * 
 * La zone d'attente peut contenir un maximum de CAPACITE personnes.
 * 
 * @author Melanie Lord
 * @version Ete 2020
 */
public class AccueilManege implements Runnable {
   
   //File d'attente pour les personnes en attente de faire un tour de manege.
   private final Vector FILE_ATTENTE; //donnee partagee par plusieurs threads
   
   //La capacite de la file d'attente
   private final int CAPACITE_FILE;
  
   //Utilise pour calculer une duree aleatoire
   private static final int DELAI = 20;
   
   /**
    * Construit un AccueilManege avec la fileAttente et le capacite de cette 
    * file donnees en parametres.
    * 
    * @param fileAttente la file d'attente (partagee) dans laquelle placer les
    *        personnes se presentant a l'accueil pour faire un tour de manege.
    * @param capaciteFileAttente la capacite de la file d'attente.
    */
   public AccueilManege (Vector fileAttente, int capaciteFileAttente) {
      this.FILE_ATTENTE = fileAttente;
      this.CAPACITE_FILE = capaciteFileAttente;
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
         
         //System.out.println("Arrivee de la personne " + i);
         
         try {
            //Simule que les gens se presente a l'accueil a des intervalles 
            //de temps irreguliers et que ça prend un certain temps pour les
            //accueillir
            Thread.sleep((int) (DELAI * Math.random()));
            
            //On accueille i en le placant dans la zone d'attente si celle-ci
            //n'est pas pleine.
            accueillir(i);

         } catch (InterruptedException ex) {
            System.out.println("\n*** ERREUR SEVERE dans methode run de "
               + this.getClass().getSimpleName() + "\n");
         }
      }
   }
   
   /**
    * Accueille les personnes et les fait passer dans la file d'attente, si 
    * possible (si celle-ci n'est pas pleine), sinon, attend.
    * 
    * @param i represente la personne a accueillir.
    * @throws InterruptedException si un thread interrompt le thread courant
    */
   private void accueillir(int i) throws InterruptedException {

      //System.out.println("\nArrivee de la personne " + i);
      
      //on attend si la file d'attente est pleine
      while (FILE_ATTENTE.size() == CAPACITE_FILE) { //condition d'attente
         
         //Verrouiller la file avant d'executer le code dans ce bloc
         synchronized (FILE_ATTENTE) {

            System.out.println("\nLa file d'attente est pleine (" 
               + FILE_ATTENTE.size() + ") !\n   => "
               + Thread.currentThread().getName() + " est en attente\n");
            
            //en attente d'une notification sur l'objet FILE_ATTENTE.
            FILE_ATTENTE.wait();
         }
      }

      //Verrouiller la file avant d'executer le code dans ce bloc
      synchronized (FILE_ATTENTE) {
         System.out.println("Entree de la personne " + i + " dans la file d'attente");
         
         //inserer la personne i dans la file d'attente
         FILE_ATTENTE.add(i);
         
         //avertir les autres threads d'un changement d'etat de la file d'attente
         FILE_ATTENTE.notifyAll();
      }
   }
   
}
