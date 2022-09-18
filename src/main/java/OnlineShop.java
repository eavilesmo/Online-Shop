import java.util.Scanner;

public class OnlineShop {

  private final ProductWarehouse productWarehouse = new ProductWarehouse();
  private final Formatter formatter = new Formatter();


  public void showCatalog() {
    String finalProducts = formatter.formatProducts(productWarehouse.getProducts());
    System.out.println(finalProducts);
    exploreProducts();
  }

  private void exploreProducts() {
    System.out.println(StringRepository.EXPLORE_PRODUCTS);
    Scanner userInputScanner = new Scanner(System.in);
    boolean doesProductExist = false;
    String reference = "";
    while (!doesProductExist) {
      reference = userInputScanner.nextLine();
      doesProductExist = productWarehouse.doesProductExist(reference);
      if (!doesProductExist) {
        System.out.println(StringRepository.INCORRECT_REFERENCE);
      }
    }
    Product singleProductToBeFormatted = productWarehouse.findProductByReference(reference);
    String singleProduct = formatter.formatProductDetails(singleProductToBeFormatted);
    System.out.println(singleProduct);

    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.ADD_PRODUCT_TO_CART);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);

    String shopperAction = userInputScanner.nextLine();
    if (shopperWantsToKeepBrowsingTheCatalog(shopperAction)) {
      showCatalog();
    }
  }

  private static boolean shopperWantsToKeepBrowsingTheCatalog(String shopperAction) {
    return shopperAction.equals("2");
  }
}
