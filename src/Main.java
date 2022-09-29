import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.WeakHashMap;

public class Main {
    enum state {
        INCORRECT_PIN,
        SUCCESS,
        SUCCESSFULLY_LOGEDIN;
    }

    static Product product;
    static WarehouseDB WHDB = new WarehouseDB();


    public static void main(String[] args) throws ParseException {
        if (args.length != 0 && args[0].equalsIgnoreCase("test")) {
            System.out.println("\n --- Running all the Tests --- \n\n");
            System.out.println("\n --- Running tests from ProductTest --- \n");
            new ProductTest();
            System.out.println("\n --- Running tests from EmployeeTest --- \n");
            new EmployeeTest();
            System.out.println("\n --- Running tests from LocationTest --- \n");
            new LocationTest();
        }
        else {
            Scanner sc = new Scanner(System.in);
            System.out.println("=======================================================================================================================");
            System.out.println("                                            Warehouse Management System                                                ");
            System.out.println("=======================================================================================================================");
            System.out.println("\n *** INFORMATION OF WAREHOUSE MANAGEMENT SYSTEM ***\n" +
                    "\n" +
                    "Every Warehouse has 2 entities , Product and It's Location\n" +
                    "\n" +
                    "An employee can log in to the system through provided PIN, Which is 3569 throughout this assignment.\n" +
                    "\n" +
                    "An employee can manage products in the system through option 1, in which the employee can add a product, Search for a Product and delete the product from the warehouse.\n" +
                    "\n" +
                    "Here we have 2 cases for Locations.\n" +
                    "\n" +
                    "Case: 1\n" +
                    "Single product has multiple locations in the warehouse.\n" +
                    "\n" +
                    "Case: 2\n" +
                    "Single Products have multiple locations in the warehouse.\n" +
                    "\n" +
                    "Both cases can be done through option 2, Which performs add the location of the product, delete Location, and change location.\n" +
                    "\n" +
                    "In addition to that, the employee can view all the products of the warehouse and its location.\n" +
                    "\n" +
                    "Lastly, Employee can view his/her profile from option 4.");
            boolean isVerifiedEmployee;
            do {
                isVerifiedEmployee = verifyEmployee();
            } while (!isVerifiedEmployee);

            while (true) {
                int selectedOption = 0;
                if (isVerifiedEmployee) {
                    do{
                        System.out.println("1) Manage Products ");
                        System.out.println("2) Manage Location in Warehouse");
                        System.out.println("3) List of products available in Warehouse with Location");
                        System.out.println("4) Employee Details");
                        System.out.println("5) Exit ");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Select any option from above");
                        while(!sc.hasNextInt()){
                            System.out.println("Enter the Positive number only");
                            sc.next();
                        }
                        selectedOption = sc.nextInt();
                    }while (selectedOption<=0);
                }
                if (selectedOption == 5) {
                    break;
                }
                switch (selectedOption) {
                    case 1:
//                FIND PRODUCT
                        int subProductOption;
                        do{
                            System.out.println("1) Add New Product ");
                            System.out.println("2) Delete Product ");
                            System.out.println("3) Search Product ");
                            System.out.println("4) Back to main menu");
                            System.out.println("Choose any option from above: ");
                            while(!sc.hasNextInt()){
                                System.out.println("Enter the Positive number only");
                                sc.next();
                            }
                            subProductOption = sc.nextInt();
                        }while(subProductOption<=0);

                        //sc.nextLine();
                        if (subProductOption == 4) {
                            break;
                        }
//                        while (true)
                        switch (subProductOption) {
                            case 1:

                                //https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
                                Scanner scProduct = new Scanner(System.in);
                                int number;
                                do {
                                    System.out.println("Enter Product Number: ");
                                    while (!scProduct.hasNextInt()) {
                                        System.out.println("Enter the Positive number only");
                                        scProduct.next();
                                    }
                                    number = scProduct.nextInt();
                                }while (number<=0);

                                Scanner scName = new Scanner(System.in);
                                System.out.println("Enter Product Name: ");
                                String name = scName.nextLine();

                                Scanner scCategory = new Scanner(System.in);
                                System.out.println("Enter Product Category: ");
                                String category = scCategory.nextLine();

                                Scanner scQuantity = new Scanner(System.in);
                                System.out.println("Enter Product Quantity: ");
                                int quantity = scQuantity.nextInt();

                                Scanner scPrice = new Scanner(System.in);
                                System.out.println("Enter Product Price: ");
                                int price = scPrice.nextInt();

                                Scanner scLocation = new Scanner(System.in);
                                System.out.println("Enter Product Warehouse Location : ");
                                String location = scLocation.nextLine();

                                Scanner scDate = new Scanner(System.in);
                                System.out.println("Enter Product Arrived Date(dd-mm-yyyy): ");
                                String date1 = scDate.nextLine();
                                Date arriveDate = new SimpleDateFormat("dd-MM-yyyy").parse(date1);

//                                LOCATION ADD
                                Location l = new Location(location);
                                product = new Product(number, l, name, category, quantity, price, LocalDate.now());
                                product.createNewProduct(WHDB);
                                int arr_len = WHDB.getArr().size();
                                Product recently_added = WHDB.getArr().get(arr_len-1);
                                System.out.println("Your Product Details is : ");
                                System.out.println("----------------------------\n");
                                System.out.println(
                                        "Product_Number    : "+ recently_added.getNumber()+"\n"+
                                                "Price             : " +recently_added.getPrice()+"\n"+
                                                "Name              : "+recently_added.getName()+"\n"+
                                                "Quantity          : "+recently_added.getQuantity()+"\n"+
                                                "Category          : "+recently_added.getCategory()+"\n"+
                                                "Location          : "+recently_added.getLocation().getProduct_location_code()+"\n"
                                );
                                break;

                            case 2:
                                System.out.println("Enter number of Product which you want to delete");
                                Scanner scDelete = new Scanner(System.in);
                                int delete_product = scDelete.nextInt();

                                product.deleteProduct(WHDB, delete_product);
                                System.out.println(WHDB.getArr());
                                break;

                            case 3:
                                System.out.println(WHDB.getArr());
                                System.out.println("Enter number of Product Number which you want to Search");
                                Scanner scSearch = new Scanner(System.in);
                                int search_product = scSearch.nextInt();
                                Product p = product.searchProduct(WHDB, search_product);
                                System.out.println("Your Product Details is : ");
                                System.out.println("----------------------------\n");
                                System.out.println(
                                                "Product_Number    : "+ p.getNumber()+"\n"+
                                                "Price             : " +p.getPrice()+"\n"+
                                                "Name              : "+p.getName()+"\n"+
                                                "Quantity          : "+p.getQuantity()+"\n"+
                                                "Category          : "+p.getCategory()+"\n"+
                                                "Location          : "+p.getLocation().getProduct_location_code()+"\n"
                                );
                                break;
                        }
                    break;
                    case 2:
//                LOCATION
                        int case2SubOption;
                        do{
                            System.out.println("1) Add location for existing product. ");
                            System.out.println("2) Delete location of removed product.  ");
                            System.out.println("3) Change the location of product. ");
                            System.out.println("4) Back to main menu");
                            System.out.println("Choose any option from above: ");
                            while(!sc.hasNextInt()){
                                System.out.println("Enter the Positive number only");
                                sc.next();
                            }
                         case2SubOption = sc.nextInt();
                        }while (case2SubOption<=0);

                        if (case2SubOption == 4){
                            break;
                        }
                        switch (case2SubOption){
                            case 1:
                                System.out.println("Add Location");
                                System.out.println("-------------\n");

                                Scanner scProduct = new Scanner(System.in);
                                int product_number;
                                do {
                                    System.out.println("Enter Product Number: ");
                                    while (!scProduct.hasNextInt()) {
                                        System.out.println("Enter the Positive number only");
                                        scProduct.next();
                                    }
                                    product_number = scProduct.nextInt();
                                }while (product_number<=0);

//                                System.out.println("Enter product number : ");
//                                Scanner scProductNumber = new Scanner(System.in);
//                                int product_number = scProductNumber.nextInt();

                                System.out.println("Enter product Location : \n");
                                Scanner scProductLocation = new Scanner(System.in);
                                String location = scProductLocation.nextLine();

                                Location ad_location = new Location();
                                Product is_successful = ad_location.addNewLocation(WHDB,product_number,location);
                                if (is_successful != null){
                                    System.out.println("---------------------------");
                                    System.out.println("Location Added Successfully");
                                    System.out.println("---------------------------");
                                    System.out.println(
                                            "Product_Number    : "+ is_successful.getNumber()+"\n"+
                                                    "Price             : " +is_successful.getPrice()+"\n"+
                                                    "Name              : "+is_successful.getName()+"\n"+
                                                    "Quantity          : "+is_successful.getQuantity()+"\n"+
                                                    "Category          : "+is_successful.getCategory()+"\n"+
                                                    "Location          : "+is_successful.getLocation().getProduct_location_code()+"\n"
                                    );
                                }else {
                                    System.out.println("Incorrect Product Number");
                                }
                                break;
                            case 2:
                                System.out.println("Delete Location");
                                System.out.println("-------------\n");


                                Scanner scPnumber = new Scanner(System.in);
                                int p_number;
                                do {
                                    System.out.println("Enter Product Number: ");
                                    while (!scPnumber.hasNextInt()) {
                                        System.out.println("Enter the Positive number only");
                                        scPnumber.next();
                                    }
                                    p_number = scPnumber.nextInt();
                                }while (p_number<=0);


                                System.out.println("Enter the location which you want to delete :");
                                Scanner scDeleteSplit = new Scanner(System.in);
                                String location_number = scDeleteSplit.nextLine();

                                Location rm_location = new Location();
                                Product is_deleted = rm_location.deleteLocation(WHDB,p_number,location_number);

                                if (is_deleted != null){
                                    System.out.println("---------------------------");
                                    System.out.println("Location Deleted Successfully");
                                    System.out.println("---------------------------");
                                    System.out.println(
                                            "Product_Number    : "+ is_deleted.getNumber()+"\n"+
                                                    "Price             : " +is_deleted.getPrice()+"\n"+
                                                    "Name              : "+is_deleted.getName()+"\n"+
                                                    "Quantity          : "+is_deleted.getQuantity()+"\n"+
                                                    "Category          : "+is_deleted.getCategory()+"\n"+
                                                    "Location          : "+is_deleted.getLocation().getProduct_location_code()+"\n"
                                    );
                                }else {
                                    System.out.println("Something went wrong");
                                }
                                break;
                            case 3:
                                System.out.println("Change Location");
                                System.out.println("-------------\n");

                                Scanner scCnumber = new Scanner(System.in);
                                int c_number;
                                do {
                                    System.out.println("Enter Product Number: ");
                                    while (!scCnumber.hasNextInt()) {
                                        System.out.println("Enter the Positive number only");
                                        scCnumber.next();
                                    }
                                    c_number = scCnumber.nextInt();
                                }while (c_number<=0);

                                System.out.println("Enter New Location :");
                                Scanner scNewLoc = new Scanner(System.in);
                                String new_loc = scNewLoc.nextLine();

                                Location ch_location = new Location();
                                Product is_changed = ch_location.changeLocation(WHDB,c_number,new_loc);

                                if (is_changed != null){
                                    System.out.println("------------------------------");
                                    System.out.println("Location Changed Successfully");
                                    System.out.println("------------------------------");
                                    System.out.println(
                                            "Product_Number    : "+ is_changed.getNumber()+"\n"+
                                                    "Price             : " +is_changed.getPrice()+"\n"+
                                                    "Name              : "+is_changed.getName()+"\n"+
                                                    "Quantity          : "+is_changed.getQuantity()+"\n"+
                                                    "Category          : "+is_changed.getCategory()+"\n"+
                                                    "Location          : "+is_changed.getLocation().getProduct_location_code()+"\n"
                                    );
                                }else {
                                    System.out.println("Something went wrong");
                                }
                        }

                        break;
                    case 3:
                        System.out.println("Product List ");
                        System.out.println("-------------\n\n");

                        Product p = new Product();
                        ArrayList<Product> arrOfProducts = p.allProducts(WHDB);
                        System.out.println("\t"+ "Product Number" + "\t:\t" + "Location");
                        System.out.println("\t"+ "______________"+"\t \t" + "__________");
                        for (int i=0; i<arrOfProducts.size(); i++){
                            System.out.println("\t      "+ arrOfProducts.get(i).getNumber()+"\t:\t" +arrOfProducts.get(i).getLocation().getProduct_location_code()  );
                        }
                        System.out.println("\n");
                        break;
                    case 4:
//                Retail Store:
                        System.out.println("4) List of items required in Retail Store");
                        break;
                    case 5:
//                Arriving Items
                        System.out.println("5) List of items arriving in this week");
                        break;
                    case 6:
//                Truck Schedule
                        System.out.println("6) Upcoming Schedule for Trucks");
                        break;
                    case 7:
//                Employee Details
                        System.out.println("Employee Details");
                        System.out.println("----------------");
                        Employee emp = new Employee();
                        EmployeeDB empDB = new EmployeeDB();
                        Employee profile = emp.getEmployeeProfile(empDB);
                        System.out.println("Name : " + profile.getName()+"\n"+
                                "Email ID : " + profile.getEmail_ID()+"\n"+
                                "PIN : " + profile.getPIN()+"\n"+
                                "Salary : " + profile.getSalary()+"\n"+
                                "Job Type : " + profile.getJobType()+"\n"
                                );
                        break;
                    default:
                        System.out.println("Please Select any appropriate Options");
                }
            }
        }

        }

        public static boolean verifyEmployee(){
            Scanner sc = new Scanner(System.in);
            System.out.println("_______________________________________________________________________________________________________________________");
            System.out.println("                                      *** Use This PIN to Login : 3569 ***                                             ");
            System.out.println("_______________________________________________________________________________________________________________________"+"\n");
            System.out.println("Enter Employee PIN : ");
            int PIN = sc.nextInt();
            sc.nextLine();

//        Checking PIN
            Employee emp = new Employee("jon", "jn55", 3569, 50000, "Full-Time");
            return emp.checkPIN(PIN);
        }

    }
//}