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
    double televisionPrice = 300.99;
    String televisionReference = "W2C";
    Product television = new Product(televisionImage, televisionShortDescription, televisionHighlightedAttribute, televisionPrice,
      televisionReference);

    String pianoImage = "\uD83C\uDFB9";
    String pianoShortDescription = "Off-key musical keyboard, 4 octaves";
    String pianoHighlightedAttribute = "Tired of your noisy neighbour? Play this off-key musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.";
    double pianoPrice = 1003.00;
    String pianoReference = "X4A";
    Product piano = new Product(pianoImage, pianoShortDescription, pianoHighlightedAttribute, pianoPrice, pianoReference);

    String candleImage = "\uD83D\uDD6F";
    String candleShortDescription = "Relaxing scented candle";
    String candleHighlightedAttribute = "If you feel stressed out at the end of the day, try giving yourself a break with our relaxing scented candle! With a subtle lavender fragrance, get rid of all the stress. Some customers affirm that this candle helps them to solve bugs in their code.";
    double candlePrice = 4.99;
    String candleReference = "C9Y";
    Product scentedCandle = new Product(candleImage, candleShortDescription, candleHighlightedAttribute, candlePrice, candleReference);

    ArrayList<Product> productsToBeAdded = new ArrayList<>();
    productsToBeAdded.add(television);
    productsToBeAdded.add(piano);
    productsToBeAdded.add(scentedCandle);

    return productsToBeAdded;
  }
}
