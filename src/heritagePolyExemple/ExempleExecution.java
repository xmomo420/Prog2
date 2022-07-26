
/**
 * Exercices d'execution avec la hierarchie de classe "AnimalDomestique".
 * @author Melanie Lord
 * @version 2013
 */
package heritagePolyExemple;
public class ExempleExecution {
   
   //Qu'est-ce que la methode main suivante affichera ?
   
   public static void main (String [] args) {
      
      //lulu : type statique = AnimalDomestique
      //       type dynamique = AnimalDomestique
      AnimalDomestique lulu = new AnimalDomestique("lulu");

      lulu.mIdentifier();
      
      lulu.meDeplacer();
      
      //type dynamique de lulu est maintenant Oiseau
      lulu = new Oiseau("lulu", 5, "bleu", 
              "arrg arrrrg !"); //type dyn de lulu = oiseau
      
      //type dynamique de lulu est maintenant Chien
      lulu = new Chien();
      
      System.out.println(lulu);
 
      //toto : type statique = AnimalDomestique
      //       type dynamique = Chien
      AnimalDomestique toto = new Chien();
      
      toto.mIdentifier();
      
      ((AnimalDomestique)toto).meDeplacer();

      System.out.println(toto.equals(lulu));
      
      lulu.nom = "loulou";
      
      System.out.println(toto.equals(lulu));
      
      //type dynamique de lulu est maintenant Oiseau
      lulu = new Oiseau();
      
      ((AnimalDomestique)toto).mIdentifier();
      
      lulu.mIdentifier();
      
      System.out.println(lulu.equals(toto));
      
      toto.monAgeEst();
      
      //charlie : type statique = Oiseau
      //          type dynamique = Oiseau
      Oiseau charlie = new Oiseau("Charlie", 10, "jaune et vert", 
              "arggg allo charlie, arrrrg !");
      
      charlie.gazouiller();
      
      ((AnimalDomestique)charlie).meDeplacer();
      
      System.out.println(charlie);
      
      //charlot : type statique = AnimalDomestique
      //          type dynamique = Oiseau
      AnimalDomestique charlot = new Oiseau();
      
      charlie.gazouiller();
      
      ((Oiseau)charlot).gazouiller();
      
      System.out.println(charlot.equals(charlie));
      
      charlot = charlie;
      
      System.out.println(charlot.equals(charlie));
      
      ((Oiseau)charlot).gazouiller();
      
      //type dynamique de charlot est (encore) Oiseau
      charlot = new Oiseau("Charlot", 10, "jaune et vert", 
              "arggg allo charlie, arrrrg !");
      
      System.out.println(charlot.equals(charlie));  
      
      //Declaration d'un tableau de type (statique) AnimalDomestique
      //Chaque case du tableau est donc un type statique AnimalDomestique
      AnimalDomestique[] lesAnimaux = new AnimalDomestique[3];

      //type dynamique de lesAnimaux[0] est Oiseau (type dyn de charlot)
      lesAnimaux[0] = charlot;
      
      //type dynamique de lesAnimaux[1] est Chien 
      lesAnimaux[1] = new Chien("Fido", 2, "frisee", "waf waf !");
      
      //type dynamique de lesAnimaux[2] est Chien (type dyn de toto)
      lesAnimaux[2] = toto;
      
      ((Oiseau)lesAnimaux[0]).gazouiller();
      
      lesAnimaux[1].meDeplacer();
      
      ((Chien)lesAnimaux[2]).mIdentifier();
   }
   
   
}
