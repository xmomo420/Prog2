
import java.util.ArrayList;

/**
 * Cette classe contient divers exemples d'utilisation de la classe
 * ArrayList.
 * @author Melanie Lord
 * @version 2014
 */
public class ExemplesMethodesArrayList {
   
   public static void main (String [] args){

      ArrayList<Animal> lesAnimaux = new ArrayList();
      Object lesAnimaux2;
      ArrayList<Chien> lesChiens;
      ArrayList<Oiseau> lesOiseaux;

      System.out.println(lesAnimaux.size());
      System.out.println(lesAnimaux.isEmpty());

      lesAnimaux.add(new Chien("Goofy", "Waffff"));
      lesAnimaux.add(new Oiseau("George", "biki ki ki"));
      lesAnimaux.add(new Oiseau("Coquette", "chikedi di di"));
      lesAnimaux.add(new Chien("Nemo", "Grrrr wouf"));
      lesAnimaux.add(new Animal ("Isa"));
      System.out.println(lesAnimaux);

      lesAnimaux.add(2, new Chien("Bob", "Wouffff"));
      System.out.println(lesAnimaux);

      System.out.println(lesAnimaux.size());

      System.out.println(lesAnimaux.isEmpty());

      lesAnimaux.add(6, new Oiseau()); 
      System.out.println(lesAnimaux);

      System.out.println(lesAnimaux.size());

      //lesAnimaux.add(-1, new Oiseau()); //IndexOutOfBoundsException
      //lesAnimaux.add(8, new Animal()); //IndexOutOfBoundsException

      lesChiens = new ArrayList<>();
      lesChiens.add(null); //ArrayList accepte les elements null
      lesChiens.add(new Chien("Nemo", "Grrrr wouf"));
      lesChiens.add(new Chien("Princesse", "wif wif"));
      //lesChiens.add(new Animal()); //ne compile pas
      //lesChiens.add(new Oiseau()); //ne compile pas
      System.out.println(lesChiens);

      lesAnimaux.addAll(lesChiens);
      System.out.println(lesAnimaux);

      lesOiseaux = new ArrayList<>();
      lesOiseaux.add(new Oiseau("Miss Myriam", "tourlou"));
      lesOiseaux.add(new Oiseau("Coquette", "cot cot"));
      lesAnimaux.addAll(1, lesOiseaux);
      System.out.println(lesAnimaux);

      Animal a = lesAnimaux.remove(5);
      System.out.println(a);
      System.out.println(lesAnimaux);

      boolean b = lesAnimaux.remove(null);
      System.out.println(b);

      b = lesAnimaux.remove(new Chien("Bob", "Wouffff"));
      System.out.println(b);

      b = lesAnimaux.remove(new Animal("Titi"));      
      System.out.println(b);

      b = lesAnimaux.removeAll(lesOiseaux);
      System.out.println(b);
      System.out.println(lesAnimaux);

      b = lesAnimaux.removeAll(lesOiseaux);
      System.out.println(b);

      System.out.println(lesAnimaux);

      System.out.println(lesAnimaux.size());

      System.out.println(lesAnimaux.get(0));

      System.out.println(lesAnimaux.get(2));

      System.out.println(lesAnimaux.get(6));

      //System.out.println(lesAnimaux.get(7)); //IndexOutOfBoundsException

      System.out.println(lesAnimaux.set(0, new Animal("Ted")));

      System.out.println(lesAnimaux);

      System.out.println(lesAnimaux.set(4, new Animal("Ted")));

      System.out.println(lesAnimaux);

      //ArrayIndexOutOfBoundsException
      //System.out.println(lesAnimaux.set(-1, new Animal("Juliette"))); 

      System.out.println(lesAnimaux.size());

      System.out.println(lesAnimaux.indexOf(new Chien("Nemo", "Grrrr wouf")));

      System.out.println(lesAnimaux.lastIndexOf(new Chien("Nemo", "Grrrr wouf")));

      System.out.println(lesAnimaux.indexOf(new Chien("Ted", "waf")));

      System.out.println(lesAnimaux.lastIndexOf(new Chien("Ted", "waf")));

      System.out.println(lesAnimaux.contains(new Chien("Nemo", "Grrrr wouf")));

      System.out.println(lesAnimaux.contains(new Chien("Bernard", "Grrrr wouf")));

      System.out.println(lesAnimaux.containsAll(lesChiens));

      lesAnimaux2 = lesAnimaux.clone();
      System.out.println(lesAnimaux2);

      lesChiens.clear();
      System.out.println(lesChiens.isEmpty());

      Animal [] tab = lesAnimaux.toArray(new Animal[0]);
      for (Animal unAnimal : tab) {
         System.out.println(unAnimal);
      }

   }
   
}
