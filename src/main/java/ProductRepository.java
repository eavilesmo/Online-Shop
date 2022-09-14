import java.util.ArrayList;

public class ProductRepository {

  private final ArrayList<Product> listOfProducts = createProducts();

  public ArrayList<Product> getProducts() {
    return listOfProducts;
  }

  private ArrayList<Product> createProducts() {
    String televisionImage = "\uD83D\uDCFA";
    String televisionShortDescription = "Glamorous panoramic television, 13 inches";
    String televisionHighlightedAttribute = "With this panoramic television, your friday nights will be boring no more.";
    String televisionLongDescription = "With this panoramic television, your friday nights will be boring no more. The screen is composed of 14 million pixels. Thanks to its low energy consumption design, your bills will stay low.";
    double televisionPrice = 300.99;
    String televisionReference = "W2C";
    int televisionStock = 20;
    Product television = new Product(televisionImage, televisionShortDescription, televisionHighlightedAttribute, televisionLongDescription,
      televisionPrice,
      televisionReference, televisionStock);

    String pianoImage = "\uD83C\uDFB9";
    String pianoShortDescription = "Off-key musical keyboard, 4 octaves";
    String pianoHighlightedAttribute = "Tired of your noisy neighbour? Play this off-key musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.";
    String pianoLongDescription = "Tired of your noisy neighbour? Play this off-key musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.";
    double pianoPrice = 1003.00;
    String pianoReference = "X4A";
    int pianoStock = 15;
    Product piano = new Product(pianoImage, pianoShortDescription, pianoHighlightedAttribute, pianoLongDescription, pianoPrice,
      pianoReference, pianoStock);

    String candleImage = "\uD83D\uDD6F";
    String candleShortDescription = "Relaxing scented candle";
    String candleHighlightedAttribute = "If you feel stressed out at the end of the day, try giving yourself a break with our relaxing scented candle! With a subtle lavender fragrance, get rid of all the stress. Some customers affirm that this candle helps them to solve bugs in their code.";
    String candleLongDescription = "If you feel stressed out at the end of the day, try giving yourself a break with our relaxing scented candle! With a subtle lavender fragrance, get rid of all the stress. Some customers affirm that this candle helps them to solve bugs in their code.";
    double candlePrice = 4.99;
    String candleReference = "C9Y";
    int candleStock = 145;
    Product scentedCandle = new Product(candleImage, candleShortDescription, candleHighlightedAttribute, candleLongDescription, candlePrice,
      candleReference, candleStock);

    ArrayList<Product> productsToBeAdded = new ArrayList<>();
    productsToBeAdded.add(television);
    productsToBeAdded.add(piano);
    productsToBeAdded.add(scentedCandle);

    return productsToBeAdded;
  }

  public boolean findProductByReference(String reference) {
    for (Product product : listOfProducts) {
      if (product.getReference().equals(reference)) {
        return true;
      }
    }
    return false;
  }

  public Product getSingleProduct(String reference) {
    for (Product product : listOfProducts) {
      if (product.getReference().equals(reference)) {
        return product;
      }
    }
    throw new RuntimeException("The product does not exist in the database");
  }
}
