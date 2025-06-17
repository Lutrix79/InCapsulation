package org.skypro.skyshop.search;

public class SearchEngine {

    private Searchable[] searchables;
    private int i = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public Searchable[] search(String searchTerm) {
        Searchable[] resultOfSearch = new Searchable[5];
        int countR = 0;
        for (Searchable searchable : searchables) {
            if ((searchable != null) && (searchable.findSearchTerm().contains(searchTerm)) && (countR < 5)) {
                resultOfSearch[countR++] = searchable;
                System.out.println(searchable.getStringRepresentation());
            } else if (countR >= 5) {
                break;
            }
        }
        return resultOfSearch;
    }

    public void add(Searchable searchable) {
        if (i < searchables.length) {
            searchables[i++] = searchable;
        }
    }
}
