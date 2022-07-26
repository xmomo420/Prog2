package laboClassesAbstraites;

public class Carre2 implements ElementGraphiqueInter {

    private int longueurCarre;
    private int x;
    private int y;

    public Carre2 (int longueurCarre, int x, int y) {
        this.longueurCarre = longueurCarre;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "position : ( " + x + ", " + y + " )\nlongueur carre : " +
                longueurCarre + "\n";
    }

    @Override
    public double perimetre() {
        return longueurCarre * 4;
    }

    @Override
    public double surface() {
        return Math.pow(longueurCarre, 2);
    }
}
