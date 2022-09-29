import java.util.ArrayList;

public interface IProduct {
    enum ProductStatus {
        SUCCESS,
        FAIL
    }
    public ProductStatus addProduct(Product p);
    public ProductStatus deleteProduct(Product p, int a);
    public Product searchProduct(int a);
    public ArrayList<Product> getArr();
}
