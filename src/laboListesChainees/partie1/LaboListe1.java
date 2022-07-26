package laboListesChainees.partie1;

public class LaboListe1 {

   //--------------------------
   // METHODES POUR TESTER 
   //--------------------------
   public static void afficherChaine(Maillon m) {
      Maillon tmp;
      if (m == null) {
         System.out.println("Maillon null");
      } else {
         //pointeur temporaire qui va se deplacer de 
         //suivant en suivant
         tmp = m;
         while (tmp != null) {
            //afficher l'info dans tmp
            System.out.print(tmp.info() + " ");
            //positionner tmp sur le maillon suivant
            tmp = tmp.suivant();
         }
         System.out.println();
      }
   }

   public static Maillon<Integer> creerListeChaineeDEntiers(int nbr) {
      Maillon<Integer> debut = new Maillon<>(1);
      Maillon<Integer> tmp = debut;
      for (int i = 2; i <= nbr; i++) {
         tmp.modifierSuivant(new Maillon<>(i));
         tmp = tmp.suivant();
      }
      return debut;
   }

   //--------------------------
   // METHODES À COMPLETER 
   //--------------------------
   /**
    * Retourne le premier maillon d'une chaine formee par l'insertion de la
    * chaine donnee par debut1 (chaine1) dans la chaine donnee par debut2
    * (chaine2). L'insertion de chaine1 dans chaine2 doit se faire apres la
    * premiere occurrence de l'element (champ info du maillon) de chaine2 qui
    * contient la valeur specifiee en parametre.
    *
    * Si valeur ne se trouve pas dans chaine2, la chaine1 est inseree a la fin
    * de chaine2. Si debut1 est null, la chaine retournee egale chaine2 Si
    * debut2 est null, la chaine retournee egale chaine1 Si debut1 et debut2
    * sont null, la methode retourne null.
    *
    * Apres l'appel de cette methode, il est possible que chaine1 ou chaine2
    * soient modifiees.
    *
    * EXEMPLES :
    *
    * Supposons : - debut1 = premier maillon de la chaine 6 7 4 - debut2 =
    * premier maillon de la chaine 1 1 2 1 4 5
    *
    * L'appel insererChaine1DansChaine2(debut1, debut2, 1) retourne le premier
    * maillon de la chaine 1 6 7 4 1 2 1 4 5
    *
    * L'appel insererChaine1DansChaine2(debut1, debut2, 6) retourne le premier
    * maillon de la chaine 1 1 2 1 4 5 6 7 4
    *
    * L'appel insererChaine1DansChaine2(debut1, debut2, 2) retourne le premier
    * maillon de la chaine 1 1 2 6 7 4 1 4 5
    *
    * Voir les cas de tests pour d'autres exemples (methode
    * testsInsererChaine1DansChaine2).
    *
    * @param debut1 debut de la chaine a inserer dans la chaine donnee par
    * debut2
    * @param	debut2 debut de la chaine dans laquelle on veut inserer la chaine
    * donnee par debut1.
    * @param valeur la valeur de la premiere occurrence de l'element (l'info du
    * maillon) de chaine2 apres laquelle on veut inserer la chaine1.
    *
    * @return le premier maillon de la chaine formee par l'insertion de chaine1
    * dans chaine2.
    */
   public static Maillon<Integer> insererChaine1DansChaine2(Maillon<Integer>
                                  debut1, Maillon<Integer> debut2, int valeur) {
      Maillon<Integer> tmp;
      Maillon<Integer> fin;
      Maillon<Integer> retour;

      if (debut1 == null) {
         retour = debut2;

      } else if (debut2 == null) {
         retour = debut1;

      } else {
         retour = debut2;

         //trouver la position de valeur dans chaine2
         tmp = debut2;
         while (tmp.suivant() != null && tmp.info() != valeur) {
            tmp = tmp.suivant();
         }
         //ici, si valeur n'a pas ete trouvee dans chaine2, tmp pointe
         //sur le dernier maillon de chaine2, sinon, il pointe sur
         //le premier maillon rencontre qui contient l'element valeur.

         //trouver le dernier maillon dans chaine1
         fin = debut1;
         while (fin.suivant() != null) {
            fin = fin.suivant();
         }

         //insertion de chaine1 dans chaine2 :
         //faire pointer le dernier de chaine1 sur le suivant de tmp
         fin.modifierSuivant(tmp.suivant());

         //faire pointer le suivant de tmp sur le premier de chaine1
         tmp.modifierSuivant(debut1);
      }
      return retour;

   }

