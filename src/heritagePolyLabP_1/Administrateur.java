package heritagePolyLabP_1;

public class Administrateur extends EmployeSalarie {

    //Variables d'instance
    private String titre;
    private String domaineExpertise;
    private String nomSuperviseur;

    //Getters
    public String getTitre() {
        return titre;
    }
    public String getDomaineExpertise() {
        return domaineExpertise;
    }
    public String getNomSuperviseur() {
        return nomSuperviseur;
    }
    //Setters
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDomaineExpertise(String domaineExpertise) {
        this.domaineExpertise = domaineExpertise;
    }

    public void setNomSuperviseur(String nomSuperviseur) {
        this.nomSuperviseur = nomSuperviseur;
    }
    //Constructeurs
    public Administrateur() {
    this.titre = "sans titre";
    this.domaineExpertise = "sans domaine";
    this.nomSuperviseur = "sans superviseur";
    }
    public Administrateur(String titre, String nomSuperviseur, String
            domaineExpertise, double tauxHoraire, String leNom, Date laDate,
                          double leSalaire) {
    super(leNom, laDate, leSalaire);
        this.titre = titre;
        this.domaineExpertise = domaineExpertise;
        this.nomSuperviseur = nomSuperviseur;
    }
    //Methode toString()
    public String toString() {
    return super.toString() + ", titre : " + titre + ", domaine : " +
            domaineExpertise + ", superviseur : " + nomSuperviseur;
    }




}
