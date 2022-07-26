package laboArrayList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import lectureClavier.Clavier;

public class Lab4 {
    public static final String MSG_SOLL = "Entrez un nombre entier " +
            "(0 pour terminer ) : ";
    public static final String MSG_ERR = "\nErreur !\n";
    public static final String MSG_OUI = " fait partie de la liste.";
    public static final String MSG_NON = " ne fait pas partie de la liste.";
    public static final String MSG_FIN = "\nFIN";

    public static void main(String[] args) {






        int i = 0;
        int j = 10;
        ArrayList l = new ArrayList<Integer>(5);
        while (i < 5) {
            l.add(j);
            j += 10;
            i++;
        }
        //afficher(l);
        // verifier(l);
        //l.clear();
        //l = saisir();
        //System.out.println(l);
        //l.clear();
        //l = saisirEnOrdre();
        //System.out.println(l);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(12);
        l2.add(12);
        l2.add(15);
        l2.add(15);
        l2.add(15);
        l2.add(3);
        l2 = eliminerDoublons(l2);
        System.out.println(l2);
        //i = 0;
        /*
        ArrayList<Point> l2 = new ArrayList<>(5);
        Point p1 = new Point(1, 10);
        Point p2 = new Point(2, 20);
        Point p3 = new Point(3, 30);
        Point p4 = new Point(4, 40);
        Point p5 = new Point(5, 50);
        l2.add(p1);
        l2.add(p2);
        l2.add(p3);
        l2.add(p4);
        l2.add(p5);
        Point p6 = new Point(1,10);
        System.out.println(l2);
        verifierPoint(l2);
        //System.out.println(l2.contains(p6));
        //System.out.println(p2.equals(p2));
        //l2 = numero11(l2, 2);
        //System.out.println(l2);
        l2 = numero12(l2, 30);
        System.out.println(l2);
         */












    }

    public static ArrayList<Point> numero12 (ArrayList<Point> points, int i) {
        ArrayList newlist = new ArrayList<>();
        int j = 0;
        int x = 0;
        int y = 0;
        Point p;
        while (j < points.size()) {
            if (points.get(j).getY() <= i) {
                x = points.get(j).getX();
                y = points.get(j).getY();
                p = new Point(x, y);
                newlist.add(p);
            }
            j++;
        }
        newlist.trimToSize();
        return newlist;

    }

    public static ArrayList<Point> numero11 (ArrayList<Point> points, int i) {
        ArrayList newlist = new ArrayList<>();
        int j = 0;
        int x = 0;
        int y = 0;
        Point p;
        while (j < points.size()) {
            if (points.get(j).getX() <= i) {
                x = points.get(j).getX();
                y = points.get(j).getY();
                p = new Point(x, y);
                newlist.add(p);
            }
            j++;
        }
        newlist.trimToSize();
        return newlist;

    }

    public static void verifierPoint (ArrayList<Point> points) {
        int x = 1;
        int y = 1;
        while (x != 0 && y != 0) {
            x = saisirEntier(MSG_SOLL, MSG_ERR);
            if (x == 0) {
                System.out.println(MSG_FIN);
            } else {
                y = saisirEntier(MSG_SOLL, MSG_ERR);
                if (y == 0) {
                    System.out.println(MSG_FIN);
                } else {
                    Point p = new Point(x, y);
                    if (points.contains(p)) {
                        System.out.println(p + MSG_OUI);
                    } else
                        System.out.println(p + MSG_NON);
                }

            }
        }
    }

    public static void afficher (ArrayList list) {
        int i = 0;
        while (i < list.size()) {
            System.out.println(list.get(i++) + " ");
        }
    }
    public static void verifier (ArrayList<Integer> list) {
        int i = 1;
        while (i != 0) {
            i = saisirEntier(MSG_SOLL, MSG_ERR);
                if (i == 0) {
                    System.out.println(MSG_FIN);
                } else {
                    if (list.contains(i)) {
                        System.out.println(i + MSG_OUI);
                    } else
                        System.out.println(i + MSG_NON);
                }
        }
    }

    public static int saisirEntier (String msgSoll, String msgErr) {
        int i = -1;
        while (i < 0) {
            System.out.print(msgSoll);
            try {
                i = Clavier.lireInt();
            } catch (NumberFormatException e) {
                System.out.println(msgErr);
                i = -1;
            }
        }
        return i;
    }

    public static ArrayList<Integer> saisir () {
        int i = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (i != 0) {
            i = saisirEntier(MSG_SOLL, MSG_ERR);
            if (i == 0) {
                System.out.println(MSG_FIN);
            } else {
                if (list.contains(i)) {
                    System.out.println("\nCe nombre est deja dans la liste !" +
                            " Il faut entrer des nouveau nombre.");
                } else
                    list.add(i);
            }
        }
        return list;
    }

    public static ArrayList<Integer> saisirEnOrdre () {
        ArrayList<Integer> list = saisir();
        list.sort(null);
        return list;
    }

    public static ArrayList eliminerDoublons2 (ArrayList list) {
        Iterator it = list.iterator();
        int i = 0;
        ArrayList newlist = new ArrayList<>();
        Object o;
        while (it.hasNext()) {
            o = it.next();
            if (list.contains(o) && !newlist.contains(o)) {
                i = (Integer) o;
                newlist.add(i);
            }
        }
        newlist.trimToSize();
        return newlist;
    }
    public static ArrayList eliminerDoublons (ArrayList list) {
        int i = 0;
        while (i < list.size()) {
             ; // element en position i
            if (i < list.lastIndexOf(list.get(i))) {
                // il existe un doublon, enlever l'element en position i
                list.remove(i);
                // i contient la position de l'element qui suivait celui qu'on
                // vient d'enlever
            } else {
                // avancer i
                i++;
            }
    }
    return list;
    }


}






