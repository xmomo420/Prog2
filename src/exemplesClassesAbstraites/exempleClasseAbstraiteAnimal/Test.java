package exemplesClassesAbstraites.exempleClasseAbstraiteAnimal;

public class Test {

   public static void afficherDeplacement(Animal[] lesAnimaux) {
      for (Animal a : lesAnimaux) {
         if (a != null) {
            a.seDeplacer();
         }
      }
   }

   public static void main(String[] args) {
      Animal[] tab = new Animal[2];
      tab[0] = new Oiseau();
      tab[1] = new Chien();

      afficherDeplacement(tab);
   }
}
