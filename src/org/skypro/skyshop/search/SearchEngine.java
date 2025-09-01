package org.skypro.skyshop.search;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class SearchEngine {

    private final Set<Searchable> searchables = new TreeSet<>(new SearchableComparator());


    public Set<Searchable> search(String searchTerm) {
        Set<Searchable> resultOfSearch = new TreeSet<>(new SearchableComparator());
        for (Searchable searchable : searchables) {
            if ((searchable != null) && (searchable.findSearchTerm().contains(searchTerm))) {
                resultOfSearch.add(searchable);
                System.out.println(searchable.getName());
            }
        }
        return resultOfSearch;
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable searchMaxMatches(String search) throws BestResultNotFound {
        Searchable resultOfSearch = null;
        int totalQuantity = 0;
        for (Searchable searchable : searchables) {
            int index = 0;
            int quantity = 0;
            if (searchable != null) {
                int indexSubstring = searchable.findSearchTerm().indexOf(search, index);
                while (indexSubstring != -1) {
                    quantity++;
                    index = indexSubstring + search.length();
                    indexSubstring = searchable.findSearchTerm().indexOf(search, index);
                }
                if (quantity > totalQuantity) {
                    totalQuantity = quantity;
                    resultOfSearch = searchable;
                }
            }
        }
        if (resultOfSearch != null) {
            System.out.println(resultOfSearch.getStringRepresentation());
        } else {
            throw new BestResultNotFound("Даное словосочетание \"" + search + "\" не найдено");
        }
        return resultOfSearch;
    }
}
