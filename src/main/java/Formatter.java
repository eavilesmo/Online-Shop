import java.util.ArrayList;

public class Formatter {

  private final ProductWarehouse productWarehouse = new ProductWarehouse();

  public String formatListOfProducts(ArrayList<Product> listOfProducts) {
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

  public String formatShoppingCart(Cart cart) {
    StringBuilder formattedString = new StringBuilder();
    addShoppingCartHeader(formattedString);
    if (cart.getTvCount() > 0) {
      Product product = productWarehouse.getProducts().get(0);
      addProductDetailsShoppingCart(formattedString, product, cart);
    }
    if (cart.getPianoCount() > 0) {
      Product product = productWarehouse.getProducts().get(1);
      addProductDetailsShoppingCart(formattedString, product, cart);
    }
    if (cart.getCandleCount() > 0) {
      Product product = productWarehouse.getProducts().get(2);
      addProductDetailsShoppingCart(formattedString, product, cart);
    }
    formattedString.append(StringRepository.SEPARATOR_THREE_DASHES);
    formattedString.append(StringRepository.TOTAL);
    formattedString.append(cart.showTotalPrice());
    addShoppingCartFooter(formattedString);

    return formattedString.toString();
  }

  private void addShoppingCartFooter(StringBuilder stringBuilder) {
    stringBuilder.append(StringRepository.DOUBLE_LINE_BREAK)
      .append(StringRepository.SEPARATOR_ASTERISKS)
      .append(StringRepository.LINE_BREAK);
  }

  private void addProductDetailsShoppingCart(StringBuilder stringBuilder, Product product, Cart cart) {
    addProductImage(stringBuilder, product);
    addProductShortDescription(stringBuilder, product);
    stringBuilder.append(StringRepository.SEPARATOR_TWO_DASHES);
    addProductPrice(stringBuilder, product);
    addProductReferenceWithoutBreakLine(stringBuilder, product);
    addProductUnits(stringBuilder, product, cart);
    addSubtotal(stringBuilder, product, cart);
  }

  private void addSubtotal(StringBuilder stringBuilder, Product product, Cart cart) {
    stringBuilder.append(StringRepository.SUBTOTAL);
    switch (product.getReference()) {
      case ProductAttributes.TV_REFERENCE -> {
        stringBuilder.append(ProductAttributes.TV_PRICE);
        stringBuilder.append(StringRepository.MULTIPLY_SYMBOL);
        stringBuilder.append(cart.getTvCount());
      }
      case ProductAttributes.PIANO_REFERENCE -> {
        stringBuilder.append(ProductAttributes.PIANO_PRICE);
        stringBuilder.append(StringRepository.MULTIPLY_SYMBOL);
        stringBuilder.append(cart.getPianoCount());
      }
      case ProductAttributes.CANDLE_REFERENCE -> {
        stringBuilder.append(ProductAttributes.CANDLE_PRICE);
        stringBuilder.append(StringRepository.MULTIPLY_SYMBOL);
        stringBuilder.append(cart.getCandleCount());
      }
    }
    stringBuilder.append(StringRepository.LINE_BREAK);
  }

  private void addProductUnits(StringBuilder stringBuilder, Product product, Cart cart) {
    stringBuilder.append(StringRepository.UNITS);
    switch (product.getReference()) {
      case ProductAttributes.TV_REFERENCE -> stringBuilder.append(cart.getTvCount());
      case ProductAttributes.PIANO_REFERENCE -> stringBuilder.append(cart.getPianoCount());
      case ProductAttributes.CANDLE_REFERENCE -> stringBuilder.append(cart.getCandleCount());
    }
    stringBuilder.append(StringRepository.LINE_BREAK);
  }

  private void addShoppingCartHeader(StringBuilder stringBuilder) {
    stringBuilder.append(StringRepository.LINE_BREAK)
      .append(StringRepository.SHOPPING_CART_HEADER)
      .append(StringRepository.DOUBLE_LINE_BREAK);
  }

  private void addProductImage(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(product.getImage())
      .append(StringRepository.LINE_BREAK);
  }

  private void addProductShortDescription(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(product.getShortDescription())
      .append(StringRepository.LINE_BREAK);
  }

  private void addProductHighlightedAttribute(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(product.getHighlightedAttribute())
      .append(StringRepository.LINE_BREAK);
  }

  private void addProductPrice(StringBuilder stringBuilder, Product product) {
    String formatForPrice = StringRepository.FORMAT_FOR_PRICE;
    String price = String.format(formatForPrice, product.getPrice());
    stringBuilder.append(price);
  }

  private void addProductReference(StringBuilder stringBuilder, Product product) {
    String formatForReference = StringRepository.FORMAT_FOR_REFERENCE;
    String reference = String.format(formatForReference, product.getReference());
    stringBuilder.append(reference)
      .append(StringRepository.LINE_BREAK);
  }

  private void addProductReferenceWithoutBreakLine(StringBuilder stringBuilder, Product product) {
    String formatForReference = StringRepository.FORMAT_FOR_REFERENCE;
    String reference = String.format(formatForReference, product.getReference());
    stringBuilder.append(reference);
  }

  private void addProductStock(StringBuilder stringBuilder, Product product) {
    String formatForStock = StringRepository.FORMAT_FOR_STOCK;
    String stock = String.format(formatForStock, product.getStock());
    stringBuilder.append(stock).append(StringRepository.LINE_BREAK);
  }

  private void addProductSummary(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(StringRepository.SUMMARY_TITLE)
      .append(product.getShortDescription())
      .append(StringRepository.LINE_BREAK)
      .append(product.getHighlightedAttribute())
      .append(StringRepository.DOUBLE_LINE_BREAK);
  }

  private void addProductGeneralDescription(StringBuilder stringBuilder, Product product) {
    stringBuilder.append(StringRepository.DESCRIPTION_TITLE)
      .append(product.getLongDescription())
      .append(StringRepository.DOUBLE_LINE_BREAK);
  }
}
