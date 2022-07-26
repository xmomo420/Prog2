package laboArrayList;

public class Point {

    private int x; //abcisse
    private int y; //ordonnee

    public Point ( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void deplacer (int dx, int dy ) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }


    public boolean equals(Point point) {
        return point.x == this.x && point.y == this.y;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point)obj;
        return this.equals(p);
    }
}