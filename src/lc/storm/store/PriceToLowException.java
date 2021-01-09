package lc.storm.store;

public class PriceToLowException extends Exception {
    public PriceToLowException() {
        super("Article price is too low!");
    }
}
