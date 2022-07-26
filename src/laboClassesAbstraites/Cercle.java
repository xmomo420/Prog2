package laboClassesAbstraites;

public class Cercle extends ElementGraphique {

    private int longueurRayon;

    public Cercle (int longueurRayon, int x, int y) {
    super.placer(x, y);
    this.longueurRayon = longueurRayon;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLongueur du rayon : " + longueurRayon;
    }

    @Override
    public double perimetre() {
        return 2 * longueurRayon * Math.PI;
    }

    @Override
    public double surface() {
        return Math.PI * Math.pow(longueurRayon, 2);
    }
}
