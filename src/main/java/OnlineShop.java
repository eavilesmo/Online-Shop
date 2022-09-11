import java.util.ArrayList;

public class OnlineShop {

  ProductRepository productRepository = new ProductRepository();
  Formatter formatter = new Formatter();

  public void showProducts() {
    ArrayList<Product> listOfProducts = addProducts();
    String finalProducts = formatter.formatProducts(listOfProducts);
    System.out.println(finalProducts);
  }

  private ArrayList<Product> addProducts() {
    productRepository.addProducts();
    return productRepository.getProducts();
  }
}
