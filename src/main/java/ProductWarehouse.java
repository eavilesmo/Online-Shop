import java.util.ArrayList;

public class ProductWarehouse {

  private final ArrayList<Product> listOfProducts = createProducts();

  public ArrayList<Product> getProducts() {
    return listOfProducts;
  }

  private ArrayList<Product> createProducts() {
    Product television = new Product(ProductAttributes.TV_IMAGE,
      ProductAttributes.TV_SHORT_DESCRIPTION,
      ProductAttributes.TV_HIGHLIGHTED_ATTRIBUTE,
      ProductAttributes.TV_LONG_DESCRIPTION,
      ProductAttributes.TV_PRICE,
      ProductAttributes.TV_REFERENCE,
      ProductAttributes.TV_STOCK);

    Product piano = new Product(ProductAttributes.PIANO_IMAGE,
      ProductAttributes.PIANO_SHORT_DESCRIPTION,
      ProductAttributes.PIANO_HIGHLIGHTED_ATTRIBUTE,
      ProductAttributes.PIANO_LONG_DESCRIPTION,
      ProductAttributes.PIANO_PRICE,
      ProductAttributes.PIANO_REFERENCE,
      ProductAttributes.PIANO_STOCK);

    Product scentedCandle = new Product(ProductAttributes.CANDLE_IMAGE,
      ProductAttributes.CANDLE_SHORT_DESCRIPTION,
      ProductAttributes.CANDLE_HIGHLIGHTED_ATTRIBUTE,
      ProductAttributes.CANDLE_LONG_DESCRIPTION,
      ProductAttributes.CANDLE_PRICE,
      ProductAttributes.CANDLE_REFERENCE,
      ProductAttributes.CANDLE_STOCK);

    ArrayList<Product> productsToBeAdded = new ArrayList<>();
    productsToBeAdded.add(television);
    productsToBeAdded.add(piano);
    productsToBeAdded.add(scentedCandle);

    return productsToBeAdded;
  }

  public Product findProductByReference(String reference) {
    for (Product product : listOfProducts) {
      if (product.getReference().equals(reference)) {
        return product;
      }
    }
    throw new RuntimeException(StringRepository.PRODUCT_DOES_NOT_EXIST);
  }
}
