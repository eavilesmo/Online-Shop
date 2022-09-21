import java.util.ArrayList;
import java.util.Scanner;

public class ActionExplorer {

  private final ProductWarehouse productWarehouse;
  private final Formatter formatter;

  public void browseProductsByPrice() {
    System.out.println(StringRepository.BROWSE_PRODUCTS_BY_PRICE);
    Scanner userInputScanner = new Scanner(System.in);
    String userInput = userInputScanner.nextLine();
    double convertedInput = Double.parseDouble(userInput);

    ArrayList<Product> listOfProductsFiltered = (ArrayList<Product>) productWarehouse.filterProductsByPrice(convertedInput);
    if (listOfProductsFiltered.equals(new ArrayList<>())) {
      System.out.println(StringRepository.NO_PRODUCTS_MATCHING_CRITERIA);
    } else {
      String productsToBeDisplayed = formatter.formatProducts(listOfProductsFiltered);
      System.out.println(productsToBeDisplayed);
    }

    printNextActions();

    String userInput2 = userInputScanner.nextLine();
    if (userInput2.equals("2")) {
      browseProductsByPrice();
    } else if (userInput2.equals("3")) {
      browseProductsByReference(productWarehouse, formatter);
    }
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

  public ActionExplorer(ProductWarehouse productWarehouse, Formatter formatter) {
    this.productWarehouse = productWarehouse;
    this.formatter = formatter;
  }

  public void exploreNextActions() {
    browseProductsByReference(productWarehouse, formatter);
    askShopperNextAction();
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
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.SEE_PRODUCT_DETAILS);
  }

  private boolean shopperWantsToKeepBrowsingTheCatalog(String shopperAction) {
    return shopperAction.equals(StringRepository.SECOND_OPTION);
  }
}
