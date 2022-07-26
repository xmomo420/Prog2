
package exemplesLambda.exemplesReseauSocial;

import java.time.LocalDate;
import java.time.Period;

public class Membre {
   
   private String nom;
   private LocalDate dateNaissance;
   private char genre;  //f ou m ou a
   private String courriel;
   
   public Membre (String nom, LocalDate date, char genre, String courriel) {
      this.nom = nom != null ? nom : "";
      dateNaissance = date != null ? date : LocalDate.parse ("2020-07-01");
      genre = Character.toLowerCase(genre);
      this.genre = genre == 'f' || genre == 'm' || genre == 'a' ? genre : 'm';
      this.courriel = courriel != null ? courriel : "john.doe@oups.com";
   }
   
   public String getNom() {
      return nom;
   }

   public LocalDate getDateNaissance() {
      return dateNaissance;
   }

   public char getGenre() {
      return genre;
   }

   public String getCourriel() {
      return courriel;
   }

   public int getAge() {
      LocalDate now = LocalDate.now();
      Period periode = Period.between(dateNaissance, now);

      return periode.getYears();
        
   }

   public void afficher() {
      System.out.println(">>> " + nom + "[" + genre + "] " 
         + "(" + dateNaissance.toString() + ") - " + courriel);
   }

}
