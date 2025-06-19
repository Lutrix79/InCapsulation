package org.skypro.skyshop.search;

public interface Searchable {

    String findSearchTerm();

    String getContentType();
    String getName();

    default String getStringRepresentation() {
        return "Имя " + getName() + " Тип " + getContentType() ;
    }
}
