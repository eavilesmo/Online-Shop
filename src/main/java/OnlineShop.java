import java.util.ArrayList;

public class OnlineShop {

  ProductRepository productRepository = new ProductRepository();
  Formatter formatter = new Formatter();
  ArrayList<Product> listOfProducts;

  public OnlineShop() {
    listOfProducts = addProducts();
  }

  public void showProducts() {
    String finalProducts = formatter.formatProducts(listOfProducts);
    System.out.println(finalProducts);
  }

  private ArrayList<Product> addProducts() {
    productRepository.addProducts();
    return productRepository.getProducts();
  }
}
