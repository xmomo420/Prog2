
package threads.exempleBanqueSynchro;

/**
 * Exemple de synchronisation dans une application multithread, pour eviter 
 * la corruption des donnees.
 * 
 * Exemple tire et adapte du livre :
 * Horstmann, Cay S. (2019) Core Java Volume I - Fundamentals (Core Series), 
 * Onzième édition,  Pearson Education. Édition du Kindle.
 * 
 * @author melanie lord
 * @version Ete 2020
 */
public class ExempleBanqueSynchro {
   
   public static final int NBR_COMPTES = 100;
   public static final double BALANCE_INIT = 1000;
   public static final double MONTANT_MAX = 1000;
   public static final int DELAI = 10;
   
   public static void main(String[] args) {
      Runnable r;
      
      //Creation d'une banque avec NBR_COMPTES comptes contenant chacun
      //BALANCE_INIT (balance totale : 100 * 1000 = 100000)
      Banque banque = new Banque(NBR_COMPTES, BALANCE_INIT);

      for (int i = 0 ; i < NBR_COMPTES ; i++) {
         //le compte a partir duquel on veut transferer un monant
         int cpt1 = i;  //effectivement final pour etre accessible dans
                        //l'expression lamda ci-dessous.

         r = () -> {
            int cpt2;
            double montant;
            
            try {
               
               //s'execute a l'infini
               while(true) {
                  
                  //Choisir un montant a transferer, au hasard
                  montant = MONTANT_MAX * Math.random();
                  
                  //Choisir un compte vers lequel transferer le monant, au hasard 
                  cpt2 = (int)(banque.nbrComptes() * Math.random());

                  //------------------------------------------------
                  //methode sensible pour la corruption des donnees
                  
                  //transferer montant de cpt1 vers cpt2
                  banque.transferer(cpt1, cpt2, montant);

                  //------------------------------------------------
                  
                  Thread.sleep((int) (DELAI * Math.random()));
               }
         
            } catch (InterruptedException e) {

            }
         
         };
         
         //Creer un nouveau thread a chaque tour de boucle
         new Thread(r, "[Thread-" + i + "]").start(); 
      }

   }
   
}
