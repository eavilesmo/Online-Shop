import java.util.ArrayList;
import java.util.Scanner;

public class ActionExplorer {

  private final ProductWarehouse productWarehouse;
  private final Formatter formatter = new Formatter();
  private final Cart cart = new Cart();

  public ActionExplorer(ProductWarehouse productWarehouse) {
    this.productWarehouse = productWarehouse;
  }

  public void browseProductsByPrice() {
    System.out.println(StringRepository.BROWSE_PRODUCTS_BY_PRICE);
    Scanner scanner = new Scanner(System.in);
    String shopperInput = scanner.nextLine();
    double convertedInput = Double.parseDouble(shopperInput);

    ArrayList<Product> listOfProductsFiltered = (ArrayList<Product>) productWarehouse.filterProductsByPrice(convertedInput);
    if (listOfProductsFiltered.equals(new ArrayList<>())) {
      System.out.println(StringRepository.NO_PRODUCTS_MATCHING_CRITERIA);
    } else {
      String productsToBeDisplayed = formatter.formatListOfProducts(listOfProductsFiltered);
      System.out.println(productsToBeDisplayed);
    }

    askShopperWhatToDoNext();
  }

  private void askShopperWhatToDoNext() {
    printNextActions();
    Scanner scanner = new Scanner(System.in);
    String shopperInput = scanner.nextLine();
    if (shopperInput.equals(StringRepository.SECOND_OPTION)) {
      browseProductsByPrice();
    } else if (shopperInput.equals(StringRepository.THIRD_OPTION)) {
      browseProductsByReference(productWarehouse, formatter);
    } else if (shopperInput.equals(StringRepository.FOURTH_OPTION)) {
      displayShoppingCart();
    }
  }

  private void displayShoppingCart() {
    String shoppingCart = formatter.formatShoppingCart(cart);
    System.out.println(shoppingCart);

    printNextActionsAfterSeeingShoppingCart();
    Scanner scanner = new Scanner(System.in);
    String shopperInput = scanner.nextLine();
    if (shopperInput.equals(StringRepository.SECOND_OPTION)) {
      browseProductsByPrice();
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
    askIfProductShouldBeAddedToCart(reference);
  }

  private void askIfProductShouldBeAddedToCart(String reference) {
    System.out.println(StringRepository.ADD_PRODUCT_TO_CART);
    Scanner scanner = new Scanner(System.in);
    String shopperResponse = scanner.nextLine();
    if (shopperResponse.equals(StringRepository.RESPONSE_YES)) {
      cart.addProductToCart(reference);
      System.out.println(StringRepository.PRODUCT_ADDED_SUCCESSFULLY);
    }
    askShopperWhatToDoNextAfterAddingProductToCart();
  }

  private void askShopperWhatToDoNextAfterAddingProductToCart() {
    printNextActionsAfterAddingProductToCart();
    Scanner scanner = new Scanner(System.in);
    String shopperInput = scanner.nextLine();
    if (shopperInput.equals(StringRepository.SECOND_OPTION)) {
      browseProductsByPrice();
    } else if (shopperInput.equals(StringRepository.THIRD_OPTION)) {
      browseProductsByReference(productWarehouse, formatter);
    } else if (shopperInput.equals(StringRepository.FOURTH_OPTION)) {
      displayShoppingCart();
    }
  }

  private void printNextActions() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.SEE_PRODUCT_DETAILS);
  }

  private void printNextActionsAfterAddingProductToCart() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.SEE_PRODUCT_DETAILS);
    System.out.println(StringRepository.GO_TO_CHECKOUT);
  }

  private void printNextActionsAfterSeeingShoppingCart() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.CONFIRM_PURCHASE);
  }
}
