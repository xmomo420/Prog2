
/**
 * Classe qui modélise un animal domestique.
 * @author Melanie Lord
 * @version 2013
 */
package heritagePolyExemple;
public class AnimalDomestique {
   String nom; //acces paquetage
   private int age; //acces prive
   
   public AnimalDomestique() {
      System.out.println("Construction d'un objet de type " + this.getClass().getName());
      this.nom = "Anonyme";  //non défini
      this.age = 0;          //non défini
   }
   
   public AnimalDomestique (String nom) {
      this ();
      this.nom = nom;
   }
   
   public AnimalDomestique (String nom, int age) {
      this (nom);
      this.age = age;
   }
   
   /**
    * Affiche la maniere dont cet AnimalDomestique se
    * deplace.
    */
   public void meDeplacer() {
      System.out.println("Je me deplace de maniere quelconque."); 
   }
   
   /**
    * Affiche un message d'identification
    */
   public void mIdentifier () {
      System.out.println(this.toString());
   }
   
   public void monAgeEst() {
      System.out.println(age);
   }
   
   /**
    * Redefinition de la methode toString() de la classe Object.
    * @return une representation sous forme de chaine de caracteres
    * de cet AnimalDomestique.
    */
   public String toString() {
      return 
         "Je suis un  : " + this.getClass().getName() + "\n" +
         "Mon nom est : " + this.nom + "\n" +
         "Mon age est : " + this.age;
   }
   
   /**
    * Redefinition de la methode equals de la classe Object.
    * Deux objets AnimalDomestique sont égaux s'ils ont le meme nom et 
    * e meme age.
    * @return true si les deux AnimalDomestique sont égaux, false sinon.
    */
   public boolean equals (Object autreAnimal) {
      return 
        //verifie que autreAnimal n'est pas null 
        //(sinon return faux)
        autreAnimal != null &&
              
        //verifie que les deux objets compares sont 
        //de meme classe
        //getClass() retourne le type dynamique ici
        this.getClass().equals(autreAnimal.getClass()) &&
              
        //verifie l'egalite des attributs
        this.nom.equals(((AnimalDomestique)autreAnimal).nom) &&
        this.age == ((AnimalDomestique)autreAnimal).age;
   }
   
   
   /* 
   //AUTRE VERSION POSSIBLE
   public boolean equals (Object autreAnimal) {
      return 
        //Optimisation : verifie qu'on ne teste pas 
        //l'egalite entre l'objet et lui-meme.  
        //Sinon, on retourne vrai et il n'est pas  
        //necessaire d'evaluer le reste de la condition.
        autreAnimal == this ||
              
        //verifie que autreAnimal n'est pas null 
        //(sinon return faux)
        (autreAnimal != null &&
              
        //verifie que les deux objets compares sont 
        //de meme classe
        //getClass() retourne le type dynamique ici
        this.getClass() == autreAnimal.getClass() &&
              
        //verifie l'egalite des attributs
        this.nom.equals(((AnimalDomestique)autreAnimal).nom) &&
        this.age == ((AnimalDomestique)autreAnimal).age  
        
        );
   }
   */
}
