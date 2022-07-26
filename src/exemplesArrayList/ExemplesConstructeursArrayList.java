
import java.util.ArrayList;

/**
 * Cette classe contient des exemples de l'utilisation des constructeurs de 
 * la classe AraryList.
 * 
 * @author Melanie Lord
 * @version 2013
 */
public class ExemplesConstructeursArrayList {
   
   public static void main (String [] args){
      
      //Creation d'une liste (de type Object) vide de capacite initiale egale a 10.
      //On ne mentionne pas ici de type pour les objets de la collection qui sont
      //alors, par défaut, de type Object.
      ArrayList listeObjets = new ArrayList();

      //Creation d'une liste (de type Character) vide de capacite initiale egale a 10.
      ArrayList<Character> listeCar = new ArrayList<Character>();

      //Creation d'une liste (de type Double) vide de capacite initiale egale a 100.
      ArrayList<Double> listeDeNombresReels = new ArrayList<>(100);

      //Ajout d'elements dans la liste listeDeNombresReels
      listeDeNombresReels.add(2.333);
      listeDeNombresReels.add(-34.5);
      listeDeNombresReels.add(0.1);

      //Creation d'une liste contenant les memes elements que listeDeNombresReels.
      ArrayList<Double> listeDeNombresReels2 = new ArrayList<>(listeDeNombresReels);

      //Ne compile pas parce que la liste donnee en parametre est une liste de type Character.
      //ArrayList<Double> listeDeNombresReels3 = new ArrayList<>(listeCar);
      
      ArrayList<Animal> lesAnimaux1 = new ArrayList<>();
      lesAnimaux1.add(new Chien("Hector", "Wouf"));
      lesAnimaux1.add(new Oiseau("Camen", "Couli cou cou cou"));
      lesAnimaux1.add(new Animal("Charlie"));
      //lesAnimaux1.add(9); //Ne compile pas car un Integer ne peut etre converti en 
                            //Animal

   }
   
}
