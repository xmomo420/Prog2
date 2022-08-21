package recursivite;

import java.util.List;

public class AutresExemplesRecursion {

	//------------
	//POUR TRACE
	//------------
	
	/**
	 * Cette methode retourne une chaine de caracteres formee par la
	 * concatenation de tous les caracteres c contenus dans s.
	 *
	 * @param c le caractere a chercher dans s pour les concatener.
	 * @param s la chaine de caracteres dont on veut concatener tous les
	 * caracteres c qui y sont presents.
	 *
	 * ANTECEDENTS : s ne doit pas etre null.
	 *
	 * @return une chaine de caracteres formee par la concatenation de tous les
	 * caracteres c contenus dans s.
	 */
	public static String quoi(char c, String s) {
		String resultat = "";
		if (s.length() > 0) {
			if (s.charAt(0) == c) {
				resultat = c + quoi(c, s.substring(1));
			} else {
				resultat = quoi(c, s.substring(1));
			}
		}
		return resultat;
	}



	//------------
	//EXEMPLES
	//------------
	 
	/**
	 * Lit une suite de caracteres jusqu'a l'entree du caractere '.' et affiche
	 * ensuite les caracteres entres dans l'ordre inverse (sauf le '.' entre a la
	 * fin de la sequence).
	 */
	public static void inverserCarLus() {
		char c;
		c = Clavier.lireChar(); 
		if (c != '.') {
			inverserCarLus();
			System.out.print(c);
		}
	}

	/**
	 * Retourne une nouvelle chaine de caracteres qui contient les caracteres de
	 * s, dans l'ordre inverse.
	 *
	 * @param s la chaine de caracteres avec laquelle on veut creer une nouvelle
	 * chaine qui contient les memes caracteres, mais dans l'ordre inverse.
	 *
	 * ANTECEDENTS : s ne doit pas etre null.
	 *
	 * @return une nouvelle chaine de caracteres qui contient les memes
	 * caracteres que s, mais dans l'ordre inverse.
	 */
	public static String inverser(String s) {
		char c;
		String tmp = s;
		String sInverse = "";

		if (s.length() > 1) {
			//s sans son dernier car
			tmp = s.substring(0, s.length() - 1);

			//dernier car de s
			c = s.charAt(s.length() - 1);
			sInverse = c + inverser(tmp);

			//cas de base
		} else {
			sInverse = s;
		}
		return sInverse;
	}

	/**
	 * Retourne le nombre de chiffres de n.
	 *
	 * @param n le nombre dont on veut compter les chiffres.
	 * @return le nombre de chiffres de n.
	 */
	public static int nbChiffres(int n) {
		int reponse;
		if (n < 0) {
			reponse = nbChiffres(-n);
		} else if (n < 10) {
			reponse = 1;
		} else {
			reponse = 1 + nbChiffres(n / 10);
		}
		return reponse;
	}

   /**
    * Retourne vrai si la liste donnee contient l'objet o, faux sinon.
    *
    * @param o l'objet recherche.
    *          ANTECEDENT : o et liste ne doivent pas etre null.
    * @param liste la liste dans laquelle rechercher o.
    * @return true si liste contient o, false sinon.
    */
   public static boolean contientElem(Object o, List liste) {
      boolean contient = false;
      if (liste.isEmpty()) {
         contient = false;
         //dernier element de la liste, on arrete la recursion
      } else if (liste.size() == 1) {
         contient = o.equals(liste.get(0));
      } else {
         contient = o.equals(liste.get(0))
                 || contientElem(o, liste.subList(1, liste.size()));
      }
      return contient;
   }

	
	
   /**
    * Retourne le plus grand entier contenu dans la portion du tableau tab allant
    * de indiceDebut jusqu'a la fin du tableau.
    *
    * @param tab le tableau dans lequel on veut chercher l'entier le plus grand
    * @param indiceDebut definit la portion du tableau dans laquelle chercher
    *			 l'entier le plus grand : [indiceDebut... tab.longueur - 1] 
    *			 (de indiceDebut jusqu'a la fin du tableau).
    * 
    *			 NOTE : l'appel de maxDansTab(tab, 0) retourne l'entier le plus grand 
    *					  parmi tous les elements du tableau tab.
    * 
    * @return l'entier le plus grand  (le maximum) se trouvant dans le tableau 
    *         tab a partir de indiceDebut. 
    * @throws RuntimeException si - tab est null  
    *										 - la longueur de tab est 0 (tableau vide)
    *										 - indiceDebut >= tab.length
    *                             - indiceDebut < 0
    */
   public static int maxDansTab (int[] tab, int indiceDebut) {
      int max = 0;
      int maxTmp;

      if (tab == null || tab.length == 0 
              || indiceDebut < 0 || indiceDebut >= tab.length) {
         throw new RuntimeException ("ERREUR, parametre(s) invalide(s)");
      }

      //CAS DE BASE : la portion de tab [indiceDebut... tab.length - 1] 
      //ne contient qu'un seul element.
      if (indiceDebut == tab.length - 1) {
         max = tab[tab.length - 1];

      //appel recursif 
      } else {
         maxTmp = maxDansTab(tab, indiceDebut + 1);
         if (tab[indiceDebut] > maxTmp) {
            max = tab[indiceDebut];
         } else {
            max = maxTmp;
         }

         //Note : le if... else ci-dessus pourrait etre remplace par l'instruction :
         //max = Math.max(tab[indiceDebut], maxDansTab(tab, indiceDebut + 1));
      }
      return max;
   }
   
   //pour tests
   public static void main (String [] args) {
      int [] tab = {1, 2, 9, 3, 1, 7, 4};
      try { // cas d'exception.
         System.out.println(maxDansTab(tab, -1));
         System.out.println(maxDansTab(tab, 7));
         System.out.println(maxDansTab(null, -1));
         System.out.println(maxDansTab(new int[] {}, -1));
      } catch (RuntimeException re) {
         System.out.println("OK");
      }
      
      System.out.println(maxDansTab(tab, 0)); //9
      System.out.println(maxDansTab(tab, 1)); //9
      System.out.println(maxDansTab(tab, 2)); //9
      System.out.println(maxDansTab(tab, 3)); //7
      System.out.println(maxDansTab(tab, 4)); //7
      System.out.println(maxDansTab(tab, 5)); //7
      System.out.println(maxDansTab(tab, 6)); //4
      
   }

}
