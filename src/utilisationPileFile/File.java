package utilisationPileFile;

/**
 * Une file (ou FIFO, First In, First Out) est une structure de donnees lineaire
 * dans laquelle un seul element est directement accessible, celui qui est au
 * debut. Un nouvel element est ajoute a la fin de la file et un element est
 * retire au debut de la file.
 *
 * @author Louise Laforest
 * @version janvier 2006, fevrier 2011, oct. 2014 (Melanie Lord)
 * @param <T> le type generique des elements dans la file.
 */
public interface File<T> {

   /**
    * Teste si la file est vide (aucun element)
    *
    * @return true si aucun element false autrement
    */
   public abstract boolean estVide();

   /**
    * Ajoute un nouvel element en fin de file
    *
    * @param element l'element a placer en file
    */
   public abstract void enfiler(T element);

   /**
    * Retire l'element au debut de la file
    *
    * @return la reference de l'element retire
    * @throws ExceptionFileVide si la file est vide avant l'appel
    */
   public abstract T defiler();

   /**
    * Retourne la reference de l'element au debut de la file, sans le retirer de
    * la file
    *
    * @return la reference de l'element au debut de la file
    * @throws ExceptionFileVide si la file est vide avant l'appel
    */
   public abstract T premier();

   /**
    * Retire tous les elements de la file Aucun effet si la file est deja vide
    */
   public abstract void vider();

   /**
    * Retourne le nombre d'elements contenus dans la file
    *
    * @return le nombre d'elements
    */
   public abstract int taille();

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
   public abstract T [] defiler (int n);

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
   public abstract int contientElement( T element );

}
