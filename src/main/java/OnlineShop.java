import java.util.Scanner;

public class OnlineShop {

  private final ProductRepository productRepository = new ProductRepository();
  private final Formatter formatter = new Formatter();

  public void showCatalog() {
    String finalProducts = formatter.formatProducts(productRepository.getProducts());
    System.out.println(finalProducts);
    exploreProducts();
  }

  private void exploreProducts() {
    System.out.println("Which product would you like to explore? - Introduce a product's reference.");
    Scanner userInputScanner = new Scanner(System.in);
    boolean doesProductExist = false;
    String reference = "";
    while (!doesProductExist) {
      reference = userInputScanner.nextLine();
      doesProductExist = productRepository.doesProductExist(reference);
      if (!doesProductExist) {
        System.out.println("Sorry, the reference does not match any product. Please try again");
      }
    }
    Product singleProductToBeFormatted = productRepository.findProductByReference(reference);
    String singleProduct = formatter.formatProductDetails(singleProductToBeFormatted);
    System.out.println(singleProduct);

    System.out.println("What would you like to do next?");
    System.out.println("1. Add product to cart.");
    System.out.println("2. Keep browsing the catalog");

    String shopperAction = userInputScanner.nextLine();
    if (shopperWantsToKeepBrowsingTheCatalog(shopperAction)) {
      showCatalog();
    }
  }

  private static boolean shopperWantsToKeepBrowsingTheCatalog(String shopperAction) {
    return shopperAction.equals("2");
  }
}
