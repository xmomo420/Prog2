package laboLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Exercice2 {

    private static final String monNom = "Mohamed Bendourou";
    private static final String monCodePermanent = "BENM23109703";
    private static final List<String> mesCours = new ArrayList<>(Arrays.asList(
            "INF2120","INF2050","INF3190","INF2171"));

    /**
     * Affiche l'objet donne en utilisant l'afficheur donne.
     * @param <T> type de l'objet a afficher
     * @param objet l'objet a afficher
     * @param afficheur methode d'affichage de l'objet donne.
     */
    public static<T> void afficher(T objet,
                                   IAffichable<T> afficheur) {
        afficheur.afficher(objet);
    }

    /**
     * Permet d'obtenir les animaux de la liste donnee qui sont en accord avec
     * le Predicate donne.
     * @param animaux liste des animaux dans laquelle on doit chercher ceux
    qui sont en accord avec le Predicate donne
     * @param testeur la methode pour selectionner les animaux
     * @return la liste des animaux selectionnes par le testeur donne
     */
    public static List<Animal> obtenir (List<Animal> animaux,
                                        Predicate<Animal> testeur) {
        List<Animal> animauxEnAccordAvecPredicatDonne = new ArrayList<>();
        for (Animal animal : animaux) {
            if (testeur.test(animal)) {
                animauxEnAccordAvecPredicatDonne.add(animal);
            }
        }
        return animauxEnAccordAvecPredicatDonne;
    }

    public static void main(String[] args) {

        IAffichable<List<Animal>> afficherListesAnimaux = (List<Animal> animaux)
                -> {
            String separateur = " | ";
            for (Animal animal : animaux) {
                if (animal.equals(animaux.get(animaux.size() - 1))) {
                    separateur = "\n";
                }
                System.out.print(animal + separateur);
            }
        };

        IAffichable<Etudiant> afficherCours = (Etudiant etudiant) -> {
            String separateur = " | ";
            for (String etudiantSingulier : etudiant.getCours()) {
                if (etudiantSingulier.equals(etudiant.getCours().get
                        (etudiant.getCours().size() - 1))) {
                    separateur = "";
                }
                System.out.print(etudiantSingulier + separateur);
            }

        };

        Predicate<Animal> selectBruns = (Animal animal) -> animal.getCouleur().
                equalsIgnoreCase("brun".trim());
        Predicate<Animal> selectBleus = (Animal animal) -> animal.getCouleur().
                equalsIgnoreCase("bleu".trim());
        Predicate<Animal> selectPlusDe4Ans = (Animal animal) -> animal.
                getAge() > 4;
        Predicate<Animal> selectMoins10Ans = (Animal animal) -> animal.getAge()
                < 10;

        List<Animal> liste = new ArrayList<>();
        liste.add(new Animal("baleine", "bleu", 4));
        liste.add(new Animal("chien", "brun", 2));
        liste.add(new Animal("poisson", "rouge", 1));
        liste.add(new Animal("requin", "blanc", 4));
        liste.add(new Animal("vache", "brun", 3));
        liste.add(new Animal("oiseau", "jaune", 2));
        liste.add(new Animal("cheval", "brun", 5));
        liste.add(new Animal("tortue", "vert", 14));
        liste.add(new Animal("perroquet", "bleu", 23));
        liste.add(new Animal("chat", "brun", 6));

        afficher(obtenir(liste,selectBruns),afficherListesAnimaux);
        afficher(obtenir(liste,selectBleus.or(selectBruns)),afficherListesAnimaux);
        afficher(obtenir(liste,selectBleus.or(selectBruns).and
                (selectPlusDe4Ans)),afficherListesAnimaux);
        afficher(obtenir(liste,selectMoins10Ans.negate()),afficherListesAnimaux);
        afficher(obtenir(liste,selectMoins10Ans.and(selectPlusDe4Ans)),
                afficherListesAnimaux);

        Etudiant etudiant = new Etudiant(monNom,monCodePermanent,mesCours);
        afficher(etudiant, afficherCours);
    }








    }


