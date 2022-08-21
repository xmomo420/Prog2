package utilisationPileFile;

/**
 * Exemples d'utilisation de piles et de files
 *
 * @author Melanie Lord
 * @version 2013
 */
public class Exemples {

   /**
    * Affiche les elements de la file f dans le format donne ci-dessous.
    *
    * EXEMPLE file avec 3 elements :
    * 
    *    e1 (tete), e2 et e3 (fin) : Affiche : tete [e1, e2, e3 ] fin 
    *      //pas de virgule apres le 
    *      //dernier element EXEMPLE file
    *    vide : Affiche : tete [ ] fin
    *
    * Apres l'appel de cette methode, f est inchangee. 
    * 
    * Antecedents :  - f ne doit pas etre null 
    *                - les elements de f doivent redefinir la methode toString()
    *                  qui retourne une chaine d'une seule ligne (pas de "\n" 
    *                  dans la chaine retournee).
    *
    * @param f la file dont on veut afficher les elements
    */
   public static void afficher(File f) {
      System.out.print("tete [ ");
      Object o;
      for (int i = 0; i < f.taille(); i++) {
         o = f.defiler();
         f.enfiler(o);
         System.out.print(o);
         if (i != f.taille() - 1) {
            System.out.print(", ");
         }
      }
      System.out.println(" ] fin");
   }

   /**
    * Affiche les elements de la pile p sous le format donne ci-dessous.
    *
    * EXEMPLE pile avec 3 elements 
    *       e1 (sommet), e2 et e3 : Affiche : sommet [e1, e2, e3 ] 
    *          //pas de virgule apres le dernier element 
    * EXEMPLE pile vide : 
    *       Affiche : sommet [ ]
    *
    * ----------------------------------------------- 
    * VOUS NE DEVEZ UTILISER QU'UNE VARIABLE LOCALE DE TYPE PILE  
    * ET UNE AUTRE DE TYPE OBJECT
    *
    * VOUS NE DEVEZ PAS UTILISER LE SERVICE TAILLE().
    * -----------------------------------------------
    *
    * Apres l'appel de cette methode, p est inchangee. 
    * 
    *    Antecedents : - p ne doit pas etre null 
    *                  - les elements de p doivent redefinir la methode toString()
    *                    qui retourne une chaine d'une seule ligne 
    *                    (pas de "\n" dans la chaine retournee).
    *
    * @param p la pile dont on veut afficher les elements
    */
   public static void afficher(Pile p) {
      System.out.print("sommet [ ");
      Pile p2 = new PileArrayList();
      Object o;
      while (!p.estVide()) {
         o = p.depiler();
         //transferer o dans p2
         p2.empiler(o);

         //afficher o
         System.out.print(o);
         if (!p.estVide()) {
            System.out.print(", ");
         }
      }
      System.out.println(" ]");
      //retransferer les elements de p2 dans p
      while (!p2.estVide()) {
         p.empiler(p2.depiler());
      }

   }

   /**
    * Determine si les deux files f1 et f2 sont identiques. Deux files sont
    * identiques si 
    *       - elles contiennent le meme nombre d'elements ET les elements de f1 
    *         sont egaux (equals) aux elements de f2 ET dans le meme ordre de defilement 
    * 
    *       - OU si elles sont toutes les deux vides.
    *
    * Apres l'appel de cette methode, les files f1 et f2 doivent etre inchangees
    *
    * ----------------------------------------------- 
    * COMME VARIABLES LOCALES,VOUS NE DEVEZ UTILISER QUE
    * DES VARIABLES DE TYPE OBJECT OU DE TYPE
    * PRIMITIF. 
    * -----------------------------------------------
    *
    * Antecedents : - les elements de f1 et de f2 redefinissent la methode
    *                   equals et ne sont pas null. 
    *                - f1 et f2 ne sont pas null
    *
    * @param f1 la premiere file a comparer avec f2
    * @param f2 la deuxieme file a comparer avec f1
    * @return true si les deux files sont identiques, false sinon.
    */
   public static boolean sontIdentiques(File f1, File f2) {
      boolean identique = false;
      Object o1;
      Object o2;
      int i;
      if (f1.taille() == f2.taille()) {
         identique = true;
         if (!f1.estVide()) {
            i = 0;
            while (i < f1.taille() && identique) {
               //defiler les elements de f1 et f2
               o1 = f1.defiler();
               o2 = f2.defiler();

               //tester l'egalite 
               identique = o1.equals(o2);

               //reenfiler les elements defiles
               f1.enfiler(o1);
               f2.enfiler(o2);

               i++;
            }
				//terminer de reenfiler
            //s'il y a lieu
            while (i < f1.taille()) {
               f1.enfiler(f1.defiler());
               f2.enfiler(f2.defiler());
               i++;
            }
         }
      }
      return identique;
   }

