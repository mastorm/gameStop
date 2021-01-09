package lc.storm.store;

public interface ArticleStorage {
    public boolean isAvailable(Article article, int requiredAmount);
    public int addStock(Article article, int amount);
}
