import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class WarehouseDBMock implements IProduct {

    private ArrayList<Product> products = new ArrayList<>();

    public WarehouseDBMock() {

        products.add(new Product(336699,new Location("WU133C"),"FastTrack_Watch","Sports",30,600, LocalDate.now()));
        products.add(new Product(112233,new Location("WU656A,WU531B"),"Generator","Hardware",5,5000,LocalDate.now()));
        products.add(new Product(993617,new Location("WU823B"),"Study Table","Housewares",10,200,LocalDate.now()));
        products.add(new Product(762516,new Location("WU213E"),"Racing Car","Toys",88,60,LocalDate.now()));
        products.add(new Product(624813,new Location("WU436A"),"Chairs","Housewares",5,8,LocalDate.now()));
    }

    @Override
    public ProductStatus addProduct(Product p) {
        if ((p.getName().equals("")) || (p.getLocation() == null)|| (p.getCategory().equals(""))|| (p.getArrivedDate().equals(""))) {
            return ProductStatus.FAIL;
        }
        return ProductStatus.SUCCESS;
    }
    @Override
    public ProductStatus deleteProduct(Product p,int id){
        if (validation(id) != null){
            return ProductStatus.SUCCESS;
        }
        else {
            return ProductStatus.FAIL;
        }
    }
    @Override
    public Product searchProduct(int product_id){
        if(validation(product_id) == null){
            return null;
        }
        else {
            return validation(product_id);
        }
    }

    public ArrayList<Product> getArr(){return products;}

    private Product validation(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getNumber()) {
                return getProducts().get(i);
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
}
