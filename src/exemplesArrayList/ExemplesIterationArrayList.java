
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Melanie Lord
 * @version 2013
 */
public class ExemplesIterationArrayList {
   
   public static void main (String [] args) {
      ArrayList<String> liste = new ArrayList<>();
      liste.add("ciseaux");
      liste.add("colle");
      liste.add("cahier");
      liste.add("crayon");
      liste.add("règle");
      
      System.out.println("Iteration avec boucle for : ");
      //Avec boucle for
      for (int i = 0 ; i < liste.size() ; i++) {
         System.out.println(liste.get(i));
      }
      
      System.out.println("\nIteration avec boucle while : ");
      int i = 0;
      while (i < liste.size()) {
         System.out.println(liste.get(i));
         i++;
      }
      
      System.out.println("\nIteration avec boucle for amelioree : ");
      for (String s : liste) {
         System.out.println(s);
      }
      
      System.out.println("\nIteration avec un iterateur : ");
      //importer le paquetage import java.util.Iterator;
      Iterator<String> it = liste.iterator();
      while (it.hasNext()) {
         System.out.println(it.next());
      }
   }
}
