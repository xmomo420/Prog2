package heritagePolyLabP_1;

public class ItemInventaire extends Item{
    //Variables d'instance
    private int quantitéStock;
    private int seuilCritique;

    //Constructeurs
    public ItemInventaire () {
        super();
        this.quantitéStock = 0;
        this.seuilCritique = 0;
    }
    public ItemInventaire (String description, double prix) {
        super(description, prix);
        this.quantitéStock = 0;
        this.seuilCritique = 0;
    }
    public ItemInventaire (String description, double prix,
                           boolean isTvsApplicable, boolean isTvqApplicable ) {
    super(description, prix, isTvsApplicable, isTvqApplicable);
        this.quantitéStock = 0;
        this.seuilCritique = 0;
    }
    public ItemInventaire (String description, double prix,
                           boolean isTvsApplicable, boolean isTvqApplicable,
                           int quantitéStock, int seuilCritique) {
        super(description, prix, isTvsApplicable, isTvqApplicable);
        this.quantitéStock = quantitéStock;
        this.seuilCritique = seuilCritique;
    }
    public ItemInventaire (ItemInventaire autreItemInventaire) {
        super(autreItemInventaire);
        this.quantitéStock = autreItemInventaire.quantitéStock;
        this.seuilCritique = autreItemInventaire.seuilCritique;
    }

    @Override
    public String toString() {
        return super.toString() + ", quantité en stock : " + quantitéStock
                + ", seuil critique : " + seuilCritique;
    }
    public boolean equals(ItemInventaire i) {
        return super.equals(i) && quantitéStock == i.quantitéStock &&
                seuilCritique == i.seuilCritique;
    }
}
