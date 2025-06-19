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
