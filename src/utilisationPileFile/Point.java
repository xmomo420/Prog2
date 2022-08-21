package utilisationPileFile;

public class Point {

   private int x;
   private int y;

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public void deplacer(int dx, int dy) {
      this.x = this.x + dx;
      this.y = this.y + dy;
   }

   public String toString() {
      return "(" + x + ", " + y + ")";
   }

   public boolean equals(Object o) {
      return o != null && o.getClass() == Point.class
              && ((Point) o).x == x && ((Point) o).y == y;
   }

}
