
package threads;

import java.util.Random;

/**
 * Exemple simple de construction et execution de threads, avec Runnable.
 * @author Melanie Lord
 * @version Ete 2020
 */
public class ThreadSimpleAvecRunnable {
   
   public static final int MILLISEC = 300;
   
   public static void main(String[] args) {
      
      final Random rnd = new Random();
   
      
      Runnable tache1 = () -> {
         
         //Affiche 10 lettres majuscules aleatoires (entre A et Z)
         try {
            for (int i = 0 ; i < 10 ; i++) {
               System.out.println((char) ('A' + rnd.nextInt(26))); 
               Thread.sleep(MILLISEC);
            }
            
            System.out.println(Thread.currentThread().getName() + " termine");
            
         } catch (InterruptedException e) {
         
         }
      };
      
      Runnable tache2 = () -> {
         //Affiche 10 caracteres numeriques aleatoires (entre 1 et 9)
         try {
            for (int i = 0 ; i < 10 ; i++) {
               System.out.println((char) ('1' + rnd.nextInt(9))); 
               Thread.sleep(MILLISEC);
            }
            
            System.out.println(Thread.currentThread().getName() + " termine");
            
         } catch (InterruptedException e) {
         
         }
        
      };
      
      new Thread(tache1, "tache1").start();
      new Thread(tache2).start();
   }
   
}
