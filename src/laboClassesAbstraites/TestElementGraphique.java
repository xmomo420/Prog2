package laboClassesAbstraites;

public class TestElementGraphique {

    public static void main(String[] args) {
        int i = 0;
        Cercle2 c1 = new Cercle2(3, 1,2);
        Cercle2 c2 = new Cercle2(12, 0, 0);
        Carre2 c = new Carre2(10, 5,5);
        ElementGraphiqueInter [] tab = {c1, c2, c};

        while (i < tab.length) {
            System.out.println(tab[i++]);
        }
    }
}
