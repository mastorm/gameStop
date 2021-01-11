package lc.storm.store;

import java.util.*;
import java.util.stream.Collectors;

public class Storefront {
    //normally would be fetched from a DB
    private final Article[] articles = {
            new Article("1111", "Assassins Creed: Valhalla", "Experience the ancient viking kingdoms!"),
            new Article("1112", "Fall Guys", "King of the hill without casualties"),
            new Article("1113", "Stranger Things", "Nice story"),
            new Article("1114", "World of Warcraft", "Most popular MMORPG"),
            new Article("1115", "Arma 3", "Modern era mil-sim with lots of useless dlc`s!")
    };

    private final List<Article> invalidArticles = new ArrayList<>();
    private final Warehouse warehouse = new Warehouse();

    public Storefront() {
        fillPriceList();
        generateStock();
    }

    private void fillPriceList() {
        //normally fetched from a DB
        Random rnd = new Random();
        for (Article article : this.articles) {
            // generate a bunch of random prices

            try {
                article.setPrice(rnd.nextFloat() * 100f);
            } catch (PriceToLowException ex) {
                invalidArticles.add(article);
            }
        }
    }

    private void generateStock() {
        Random rnd = new Random();

        for (Article article : this.articles) {
            warehouse.addStock(article, rnd.nextInt(500));
        }
    }

    public List<Article> getAvailableArticles() {
        return Arrays.stream(articles)
                .filter(article -> !invalidArticles.contains(article))
                .filter(article -> warehouse.isAvailable(article, 1))
                .collect(Collectors.toList());
    }
}
