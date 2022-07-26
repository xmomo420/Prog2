package laboClassesAbstraites;

public abstract class ElementGraphique {

   private int x; // coordonnee x de la position de l'element
   private int y; // coordonnee y de la position de l'element

   public String toString() {
      return "position : ( " + x + ", " + y + " )";
   }

   public void placer(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public abstract double surface();

   public abstract double perimetre();

}
