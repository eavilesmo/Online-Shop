public class Cart {

  private int tvCount = 0;
  private int pianoCount = 0;
  private int candleCount = 0;
  private double totalPrice = 0;

  public void addProductToCart(String reference) {
    switch (reference) {
      case ProductAttributes.TV_REFERENCE -> addTelevisionToCart();
      case ProductAttributes.PIANO_REFERENCE -> addPianoToCart();
      case ProductAttributes.CANDLE_REFERENCE -> addCandleToCart();
    }
    calculatePrice();
  }

  private void addTelevisionToCart() {
    tvCount++;
  }

  private void addPianoToCart() {
    pianoCount++;
  }

  private void addCandleToCart() {
    candleCount++;
  }

  private double calculatePrice() {
    totalPrice += ProductAttributes.TV_PRICE * tvCount;
    totalPrice += ProductAttributes.PIANO_PRICE * pianoCount;
    totalPrice += ProductAttributes.CANDLE_PRICE * candleCount;

    return totalPrice;
  }
}
