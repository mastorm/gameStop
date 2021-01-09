package lc.storm.store;

public interface ArticleStorage {
    boolean isAvailable(Article article, int requiredAmount);
    int addStock(Article article, int amount);
}
