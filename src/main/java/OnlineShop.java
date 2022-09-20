public class OnlineShop {

  private static final ProductWarehouse productWarehouse = new ProductWarehouse();
  private static final Formatter formatter = new Formatter();
  private static final ActionExplorer actionExplorer = new ActionExplorer(productWarehouse, formatter);

  public static void showCatalog() {
    String finalProducts = formatter.formatProducts(productWarehouse.getProducts());
    System.out.println(finalProducts);
    actionExplorer.exploreNextActions();
  }
}
