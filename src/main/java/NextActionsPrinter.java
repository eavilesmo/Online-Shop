public class NextActionsPrinter {

  public void printNextActions() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.SEE_PRODUCT_DETAILS);
  }

  public void printNextActionsAfterAddingProductToCart() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.SEE_PRODUCT_DETAILS);
    System.out.println(StringRepository.GO_TO_CHECKOUT);
  }

  public void printNextActionsAfterSeeingShoppingCart() {
    System.out.println(StringRepository.NEXT_ACTION_QUESTION);
    System.out.println(StringRepository.KEEP_BROWSING_PRODUCTS);
    System.out.println(StringRepository.CONFIRM_PURCHASE);
  }
}