   /**
    * Insere un nouveau maillon contenant l'element valeur dans la liste donnee
    * par le maillon debut. L'insertion de ce nouveau maillon doit respecter
    * l'ordre croissant des elements de la chaine donnee par debut.
    *
    * Antecedent : la chaine donnee par le parametre debut est ordonnee en ordre
    * croissant. Si debut est null ou que valeur est null, le maillon retourne
    * egal le maillon debut
    *
    * Voir cas de tests pour des exemples (methode testsInsererOrdreCroissant)
    *
    * Apres l'appel de cette methode, il se peut que la chaine donne par debut
    * soit modifiee (contient un element de plus).
    *
    * @param debut le premier maillon de la chaine dans laquelle on veut inserer
    * @param valeur la valeur a inserer dans la chaine
    * @return le premier maillon de la chaine donnee par debut (le maillon debut
    * peut avoir ete modifie si l'insertion est faite au debut).
    */
   public static Maillon<String> insererOrdreCroissant(Maillon<String> debut,
      String valeur) {
      Maillon<String> retour = debut;
      Maillon<String> nouveau = new Maillon<>(valeur);
      String s;

      if (debut != null && valeur != null) {

         //positionner debut sur le premier element qui est plus grand ou egal a valeur,
         //s'il en existe un puis inserer le nouveau maillon.
         //ici, on utilise debut comme pointeur temporaire pour parcourir la liste.
         while (debut.suivant() != null && debut.info().compareTo(valeur) < 0) {
            debut = debut.suivant();
         }
         //ici, si debut pointe sur le maillon de fin (si on n'a pas trouve d'element plus
         //grand), on veut inserer APRES debut. Sinon, on veut inserer avant debut.

         //Inserer nouveau apres tmp
         nouveau.modifierSuivant(debut.suivant());
         debut.modifierSuivant(nouveau);

         //echanger l'info (pour simuler insertion avant) si
         //debut.info() est plus grand que valeur.
         if (debut.info().compareTo(valeur) > 0) {
            s = nouveau.info();
            nouveau.modifierInfo(debut.info());
            debut.modifierInfo(s);
         }
      }
      return retour;
   }

   /**
    * Tests de la methode insererChaine1DansChaine2.
    */
   public static void testsInsererChaine1DansChaine2() {
      System.out.println("\nTEST METHODE INSERER CHAINE 1 DANS CHAINE 2\n");
      Maillon<Integer> debut1 = null;
      Maillon<Integer> debut2 = null;
      Maillon<Integer> debut3;

      debut3 = insererChaine1DansChaine2(debut1, debut2, 2);
      afficherChaine(debut3); //Maillon null

      debut1 = new Maillon<>(5);
      debut3 = insererChaine1DansChaine2(debut1, null, 2);
      afficherChaine(debut3); //5

      debut2 = creerListeChaineeDEntiers(2);
      debut3 = insererChaine1DansChaine2(null, debut2, 2);
      afficherChaine(debut3); //1  2

      debut1 = new Maillon<>(5);
      debut2 = creerListeChaineeDEntiers(2);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 2);
      afficherChaine(debut3); //1  2  5

