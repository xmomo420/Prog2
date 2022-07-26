
/**
 * Exercices de compilation avec la hierarchie de classes "AnimalDomestique".
 * @author Melanie Lord
 * @version 2013
 */
package heritagePolyExemple;
public class ExempleCompilation {
   
   
   public static void main (String [] args) {
      
      //Est-ce que les instructions suivantes compilent ?  Et si oui, 
      //dites celles qui lanceront une Exception (ClassCastException).

      //SOLUTION : 
      //Les instructions en commentaires sont celles qui ne compilent pas.
      //Les commentaires indiquent s'il y a Exception a l'execution c.-a-d. si 
      //l'instruction fait planter le programme.

      AnimalDomestique lulu = new AnimalDomestique("lulu");

      lulu.nom = "loulou"; 

      lulu.meDeplacer();

      ((Chien)lulu).aboyer();    //COMPILE mais PLANTE a l'execution
                                 //lulu est une AnimalDomestique et donc 
                                 //N'EST PAS un Chien.

      //((Oiseau)lulu).aboyer();  //methode aboyer() n'existe pas dans Oiseau

      //lulu.aboyer();  //methode aboyer n'existe pas dans AnimalDomestique

      lulu = new Oiseau("lulu", 5, "bleu", "arrg arrrrg !"); 

      //lulu.gazouiller();  //methode gazouiller() n'existe pas dans AnimalDomestique

      lulu.monAgeEst();

      ((Oiseau)lulu).meDeplacer();

      System.out.println(((Chien)lulu).toString());  //COMPILE mais PLANTE a l'execution
                                                     //lulu est une Oiseau et donc 
                                                     //N'EST PAS un Chien.

      lulu = new Chien();

      //(Chien)lulu.aboyer(); //manque des parentheses => ((Chien)lulu).aboyer

      AnimalDomestique toto = new Chien(); 

      toto.mIdentifier();

      System.out.println(toto.equals(lulu));

      ((AnimalDomestique)toto).mIdentifier(); 

      lulu.mIdentifier();

      ((Chien)toto).monAgeEst();

      toto.monAgeEst();

      //Oiseau coco = new Oiseau("Coco", 12); //constructeur inexistant dans Oiseau

      Oiseau charlie = new Oiseau("Charlie", 10, "jaune et vert", "arggg allo charlie, arrrrg !");

      charlie.gazouiller();

      //((AnimalDomestique)charlie).gazouiller(); //methode gazouiller() n'existe pas dans AnimalDomestique

      charlie.meDeplacer();

      //charlie = new Chien();  //On ne peut pas affecter un Chien a un Oiseau 
                                //(un Chien n'EST PAS un Oiseau)

      //charlie = new AnimalDomestique(); //On ne peut pas affecter un AnimalDomestique a un Oiseau 
                                          //(un AnimalDomestique n'EST PAS un Oiseau)

      charlie = (Oiseau)toto;  //COMPILE mais PLANTE a l'execution
                               //toto est un Chien et donc pas un Oiseau

      AnimalDomestique charlot = new Oiseau();

      charlot.mIdentifier();

      System.out.println(charlot.equals(charlie));

      //charlie = charlot;  //On ne peut pas affecter un AnimalDomestique a un Oiseau
                            //un AnimalDomestique n'EST PAS un Oiseau 

      charlot = charlie;

      //charlot.gazouiller();  //La methode gazouiller() n'existe pas dans AnimalDomestique

      Chien[] lesChiens = {(Chien)charlot, (Chien)lulu};  //COMPILE mais PLANTE a l'execution
                                                          //Charlot est un Oiseau et donc 
                                                          //N'EST PAS UN un chien

      AnimalDomestique [] lesAnimaux = {lulu, toto, charlie, charlot};

   }
   
}
