package sk.spse.jackson;

import java.util.Comparator;

class IntegerComparator implements Comparator<Integer> {
    boolean descending;

    public IntegerComparator() {
        descending = false;
    }

    public IntegerComparator(boolean descending) {
        this.descending = descending;
    }
    @Override
    public int compare(Integer a, Integer b) {
        if (descending) {
            return Integer.compare(b, a);
        } else {
            return Integer.compare(a, b);
        }
    }
}