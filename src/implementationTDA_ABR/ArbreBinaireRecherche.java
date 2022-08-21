
/**
 * Implementation du TDA Arbre binaire de recherche TdaAbr. 
 * NOTE : ABR sans doublons et sans elements null.
 * 
 * @param <T> le type des elements de l'arbre
 */
public class ArbreBinaireRecherche<T extends Comparable<T>> implements TdaAbr<T> {

   //variable de classe pour la valeur de retour de la methode inserer
   private static boolean estInsere;
   
   //variable de classe pour la valeur de retour de la methode retirer
   private static boolean estRetire;
   
   //la racine de l'arbre
   private Noeud<T> racine;

   /**
    * Construit un ABR vide.
    */
   public ArbreBinaireRecherche() {
      racine = null; // facultatif
   }

   /**
    * Construit un ABR d'un noeud.
    *
    * @param element La clé (la valeur) de la racine.
    */
   public ArbreBinaireRecherche(T element) {
      racine = new Noeud(element);
   }

   /**
    * Teste si cet ABR est vide.
    *
    * @return true si cet ABR est vide, false autrement.
    */
   @Override
   public boolean estVide() {
      return racine == null;
   }

   /**
    * Retourne le nombre de noeuds dans cet ABR.
    *
    * @return le nombre de noeuds de cet ABR.
    */
   @Override
   public int nbNoeuds() {
      return nbNoeuds(racine);
   }

   /**
    * Verifie si element est present dans cet ABR.
    *
    * @param element l'element a verifier.
    * @return true si element est dans cer ABR, false sinon.
    */
   @Override
   public boolean estPresent(T element) {
      return chercher(racine, element) != null;
   }

   /**
    * Cherche element dans cet ABR.
    *
    * @param element l'element a chercher.
    * @return la reference au noeud contenant element si present, null sinon.
    */
   @Override
   public Noeud<T> chercher(T element) {
      return chercher(racine, element);
   }

   /**
    * Cherche element dans cet ABR (version iterative alternative).
    *
    * @param element l'element a chercher.
    * @return la reference au noeud contenant element si present, null sinon.
    */
   public Noeud<T> chercherIte(T element) {
      return chercherIte(racine, element);
   }

   /**
    * Insere element dans cet ABR.
    *
    * @param element l'element a inserer.
    * @return true si l'element a ete insere, false sinon (dans le cas ou il se
    *         trouvait deja dans l'arbre).
    */
   @Override
   public boolean inserer(T element) {
      estInsere = true;
      racine = inserer(racine, element);
      return estInsere;
   }

   /**
    * Insere element dans cet ABR (version iterative alternative).
    *
    * @param element l'element a inserer.
    * @return true si l'element a ete insere, false sinon (dans le cas ou il se
    *         trouvait deja dans l'arbre).
    */
   public boolean insererIte(T element) {
      estInsere = true;
      racine = insererIte(racine, element);
      return estInsere;
   }

   /**
    * Retire element de cet ABR.
    *
    * @param element l'element a retirer.
    * @return true si l'element a ete retire (parce que present) false s'il
    *         n'etait pas present.
    */
   @Override
   public boolean retirer(T element) {
      estRetire = false;
      racine = retirer(racine, null, element); //la racine peut etre modifiee
      return estRetire;
   }
   
   
  
   //-----   M e t h o d e s   u t i l i t a i r e s   p r i v e e s ----- //
   
   
   /**
    * Permet d'obtenir le noeud contenant l'element donne s'il est present dans
    * l'arbre binaire de recherche dont la racine est n.
    * @param n la racine de l'ABR dans lequel chercher element.
    * @param element l'element a chercher.
    * @return le noeud contenant l'element donne s'il est present dans
    *         l'arbre binaire de recherche dont la racine est n ou null
    *         si l'element n'existe pas.
    */
   private Noeud<T> chercher(Noeud<T> n, T element) {
      Noeud<T> reponse;
      int direction;
      if (n == null || element == null) {
         reponse = null;
      } else {
         direction = element.compareTo(n.info());
         if (direction == 0) {
            reponse = n;
         } else if (direction < 0) {
            reponse = chercher(n.gauche(), element);
         } else {
            reponse = chercher(n.droite(), element);
         }
      }
      return reponse;
   }

