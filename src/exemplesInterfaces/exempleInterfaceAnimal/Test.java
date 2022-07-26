package exemplesInterfaces.exempleInterfaceAnimal;

public class Test {

  //Affiche les animaux de ce tableau
	public static void afficher (IAnimal [] lesAnimaux) {
	  for (IAnimal a : lesAnimaux) {
			if (a != null) {
				a.sIdentifier();
  			a.seDeplacer();
  			a.communiquer();
  			System.out.println("----------------");
			}
  	}
	}

	//Retourne un tableau qui contient seulement les instances
  //de Poisson
	public static IAnimal[] trierLesPoissons (IAnimal [] lesAnimaux) {
		IAnimal [] lesPoissons = new IAnimal [lesAnimaux.length];
		int j = 0;
		for (IAnimal a : lesAnimaux) {
			if (a != null && a instanceof Poisson) {
				lesPoissons[j] = a;
				j++;
			}
  	}
		return lesPoissons;
	}
  

	public static void main () {

  	//Declaration de variables de type IAnimal et instanciation
  	//avec une instance d'une classe qui implemente IAnimal
  	IAnimal unPoisson = new Poisson ("rouge");
  	IAnimal unChien = new Chien ("chiwawa", 2, "wif wif");
  	IAnimal unOiseau = new Oiseau ("chique di di di", "mesange", "court et mince");
  
  	//Declaration d'un tableau de type IAnimal
  	IAnimal [] lesAnimaux = new IAnimal [4];
  
  	//Instanciation des cases du tableau avec une instance
  	//d'une classe qui implémente IAnimal
  	lesAnimaux[0] = unPoisson;
  	lesAnimaux[1] = unChien;
  	lesAnimaux[2] = unOiseau;
    lesAnimaux[3] = new Poisson("doré");
  
		System.out.println("AFFICHER LES ANIMAUX\n");
  	afficher(lesAnimaux);
		
		IAnimal [] lesPoissons = trierLesPoissons(lesAnimaux);

		System.out.println("\nAFFICHER LES POISSONS\n");
		afficher(lesPoissons);	
  }
}

/* 
RESULTAT MAIN :

AFFICHER LES ANIMAUX

Je suis un poisson rouge
Je nage
...
----------------
Je suis un chiwawa et j'ai 2 an(s)
Je marche et je cours
wif wif
----------------
Je suis un(e) mesange et mon bec est court et mince
Je vole !
chique di di di
----------------
Je suis un poisson doré
Je nage
...
----------------

AFFICHER LES POISSONS

Je suis un poisson rouge
Je nage
...
----------------
Je suis un poisson doré
Je nage
...
----------------
*/