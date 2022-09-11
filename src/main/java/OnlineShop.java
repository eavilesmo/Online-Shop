import java.util.ArrayList;

public class OnlineShop {

  ProductRepository productRepository = new ProductRepository();

  public void showProducts() {
    ArrayList<Product> listOfProducts = addProducts();
    for (Product product : listOfProducts) {
      System.out.println(product.getImage());
      System.out.println(product.getShortDescription());
      System.out.println(product.getHighlightedAttribute());
      System.out.printf("\uD83D\uDCB0 Price: %s €\n", product.getPrice());
      System.out.printf("Reference: %s\n", product.getReference());
      System.out.println();
    }
  }

  private ArrayList<Product> addProducts() {
    productRepository.addProducts();
    return productRepository.getProducts();
  }
}
