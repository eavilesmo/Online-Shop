import java.util.ArrayList;

public class Formatter {

  public String formatProducts(ArrayList<Product> listOfProducts) {
    StringBuilder finalProducts = new StringBuilder();
    for (Product product : listOfProducts) {
      finalProducts.append(product.getImage());
      finalProducts.append("\n");

      finalProducts.append(product.getShortDescription());
      finalProducts.append("\n");

      finalProducts.append(product.getHighlightedAttribute());
      finalProducts.append("\n");

      String formatForPrice = "\uD83D\uDCB0 Price: %s €\n";
      String price = String.format(formatForPrice, product.getPrice());
      finalProducts.append(price);

      String formatForReference = "Reference: %s \n";
      String reference = String.format(formatForReference, product.getReference());
      finalProducts.append(reference);
      finalProducts.append("\n");
    }
    return finalProducts.toString();
  }

  public String formatProductDetails(Product product) {
    StringBuilder singleProduct = new StringBuilder();
    singleProduct.append(product.getImage());
    singleProduct.append("\n");

    String formatForPrice = "\uD83D\uDCB0 Price: %s €\n";
    String price = String.format(formatForPrice, product.getPrice());
    singleProduct.append(price);

    String formatForReference = "Reference: %s \n";
    String reference = String.format(formatForReference, product.getReference());
    singleProduct.append(reference);

    String formatForStock = "%s left.\n";
    String stock = String.format(formatForStock, product.getStock());
    singleProduct.append(stock);
    singleProduct.append("\n");

    singleProduct.append("SUMMARY:\n");
    singleProduct.append(product.getShortDescription());
    singleProduct.append("\n");
    singleProduct.append(product.getHighlightedAttribute());
    singleProduct.append("\n\n");

    singleProduct.append("DESCRIPTION:\n");
    singleProduct.append(product.getLongDescription());
    singleProduct.append("\n\n");

    return singleProduct.toString();
  }
}
