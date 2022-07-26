
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classes d'exemples de l'utilisation de la classe ArrayList.
 * 
 * @author Melanie Lord
 * @version 2013
 */
public class ExemplesArrayList {
   /**
    * Retourne vrai si o1 et o2 sont dans liste, faux sinon.
    * Retourne false si liste est null.
    * Si les deux éléments o1 et o2 sont egaux, la methode retourne vrai
    * meme s'il n'y a qu'une seule occurrence de o1 (ou o2) dans la liste.
    *
    * 
    * @param liste la liste dans laquelle chercher les deux objets donnes.
    * @param o1 un des deux objets a trouver dans la liste donnee.
    * @param o2 l'autre objet a trouver dans la liste donnee.
    * 
    * @return true si les deux objets donnes sont dans la liste donnee, 
    * faux sinon.
    */
   public static boolean contientCesDeuxElements 
               (ArrayList liste, Object o1, Object o2) {
      return liste != null && liste.contains(o1) && liste.contains(o2);
   
   }
  
   /**
    * Affiche tous les elements de cette liste dans l'ordre inverse,
    * un element par ligne. Si la liste est null, affiche "Liste null".
    * Si la liste est vide, affiche "Liste vide".
    * 
    * @param liste la liste a afficher dans l'ordre inverse. 
    */
   public static void afficherOrdreInverse(ArrayList liste) {
      
      if (liste == null) {
         System.out.println("Liste null");
      } else if (liste.isEmpty()){
         System.out.println("Liste vide");
      } else {
         for (int i = liste.size() - 1 ; i >= 0 ; i--) {
            System.out.println(liste.get(i));
         }
      }
   }
   
   /**
    * Modifie la liste donnee en transformant chaque chaine de caracteres 
    * qu'elle contient en Majuscule.
    * Si la liste est null ou vide, la liste donnee reste inchangee.
    * Si un element de la liste est null, il demeure inchange.
    * Si un element de la liste est deja en majuscule, il demeure inchange.
    * 
    * @param liste la liste a modifier en transformant tous ses elements, des
    * chaines de caracteres, en majuscules.
    */
   public static void chainesToMajuscules(ArrayList<String> liste) {
      String s;
      if (liste != null && !liste.isEmpty()) {
         for (int i = 0 ; i < liste.size() ; i++) {
            s = liste.get(i);
            if (s != null) {
               liste.set(i, s.toUpperCase());
            }
         }
      }
   
   }
   
   /**
    * Retourne la chaine formee par la concatenation de tous 
    * les caracteres contenus dans la liste donnee.
    * 
    * Si la liste donnee est null ou vide, retourne la chaine vide.
    * Si un element de la liste est null, on ne le concatene pas.
    * 
    * @param liste la liste dont il faut concatener les elements.
    * @return la chaine formee par la concatenation de tous les 
    *         caracteres contenus dans la liste donnee.
    */
   public static String listeToString(ArrayList<Character> liste) {
      String s = ""; //chaine vide
      
      if (liste != null && !liste.isEmpty()) {
         for (Character c : liste) {
            if (c != null) {
               s = s + c;
            }
         }
      }
      return s;
   }
   
