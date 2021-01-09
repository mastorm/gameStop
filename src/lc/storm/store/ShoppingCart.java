package lc.storm.store;

import java.util.LinkedList;
import java.util.List;

public final class ShoppingCart {

    private List<ShoppingCartItem> cart = new LinkedList<>();

    public void addToCart(Article article, int amount) throws PriceToLowException {
        if(article.getPrice() <= 0f) {
            throw new PriceToLowException();
        }
        cart.add(new ShoppingCartItem(article, amount));
    }

    public void removeFromCart(Article article) {
        cart.removeIf((cartItem) -> cartItem.getArticle().getProductNumber().equals(article.getProductNumber()));
    }

    public float getTotalPrice() {
        float total = 0.0f;

        for(ShoppingCartItem cartItem : cart) {
            total += cartItem.getArticle().getPrice() * cartItem.getAmount();
        }
        return total;
    }

}
