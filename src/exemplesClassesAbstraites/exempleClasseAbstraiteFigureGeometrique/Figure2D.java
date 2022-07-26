package exemplesClassesAbstraites.exempleClasseAbstraiteFigureGeometrique;

public abstract class Figure2D extends FigureGeometrique {
   //coordonnees de la figure dans un plan cartesien

   private int x; //abcisse
   private int y; //ordonne

   /**
    * Figure2D en (0,0) de couleur 0 et vide
    */
   public Figure2D() {
      this(0, 0);
   }

   /**
    * Figure2D de couleur 0, vide et de coordonnees x et y
    *
    * @param x position en x
    * @param y position en y
    */
   public Figure2D(int x, int y) {
      this(x, y, 0, false);
   }

   /**
    * Figure2D initialisee avec les valeurs des parametres
    */
   public Figure2D(int x, int y, int couleur, boolean pleine) {
      super(couleur, pleine);
      changerPosition(x, y);
   }

   /**
    * Donne la position x de la figure2D
    *
    * @return position x
    */
   public int getX() {
      return this.x;
   }

   /**
    * Donne la position y de la figure2D
    *
    * @return position y
    */
   public int getY() {
      return this.y;
   }

   /**
    * Changer la position de la figure2D
    *
    * @param x position en x
    */
   public void setX(int x) {
      this.x = x;
   }

   /**
    * Changer la position de la figure2D
    *
    * @param y position en y
    */
   public void setY(int y) {
      this.y = y;
   }

   /**
    * Changer la position de la figure2D
    *
    * @param x position en x
    * @param y position en y
    */
   public void changerPosition(int x, int y) {
      this.x = x;
      this.y = y;
   }

   //METHODES ABSTRAITES
   
   /**
    * Determine la surface de la figure2D
    *
    * @return la surface de la figure2D
    */
   public abstract double surface();

   /**
    * Representation de la figure 2D sous forme de String
    */
   public abstract String toString();
}