   /**
    * Retourne vrai si la liste specifiee contient un nombre plus grand
    * ou egal au parametre n d'elements qui sont egaux a l'animal donne
    * en parametre, retourne faux sinon. On considere que deux objets
    * null sont egaux.
    * 
    * SOLUTION EN UTILISANT EXPLICITEMENT LA METHODE EQUALS POUR 
    * TESTER L'EGALITE ENTRE DEUX OBJETS ANIMAL.
    * 
    * @param liste la liste dans laquelle rechercher les doublons.
    *        Antecedent : liste NE DOIT PAS ETRE NULL.
    * @param n le nombre de doublons minimal pour que la methode
    *        retourne true.
    * @param animal l'animal dont on cherche les doublons.
    * @return true si la liste specifiee contient au moins n elements
    *         egaux a animal.
    */
   public static boolean contientAuMoinsNDoublons1
               (ArrayList<Animal> liste, int n, Animal animal) {
   
      Iterator<Animal> it = liste.iterator();
      Animal a;
      int compteur = 0;
      while(it.hasNext() && compteur < n) {
         a = it.next();
         if ((a == null && animal == null) || (a != null && a.equals(animal))) {
            compteur++;
         }
      }
      return compteur == n;
   }
   
   
   /**
    * Retourne vrai si la liste specifiee contient un nombre plus grand
    * ou egal au parametre n d'elements qui sont egaux a l'animal donne
    * en parametre, retourne faux sinon.
    * 
    * SOLUTION EN UTILISANT LA METHODE INDEX OF DE ARRAYLIST 
    * QUI UTILISE IMPLICITEMENT LA METHODE EQUALS POUR 
    * TESTER L'EGALITE ENTRE DEUX OBJETS ANIMAL.
    * 
    * @param liste la liste dans laquelle rechercher les doublons.
    *        Antecedent : liste NE DOIT PAS ETRE NULL.
    * @param n le nombre de doublons minimal pour que la methode
    *        retourne true.
    * @param animal l'animal dont on cherche les doublons.
    * @return true si la liste specifiee contient au moins n elements
    *         egaux a animal.
    */
   public static boolean contientAuMoinsNDoublons2
               (ArrayList<Animal> liste, int n, Animal animal) {
      
      int compteur = 0;
      int i = liste.indexOf(animal);
      List<Animal> subList = liste.subList(i + 1, liste.size());
      
      while (i != -1 && compteur < n) {
         compteur++;
         i = subList.indexOf(animal);
         subList = subList.subList(i + 1, subList.size());
         
      }
      return compteur == n;
   
   }
   
   
   /**
    * Supprime de la liste donnee tous les animaux qui sont de type Chien.
    * Si la liste donnee en parametre est null ou vide, elle demeure
    * inchangee. Si la liste donnee ne contient pas de Chien, elle reste 
    * inchangee.
    * 
    * @param lesAnimaux la liste dans laquelle on veut supprimer 
    *        tous les objets de type Chien.
    */
   public static void supprimerLesChiens
               (ArrayList<Animal> lesAnimaux) {
      Animal a;
      int j;
      if (lesAnimaux != null && !lesAnimaux.isEmpty()) {
      
         //la boucle foreach fait planter le programme 
         //(ConcurrentModificationException)
         //car on supprime des elements la liste en meme temps 
         //qu'on itere sur ses elements. 
         /*
         for (Animal a : lesAnimaux) {
            if (a instanceof Chien) {
               lesAnimaux.remove(a);
            }
         }
         */
         
         //Ne fonctionne pas car les indices de la liste
         //changent a mesure qu'on enleve des elements.
         //Risque de donner un resultat erronne.
         /*
         for (int i = 0 ; i < lesAnimaux.size() ; i++) {
            a = lesAnimaux.get(i);
            if (a instanceof Chien) {
               lesAnimaux.remove(a);
            }
         }
         */
         
         //OK
         j = 0;
         while (j < lesAnimaux.size()) {
            a = lesAnimaux.get(j); 
            if (a instanceof Chien) {
               lesAnimaux.remove(a);
            } else {
               //avancer i si on n'a rien retire de la liste
               j++;
            }
         } 
         
         //OK si on utilise la methode remove de l'iterateur
         //et non celle de la liste.
         Iterator<Animal> it = lesAnimaux.iterator();
         while (it.hasNext()) {
            a = it.next();
            if (a instanceof Chien) {
               //supprime de la liste le dernier element retourne par cet
               //iterateur (element retourne par le dernier appel a next)
               it.remove();
            }
         }
      } 
   }
   
   
   public static void main (String [] args) {
      
      
      //Test methode contientCesDeuxElements
      System.out.println("\nTEST METHODE CONTIENT CES DEUX ELEMENTS :\n");
      ArrayList liste = null;
      boolean contient;
      contient = contientCesDeuxElements(liste, null, null);
      System.out.println(contient);
      //devrait afficher : false
      
      contient = contientCesDeuxElements(liste, "Vert", null);
      System.out.println(contient);
      //devrait afficher : false
      
      contient = contientCesDeuxElements(liste, "Vert", new Animal("Toto"));
      System.out.println(contient);
      //devrait afficher : false
      
      liste = new ArrayList();
      contient = contientCesDeuxElements(liste, "Vert", new Animal("Toto"));
      System.out.println(contient);
      //devrait afficher : false
      
      liste.add("vert");
      liste.add(5);
      liste.add(new Animal("Toto"));
      liste.add(10);
      liste.add("rouge");
      liste.add(23);
      liste.add(new Chien("Hector", "wouf"));
      liste.add(null);
      liste.add("chien");
      contient = contientCesDeuxElements(liste, null, null);
      System.out.println(contient);
      //devrait afficher : true
      
      contient = contientCesDeuxElements(liste, 11, null);
      System.out.println(contient);
      //devrait afficher : false
      
      contient = contientCesDeuxElements(liste, "23", 22);
      System.out.println(contient);
      //devrait afficher : false
      
      contient = contientCesDeuxElements(liste, new Chien("Hector", "wouf"), "vert");
      System.out.println(contient);
      //devrait afficher : true
      
      contient = contientCesDeuxElements(liste, 23, null);
      System.out.println(contient);
      //devrait afficher : true
      
      //Test methode contientAuMoinsNDoublons1
      System.out.println("TEST METHODE AFFICHER ORDRE INVERSE :\n");
      
      ArrayList liste1 = null;
      afficherOrdreInverse(liste1);
      //devrait afficher : Liste null

      liste1 = new ArrayList();
      afficherOrdreInverse(liste1);
      //devrait afficher : Liste vide
      
      liste1.add(2);
      afficherOrdreInverse(liste1);
      //devrait afficher : 2
      
      liste1.add(7);
      liste1.add("coucou");
      liste1.add(true);
      afficherOrdreInverse(liste1);
      //devrait afficher :
      //true
      //coucou
      //7
      //2
      
      //Test methode contientAuMoinsNDoublons1
      System.out.println("\nTEST METHODE CONTIEN AU MOINS N DOUBLONS 1 :\n");
      ArrayList<Animal> lesAnimaux = new ArrayList<>();
      
      //liste de 13 elements : 
      //2 Titi
      //4 Toto
      //2 null
      //3 Lili
      //1 Lulu
      //1 Loulou
      lesAnimaux.add(new Animal("Titi"));  
      lesAnimaux.add(new Animal("Toto"));
      lesAnimaux.add(new Animal("Lili"));
      lesAnimaux.add(new Animal("Lulu"));
      lesAnimaux.add(new Animal("Toto"));
      lesAnimaux.add(new Animal("Titi"));
      lesAnimaux.add(null);
      lesAnimaux.add(new Animal("Toto"));
      lesAnimaux.add(new Animal("Lili"));
      lesAnimaux.add(new Animal("Toto"));
      lesAnimaux.add(null);
      lesAnimaux.add(new Animal("Lili"));
      lesAnimaux.add(new Animal("LouLou"));
      

      System.out.println(contientAuMoinsNDoublons1
                           (lesAnimaux, 2, new Animal("Toto"))); //true
      
      System.out.println(contientAuMoinsNDoublons1
                           (lesAnimaux, 4, new Animal("Toto"))); //true
            
      System.out.println(contientAuMoinsNDoublons1
                           (lesAnimaux, 5, new Animal("Toto"))); //false
      
      System.out.println(contientAuMoinsNDoublons1
                           (lesAnimaux, 2, null));  //true
      
      System.out.println(contientAuMoinsNDoublons1
                           (lesAnimaux, 3, null)); //false
      
      System.out.println(contientAuMoinsNDoublons1
                           (lesAnimaux, 2, new Animal("Loulou"))); //false
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 2, new Animal("Serge"))); //false
      
      
      //Test methode contientAuMoinsNDoublons2
      System.out.println("\nTEST METHODE CONTIEN AU MOINS N DOUBLONS 2 :\n");
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 2, new Animal("Toto"))); //true
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 4, new Animal("Toto"))); //true
            
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 5, new Animal("Toto"))); //false
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 2, null));  //true
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 3, null)); //false
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 2, new Animal("Loulou"))); //false
      
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 2, new Animal("Serge"))); //false
      
      lesAnimaux.add(new Animal("Toto"));
      System.out.println(contientAuMoinsNDoublons2
                           (lesAnimaux, 5, new Animal("Toto"))); //true
      
      //NOTE : 
      //REFAIRE LES DEUX TESTS PRECEDENTS EN METTANT TEMPORAIREMENT EN 
      //COMMENTAIRES LA METHODE EQUALS DE LA CLASSE ANIMAL - VOUS 
      //N'OBTIENDREZ PAS LES MEMES RESULTATS.
      
      
      //POUR LES TESTS SUIVANTS, N'OUBLIEZ PAS D'ENLEVER LES COMMENTAIRES 
      //DE LA METHODE EQUALS DANS LA CLASSE ANIMAL.
      

      //on vide la liste
      lesAnimaux.clear();

      //Test methode supprimerLesChiens
      System.out.println("\nTEST METHODE SUPPRIMER LES CHIENS :\n");
      
      lesAnimaux.add(new Oiseau("Titi", "cui cui"));
      lesAnimaux.add(new Animal("Toto"));
      lesAnimaux.add(new Chien("Ben", "Wouffff"));
      lesAnimaux.add(new Chien("Junior", "Waf Waf"));
      lesAnimaux.add(new Oiseau("Marco", "fuittttt"));
      lesAnimaux.add(new Oiseau("Coco", "arrrrg"));
      lesAnimaux.add(new Chien("Ben", "Wouffff"));
      lesAnimaux.add(null);
      lesAnimaux.add(new Animal("Voltere"));
      lesAnimaux.add(new Chien("Fripouille", "grrrrr"));
      lesAnimaux.add(new Animal("Lulu"));
      lesAnimaux.add(new Animal("Pitou"));
      lesAnimaux.add(new Chien("Junior", "Wifff"));
      
      supprimerLesChiens(null); //ne doit pas planter
      
      ArrayList<Animal> listeVide = new ArrayList<>();
      supprimerLesChiens(listeVide);
      System.out.println(listeVide);
      //devrait afficher : 
      //[] //liste vide - inchangee
      
      supprimerLesChiens(lesAnimaux);
      System.out.println(lesAnimaux);
      //devrait afficher : 
      //[Titi cui cui, Toto, Marco fuittttt, Coco arrrrg, null, Voltere, Lulu, Pitou]
      
      //La liste ne contient aucun chien ici.
      supprimerLesChiens(lesAnimaux);
      System.out.println(lesAnimaux);
      //devrait afficher la liste inchangee : 
      //[Titi cui cui, Toto, Marco fuittttt, Coco arrrrg, null, Voltere, Lulu, Pitou]
      
      //Test methode listeToString
      System.out.println("\nTEST METHODE LISTE TO STRING :\n");
      ArrayList<Character> lesCar = null;
      String s = listeToString(lesCar);
      System.out.println(s.length());  //devrait afficher 0
      
      lesCar = new ArrayList<>();
      s = listeToString(lesCar);
      System.out.println(s.length());  //devrait afficher 0
      
      lesCar.add('A');
      s = listeToString(lesCar);
      System.out.println(s);  //devrait afficher A
      
      lesCar.add('L');
      lesCar.add('L');
      lesCar.add('O');
      s = listeToString(lesCar);
      System.out.println(s);  //devrait afficher ALLO
      
      lesCar.add(null);
      lesCar.add('a');
      lesCar.add('l');
      s = listeToString(lesCar); 
      System.out.println(s);  //devrait afficher ALLOal
      
      
      //Test methode chainesToMajuscules
      System.out.println("\nTEST METHODE CHAINES TO MAJUSCULES :\n");
      
      ArrayList<String> listeDeChaines = null;
      chainesToMajuscules(listeDeChaines); 
      System.out.println(listeDeChaines);
      //devrait afficher : null
      
      listeDeChaines = new ArrayList<>();
      chainesToMajuscules(listeDeChaines); 
      System.out.println(listeDeChaines);
      //devrait afficher : []
      
      listeDeChaines.add("allo");
      listeDeChaines.add(null);
      listeDeChaines.add("aLLO");
      listeDeChaines.add("alLo");
      listeDeChaines.add("ALLO");
      listeDeChaines.add(null);
      chainesToMajuscules(listeDeChaines); 
      System.out.println(listeDeChaines);
      //devrait afficher : [ALLO, null, ALLO, ALLO, ALLO, null]
      
   }   
}
