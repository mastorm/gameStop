package lc.storm.store;

public class Article {
    private float price;
    private String productNumber;
    private String name;
    private String description;

    public Article(String productNumber, String name, String description) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article{" +
                "price=" + price +
                ", productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) throws PriceToLowException {
        if (price <= 0) {
            throw new PriceToLowException();
        }
        this.price = price;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
