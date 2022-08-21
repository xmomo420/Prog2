
package threads;

import java.util.Random;

/**
 * Exemple simple de construction et execution de threads.
 * @author Melanie Lord
 * @version Ete 2020
 */
public class ThreadSimpleAvecHeritage {
   
   public static final int MILLISEC = 300;
   
   
   public static void main (String[] args) {
      
      final Random rnd = new Random();
      
      //Classe Anonyme 
      Thread tache1 = new Thread ("tache 1") {

         @Override
         public void run () {
            //Affiche 10 lettres majuscules aleatoires (entre A et Z)
            try {
               for (int i = 0 ; i < 10 ; i++) {
                  System.out.println((char) ('1' + rnd.nextInt(9))); 
                  Thread.sleep(MILLISEC);
               }
               
               System.out.println(Thread.currentThread().getName() + " termine");

            } catch (InterruptedException e) {
                  
            }
         }
      };
      
      //Classe anonyme
      Thread tache2 = new Thread () {
         
         @Override
         public void run () {
            //Affiche 10 caracteres numeriques aleatoires (entre 1 et 9)
            try {
               for (int i = 0 ; i < 10 ; i++) {
                  System.out.println((char) ('A' + rnd.nextInt(9))); 
                  Thread.sleep(MILLISEC);
               }
               
               System.out.println(Thread.currentThread().getName() + " termine");

            } catch (InterruptedException e) {

            }
         }
      };
      
      tache1.start();
      tache2.start();
   } 
}
