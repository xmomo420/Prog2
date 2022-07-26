package laboClassesAbstraites;

public class Carre extends ElementGraphique {

private int longueurCarre;

    //Concretisation des methodes abstraites de la classe parente
    @Override
    public double surface() {
        return Math.pow(longueurCarre, 2);
    }
    @Override
    public double perimetre() {
        return 4 * longueurCarre;
    }

    //Redefinition de la classe toString()
    @Override
    public String toString() {
        return super.toString() + "\nlongueur carre : " + longueurCarre;
    }
    //Constructeur
    public Carre (int longueurCarre, int x, int y) {
        super.placer(x, y);
        this.longueurCarre = longueurCarre;
    }
}
