package laboStreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LaboStream {
    private final Predicate<Integer> pairsEtPositif = i -> i % 2 == 0 && i > 0;
    private final Predicate<String> nulls = e -> e == null;
    private final Predicate<String> moinsDe4Chars = e -> e.length() < 4;
    private final List<String> listeString = Arrays.asList(
            "yo", "pif", "bang", "bin", null, "broum", "machin", "truc", "bof",
            "coucou", "paf", "bang", "machin", "foo", "yo", "tictac", null
    );
    //Pour les exercices suivants, tenez pour acquis que listeInt ne contient
    //aucun élément null.
    private final List<Integer> listeInt =
            Arrays.asList(1, -12, 23, 4, 22, 0, 10, 7, -9, -17, 4, 10, -12, 4);

    private void un () {
        System.out.println(listeInt.stream().mapToInt(e -> e).sum());
    }
    private void deux () {
        listeString.stream().filter(nulls.negate().and(moinsDe4Chars)).distinct()
                .forEach(e -> System.out.print(e + " "));
    }
    private void trois () {
        System.out.println(listeString.size() - listeString.stream().distinct().
                count());
    }
    private void quatre () {
        System.out.println(Arrays.asList(listeString.stream().map
                (s -> s == null ? -1 : s.length()).sorted().toArray()));

        int[] tab = IntStream.concat(listeString.stream().filter(nulls.negate())
                        .mapToInt(e -> e.length()),listeString.stream().filter
                (nulls).mapToInt(e -> -1)).sorted().toArray();
        String sep = ", ";
        int k = 0;
        System.out.print("[");
        for (int i : tab) {
            int j = tab.length - 1;
            if (k == 3) {
                sep = "]";
            }
            if (i == tab[j]) {
                k++;
            }
            System.out.print(i + sep);
        }

    }
    private void cinq () {
        listeInt.stream().distinct().filter(pairsEtPositif).mapToInt(i -> i).
                average().ifPresent(e -> System.out.println(e));
    }
    private void six () {
        listeString.stream().filter(nulls.negate()).sorted().forEach(e ->
                System.out.println(e));
    }
    private void sept () {
        listeString.stream().filter(nulls.negate()).sorted((s1,s2) -> {
            int i = 0;
            if (s1.length() < s2.length()) {
                i = -1;
            } else if (s2.length() < s1.length()) {
                i = 1;
            }
                    return i;
                }
                ).forEach(System.out::println);
    }

    public static void main(String[] args) {
        String sep = "\n----------------------------------------------------------";
        LaboStream test = new LaboStream();
        //test.un();
        //System.out.println(sep);
        //test.deux();
        //System.out.println(sep);
        //test.trois();
        //System.out.println(sep);
        test.quatre();
        //System.out.println(sep);
        //test.cinq();
        //System.out.println(sep);
        //test.six();
        //System.out.println(sep);
        //test.sept();
    }
}

