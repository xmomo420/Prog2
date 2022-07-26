package exemplesClassesAbstraites.exempleClasseAbstraiteFigureGeometrique;

public abstract class FigureGeometrique {

   private int couleur;
   private boolean estPleine;

   /**
    * Une figure geometrique de couleur 0, vide
    */
   public FigureGeometrique() {
      this(0, false);
   }

   /**
    * Une figure geometrique
    *
    * @param couleur sa couleur
    * @param pleine true si pleine, false sinon
    */
   public FigureGeometrique(int couleur, boolean pleine) {
      this.couleur = couleur;
      this.estPleine = pleine;
   }

   //GETTERS ET SETTERS
   
   /**
    * Determine la couleur de la figure
    *
    * @return sa couleur
    */
   public int getCouleur() {
      return couleur;
   }

   /**
    * Determine si vide ou non
    *
    * @return true si vide, false sinon
    */
   public boolean estVide() {
      return !estPleine;
   }

   /**
    * Changer la couleur
    *
    * @param couleur la nouvelle couleur
    */
   public void setCouleur(int couleur) {
      this.couleur = couleur;
   }

   /**
    * Changer la valeur de pleine
    *
    * @param pleine true si pleine, false sinon
    */
   public void setEstPleine(boolean pleine) {
      this.estPleine = pleine;
   }
}
