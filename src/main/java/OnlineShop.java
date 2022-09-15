import java.util.ArrayList;
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
    System.out.println("Browse products with prices lower than:");
    Scanner userInputScanner = new Scanner(System.in);
    String userInput = userInputScanner.nextLine();
    double convertedInput = Double.parseDouble(userInput);
    ArrayList<Product> listOfProductsFiltered = (ArrayList<Product>) productRepository.filterProductsByPrice(convertedInput);
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

  private void showSingleProduct() {
    System.out.println("Which product would you like to explore? - Introduce the product's reference.");
    boolean doesProductExist = false;
    Scanner userInputScanner = new Scanner(System.in);

    while (!doesProductExist) {
      String userInput = userInputScanner.nextLine();
      doesProductExist = productRepository.findProductByReference(userInput);
      if (!doesProductExist) {
        System.out.println("Sorry, the reference does not match any product. Please try again");
      }
      Product singleProductToBeFormatted = productRepository.getSingleProduct(userInput);
      String singleProduct = formatter.formatProductDetails(singleProductToBeFormatted);
      System.out.println(singleProduct);
    }
  }
}
