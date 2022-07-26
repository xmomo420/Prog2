package listeSimpleAvecIterateur;

import java.util.Iterator;

/**
 * Exemples d'utilisation de la methode iterator et de la boucle for amelioree
 * avec la classe ListeSimpleAvecIterateur.
 *
 * @author melanie lord
 * @version mai 2017
 */
public class UtilisationIterateurDeListeAvecIterateur {

   public static void main(String[] args) {

      ListeAvecIterateur<String> liste = new ListeSimpleAvecIterateur<>();

      Iterator<String> it; //les elements a parcourir sont de type String

      String element;

      //ajout d'elements a liste
      liste.insererFin("allo");
      liste.insererFin("coucou");
      liste.insererFin("bye");
      liste.insererFin("ciao");
      liste.insererFin("salut");

      //--------------------------------
      //UTILISATION DE L'ITERATEUR       
      //--------------------------------
      
      
      it = liste.iterator();           //obtenir l’iterateur

      //Parcourir les elements de la liste, et les afficher
      while (it.hasNext()) {
         System.out.print(it.next() + " ");
      }
      //affiche : allo  coucou  bye  ciao  salut

      //--------------------------------------------------------------------
      
      System.out.println();
      
      it = liste.iterator();           //obtenir l’iterateur

      //Parcourir les elements (chaines de caracteres) de la liste et 
      //supprimer les chaines de moins de 5 caractères.
      while (it.hasNext()) {
         element = it.next();
         if (element.length() <= 4) {
            it.remove();	             //utilisation de la methode remove
         }
      }
      System.out.println(liste);  //affiche : coucou  salut

      
      //-------------------------------------------------
      //UTILISATION DE LA BOUCLE FOR AMELIOREE (FOR EACH)        
      //-------------------------------------------------
      
      
      //recreation de la liste
      liste = new ListeSimpleAvecIterateur<>();
      liste.insererFin("allo");
      liste.insererFin("coucou");
      liste.insererFin("bye");
      liste.insererFin("ciao");
      liste.insererFin("salut");

      //parcourir les elements avec une boucle for amelioree, et les afficher
      for (String s : liste) {
         System.out.print(s + "  ");
      }
      //affiche : allo  coucou  bye  ciao  salut

   }

}
