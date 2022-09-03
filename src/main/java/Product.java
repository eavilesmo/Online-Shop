public class Product {
    private final String image;
    private final String shortDescription;
    private final String highlightedAttribute;
    private final double price;
    private final String reference;

    public Product(String image, String shortDescription, String highlightedAttribute, double price, String reference) {
        this.image = image;
        this.shortDescription = shortDescription;
        this.highlightedAttribute = highlightedAttribute;
        this.price = price;
        this.reference = reference;
    }
}
