//NOTE : les methodes suivantes supposent des parametres non negatifs.

public class ExemplesMethodesRecursives {

  public static int factorielle ( int n ) {
    int resultat;
    if ( n < 2 ) { // n = 0 ou 1
      resultat = 1;
    } else {
      resultat = n * factorielle ( n - 1 );
    }
    return resultat;
  } 

  public static int plus ( int a, int b ) {
    int resultat;
    if ( a == 0 ) {
      resultat = b;
    } else if ( b == 0 ) {
      resultat = a;
    } else if ( a < b ) {
      resultat = plus ( b, a ); // optimisation
    } else { // a >= b
      resultat = 1 + plus ( a, b - 1 );
    }
    return resultat;
  }

  public static int mult ( int a, int b ) {
    int resultat;
    if ( a == 0 || b == 0 ) {
      resultat = 0;
    } else if ( a < b ) {
      resultat = mult ( b, a ); // optimisation
    } else {
      resultat = a + mult ( a, b - 1 );
    }
    return resultat;
  }

  public static double expo1 ( double a, int b ) {
    double resultat;
    if ( b == 0 ) {
      resultat = 1;
    } else if ( a == 0 ) {
      resultat = 0;
    } else if ( b < 0 ) {
      resultat = expo1 ( 1 / a, -b );
    } else {
      resultat = a * expo1 ( a, b - 1 );
    }
    return resultat;
  }

  public static double expo2 ( double a, int b ) {
    double resultat;
    double temp;
    if ( b == 0 ) {
      resultat = 1;
    } else if ( a == 0 ) {
      resultat = 0;
    } else if ( b % 2 == 1 ) { // b impair ?
      resultat = a * expo2 ( a, b - 1 );
    } else {
      temp = expo2 ( a, b / 2 );
      resultat = temp * temp;
    }
    return resultat;
  }

  public static int pgcd ( int a, int b ) {
    int resultat;
    if ( a == b ) {
      resultat = a;
    } else if ( a < b ) {
      resultat = pgcd ( b - a, a );
    } else {
      resultat = pgcd ( a - b, b );
    }
    return resultat;
  }

	public static int fibonacci (int ieme) {
		int resultat;
		if (ieme == 0 || ieme == 1) {
			resultat = ieme;
		} else {
			//somme des deux nombres precedents
			resultat = fibonacci(ieme - 1) + fibonacci (ieme - 2);
		}
		return resultat;
	}


}
