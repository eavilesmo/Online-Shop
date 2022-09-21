public class OnlineShop {

  private static final ProductWarehouse productWarehouse = new ProductWarehouse();
  private static final ActionExplorer actionExplorer = new ActionExplorer(productWarehouse);

  public static void showCatalog() {
    actionExplorer.browseProductsByPrice();
    
  }
}
