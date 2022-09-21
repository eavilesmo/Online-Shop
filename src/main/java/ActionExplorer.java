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
      String productsToBeDisplayed = formatter.formatProducts(listOfProductsFiltered);
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
    System.out.println("Would you like to add this product to the cart?");
    Scanner scanner = new Scanner(System.in);
    String shopperResponse = scanner.nextLine();
    if (shopperResponse.equals("YES")) {
      cart.addProductToCart(reference);
      System.out.println("Product was added to cart.");
    }
    askShopperWhatToDoNext();
  }

  private void printNextActions() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.SEE_PRODUCT_DETAILS);
  }
}
