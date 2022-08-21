
/**
 * Exemples de methodes de classe traitant des ABR.
 * @author Melanie Lord
 * @version decembre 2013, Juillet 2017
 */
public class Exemples {

   /**
    * Calcule le nombre des noeuds qui n'ont qu'un seul fils (gauche ou droit)
    * dans l'ABR dont la racine est donnee en parametre.
    *
    * @param racine la racine d'un ABR.
    * @return le nombre de noeuds qui n'ont qu'un seul fils.
    */
   public static int nbNoeuds1Enfant(Noeud racine) {
      int reponse = 0;
      if (racine != null) {
         if (racine.gauche() == null && racine.droite() != null) {
            reponse = 1;
         } else if (racine.gauche() != null && racine.droite() == null) {
            reponse = 1;
         }
         reponse = reponse + nbNoeuds1Enfant(racine.gauche()) 
                 + nbNoeuds1Enfant(racine.droite());
      }
      return reponse;
   }

   /**
    * Calcule le nombre de noeuds contenant une chaine dont le prefixe (debut de
    * la chaine) est la chaine prefix passee en parametre.
    *
    * @param racine la racine de l'ABR
    * @param prefix le prefixe a chercher ANT : prefix est non null.
    * @return le nombre de noeuds contenant une chaine dont le prefixe est est
    * le parametre prefix.
    */
   public static int nbNoeudsAvecPrefixe(Noeud<String> racine, String prefix) {

      int reponse = 0;
      int direction;
      int longPrefix = prefix.length();

      if (racine != null) {
         
         if (racine.info().length() < longPrefix) {
            direction = racine.info().compareTo(prefix);
         } else {
            direction = racine.info().substring(0, longPrefix).compareTo(prefix);
         }

         //les deux prefixes sont egaux
         if (direction == 0) {
            reponse = 1 + nbNoeudsAvecPrefixe(racine.gauche(), prefix)
                    + nbNoeudsAvecPrefixe(racine.droite(), prefix);

         //Le prefixe de l'info du noeud courant < prefix
         } else if (direction < 0) {
            reponse = nbNoeudsAvecPrefixe(racine.droite(), prefix);

         //Le prefixe de l'info du noeud courant > prefix
         } else {
            reponse = nbNoeudsAvecPrefixe(racine.gauche(), prefix);
         }
      }
      return reponse;
   }

   /**
    * Calcule la hauteur de l'ABR donne par racine.
    *
    * @param racine la racine de l'ABR
    * @return la hauteur de l'ABR ou -1 si racine est null.
    */
   public static int hauteur(Noeud racine) {
      int reponse = -1;

      if (racine != null) {
         reponse = 1 + Math.max(
                 hauteur(racine.gauche()), hauteur(racine.droite()));
      }
      return reponse;
   }
   
   /**
    * Retourne le plus grand element (cle) dans l'ABR dont la racine est 
    * donnee en parametre. Retourne null si racine est null.
    * @param racine la racine de l'ABR dont on veut le plus grand element.
    * @return le plus grand element contenu dans l'ABR dont la racine
         est donnee en parametre ou null si la racine donnee est null.
    */
   public static Integer maximum (Noeud<Integer> racine) {
      Integer max = null;
      if (racine != null) {
         if (racine.droite() == null) {
            max = racine.info();
         } else {
            max = maximum(racine.droite());
         }
      }
      return max;
   }

   /**
    * Retourne le plus petit element (cle) dans l'ABR dont la racine est 
    * donnee en parametre. Retourne null si racine est null.
    * @param racine la racine de l'ABR dont on veut le plus petit element.
    * @return le plus petit element contenu dans l'ABR dont la racine
         est donnee en parametre ou null si la racine donnee est null.
    */
   public static Integer minimum (Noeud<Integer> racine) {
      Integer min = null;
      if (racine != null) {
         if (racine.gauche() == null) {
            min = racine.info();
         } else {
            min = minimum(racine.gauche());
         }
      }
      return min;
   }

   /**************
    * TESTS
    **************/
   
   /**
    * POUR TESTS SEULEMENT. 
    * Insere un noeud contenant l'element e dans l'ABR donne par
    * racine. Si e existe deja dans l'ABR, il n'est pas insere.
    *
    * @param racine la racine de l'ABR
    * @param element l'element a inserer
    * @return la racine de l'ABR
    */
   private static Noeud inserer(Noeud racine, Comparable element) {
      int direction;
      if (racine == null) {
         return new Noeud(element);
      } else {
         direction = element.compareTo(racine.info());
         if (direction == 0) {
         } else if (direction < 0) {
            racine.modifierGauche(inserer(racine.gauche(), element));
         } else {
            racine.modifierDroite(inserer(racine.droite(), element));
         }
         return racine;
      }
   }

