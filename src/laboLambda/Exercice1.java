package laboLambda;

public class Exercice1 {

    ICalculable rectangle = new ICalculable() {

        /**
         * Execute un calcul sur a et b, et retourne la valeur calculee.
         * @param a premiere valeur impliquee dans le calcul
         * @param b deuxieme valeur impliquee dans le calcul
         * @return le resultat du calcul
         */
        @Override
        public double calculer(double a, double b) {
            return a * b;
        }
    };

    ICalculable salaire = new ICalculable() {

        /**
         * Execute un calcul sur a et b, et retourne la valeur calculee.
         * @param a premiere valeur impliquee dans le calcul
         * @param b deuxieme valeur impliquee dans le calcul
         * @return le resultat du calcul
         */
        @Override
        public double calculer(double a, double b) {
            double paie;
            if (b > 35) {
                paie = a * b + (b - 35) * a * 2;
            } else
                paie = a * b;
            return paie;
        }
    };

    ICalculable rectangleLambda = (double a, double b) -> a * b;

    ICalculable salaireLambda = (double a, double b) -> {
        double paie;
        if (b > 35) {
            paie = a * b + (b - 35) * a * 2;
        } else
            paie = a * b;
        return paie;
    };








}
