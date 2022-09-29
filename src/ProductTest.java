import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ProductTest {
    WarehouseDBMock wdbmock = new WarehouseDBMock();
    Product p = new Product();
    public ProductTest() {

//        METHODS TESTS
        addProductTest();
        addProductIncorrectDataTest();
        deleteProductTest();
        deleteProductIncorrectDataTest();
        searchProductTest();
        searchProductIncorrectDataTest();
        allProductsTest();

//        SETTER TEST
        setProductLocationTest();
        setProductIncorrectLocationTest();
        setProductNameTest();
        setProductIncorrectNameTest();
        setProductCategoryTest();
        setProductIncorrectCategoryTest();
        setProductQuantityTest();
        setProductIncorrectQuantityTest();
        setProductPriceTest();
        setProductIncorrectPriceTest();
        setProductNumberTest();
        setProductIncorrectNumberTest();
        setProductArrivedDateTest();

//        GETTER TEST
        getProductNameTest();
        getProductQuantityTest();
        getProductLocationTest();
        getProductPriceTest();
        getProductCategoryTest();
        getProductNumberTest();

    }

    public void allProductsTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Location l = new Location("WU133C");
        Product p = new Product(336699,l,"FastTrack_Watch","Sports",30,600,LocalDate.now());
        ArrayList<Product> arrProduct = p.allProducts(wdbMock);
        if (arrProduct.get(0).getNumber()==336699){
            System.out.println("allProductsTest -- TEST PASS");
        }else{
            System.out.println("allProductsTest -- TEST FAIL");
        }
    }
    public void addProductTest(){
        WarehouseDBMock wdbmock = new WarehouseDBMock();
        Location l = new Location("WU526A");
        Product p = new Product(256487, l, "Fan", "Housewares", 12, 30, LocalDate.now());
        IProduct.ProductStatus np = p.createNewProduct(wdbmock);

        if(IProduct.ProductStatus.SUCCESS == np){
            System.out.println("addProductTest -- TEST PASS");
        }else{
            System.out.println("addProductTest -- TEST FAIL");
        }
    }
    public void addProductIncorrectDataTest(){
        WarehouseDBMock wdbmock = new WarehouseDBMock();
        Location l = new Location("");
        Product p  = new Product(235689, null, "hbjn", "Housewares", 12, 30, LocalDate.now());
        IProduct.ProductStatus np = p.createNewProduct(wdbmock);

        if(IProduct.ProductStatus.FAIL == np){
            System.out.println("addProductIncorrectDataTest -- TEST PASS");
        }else{
            System.out.println("addProductIncorrectDataTest -- TEST FAIL");
        }
    }

    public void deleteProductTest(){
        WarehouseDBMock wdbmock = new WarehouseDBMock();
        Product p = new Product();
        ArrayList<Product> arr = wdbmock.getProducts();
        IProduct.ProductStatus dp = p.deleteProduct(wdbmock,762516);

        if(IProduct.ProductStatus.SUCCESS == dp){
            System.out.println("deleteProductTest -- TEST PASS");
        }else{
            System.out.println("deleteProductTest -- TEST FAIL");
        }
    }
    public void deleteProductIncorrectDataTest(){
        WarehouseDBMock wdbmock = new WarehouseDBMock();
        Product p = new Product();
        ArrayList<Product> arr = wdbmock.getProducts();
        IProduct.ProductStatus dp = p.deleteProduct(wdbmock,000000);

        if(IProduct.ProductStatus.FAIL == dp){
            System.out.println("deleteProductIncorrectDataTest -- TEST PASS");
        }else{
            System.out.println("deleteProductIncorrectDataTest -- TEST FAIL");
        }

    }
    public void searchProductTest(){
        WarehouseDBMock wdbmock = new WarehouseDBMock();
        Product p = new Product();
        ArrayList<Product> arr = wdbmock.getProducts();
        Product sp = p.searchProduct(wdbmock,arr.get(0).getNumber());
        if(sp != null && sp.getNumber() == 336699){
            System.out.println("searchProductTest -- TEST PASS");
        }else{
            System.out.println("searchProductTest -- TEST FAIL");
        }
    }
    public void searchProductIncorrectDataTest(){
        WarehouseDBMock wdbmock = new WarehouseDBMock();
        Product p = new Product();
        ArrayList<Product> arr = wdbmock.getProducts();
        Product sp = p.searchProduct(wdbmock,336692);
        if(sp == null || sp.getNumber() != 336699){
            System.out.println("searchProductIncorrectDataTest -- TEST PASS");
        }else{
            System.out.println("searchProductIncorrectDataTest -- TEST FAIL");
        }
    }