   public static void main(String[] args) {

      System.out.println(hauteur(null)); //-1
      
      
      //construction d'un ABR
      Noeud racine1 = new Noeud<>("eez");

      inserer(racine1, "kkk");
      inserer(racine1, "efg");
      inserer(racine1, "eee");
      inserer(racine1, "eef");
      inserer(racine1, "cda");
      inserer(racine1, "vvv");
      inserer(racine1, "ee");
      inserer(racine1, "eeqq");
      inserer(racine1, "e");
      inserer(racine1, "eehsv");

      System.out.println(nbNoeudsAvecPrefixe(racine1, "ee")); //6
      System.out.println(nbNoeudsAvecPrefixe(racine1, "ef")); //1
      System.out.println(nbNoeudsAvecPrefixe(racine1, "e"));  //8
      System.out.println(nbNoeudsAvecPrefixe(racine1, ""));   //11
      System.out.println(nbNoeudsAvecPrefixe(racine1, "vvv")); //1
      System.out.println(nbNoeudsAvecPrefixe(racine1, "vvva")); //0

      System.out.println(hauteur(racine1)); //4

      Noeud<Integer> racine2 = new Noeud<>(23);
      inserer(racine2, 57);
      inserer(racine2, 63);
      inserer(racine2, 49);
      inserer(racine2, 13);

      System.out.println(hauteur(racine2)); //2

      inserer(racine2, 17);

      System.out.println(hauteur(racine2)); //2

      inserer(racine2, 70);
      inserer(racine2, 71);
      inserer(racine2, 72);

      System.out.println(hauteur(racine2)); //5
      
      
      racine1 = new Noeud<>("G");
      racine1.modifierGauche(new Noeud<>("E", new Noeud<>("B"), new Noeud<>("H")));
      racine1.modifierDroite(new Noeud<>("K"));

      racine1 = new Noeud<>("4");
      inserer(racine1, "6");
      inserer(racine1, "55");
      inserer(racine1, "71");
      inserer(racine1, "555");
      inserer(racine1, "45");
      System.out.println(nbNoeudsAvecPrefixe(racine1, "55")); //2
      System.out.println(nbNoeudsAvecPrefixe(racine1, "4"));  //2
      
      racine1 = new Noeud<>("555");
      inserer(racine1, "55");
      inserer(racine1, "553");
      inserer(racine1, "55975");
      inserer(racine1, "5");
      inserer(racine1, "559");
      inserer(racine1, "7");
      System.out.println(nbNoeudsAvecPrefixe(racine1, "55"));  //5
      System.out.println(nbNoeudsAvecPrefixe(racine1, "5"));   //6
      System.out.println(nbNoeudsAvecPrefixe(racine1, "7"));   //1
      System.out.println(nbNoeudsAvecPrefixe(racine1, "559")); //2
      
      racine1 = new Noeud<>("551");
      inserer(racine1, "535");
      inserer(racine1, "550");
      inserer(racine1, "55");
      inserer(racine1, "569");
      inserer(racine1, "552");
      inserer(racine1, "7");
      System.out.println(nbNoeudsAvecPrefixe(racine1, "55"));  //4
      
      racine1 = new Noeud<>("551");
      inserer(racine1, "545");
      inserer(racine1, "55");
      inserer(racine1, "589");
      inserer(racine1, "59");
      inserer(racine1, "888");
      inserer(racine1, "5537");
      inserer(racine1, "5512");
      System.out.println(nbNoeudsAvecPrefixe(racine1, "55"));  //4
      
      
      
      
      //TESTS maximum / minimum
      
      Noeud<Integer> racine3 = null;
      System.out.println(maximum(racine3));   //null
      System.out.println(minimum(racine3));   //null
      

      racine3 = new Noeud<>(30);
      System.out.println(maximum (racine3));  //30
      System.out.println(minimum (racine3));  //30
      
      inserer(racine3, 20);
      System.out.println(maximum (racine3));  //30
      System.out.println(minimum (racine3));  //20
      
      inserer(racine3, 50);
      System.out.println(maximum (racine3));  //50
      System.out.println(minimum (racine3));  //20
      
      inserer(racine3, 40);
      System.out.println(maximum (racine3));  //50
      System.out.println(minimum (racine3));  //20
      
      inserer(racine3, 45);
      System.out.println(maximum (racine3));  //50
      System.out.println(minimum (racine3));  //20
      
      inserer(racine3, 60);
      System.out.println(maximum (racine3));  //60
      System.out.println(minimum (racine3));  //20
      
      inserer(racine3, 55);
      System.out.println(maximum (racine3));  //60
      System.out.println(minimum (racine3));  //20
      
      
      
      racine3 = new Noeud<>(30);
      inserer(racine3, 20);
      inserer(racine3, 25);
      System.out.println(maximum (racine3));  //30
      System.out.println(minimum (racine3));  //20
      
      inserer(racine3, 10);
      System.out.println(maximum (racine3));  //30
      System.out.println(minimum (racine3));  //10
      
      inserer(racine3, 6);
      inserer(racine3, 3);
      System.out.println(maximum (racine3));  //30
      System.out.println(minimum (racine3));  //3
      
      inserer(racine3, 8);
      inserer(racine3, 15);
      System.out.println(maximum (racine3));  //30
      System.out.println(minimum (racine3));  //3
   }
}
