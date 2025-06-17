package org.skypro.skyshop.articles;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {

    final private String nameArticle;
    final private String contentArticle;

    public Article(String nameArticle, String contentArticle) {
        this.nameArticle = nameArticle;
        this.contentArticle = contentArticle;
    }

    @Override
    public String toString() {
        return  nameArticle + "\n" + contentArticle;
    }

    @Override
    public String findSearchTerm() {
        return nameArticle + "\n" + contentArticle;
     }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return nameArticle;
    }
}
