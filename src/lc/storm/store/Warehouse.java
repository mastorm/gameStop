package lc.storm.store;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages article stock and offers apis to check availability
 */
public final class Warehouse implements ArticleStorage {
    private Map<String, Integer> articleStorage = new HashMap<>();

    /**
     * Adds stock for an article
     * @param article The article that receives the stock
     * @param amount How much should be added
     * @return the new amount on stock
     */
    public int addStock(Article article, int amount) {
        String sku = article.getProductNumber();
        int newStock;

        if (articleStorage.containsKey(sku)) {
            newStock = articleStorage.get(sku) + amount;

        } else {
            newStock = amount;
        }

        articleStorage.put(sku, newStock);

        return articleStorage.get(sku);
    }

    public boolean isAvailable(Article article, int requiredAmount) {
        String sku = article.getProductNumber();
        if(!articleStorage.containsKey(sku)) {
            return false;
        }

        int currentStock = articleStorage.get(sku);
        return currentStock >= requiredAmount;
    }

}
