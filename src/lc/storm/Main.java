package lc.storm;

import lc.storm.store.Article;
import lc.storm.store.PriceToLowException;
import lc.storm.store.ShoppingCart;
import lc.storm.store.Warehouse;

public class Main {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Article[] articles = {
                new Article("1111", "Assassins Creed: Valhalla", "Experience the ancient viking kingdoms!"),
                new Article("1111", "Fall Guys", "King of the hill without casualties")
        };

        try{
            articles[0].setPrice(3f);
            articles[1].setPrice(5f);
        } catch (PriceToLowException exception) {
            System.out.println("Price cant be unter an euro.");
        }

        ShoppingCart myCart = new ShoppingCart();
        myCart.addToCart(articles[0], 4);
        myCart.addToCart(articles[1], 3);
        System.out.println(myCart.getTotalPrice());

    }
}
