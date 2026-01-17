package sk.spse.jackson;

import java.util.Comparator;

class NarodenieComparator implements Comparator<Osoba> {
    @Override
    public int compare(Osoba a, Osoba b) {
        return a.getDatumNarodenia().compareTo(b.getDatumNarodenia());
    }
}