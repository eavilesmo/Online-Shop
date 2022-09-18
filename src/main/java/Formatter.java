import java.util.ArrayList;

public class Formatter {

  public String formatProducts(ArrayList<Product> listOfProducts) {
    StringBuilder finalProducts = new StringBuilder();
    for (Product product : listOfProducts) {
      finalProducts.append(product.getImage());
      finalProducts.append(StringRepository.LINE_BREAK);

      finalProducts.append(product.getShortDescription());
      finalProducts.append(StringRepository.LINE_BREAK);

      finalProducts.append(product.getHighlightedAttribute());
      finalProducts.append(StringRepository.LINE_BREAK);

      String formatForPrice = StringRepository.FORMAT_FOR_PRICE;
      String price = String.format(formatForPrice, product.getPrice());
      finalProducts.append(price);

      String formatForReference = StringRepository.FORMAT_FOR_REFERENCE;
      String reference = String.format(formatForReference, product.getReference());
      finalProducts.append(reference);
      finalProducts.append(StringRepository.LINE_BREAK);
    }
    return finalProducts.toString();
  }

  public String formatProductDetails(Product product) {
    StringBuilder singleProduct = new StringBuilder();
    singleProduct.append(product.getImage());
    singleProduct.append(StringRepository.LINE_BREAK);

    String formatForPrice = StringRepository.FORMAT_FOR_PRICE;
    String price = String.format(formatForPrice, product.getPrice());
    singleProduct.append(price);

    String formatForReference = StringRepository.FORMAT_FOR_REFERENCE;
    String reference = String.format(formatForReference, product.getReference());
    singleProduct.append(reference);

    String formatForStock = StringRepository.FORMAT_FOR_STOCK;
    String stock = String.format(formatForStock, product.getStock());
    singleProduct.append(stock).append(StringRepository.LINE_BREAK);

    singleProduct.append(StringRepository.SUMMARY_TITLE);
    singleProduct.append(product.getShortDescription());
    singleProduct.append(StringRepository.LINE_BREAK);
    singleProduct.append(product.getHighlightedAttribute());
    singleProduct.append(StringRepository.DOUBLE_LINE_BREAK);

    singleProduct.append(StringRepository.DESCRIPTION_TITLE);
    singleProduct.append(product.getLongDescription());
    singleProduct.append(StringRepository.DOUBLE_LINE_BREAK);

    return singleProduct.toString();
  }
}
