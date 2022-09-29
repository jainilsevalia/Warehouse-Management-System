import java.util.Arrays;

public class LocationTest {
    WarehouseDBMock wdbmock = new WarehouseDBMock();
    Location l = new Location();

    public LocationTest(){

//        Method Tests
        addNewLocationTest();
        addNewIncorrectLocationTest();
        deleteLocationTest();
        deleteLocationFromMultipleLocationTest();
        deleteIncorrectLocationTest();
        incorrectProductNumberDeleteLocationTest();
        changeLocationTest();
        incorrectProductNumberChangeLocationTest();
        addNewIncorrectProductLocationTest();

//        Setter Tests
        setProduct_location_codeTest();

//        Getter Test
        getProduct_location_codeTest();
    }

    public void addNewLocationTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().addNewLocation(wdbMock,336699,"WU651A");
        String[] split_string = p.getLocation().getProduct_location_code().split(",");
        if (Arrays.toString(split_string).contains("WU651A")){
            System.out.println("addNewLocationTest -- TEST PASS");
        }else{
            System.out.println("addNewLocationTest -- TEST FAIL");
        }
    }

    public void addNewIncorrectLocationTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().addNewLocation(wdbMock,336699,null);
        String[] split_string = p.getLocation().getProduct_location_code().split(",");
        if (Arrays.toString(split_string).contains("WU133C")){
            System.out.println("addNewIncorrectLocationTest -- TEST PASS");
        }else{
            System.out.println("addNewIncorrectLocationTest -- TEST FAIL");
        }
    }

    public void addNewIncorrectProductLocationTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().addNewLocation(wdbMock,123456,"WU133C");
//        String[] split_string = p.getLocation().getProduct_location_code().split(",");
        if (p==null){
            System.out.println("addNewIncorrectProductLocationTest -- TEST PASS");
        }else{
            System.out.println("addNewIncorrectProductLocationTest -- TEST FAIL");
        }
    }

    public void deleteLocationTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p =new Location().deleteLocation(wdbMock,336699,"WU133C");
        if (p.getLocation().getProduct_location_code().equals("")){
                System.out.println("deleteLocationTest -- TEST PASS");
            }else{
                System.out.println("deleteLocationTest -- TEST FAIL");
            }
        }
        public void deleteLocationFromMultipleLocationTest(){
            WarehouseDBMock wdbMock =new WarehouseDBMock();
            Product p =new Location().deleteLocation(wdbMock,112233,"WU656A");
            if (p.getLocation().getProduct_location_code().equals("WU531B,null")){
                System.out.println("deleteLocationFromMultipleLocationTest -- TEST PASS");
            }else{
                System.out.println("deleteLocationFromMultipleLocationTest -- TEST FAIL");
            }
    }

    public void deleteIncorrectLocationTest() {
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().deleteLocation(wdbMock,112233,"WU000A");
        if (p.getLocation().getProduct_location_code().equals("WU656A,WU531B")){
            System.out.println("deleteIncorrectLocationTest -- TEST PASS");
        }else{
            System.out.println("deleteIncorrectLocationTest -- TEST FAIL");
        }
    }

    public void incorrectProductNumberDeleteLocationTest() {
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().deleteLocation(wdbMock,123456,"WU000A");
        if (p==null){
            System.out.println("incorrectProductNumberDeleteLocationTest -- TEST PASS");
        }else{
            System.out.println("incorrectProductNumberDeleteLocationTest -- TEST FAIL");
        }
    }

    public void changeLocationTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().changeLocation(wdbMock,336699,"WU987C");
        if(p.getLocation().getProduct_location_code().equals("WU987C")){
            System.out.println("changeLocationTest -- TEST PASS");
        }else{
            System.out.println("changeLocationTest -- TEST FAIL");
        }
    }

    public void incorrectProductNumberChangeLocationTest(){
        WarehouseDBMock wdbMock = new WarehouseDBMock();
        Product p = new Location().changeLocation(wdbMock,123456,"WU987C");
        if(p==null){
            System.out.println("incorrectProductNumberChangeLocationTest -- TEST PASS");
        }else{
            System.out.println("incorrectProductNumberChangeLocationTest -- TEST FAIL");
        }
    }

    public void setProduct_location_codeTest(){
        Location l = new Location("WU133C");
        l.setProduct_location_code("WU001A");
        if (l.getProduct_location_code().equals("WU001A")){

            System.out.println("setProduct_location_codeTest -- TEST PASS");
        }else{
            System.out.println("setProduct_location_codeTest -- TEST FAIL");
        }
    }

    public void getProduct_location_codeTest(){
        Location l = new Location("WU133C");
        if (l.getProduct_location_code().equals("WU133C")){
            System.out.println("getProduct_location_codeTest -- TEST PASS");
        }else{
            System.out.println("getProduct_location_codeTest -- TEST FAIL");
        }
    }
}

