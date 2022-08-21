package utilisationPileFile;

import java.util.ArrayList;

/**
 * La classe FileArrayList implante l'interface File. L'implantation est basee
 * sur les service de ArrayList
 * Cours : INF2120
 *
 * @author Louise Laforest
 * @version fevrier 2006, fevrier 2011, 2014 (Melanie Lord)
 * @param <T> le type generique des elements dans la file.
 */
public class FileArrayList<T> implements File<T> {

  // ------------------------------------------------------
   // Liste contenant les objets de la file.
   // Choix d'implementation :
   // Le debut de la file est en debut de liste,
   // la fin de la file est en fin de liste.
   // ------------------------------------------------------
   // liste vide
   private ArrayList<T> liste = new ArrayList<>();

   /**
    * Teste si la file est vide
    *
    * @return true si aucun element false autrement
    */
   @Override
   public boolean estVide() {
      return liste.isEmpty();
   }

   /**
    * Ajoute un nouvel element en fin de file
    *
    * @param element l'element a placer en file
    */
   @Override
   public void enfiler(T element) {
      // ajout en fin de liste
      liste.add(element);
   }

   /**
    * Retire l'element au debut de la file
    *
    * @return la reference de l'objet retire
    * @throws ExceptionFileVide si la file est vide avant l'appel
    */
   @Override
   public T defiler() {
      T reponse = premier();
      // retrait en debut de liste
      liste.remove(0);
      return reponse;
   }

   /**
    * Retourne la reference de l'element au debut de la file, sans le retirer de
    * la file
    *
    * @return la reference de l'element au debut de la file
    * @throws ExceptionFileVide si la file est vide avant l'appel
    */
   @Override
   public T premier() {
      T reponse = null;
      if (estVide()) {
         throw new ExceptionFileVide();
      } else {
         // consultation en debut de liste
         reponse = liste.get(0);
      }
      return reponse;
   }

   /**
    * Retire tous les elements de la file Aucun effet si la file est deja vide
    */
   @Override
   public void vider() {
      liste.clear();
   }

   /**
    * Retourne le nombre d'elements contenus dans la file
    *
    * @return le nombre d'elements
    */
   @Override
   public int taille() {
      return liste.size();
   }

   //--------------------------------
   // SERVICES SUPPLEMENTAIRES
   // -------------------------------
   /**
    * Retire les n elements en debut de file.
    *
    * @param n le nombre d'elements a retirer de cette file
    * @return un tableau de taille n contenant les n elements retires. Le
    * premier element retire se trouve en position 0, le deuxieme en position
    * 1... du tableau retourne.
    * @throws ExceptionFileVide si la file est vide avant l'appel ou si elle
    * devient vide avant qu'on ait defile tous les elements.
    */
   @Override
   public T[] defiler(int n) throws ExceptionFileVide {
      T[] tab = (T[]) new Object[n];
      for (int i = 0; i < n; i++) {
         tab[i] = defiler();  //s'occupe de lancer ExceptionFileVide
                              //s'il y a lieu
      }
      return tab;
   }

   /**
    * Retourne le nombre de defilements requis pour obtenir la premiere
    * occurrence de l'element specifie. Si l'element specifie ne se trouve pas
    * dans cette file, retourne -1.
    *
    * @param element l'element dont on veut savoir s'il est dans la file et le
    * nombre de defilement requis pour obtenir sa premiere occurrence.
    *    Antecedent : les elements de la file doivent redefinir la methode equals
    *                 et ne doivent pas etre null.
    * @return le nombre de defilements requis pour obtenir la premiere
    * occurrence de l'element specifie ou -1 si l'element ne se trouve pas dans
    * cette file.
    */
   @Override
   public int contientElement(T element) {
      int n = -1;
      if (liste.contains(element)) {
         n = liste.indexOf(element) + 1;
      }
      return n;
   }

}
