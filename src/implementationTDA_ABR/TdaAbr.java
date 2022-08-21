
/**
 * TDA ABR. Type abstrait Arbre Binaire de Recherche.
 *
 * @author Louise Laforest (2005), Melanie Lord (2017)
 * @version Juillet 2017
 * @param <T> le type des elements dans l'arbre.
 */
public interface TdaAbr<T extends Comparable<T>> {

   /**
    * Teste si cet ABR est vide.
    *
    * @return true si cet ABR est vide, false autrement.
    */
   public abstract boolean estVide();

   /**
    * Retourne le nombre d'elements de cet ABR.
    *
    * @return le nombre d'elements de cet ABR.
    */
   public abstract int nbNoeuds();

   /**
    * Verifie si element est present dans cet ABR.
    *
    * @param element l'element a verifier.
    * @return true si element est dans cer ABR, false sinon.
    */
   public abstract boolean estPresent(T element);
   
   /**
    * Cherche element dans cet ABR.
    * 
    * @param element l'element a chercher.
    * @return la reference au noeud contenant element si present, null sinon.
    */
   public abstract Noeud<T> chercher(T element);

   /**
    * Insere element dans cet ABR.
    *
    * @param element l'element a inserer.
    * @return true si l'element a ete insere, false sinon (dans le cas ou il se
    *         trouvait deja dans l'arbre).
    */
   public abstract boolean inserer(T element);

   /**
    * Retire element de cet ABR.
    *
    * @param element l'element a retirer.
    * @return true si l'element a ete retire (parce que present) false s'il 
    * n'etait pas present.
    */
   public abstract boolean retirer(T element);
   
}
