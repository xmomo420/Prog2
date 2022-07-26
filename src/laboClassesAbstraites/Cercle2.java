package laboClassesAbstraites;

public class Cercle2 implements ElementGraphiqueInter {

private int x;
private int y;
private int longueurRayon;

    @Override
    public double surface() {
        return Math.PI * Math.pow(longueurRayon, 2);
    }

    @Override
    public double perimetre() {
        return 2 * longueurRayon * Math.PI;
    }

    @Override
    public String toString() {
        return "position : ( " + x + ", " + y + " )\nLongueur du rayon : "
                + longueurRayon;
    }

    public Cercle2 (int longueurRayon, int x, int y) {
        this.longueurRayon = longueurRayon;
        this.x = x;
        this.y = y;
    }
}
