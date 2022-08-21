
package threads.exempleBanqueNonSynchro;

import java.util.Arrays;
import java.util.Locale;

/**
 * Modelisation d'une banque contenant un nombre donne de comptes bancaires
 * (dont la balance est representee par un double).
 * 
 * Exemple tire et adapte du livre :
 * Horstmann, Cay S. (2019) Core Java Volume I - Fundamentals (Core Series), 
 * Onzième édition,  Pearson Education. Édition du Kindle.

 * @author melanie lord
 * @version Ete 2020
 */
public class Banque {
   
   private double[] comptes;
   
   /**
    * Construit une banque avec nbrComptes comptes bancaires contenant chacun
    * montantInit dollars.
    * @param nbrComptes le nombre de comptes dans cette banque
    * @param montantInit le montant initial dans chaque compte
    */
   public Banque (int nbrComptes, double montantInit) {
      comptes = new double[nbrComptes];
      Arrays.fill(comptes, montantInit);  
   }
   
   /**
    * Transfere le montant donne du cpt1 vers cpt2.
    * @param cpt1 le compte duquel on veut transferer le montant donne
    * @param cpt2 le compte vers lequel on veut transferer le montant donne
    * @param montant le montant a transferer de cpt1 vers cpt2
    */
   public void transferer (int cpt1, int cpt2, double montant) {

      //ATTENTION : exemple non securitaire si multithread
      
      //Afficher le nom du thread courant
      System.out.println(Thread.currentThread().getName());
      
      //soustraire le montant a transferer de cpt1
      comptes[cpt1] -= montant;

      //Afficher les details du transfert
      System.out.printf
            (Locale.ENGLISH, "%10.2f de %d vers %d\n", montant, cpt1, cpt2);
      
      //Ajouter le montant a transferer dans cpt2
      comptes[cpt2] += montant;

      //Afficher la somme de tous les comptes (balance totale)
      System.out.printf
            (Locale.ENGLISH, "\nBALANCE TOTALE : %10.2f\n\n", getBalanceTotal());

   }
   
   /**
    * Calcule la balance totale (somme du montant de tous les comptes).
    * @return la balance totale de tous les comptes.
    */
   public double getBalanceTotal() {
      double somme = 0 ;
      
      for (double a : comptes) {
         somme += a;
      }
      return somme;
   }
   
   /**
    * Retourne le nombre de comptes dans cette banque.
    * @return le nombre de comptes dans cette banque
    */
   public int nbrComptes() {
      return comptes.length;
   }
   
}
