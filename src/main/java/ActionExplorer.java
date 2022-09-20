import java.util.Scanner;

public class ActionExplorer {

  private final ProductWarehouse productWarehouse;
  private final Formatter formatter;

  public ActionExplorer(ProductWarehouse productWarehouse, Formatter formatter) {
    this.productWarehouse = productWarehouse;
    this.formatter = formatter;
  }

  public void exploreNextActions() {
    browseProductsByReference(productWarehouse, formatter);
    askShopperNextAction();
  }

  private void browseProductsByReference(ProductWarehouse productWarehouse, Formatter formatter) {
    System.out.println(StringRepository.EXPLORE_PRODUCTS);
    Scanner scanner = new Scanner(System.in);
    boolean doesProductExist = false;
    String reference = "";

    while (!doesProductExist) {
      try {
        reference = scanner.nextLine();
        Product singleProductToBeFormatted = productWarehouse.findProductByReference(reference);
        String singleProduct = formatter.formatProductDetails(singleProductToBeFormatted);
        System.out.println(singleProduct);
        doesProductExist = true;
      } catch (RuntimeException exception) {
        System.out.println(StringRepository.INCORRECT_REFERENCE);
      }
    }
  }

  private void askShopperNextAction() {
    printNextActions();
    Scanner scanner = new Scanner(System.in);
    String shopperAction = scanner.nextLine();
    if (shopperWantsToKeepBrowsingTheCatalog(shopperAction)) {
      OnlineShop.showCatalog();
    }
  }

  private void printNextActions() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.ADD_PRODUCT_TO_CART);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
  }

  private boolean shopperWantsToKeepBrowsingTheCatalog(String shopperAction) {
    return shopperAction.equals(StringRepository.SECOND_OPTION);
  }
}
