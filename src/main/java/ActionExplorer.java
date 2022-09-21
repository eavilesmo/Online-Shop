import java.util.ArrayList;
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

    System.out.println("Browse products with prices lower than:");
    Scanner userInputScanner = new Scanner(System.in);
    String userInput = userInputScanner.nextLine();
    double convertedInput = Double.parseDouble(userInput);
    ArrayList<Product> listOfProductsFiltered = (ArrayList<Product>) productWarehouse.filterProductsByPrice(convertedInput);
    if (listOfProductsFiltered.equals(new ArrayList<>())) {
      System.out.println("Sorry, there are no products matching the criteria.");
    } else {
      String finalProductsFiltered = formatter.formatProducts(listOfProductsFiltered);
      System.out.println(finalProductsFiltered);
      System.out.println("What would you like to do next?");
      System.out.println("2. Keep browsing the catalog");
      System.out.println("3. See a product's details.");

      String userInput2 = userInputScanner.nextLine();
      if (userInput2.equals("2")) {
        exploreProducts();
      } else if (userInput2.equals("3")) {
        showSingleProduct();
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
