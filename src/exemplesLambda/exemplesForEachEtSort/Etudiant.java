
package exemplesLambda.exemplesForEachEtSort;

public class Etudiant {
   private String nom;
   private String prenom;
   private int age;
   private String codePermanent;
   private double moyCumul; //(0 - 4.3)

   public Etudiant(String nom, String prenom, int age, String codePermanent, 
                   double moyCumul) {
      this.nom = nom;
      this.prenom = prenom;
      this.age = age;
      this.codePermanent = codePermanent;
      this.moyCumul = moyCumul;
   }

   public String getNom() {
      return nom;
   }

   public String getPrenom() {
      return prenom;
   }

   public int getAge() {
      return age;
   }

   public String getCodePermanent() {
      return codePermanent;
   }

   public double getMoyCumul() {
      return moyCumul;
   }

   public void setMoyCumul(double moyCumul) {
      this.moyCumul = moyCumul;
   }

   public String toString() {
      return nom.toUpperCase() + ", " + prenom.charAt(0) + ". " 
         + age + " ans (" + moyCumul + ")";
   }
}
