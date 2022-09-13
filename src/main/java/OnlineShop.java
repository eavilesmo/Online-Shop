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
    String userInput = "";
    Scanner userInputScanner = new Scanner(System.in);
    userInput = userInputScanner.nextLine();
    System.out.println(userInput);
  }
}
