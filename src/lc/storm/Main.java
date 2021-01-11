package lc.storm;

import lc.storm.store.*;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Storefront myShop = new Storefront();
        List<Article> articles = myShop.getAvailableArticles();
        System.out.println("Welcome to JAMA Store, these are the games we offer!");
        for(Article article : articles) {
            System.out.println(article);
        }

        // just for practice, lets iterate over it using the bare iterator
        for(Iterator<Article> it = articles.iterator(); it.hasNext(); ) {
            Article article = it.next();
            System.out.println(article);
        }
    }
}
