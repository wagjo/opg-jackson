package sk.spse.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static List<Osoba> fetchOsoby(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Osoba> osoby = mapper.readValue(
                file,
                new TypeReference<List<Osoba>>() {}
        );
        return osoby;
    }

    public static void printOsoby(String msg, List<Osoba> osoby) {
        System.out.println(msg + ":");
        for (Osoba osoba : osoby) {
            System.out.println(osoba);
        }
        System.out.println();
    }

    public static List<Integer> sortCisla(List<Integer> cisla) {
        List<Integer> zoradene = new ArrayList<>(cisla);
        Collections.sort(zoradene);
        return zoradene;
    }

    public static List<Osoba> sortNarodenie(List<Osoba> osoby) {
        List<Osoba> zoradene = new ArrayList<>(osoby);
        Collections.sort(zoradene, new NarodenieComparator());
        return zoradene;
    }

    public static List<Osoba> sortPriezvisko(List<Osoba> osoby) {
        List<Osoba> zoradene = new ArrayList<>(osoby);
        Collections.sort(zoradene, new PriezviskoComparator());
        return zoradene;
    }

    public static List<Osoba> sortMulti(List<Osoba> osoby) {
        List<Osoba> zoradene = new ArrayList<>(osoby);
        Collections.sort(zoradene, new MultiComparator().reversed());
        return zoradene;
    }

    public static void main(String[] args) {
        // Vytvorime zoznam cisel
        List<Integer> cisla = new ArrayList<>();
        cisla.add(4);
        cisla.add(5);
        cisla.add(2);
        cisla.add(1);
        cisla.add(3);

        // Vypiseme zoznam cisel
        System.out.println("Zoznam cisel:");
        for (Integer i : cisla) {
            System.out.println(i);
        }
        System.out.println();


        // Zoradime vzostupne a vypiseme
        List<Integer> cislaVzostupne = new ArrayList<>(cisla);
        Collections.sort(cislaVzostupne, new IntegerComparator());
        System.out.println("Cisla vzostupne:");
        for (Integer i : cislaVzostupne) {
            System.out.println(i);
        }
        System.out.println();

        // Zoradime zostupne a vypiseme
        List<Integer> cislaZostupne = new ArrayList<>(cisla);
        Collections.sort(cislaZostupne, new IntegerComparator(true));
        System.out.println("Cisla zostupne:");
        for (Integer i : cislaZostupne) {
            System.out.println(i);
        }
        System.out.println();

        // Vytvorime zoznam Osob
        File file = new File("assets/osoby2.json");
        List<Osoba> osoby = new ArrayList<>();

        try {
            osoby = fetchOsoby(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Vypiseme nacitame osoby
        printOsoby("Nacitane osoby", osoby);

        // Zoradime a vypiseme osoby podla datumu narodenia
        List<Osoba> osobyPodlaNarodenia = sortNarodenie(osoby);
        printOsoby("Podla datumu narodenia", osobyPodlaNarodenia);

        // Zoradime a vypiseme osoby podla priezviska
        List<Osoba> osobyPodlaPriezviska = sortPriezvisko(osoby);
        printOsoby("Podla priezviska", osobyPodlaPriezviska);

        // Zoradime a vypiseme osoby podla pohlavia a potom podla datumu narodenia
        List<Osoba> osobyPodlaMulti = sortMulti(osoby);
        printOsoby("Podla pohlavia a potom podla datumu narodenia", osobyPodlaMulti);

    }
}
