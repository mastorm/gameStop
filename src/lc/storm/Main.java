package lc.storm;

import lc.storm.store.Article;
import lc.storm.store.Warehouse;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Article[] articles = {
                new Article("1111", 33.40f, "Assassins Creed: Valhalla", "Experience the ancient viking kingdoms!")
        };

        int newStock = warehouse.addStock(articles[0], 500);
        System.out.println(articles[0].toString());
        System.out.println(newStock);
        System.out.println(warehouse.isAvailable(articles[0], 10));


    }
}
