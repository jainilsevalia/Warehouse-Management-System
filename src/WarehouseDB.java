import java.util.ArrayList;

public class WarehouseDB implements IProduct {
    private ArrayList<Product> arr = new ArrayList<>();

    public IProduct.ProductStatus addProduct(Product product){
        arr.add(new Product(product.getNumber(),product.getLocation(), product.getName(),product.getCategory(),product.getQuantity(),product.getPrice(),product.getArrivedDate()));
        System.out.println("________________________________");
        System.out.println("Product Added Successfully.");
        System.out.println("_________________________________\n\n");
        return ProductStatus.SUCCESS;
    }

    public IProduct.ProductStatus deleteProduct(Product product,int id){
        for(int i=0; i<arr.size();i++) {
            if (id == arr.get(i).getNumber()) {
                arr.remove(i);
            }
        }
        System.out.println("Product Deleted SuccessFully");
        return ProductStatus.SUCCESS;
    }

    public ArrayList<Product> getArr() {
        return arr;
    }

    public Product searchProduct(int product_id){
        for(int i=0; i<arr.size();i++){
            if(product_id == arr.get(i).getNumber()){
                return arr.get(i);
            }
        }
        return null;
    }


}
