public class Product {

  private final String image;
  private final String shortDescription;
  private final String highlightedAttribute;
  private final String longDescription;
  private final double price;
  private final String reference;
  private final int stock;

  public Product(String image, String shortDescription, String highlightedAttribute, String longDescription, double price,
    String reference, int stock) {
    this.image = image;
    this.shortDescription = shortDescription;
    this.highlightedAttribute = highlightedAttribute;
    this.longDescription = longDescription;
    this.price = price;
    this.reference = reference;
    this.stock = stock;
  }

  public String getImage() {
    return image;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public String getHighlightedAttribute() {
    return highlightedAttribute;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public double getPrice() {
    return price;
  }

  public String getReference() {
    return reference;
  }

  public int getStock() {
    return stock;
  }
}