   /**
    * Ordonne les elements de f, en ordre croissant : plus petit element en tete
    * de file jusqu'au plus grand element en fin de file.
    *
    * Antecedents : - f n'est pas null et les elements de f ne sont pas null.
    *
    * EXEMPLE : Avant : f = tete ['b', 'a', 'd', 'b', 'h', 'w', 's', 'a' ] fin
    *
    *           Apres : f = tete ['a', 'a', 'b', 'b', 'd', 'h', 's', 'w' ] fin
    * 
    * @param f la file a ordonner
    */
   public static void ordonnerFile(File<Character> f) {
      Pile<Character> p = new PileArrayList<>();
      //trier les elements dans p (sommet = plus petit)
      while (!f.estVide()) {
         if (p.estVide()) {
            p.empiler(f.defiler());
         } else if (p.sommet().compareTo(f.premier()) >= 0) {
            p.empiler(f.defiler());
         } else {
            f.enfiler(p.depiler());
         }
      }
      //vider p dans f
      while (!p.estVide()) {
         f.enfiler(p.depiler());
      }
   }

   /**
    * Supprime tous le nombres pairs de cette pile d'entiers. Apres l'appel de
    * cette methode, p ne contient que des nombres impairs, dans l'ordre
    * original.
    *
    * EXEMPLE : 
    *       - Si avant l'appel, p => sommet [ 1, 2, 3, 4, 5, 6 ] 
    *       - alors apres l'appel, p => sommet [ 1, 3, 5 ]
    *
    * Antecedent : - p ne doit pas etre null et les elements de p ne sont pas null.
    * @param p la pile dont on veut eliminer les elements pairs.
    */
   public static void eliminerPairs(Pile<Integer> p) {
      Pile<Integer> p2 = new PileArrayList<>();
      Integer i;
      while (!p.estVide()) {
         i = p.depiler();
         if (i % 2 == 1) {
            //conserver les impairs dans p2
            p2.empiler(i);
         }
      }
      //retransferer les elements de p2 dans p.
      while (!p2.estVide()) {
         p.empiler(p2.depiler());
      }
   }

   /**
    * Inverse les elements de p. Si p est vide, p demeure inchangee.
    *
    * EXEMPLE : Avant l'appel de la methode : p = sommet point1, point2, point3 
    *           Apres l'appel de la methode : p = sommet point3, point2, poing1.
    *
    * ---------------------------------------- 
    * COMME VARIABLE LOCALE, VOUS NE
    * DEVEZ UTILISER QU'UNE FILE
    *
    * VERSION SANS UTILISER LE SERVICE TAILLE
    * ----------------------------------------
    *
    * Antecedent : - p ne doit pas etre null.
    *
    * @param p la pile dont on veut inverser les elements.
    */
   public static void inverser(Pile<Point> p) {
      File<Point> f = new FileArrayList<>();
      while (!p.estVide()) {
         f.enfiler(p.depiler());
      }
      while (!f.estVide()) {
         p.empiler(f.defiler());
      }
   }

