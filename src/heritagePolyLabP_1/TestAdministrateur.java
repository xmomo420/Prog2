package heritagePolyLabP_1;
import lectureClavier.Clavier;

public class TestAdministrateur {
    private final static Employe [] TABLEAU_EMPLOYE_NULL = null;
    private final static String MSG_JOUR = "Quel jour êtes-vous né ? ";
    private final static String MSG_HEURES = "Combien d'heures " +
            "travaillez-vous en une semaine : ";
    private final static String MSG_MOIS = "Quel mois êtes-vous né ? ";
    private final static String MSG_ANNÉE = "Dans quelle année êtes-vous né ? ";
    public final static String MSG_ERR_DOUBLE = "Nombre invalide, il faut " +
            "entrer" +
            " un nombre supérieur à 0\n";
    public final static String MSG_ERR_INT = "Nombre invalide, il faut entrer" +
            " un nombre ENTIER qui correspond à la donnée demandée\n";
    private final static int ANNÉE_MAX = 2022;
    private final static int MOIS_MAX = 12;
    private final static int JOUR_MAX = 31;
    private final static int ANNÉE_MIN = 1900;
    private final static int MOIS_MIN = 1;
    private final static int JOUR_MIN = 1;
    private static final int HEURE_MAX = 24 * 7;
    private static final int HEURE_MIN = 0;
    private final static double SALAIRE_MIN = 0.0;
    private final static double DOUBLE_MAX = Double.MAX_VALUE;
    private final static String MSG_SAL_ANN = "Quel est votre salaire " +
            "annuel : ";
    private static final String MSG_SAL_HOR = "Quel est votre salaire " +
            "horaire : ";

    public static void afficherTableau (Employe[] tab) {
        int i = 0;

        try {
            while (i < tab.length) {
                System.out.println(tab[i++].toString() + "\n");
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }




    public static void afficherTableau2 (Employe[] tab) {
        int i = 0;
        while (i < tab.length)
            try {
                while (i < tab.length) {
                    System.out.println(tab[i++].getClass().getSimpleName()
                            + "\n");
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (NegativeArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }

    public static int validerEntier(String msgSoll, String msgErr,
                                    int min, int max) {
        int entier = min - 1;
        while (entier < min || entier > max) {
            try {
                System.out.print(msgSoll);
                entier = Clavier.lireInt();
                if (entier < min || entier > max) {
                    System.out.println(msgErr);
                }
            } catch (NumberFormatException e) {
                System.out.println(msgErr);
            }
        }
        return entier;
    }

    public static double validerDouble(String msgSoll, String msgErr,
                                    double min, double max) {
        double reel = min - 1;
        while (reel < min || reel > max) {
            try {
                System.out.print(msgSoll);
                reel = Clavier.lireDouble();
                if (reel < min || reel > max) {
                    System.out.println(msgErr);
                }
            } catch (NumberFormatException e) {
                System.out.println(msgErr);
            }
        }
        return reel;
    }

    public static void main(String[] args) {
        if (1 == 2) {
            try {
                Date date = new Date(2019, 6, 20);
                Employe e1 = new Employe("Mohamed", date);
                EmployeSalarie e2 = new EmployeSalarie(e1.getNom(),
                        e1.getDateDembauche(), 18500);
                EmployeHoraire e3 = new EmployeHoraire(e1.getNom(),
                        e1.getDateDembauche(), 14.05, 25);
                Administrateur a = new Administrateur("Adjoint",
                        "André", "Produits frais",
                        e3.getTauxHoraire(), e1.getNom(), e1.getDateDembauche(),
                        e2.getSalaire());

                System.out.println("1 : " + e1.toString() + "\n");
                System.out.println("2 : " + e2.toString() + "\n");
                System.out.println("3 : " + e3.toString() + "\n");
                System.out.println("4 : " + a.toString() + "\n");

                Employe[] tab = new Employe[5];
                tab[0] = e1;
                tab[1] = e2;
                tab[2] = e3;
                tab[3] = a;

                System.out.println("Tableau 1 :");
                afficherTableau(tab);
                System.out.println("\nTableau 2 :");
                afficherTableau2(tab);

            } catch (ErrConstDate e) {
                System.out.println(e.getMessage());
            }
        } else {
        int jour = validerEntier(MSG_JOUR, MSG_ERR_INT, JOUR_MIN, JOUR_MAX);
        int mois = validerEntier(MSG_MOIS, MSG_ERR_INT, MOIS_MIN, MOIS_MAX);
        int annee = validerEntier(MSG_ANNÉE, MSG_ERR_INT, ANNÉE_MIN, ANNÉE_MAX);
        System.out.print("\nC'est quoi votre nom : ");
        String nom = Clavier.lireString();
        System.out.print("\nC'est quoi votre titre : ");
        String titre = Clavier.lireString();
        System.out.print("\nC'est quoi votre domaine : ");
        String domaine = Clavier.lireString();
        System.out.print("\nC'est quoi le nom de votre superviseur :  : ");
        String nomSup = Clavier.lireString();
        System.out.println();
        double salaireHoraire = validerDouble(MSG_SAL_HOR, MSG_ERR_DOUBLE,
                SALAIRE_MIN, DOUBLE_MAX);
        double salaireAnnuel = validerDouble(MSG_SAL_ANN, MSG_ERR_DOUBLE,
                SALAIRE_MIN, DOUBLE_MAX);
        int nbrHr = validerEntier(MSG_HEURES, MSG_ERR_INT, HEURE_MIN,
                HEURE_MAX);
        try {
            Date date = new Date(annee, mois, jour);
            Employe momo = new Employe(nom, date);
            EmployeSalarie toto = new EmployeSalarie(momo.getNom(),
                    momo.getDateDembauche(), salaireAnnuel);
            EmployeHoraire soso = new EmployeHoraire(momo.getNom(),
                    momo.getDateDembauche(), salaireHoraire, nbrHr);
            Administrateur a = new Administrateur(titre, nomSup, domaine,
                    soso.getTauxHoraire(), momo.getNom(),
                    momo.getDateDembauche(), toto.getSalaire());

            System.out.println("1 : " + momo.toString() + "\n");
            System.out.println("2 : " + toto.toString() + "\n");
            System.out.println("3 : " + soso.toString() + "\n");
            System.out.println("4 : " + a.toString() + "\n");

            Employe[] tab = new Employe[5];
            tab[0] = momo;
            tab[1] = toto;
            tab[2] = soso;
            tab[3] = a;

            System.out.println("Tableau 1 :");
            afficherTableau(tab);
            System.out.println("\nTableau 2 :");
            afficherTableau2(tab);

        } catch (ErrConstDate e) {
        System.out.println(e.getMessage());
        }


        }
        }
}

