package pile_implAvecChainage;

public class MaillonEx<T> {
	
  //-----   Variables d'instance -----

  private T          info;
  private MaillonEx<T> suiv;

  /** 
   * Cree un nouveau maillon n'ayant pas de maillon suivant
   * @param o l'information qui sera stockee dans le maillon
   */
  public MaillonEx(T o ) {
    this ( o, null );
  }

  /** 
   * Cree un nouveau maillon ayant un autre maillon existant comme suivant
   * @param o l'information qui sera stockee dans le maillon
   * @param suivant le maillon qui sera le suivant du maillon cree
   */
  public MaillonEx(T o, MaillonEx<T> suivant ) {
    info = o;
    suiv = suivant;
  }

  //-----   Observateurs (getters) -----

  public T info () {
    return info;
  }

  public MaillonEx<T> suivant () {
    return suiv;
  }

  //-----   Modificateurs (setters) -----

  public void modifierInfo ( T o ) {
    info = o;
  }

  public void modifierSuivant ( MaillonEx<T> suivant ) {
    suiv = suivant;
  }
} 