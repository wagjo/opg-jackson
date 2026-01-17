package sk.spse.jackson;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class PriezviskoComparator implements Comparator<Osoba> {
    Collator collator;

    {
        collator = Collator.getInstance(new Locale("sk", "SK"));
        collator.setStrength(Collator.SECONDARY);
    }

    @Override
    public int compare(Osoba a, Osoba b) {
        return collator.compare(a.getPriezvisko(), b.getPriezvisko());
//        return a.getPriezvisko().compareTo(b.getPriezvisko());
    }
}