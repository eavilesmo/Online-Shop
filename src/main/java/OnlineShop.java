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
    boolean doesProductExist = false;
    String userInput = "";
    while (!doesProductExist) {
      userInput = userInputScanner.nextLine();
      doesProductExist = productRepository.findProductByReference(userInput);
      if (!doesProductExist) {
        System.out.println("Sorry, the reference does not match any product. Please try again");
      }
    }
    Product singleProductToBeFormatted = productRepository.getSingleProduct(userInput);
    String singleProduct = formatter.formatSingleProduct(singleProductToBeFormatted);
    System.out.println(singleProduct);

    System.out.println("What would you like to do next?");
    System.out.println("1. Add product to cart.");
    System.out.println("2. Keep browsing the catalog");

    String userInput2 = userInputScanner.nextLine();
    if (userInput2.equals("2")) {
      showProducts();
    }
  }
}
