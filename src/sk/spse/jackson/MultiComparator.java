package sk.spse.jackson;

import java.util.Comparator;

class MultiComparator implements Comparator<Osoba> {
    @Override
    public int compare(Osoba a, Osoba b) {
        int r = a.getPohlavie().compareTo(b.getPohlavie());
        if (r != 0)
            return r;

        return b.getDatumNarodenia().compareTo(a.getDatumNarodenia());
    }
}