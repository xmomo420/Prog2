package exemplesLambda;

/**
 * Exemples de classes locales et anonymes.
 * @author Melanie Lord
 * @version juin 2020
 */
 public class ExemplesClassesLocalesEtAnonymes {

   public void afficherAnimaux () {

      IComportementAnimal dauphin;
      IComportementAnimal moineau;
      
      //----------------------------
      // Classe locale
      //----------------------------

      //Declaration d'une classe locale qui implemente l'interface 
      //IComportementAnimal
      class Dauphin implements IComportementAnimal {

         @Override
         public void jeSuis() {
            System.out.println("Je suis un dauphin");
         }

         @Override
         public void seDeplacer() {
            System.out.println("Je nage");
         }

         @Override
         public void crier() {
            System.out.println("hi hi hi");
         }
      }

      //Utilisation de la classe interne locale Dauphin
      dauphin = new Dauphin();
      
      dauphin.jeSuis();
      dauphin.seDeplacer();
      dauphin.crier();

      //----------------------------
      // Classes anonymes
      //----------------------------
      
      //Declaration et instanciation d'une classe interne anonyme qui implemente 
      //l'interface IComportementAnimal et affectation a la variable moineau
      moineau = new IComportementAnimal() {
         @Override
         public void jeSuis() {
            System.out.println("Je suis un moineau");
         }
         
         @Override
         public void seDeplacer() {
            System.out.println("Je vole");
         }
         
         @Override
         public void crier() {
            System.out.println("cui cui cui");
         }
      };
      
      moineau.jeSuis();
      moineau.seDeplacer();
      moineau.crier();
      
      
      //Declaration et instanciation d'une classe interne anonyme qui implemente 
      //l'interface IComportementAnimal et appel de la methode crier sur l'objet
      //instancie.
      new IComportementAnimal() {
         @Override
         public void jeSuis() {
            System.out.println("Je suis une vache");
         }
         
         @Override
         public void seDeplacer() {
            System.out.println("Je mache");
         }
         
         @Override
         public void crier() {
            System.out.println("moooo");
         }
      }
              .crier();
   }
   
   public static void main (String [] args) {
      
      ExemplesClassesLocalesEtAnonymes ex = new ExemplesClassesLocalesEtAnonymes();
      
      ex.afficherAnimaux();
   }
}


