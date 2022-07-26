package heritagePolyLabP_1;

public class Item {
    //Variables d'instance
    private int id;
    private String description;
    private double prix;
    private boolean isTvsApplicable;
    private boolean isTvqApplicable;
    //Variable de classe
    private static int nbrItem = 0;

    //Constructeurs
    public Item () {
        description = "";
        prix = 0.0;
        isTvsApplicable = false;
        isTvqApplicable = false;
        nbrItem++;
    }
    public Item (String description, double prix) {
        this();
        this.prix = prix;
        this.description = description;
    }
    public Item (String description, double prix,
                 boolean isTvsApplicable, boolean isTvqApplicable) {
        this(description, prix);
        this.isTvsApplicable = isTvsApplicable;
        this.isTvqApplicable = isTvqApplicable;
    }

    public Item (Item autreItem) {
    this.id = autreItem.id;
    this.description = autreItem.description;
    this.prix = autreItem.prix;
    this.isTvsApplicable = autreItem.isTvsApplicable;
    this.isTvqApplicable = autreItem.isTvqApplicable;
    }

    public String toString() {
    String s = "id : " + id + ", description : " + description + ", prix : "
            + prix;
    String tvs;
    String tvq;
    if (isTvsApplicable) {
    tvs = ", TVS applicable, ";
    } else {
    tvs = ", TVS non-applicable, ";
    }
    if (isTvqApplicable) {
        tvq = "TVQ applicable";
    } else {
        tvq = "TVQ non-applicable";
    }
    return s + tvs + tvq;
    }

    public boolean equals(Item i) {
        if (i == null) {
            return false;
        } else if (description == i.description && prix == i.prix &&
                isTvsApplicable == i.isTvsApplicable &&
                isTvqApplicable == i.isTvqApplicable) {
            return true;
        } else
            return false;
        }

}

