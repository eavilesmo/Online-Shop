public class OnlineShop {

  private final ProductRepository productRepository = new ProductRepository();
  private final Formatter formatter = new Formatter();

  public void showProducts() {
    String finalProducts = formatter.formatProducts(productRepository.getProducts());
    System.out.println(finalProducts);
  }
}