      debut1 = new Maillon<>(5);
      debut2 = creerListeChaineeDEntiers(2);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 1);
      afficherChaine(debut3); //1  5  2  

      debut1 = new Maillon<>(5);
      debut2 = creerListeChaineeDEntiers(2);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 3);
      afficherChaine(debut3); //1  2  5  

      debut1 = new Maillon<>(5);
      debut2 = creerListeChaineeDEntiers(2);
      debut3 = insererChaine1DansChaine2(debut2, debut1, 2);
      afficherChaine(debut3); //5  1  2 

      debut1 = new Maillon<>(5);
      debut2 = creerListeChaineeDEntiers(2);
      debut3 = insererChaine1DansChaine2(debut2, debut1, 5);
      afficherChaine(debut3); //5  1  2 

      debut1 = creerListeChaineeDEntiers(3);
      debut2 = creerListeChaineeDEntiers(5);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 0);
      afficherChaine(debut3); //1  2  3  4  5  1  2  3

      debut1 = creerListeChaineeDEntiers(3);
      debut2 = creerListeChaineeDEntiers(5);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 1);
      afficherChaine(debut3); //1  1  2  3  2  3  4  5

      debut1 = creerListeChaineeDEntiers(3);
      debut2 = creerListeChaineeDEntiers(5);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 3);
      afficherChaine(debut3); //1  2  3  1  2  3  4  5

      debut1 = creerListeChaineeDEntiers(3);
      debut2 = creerListeChaineeDEntiers(5);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 5);
      afficherChaine(debut3); //1  2  3  4  5  1  2  3

      debut1 = creerListeChaineeDEntiers(3);
      debut2 = creerListeChaineeDEntiers(5);
      debut3 = insererChaine1DansChaine2(debut1, debut2, 6);
      afficherChaine(debut3); //1  2  3  4  5  1  2  3

      debut1 = creerListeChaineeDEntiers(5);
      debut2 = new Maillon<>(1, new Maillon<>(1, new Maillon<>(1)));
      debut3 = insererChaine1DansChaine2(debut1, debut2, 1);
      afficherChaine(debut3); //1  1  2  3  4  5  1  1  

   }

   /**
    * Tests de la methode insererOrdreCroissant.
    */
   public static void testsInsererOrdreCroissant() {
      System.out.println("\nTEST METHODE INSERER ORDRE CROISSANT\n");
      Maillon<String> debut;
      Maillon<String> debut2;

      debut2 = insererOrdreCroissant(null, null);
      afficherChaine(debut2); //Maillon null

      debut2 = insererOrdreCroissant(new Maillon<>("cafe"), null);
      afficherChaine(debut2); //cafe

      debut2 = insererOrdreCroissant(null, "cafe");
      afficherChaine(debut2); //Maillon null

      debut = new Maillon<>("cafe");
      debut2 = insererOrdreCroissant(debut, "amande");
      afficherChaine(debut2); //amande  cafe

      debut = new Maillon<>("amande");
      debut2 = insererOrdreCroissant(debut, "cafe");
      afficherChaine(debut2); //amande  cafe

      debut = debut2;
      debut2 = insererOrdreCroissant(debut, "aiglefin");
      afficherChaine(debut2); //aiglefin  amande  cafe 

      debut = debut2;
      debut2 = insererOrdreCroissant(debut, "coke");
      afficherChaine(debut2); //aiglefin  amande  cafe  coke

      debut = debut2;
      debut2 = insererOrdreCroissant(debut, "bine");
      afficherChaine(debut2); //aiglefin  amande  bine  cafe  coke

      debut = debut2;
      debut2 = insererOrdreCroissant(debut, "abat");
      afficherChaine(debut2); //abat aiglefin  amande  bine  cafe  coke

      debut = debut2;
      debut2 = insererOrdreCroissant(debut, "sandwich");
      afficherChaine(debut2); //abat aiglefin  amande  bine  cafe  coke  sandwich

      debut = debut2;
      debut2 = insererOrdreCroissant(debut, "boeuf");
      afficherChaine(debut2); //abat  aiglefin  amande  bine  boeuf  cafe  coke  sandwich

   }

   public static void main(String[] args) {

      testsInsererChaine1DansChaine2();
      testsInsererOrdreCroissant();

   }
}
