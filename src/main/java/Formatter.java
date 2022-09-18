import java.util.ArrayList;

public class Formatter {

  public String formatProducts(ArrayList<Product> listOfProducts) {
    StringBuilder formattedStrings = new StringBuilder();
    for (Product product : listOfProducts) {
      addProductImage(formattedStrings, product);
      addProductShortDescription(formattedStrings, product);
      addProductHighlightedAttribute(formattedStrings, product);
      addProductPrice(formattedStrings, product);
      addProductReference(formattedStrings, product);
    }
    return formattedStrings.toString();
  }

  public String formatProductDetails(Product product) {
    StringBuilder formattedString = new StringBuilder();
    addProductImage(formattedString, product);
    addProductPrice(formattedString, product);
    addProductReference(formattedString, product);
    addProductStock(formattedString, product);
    addProductSummary(formattedString, product);
    addProductGeneralDescription(formattedString, product);

    return formattedString.toString();
  }

  private void addProductImage(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(product.getImage());
    stringBuilder.append(StringRepository.LINE_BREAK);
  }

  private void addProductShortDescription(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(product.getShortDescription());
    stringBuilder.append(StringRepository.LINE_BREAK);
  }

  private void addProductHighlightedAttribute(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(product.getHighlightedAttribute());
    stringBuilder.append(StringRepository.LINE_BREAK);
  }

  private void addProductPrice(StringBuilder stringBuilder, Product product) {
    String formatForPrice = StringRepository.FORMAT_FOR_PRICE;
    String price = String.format(formatForPrice, product.getPrice());
    stringBuilder.append(price);
  }

  private void addProductReference(StringBuilder stringBuilder, Product product) {
    String formatForReference = StringRepository.FORMAT_FOR_REFERENCE;
    String reference = String.format(formatForReference, product.getReference());
    stringBuilder.append(reference);
    stringBuilder.append(StringRepository.LINE_BREAK);
  }

  private void addProductStock(StringBuilder stringBuilder, Product product) {
    String formatForStock = StringRepository.FORMAT_FOR_STOCK;
    String stock = String.format(formatForStock, product.getStock());
    stringBuilder.append(stock).append(StringRepository.LINE_BREAK);
  }

  private void addProductSummary(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(StringRepository.SUMMARY_TITLE);
    stringBuilder.append(product.getShortDescription());
    stringBuilder.append(StringRepository.LINE_BREAK);
    stringBuilder.append(product.getHighlightedAttribute());
    stringBuilder.append(StringRepository.DOUBLE_LINE_BREAK);
  }

  private void addProductGeneralDescription(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(StringRepository.DESCRIPTION_TITLE);
    stringBuilder.append(product.getLongDescription());
    stringBuilder.append(StringRepository.DOUBLE_LINE_BREAK);
  }
}
