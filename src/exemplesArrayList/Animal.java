
public class Animal {
   private String nom;
   
   /**
    * Construit un animal ayant le nom 
    * "Anonyme".
    */
   public Animal() {
      this.nom = "Anonyme"; 
   }
   
   /**
    * Constructeur qui initialise le nom de cet 
    * Animal.
    * @param nom le nom de cet Animal
    *        ANT: ne doit pas etre null.
    */
   public Animal (String nom) {
      this.nom = nom;
   }

   /**
    * Redefinition de la methode toString() de 
    * la classe Object.
    * @return une representation sous forme de 
    * chaine de caracteres.
    * de cet Animal.
    */
   public String toString() {
      return this.nom;
   }
   
   /**
    * Redefinition de la methode equals 
    * de la classe Object.
    * Deux objets Animal sont égaux s'ils ont le 
    * meme nom et le meme age.
    * @return true si les deux Animal sont égaux, 
    * false sinon.
    */
   public boolean equals (Object autreAnimal) {
      return 
        //verifie que autreAnimal n'est pas null 
        //(sinon return faux)
        autreAnimal != null &&
              
        //verifie que les deux objets compares sont 
        //de meme classe
        this.getClass().equals(autreAnimal.getClass()) &&
              
        //verifie l'egalite des attributs 
        //on suppose ici que this.nom n'est pas null
        this.nom.equals(((Animal)autreAnimal).nom);
   }
}
