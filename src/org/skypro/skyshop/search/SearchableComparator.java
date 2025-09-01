package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int i = Integer.compare(o2.getName().length(),o1.getName().length());
        if (i != 0) return i;
        return o1.getName().compareTo(o2.getName());
    }
}