//    SETTER TESTS

    public void setProductNumberTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setNumber(987654);
        if (p.getNumber()==987654){
            System.out.println("setProductNumberTest - TEST PASS");
        } else {
            System.out.println("setProductNumberTest - TEST FAIL");
        }
    }
    public void setProductIncorrectNumberTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setNumber(00);
        if (p.getNumber()==556688){
            System.out.println("setProductIncorrectNumberTest - TEST PASS");
        } else {
            System.out.println("setProductIncorrectNumberTest - TEST FAIL");
        }
    }

    public void setProductNameTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setName("Driller");
        if (p.getName().equals("Driller")){
            System.out.println("setProductNameTest - TEST PASS");
        } else {
            System.out.println("setProductNameTest - TEST FAIL");
        }
    }
    public void setProductIncorrectNameTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setName("");
        if (p.getName().equals("Generator")){
            System.out.println("setProductIncorrectNameTest - TEST PASS");
        } else {
            System.out.println("setProductIncorrectNameTest - TEST FAIL");
        }
    }
    public void setProductLocationTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setLocation("WU895C");
        if (p.getLocation().getProduct_location_code().equals("WU895C")){
            System.out.println("setProductLocationTest - TEST PASS");
        } else {
            System.out.println("setProductLocationTest - TEST FAIL");
        }
    }
    public void setProductIncorrectLocationTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setLocation(null);
        if (p.getLocation().getProduct_location_code().equals("WU256A")){
            System.out.println("setProductIncorrectLocationTest - TEST PASS");
        } else {
            System.out.println("setProductIncorrectLocationTest - TEST FAIL");
        }
    }
    public void setProductCategoryTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setCategory("Housewares");
        if (p.getCategory().equals("Housewares")){
            System.out.println("setProductCategoryTest - TEST PASS");
        } else {
            System.out.println("setProductCategoryTest - TEST FAIL");
        }
    }
    public void setProductIncorrectCategoryTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setCategory("");
        if (p.getCategory().equals("Hardware")){
            System.out.println("setProductIncorrectCategoryTest - TEST PASS");
        } else {
            System.out.println("setProductIncorrectCategoryTest - TEST FAIL");
        }
    }
    public void setProductQuantityTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setQuantity(7);
        if (p.getQuantity()== 7){
            System.out.println("setProductQuantityTest - TEST PASS");
        } else {
            System.out.println("setProductQuantityTest - TEST FAIL");
        }
    }
    public void setProductIncorrectQuantityTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setQuantity(0);
        if (p.getQuantity()== 5){
            System.out.println("setProductIncorrectQuantityTest - TEST PASS");
        } else {
            System.out.println("setProductIncorrectQuantityTest - TEST FAIL");
        }
    }
    public void setProductPriceTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setPrice(3000);
        if (p.getPrice()==3000){
            System.out.println("setProductPriceTest - TEST PASS");
        } else {
            System.out.println("setProductPriceTest - TEST FAIL");
        }
    }
    public void setProductIncorrectPriceTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        p.setPrice(000);
        if (p.getPrice()==2000){
            System.out.println("setProductIncorrectPriceTest - TEST PASS");
        } else {
            System.out.println("setProductIncorrectPriceTest - TEST FAIL");
        }
    }

    public void setProductArrivedDateTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000, LocalDate.now());
        p.setArrivedDate(LocalDate.now());
        if ((p.getArrivedDate()).equals(LocalDate.now())){
            System.out.println("setProductArrivedDateTest - PASS");
        }else {
            System.out.println("setProductArrivedDateTest - FAIL");
        }
    }

    public void getProductNameTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        if (p.getName().equals("Generator")){
            System.out.println("getProductNameTest - TEST PASS");
        }else{
            System.out.println("getProductNameTest - TEST FAIL");
        }
    }

    public void getProductLocationTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        if (p.getLocation() instanceof Location) {
            System.out.println("getProductLocationTest - TEST PASS");
        }else{
            System.out.println("getProductLocationTest - TEST FAIL");
        }
    }

    public void getProductCategoryTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        if (p.getCategory().equals("Hardware")){
            System.out.println("getProductCategoryTest - TEST PASS");
        }else{
            System.out.println("getProductCategoryTest - TEST FAIL");
        }
    }

    public void getProductQuantityTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        if (p.getQuantity() == 5){
            System.out.println("getProductQuantityTest - TEST PASS");
        }else{
            System.out.println("getProductQuantityTest - TEST FAIL");
        }
    }

    public void getProductPriceTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        if (p.getQuantity() == 5){
            System.out.println("getProductPriceTest - TEST PASS");
        }else{
            System.out.println("getProductPriceTest - TEST FAIL");
        }
    }

    public void getProductNumberTest(){
        Location l = new Location("WU256A");
        Product p = new Product(556688,l,"Generator","Hardware",5,2000,LocalDate.now());
        if (p.getNumber() == 556688){
            System.out.println("getProductNumberTest - TEST PASS");
        }else{
            System.out.println("getProductNumberTest - TEST FAIL");
        }
    }
}
