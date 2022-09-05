import java.util.ArrayList;

public class OnlineShop {
    ProductRepository productRepository = new ProductRepository();

    public void showProducts() {
        productRepository.addProducts();
        for (Product product : productRepository.listOfProducts) {
            System.out.println(product.getImage());
            System.out.println(product.getShortDescription());
            System.out.println(product.getHighlightedAttribute());
            System.out.printf("\uD83D\uDCB0 Price: %s €\n", product.getPrice());
            System.out.printf("Reference: %s\n" ,product.getReference());
            System.out.println();
        }
    }
}