   //TESTS
   public static void main(String[] args) {

      File<Integer> f1 = new FileArrayList<>();
      File<Integer> f2 = new FileArrayList<>();

      System.out.println("TESTS SONT IDENTIQUES\n");

      System.out.println(sontIdentiques(f1, f2)); //true
      afficher(f1); //tete [  ] fin
      afficher(f2); //tete [  ] fin

      f1.enfiler(1);
      System.out.println(sontIdentiques(f1, f2)); //false
      afficher(f1); //tete [ 1 ] fin
      afficher(f2); //tete [  ] fin

      f2.enfiler(1);
      System.out.println(sontIdentiques(f1, f2)); //true
      afficher(f1); //tete [ 1 ] fin
      afficher(f2); //tete [ 1 ] fin
      f2.defiler();
      f2.enfiler(2);
      System.out.println(sontIdentiques(f1, f2)); //false
      afficher(f1); //tete [ 1 ] fin
      afficher(f2); //tete [ 2 ] fin
      f1.vider();
      f2.vider();
      f1.enfiler(3);
      f2.enfiler(3);
      f1.enfiler(6);
      f2.enfiler(6);
      f1.enfiler(-1);
      f2.enfiler(-1);
      f1.enfiler(30);
      f2.enfiler(30);
      f1.enfiler(0);
      f2.enfiler(0);
      System.out.println(sontIdentiques(f1, f2)); //true;
      afficher(f1); //tete [ 3 ,6 ,-1 ,30 ,0 ] fin
      afficher(f2); //tete [ 3 ,6 ,-1 ,30 ,0 ] fin

      f1.vider();
      f2.vider();
      f1.enfiler(3);
      f2.enfiler(3);
      f1.enfiler(6);
      f2.enfiler(6);
      f1.enfiler(1);  //non identique ici
      f2.enfiler(-1);
      f1.enfiler(30);
      f2.enfiler(30);
      f1.enfiler(0);
      f2.enfiler(0);
      System.out.println(sontIdentiques(f1, f2)); //false;
      afficher(f1); //tete [ 3 ,6 ,1 ,30 ,0 ] fin
      afficher(f2); //tete [ 3 ,6 ,-1 ,30 ,0 ] fin

      System.out.println("\nTESTS  INVERSER\n");

      Point p1 = new Point(1, 1);
      Point p2 = new Point(2, 2);
      Point p3 = new Point(3, 3);
      Point p4 = new Point(4, 4);
      Point p5 = new Point(5, 5);
      Point p6 = new Point(6, 6);
      Point p7 = new Point(7, 7);

      Pile<Point> p = new PileArrayList<>();
      afficher(p); //sommet [  ]
      inverser(p);
      afficher(p); //sommet [  ]

      p.empiler(p1);
      afficher(p); //sommet [ (1, 1) ]
      inverser(p);
      afficher(p); //sommet [ (1, 1) ]

      p.empiler(p2);
      p.empiler(p3);
      p.empiler(p4);
      p.empiler(p5);
      p.empiler(p6);
      p.empiler(p7);
      afficher(p); //sommet [ (7, 7), (6, 6), (5, 5), (4, 4), (3, 3), (2, 2), (1, 1) ]
      inverser(p);
      afficher(p); //sommet [ (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6), (7, 7) ]

      System.out.println("\nTESTS ELIMINER PAIRS\n");
      Pile<Integer> pile2 = new PileArrayList<>();

      afficher(pile2);			//sommet [  ]
      eliminerPairs(pile2);
      afficher(pile2);			//sommet [  ]

      pile2.empiler(1);
      afficher(pile2);			//sommet [ 1 ]
      eliminerPairs(pile2);
      afficher(pile2);			//sommet [ 1 ]

      pile2.vider();
      pile2.empiler(2);
      afficher(pile2);			//sommet [ 2 ]
      eliminerPairs(pile2);
      afficher(pile2);			//sommet [  ]

      pile2.empiler(3);
      pile2.empiler(1);
      pile2.empiler(6);
      pile2.empiler(7);
      pile2.empiler(8);
      pile2.empiler(8);
      pile2.empiler(0);
      pile2.empiler(2);
      pile2.empiler(1);
      pile2.empiler(3);
      pile2.empiler(5);
      afficher(pile2);			//sommet [ 5, 3, 1, 2, 0, 8, 8, 7, 6, 1, 3 ]
      eliminerPairs(pile2);
      afficher(pile2);			//sommet [ 5, 3, 1, 7, 1, 3 ]

      pile2.vider();
      pile2.empiler(1);
      pile2.empiler(1);
      pile2.empiler(1);
      pile2.empiler(1);
      pile2.empiler(1);
      afficher(pile2);			//sommet [ 1, 1, 1, 1, 1 ]
      eliminerPairs(pile2);
      afficher(pile2);			//sommet [ 1, 1, 1, 1, 1 ]

      pile2.vider();
      pile2.empiler(2);
      pile2.empiler(2);
      pile2.empiler(2);
      pile2.empiler(2);
      pile2.empiler(2);
      afficher(pile2);			//sommet [ 2, 2, 2, 2, 2 ]
      eliminerPairs(pile2);
      afficher(pile2);			//sommet [  ]

      System.out.println("\nTESTS ORDONNER FILE\n");
      File<Character> f3 = new FileArrayList<>();

      ordonnerFile(f3);
      afficher(f3);				//tete [  ] fin

      f3.enfiler('B');
      ordonnerFile(f3);
      afficher(f3);				//tete [ B ] fin

      f3.enfiler('B');
      ordonnerFile(f3);
      afficher(f3);				//tete [ B, B ] fin

      f3.enfiler('B');
      f3.enfiler('A');
      ordonnerFile(f3);
      afficher(f3);				//tete [ A, B, B, B ] fin

      f3.vider();
      f3.enfiler('G');
      f3.enfiler('D');
      f3.enfiler('O');
      f3.enfiler('A');
      f3.enfiler('G');
      f3.enfiler('P');
      f3.enfiler('E');
      f3.enfiler('F');
      f3.enfiler('G');
      f3.enfiler('C');
      f3.enfiler('Y');
      afficher(f3);				//tete [ G, D, O, A, G, P, E, F, G, C, Y ] fin
      ordonnerFile(f3);
      afficher(f3);				//tete [ A, C, D, E, F, G, G, G, O, P, Y ] fin

   }

}
