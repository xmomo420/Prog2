package heritagePolyLabP_1;

public class TestItem {
    public static void main(String[] args) {
        int i = 0;
        Item i1 = new Item("lait", 7.97, false, false);
        Item i2 = new Item("yogourt", 4.96, false, false);
        ItemInventaire i3 = new ItemInventaire("fromage", 3.97, false, false, 16, 5);
        ItemInventaire i4 = new ItemInventaire("poulet", 20, false, false, 100, 50);
        ItemInventaire i5 = new ItemInventaire("pizza", 7.97, false, false, 250, 100);
        Item i6 = new ItemInventaire(i5);

        Item [] tab = {i1,i2,i3,i4,i5,i6};

        while (i < tab.length) {
            System.out.println(tab[i++] + "\n");
        }

        System.out.print("Est-ce que i1 et i2 sont égaux : ");
        System.out.println(i1.equals(i2));
        System.out.print("\nEst-ce que i1 et i2 sont égaux : ");
        System.out.println(i5.equals(i6));
    }
}
