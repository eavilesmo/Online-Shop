import java.util.Scanner;

public class OnlineShop {

  private final ProductRepository productRepository = new ProductRepository();
  private final Formatter formatter = new Formatter();

  public void showProducts() {
    String finalProducts = formatter.formatProducts(productRepository.getProducts());
    System.out.println(finalProducts);
    exploreProducts();
  }

  private void exploreProducts() {
    System.out.println("Which product would you like to explore? - Introduce a product's reference.");
    Scanner userInputScanner = new Scanner(System.in);
    String userInput = userInputScanner.nextLine();
    boolean doesProductExist = productRepository.findProductByReference(userInput);
    System.out.println(doesProductExist);
  }
}
