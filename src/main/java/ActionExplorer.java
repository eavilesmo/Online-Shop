import java.util.ArrayList;
import java.util.Scanner;

public class ActionExplorer {

  private final ProductWarehouse productWarehouse = new ProductWarehouse();
  private final Formatter formatter = new Formatter();
  private final NextActionsPrinter nextActionsPrinter = new NextActionsPrinter();
  private final Cart cart = new Cart();
  private final Scanner scanner = new Scanner(System.in);

  public void browseProductsByPrice() {
    System.out.println(StringRepository.BROWSE_PRODUCTS_BY_PRICE);
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

  private void browseProductsByReference(ProductWarehouse productWarehouse, Formatter formatter) {
    System.out.println(StringRepository.EXPLORE_PRODUCTS);
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

  private void askShopperWhatToDoNext() {
    nextActionsPrinter.printNextActions();
    String shopperInput = scanner.nextLine();
    switch (shopperInput) {
      case StringRepository.SECOND_OPTION -> browseProductsByPrice();
      case StringRepository.THIRD_OPTION -> browseProductsByReference(productWarehouse, formatter);
    }
  }

  private void displayShoppingCart() {
    String shoppingCart = formatter.formatShoppingCart(cart);
    System.out.println(shoppingCart);

    nextActionsPrinter.printNextActionsAfterSeeingShoppingCart();
    String shopperInput = scanner.nextLine();
    if (shopperInput.equals(StringRepository.SECOND_OPTION)) {
      browseProductsByPrice();
    }
  }

  private void askIfProductShouldBeAddedToCart(String reference) {
    System.out.println(StringRepository.ADD_PRODUCT_TO_CART);
    String shopperResponse = scanner.nextLine();
    if (shopperResponse.equals(StringRepository.RESPONSE_YES)) {
      cart.addProductToCart(reference);
      System.out.println(StringRepository.PRODUCT_ADDED_SUCCESSFULLY);
    }
    askShopperWhatToDoNextAfterAddingProductToCart();
  }

  private void askShopperWhatToDoNextAfterAddingProductToCart() {
    nextActionsPrinter.printNextActionsAfterAddingProductToCart();
    String shopperInput = scanner.nextLine();
    switch (shopperInput) {
      case StringRepository.SECOND_OPTION -> browseProductsByPrice();
      case StringRepository.THIRD_OPTION -> browseProductsByReference(productWarehouse, formatter);
      case StringRepository.FOURTH_OPTION -> displayShoppingCart();
    }
  }
}
