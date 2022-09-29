import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Product{
    private int number;
    private Location location;
    private String name;
    private String category;
    private LocalDate arrivedDate;
    private int quantity;
    private int price;

    public Product(){

    }
    public Product(int number, Location location, String name, String category, int quantity, int price, LocalDate arrivedDate) {
        this.number = number;
        this.location = location;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.arrivedDate = LocalDate.now();
    }

    public IProduct.ProductStatus createNewProduct(IProduct wh){
        return wh.addProduct(this);
    }
    public IProduct.ProductStatus deleteProduct(IProduct wh,int product_id){
        return wh.deleteProduct(this,product_id);
    }
    public Product searchProduct(IProduct wh,int product_id){
        return wh.searchProduct(product_id);
    }

    public ArrayList<Product> allProducts(IProduct wh){
        return wh.getArr();
    }
    public int getNumber() {
        return number;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getArrivedDate() {
        return arrivedDate;
    }

    public boolean setNumber(int number) {
        if (number == 0) {
            return false;
        }
        this.number = number;
        return true;
    }

    public boolean setLocation(String location) {
//        NULL or NOT
        if(location ==null){
            return false;
        }
        this.location.setProduct_location_code(location);
        return true;
    }

    public boolean setName(String name) {
        if(name.length()==0){
            return false;
        }
        this.name = name;
        return true;
    }

    public boolean setCategory(String category) {
        if(category.length()==0){
            return false;
        }
        this.category = category;
        return true;
    }

    public boolean setQuantity(int quantity) {
        if(quantity == 0){
            return false;
        }
        this.quantity = quantity;
        return true;
    }

    public boolean setPrice(int price) {
        if(price == 0){
            return false;
        }
        this.price = price;
        return true;
    }

//    TEST REMAINING
    public void setArrivedDate(LocalDate arrivedDate) {
        this.arrivedDate = arrivedDate;
    }
}