   /**
    * Permet d'obtenir le noeud contenant l'element donne s'il est present dans
    * l'arbre binaire de recherche dont la racine est n.
    * @param n la racine de l'ABR dans lequel chercher element.
    * @param element l'element a chercher.
    * @return le noeud contenant l'element donne s'il est present dans
    *         l'arbre binaire de recherche dont la racine est n ou null
    *         si l'element n'existe pas.
    */
   private Noeud<T> chercherIte(Noeud<T> n, T element) {
      boolean trouve = false;
      Noeud<T> p = n;
      int direction;
      while (!trouve && p != null) {
         direction = element.compareTo(p.info());
         if (direction == 0) {
            trouve = true;
         } else if (direction < 0) {
            p = p.gauche();
         } else {
            p = p.droite();
         }
      }
      return p;
   }

   /**
    * Insere l'element donne dans l'arbre binaire de recherche dont la racine
    * est n.
    * @param n la racine de l'arbre binaire de recherche dans lequel on veut 
    *          ajouter l'element donne.
    * @param element l'element a ajouter.
    * @return la racine de cet ABR (peut avoir ete modifiee).
    */
   private Noeud<T> inserer(Noeud<T> n, T element) {
      int direction;
      if (n == null) {
         n = new Noeud<>(element);
      } else {
         direction = element.compareTo(n.info());
         if (direction == 0) {
            estInsere = false; // l'element y est deja
         } else if (direction < 0) {
            n.modifierGauche(inserer(n.gauche(), element));
         } else {
            n.modifierDroite(inserer(n.droite(), element));
         }
      }
      return n;
   }

   /**
    * Insere l'element donne dans l'arbre binaire de recherche dont la racine
    * est n.
    * @param n la racine de l'arbre binaire de recherche dans lequel on veut 
    *          ajouter l'element donne.
    * @param element l'element a ajouter.
    * @return la racine de cet ABR (peut avoir ete modifiee).
    */
   private Noeud<T> insererIte(Noeud<T> n, T element) {
      Noeud<T> p = n;
      int direction;
      boolean endroitTrouve = false;
      Noeud<T> reponse;

      if (n == null) {
         reponse = new Noeud(element);
      } else {
         while (!endroitTrouve) {
            direction = element.compareTo(p.info());
            if (direction == 0) {
               endroitTrouve = true;
               estInsere = false;
            } else if (direction < 0) {
               if (p.gauche() == null) {
                  endroitTrouve = true;
                  p.modifierGauche(new Noeud(element));
               } else {
                  p = p.gauche();
               }
            } else {
               if (p.droite() == null) {
                  endroitTrouve = true;
                  p.modifierDroite(new Noeud(element));
               } else {
                  p = p.droite();
               }
            }
         }
         reponse = n;
      }
      return reponse;
   }
   
   /**
    * Retourne le nombre de noeuds de l'arbre binaire de recherche dont la racine
    * est celle donnee en parametre.
    * @param racine la racine de l'arbre.
    * @return le nombre de noeuds de l'arbre binaire de recherche dont la racine
    *         est celle donnee en parametre.
    */
   private int nbNoeuds(Noeud<T> racine) {
      int nombre = 0;

      //--- solution 1 ---//
      /*
      if (racine != null) {
         if (racine.gauche() != null && racine.droite() != null) {
            nombre = 1 + nbNoeuds(racine.gauche()) + nbNoeuds(racine.droite());
         } else if (racine.gauche() == null && racine.droite() != null) {
            nombre = 1 + nbNoeuds(racine.droite());
         } else if (racine.gauche() != null && racine.droite() == null) {
            nombre = 1 + nbNoeuds(racine.gauche());
         } else {
            nombre = 1;
         }
      }
      */
     
      //--- solution 2 ---//
      if (racine != null) {
         nombre = 1 + nbNoeuds(racine.gauche()) + nbNoeuds(racine.droite());
      }
      
      return nombre;
   }

   /**
    * Retire l'element donne de l'arbre dont la racine est n.
    * @param n la racine de l'arbre dans lequel chercher element.
    * @param parent le noeud parent de n. 
    * @param element l'element a supprimer.
    * @return la racine de cet ABR (peut avoir ete modifiee).
    */
   private Noeud<T> retirer(Noeud<T> n, Noeud<T> parent, T element) {
      Noeud<T> reponse = racine;
      int direction;
      
      if (n != null && element != null) {   
         
         //chercher le noeud contenant element
         direction = element.compareTo(n.info());
         
         //on a trouve le noeud contenant element
         if (direction == 0) {
            
            estRetire = true;  //element existe donc il sera retire
            
            //le noeud a retirer est une feuille 
            if (n.gauche() == null && n.droite() == null) {
               reponse = retirerFeuille(n, parent);
            
            //le noeud a retirer a seulement un fils gauche ou un fils droit
            } else if (n.gauche() == null || n.droite() == null) {
               reponse = retirerNoeudAvec1Fils(n, parent);

            //le noeud a retirer a deux fils  
            } else {
               retirerNoeudAvec2Fils(n, n.gauche(), n);
            }
            
         } else if (direction < 0) {  //chercher a gauche
            reponse = retirer(n.gauche(), n, element);
            
         } else {                      //chercher a droite
            reponse = retirer(n.droite(), n, element);
         }
      }
      return reponse;
   }
   
   /**
    * Retire le noeud n de cet ABR.
    * @param n le noeud a retirer. ANT : n est une feuille (non null).
    * @param parent le noeud parent de n.
    * @return la racine de cet ABR (peut avoir ete modifiee).
    */
   private Noeud<T> retirerFeuille (Noeud<T> n, Noeud<T> parent) {
      if (n == racine) {
         racine = null;
      } else if (parent.gauche() == n) {
         parent.modifierGauche(null);
      } else {
         parent.modifierDroite(null);
      }
      return racine;
   }

   /**
    * Retire le noeud n de cet ABR.
    * @param n le noeud a retirer. ANT : n est non null et n'a qu'un seul fils.
    * @param parent le noeud parent de n.
    * @return la racine de cet ABR (peut avoir ete modifiee).
    */
   private Noeud<T> retirerNoeudAvec1Fils (Noeud<T> n, Noeud<T> parent) {
      Noeud<T> fils = n.droite();
      
      //determiner si le fils de n est un fils droit ou un fils gauche
      if (n.gauche() != null) {
         fils = n.gauche();
      }
      //n est la racine : modifier racine par le fils de n
      if (n == racine) {
         racine = fils;

      //n est le fils gauche de parent : remplacer le fils gauche de parent
      //par le fils de n.
      } else if (parent.gauche() == n) {
         parent.modifierGauche(fils);
      
      //n est le fils droit de parent : remplacer le fils droit de parent
      //par le fils de n.
      } else {
         parent.modifierDroite(fils);
      }
      
      return racine;
   }

   /**
    * Retire le noeud n de cet ABR, en le remplacant par son predecesseur
    * (le maximum dans son sous-arbre gauche).
    * 
    * @param n le noeud a supprimer. ANT : n est non null et a deux fils.  
    * @param max le maximum dans le sous-arbre gauche de n (initialise a n.gauche
    *            au premier appel)
    * @param parentMax le parent de max (initialise a n au premier appel);
    * @return la racine de cet ABR.
    */
   private void retirerNoeudAvec2Fils (Noeud<T> n, Noeud<T> max, Noeud<T> parentMax) {

      //chercher max : aller vers la droite jusqu'à trouver le max
      if (max.droite() != null) {
         retirerNoeudAvec2Fils(n, max.droite(), max);
         
      //max trouve 
      } else {
         //copier info de max dans n
         n.modifierInfo(max.info());
         
         //supprimer max s'il est une feuille
         if (max.droite() == null && max.gauche() == null) {
            retirerFeuille(max, parentMax);
         
         //supprimer max s'il a un seul fils gauche 
         } else {
            retirerNoeudAvec1Fils(max, parentMax);
         } 
      } 
   }

}