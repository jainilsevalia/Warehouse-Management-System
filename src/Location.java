import java.util.Scanner;

public class Location {
    String[] split_string;
    String[] new_string ;



    Product p = new Product();
    public String getProduct_location_code() {
        return product_location_code;
    }

    public void setProduct_location_code(String product_location_code) {
        this.product_location_code = product_location_code;
    }

    private  String product_location_code;

    public Location(){

    }
    public Location(String location) {
        this.product_location_code = location;
    }
    public Product addNewLocation(IProduct wh,int product_number,String location){

        Product product_is_available = p.searchProduct(wh,product_number);
        if (product_is_available != null ){
            product_is_available.setLocation(product_is_available.getLocation().getProduct_location_code()+","+location);
            return product_is_available;
        }else{
            return null;
        }
    }
    public Product deleteLocation(IProduct wh,int product_number,String location_number){
        Product product_is_available = p.searchProduct(wh,product_number);
        if (product_is_available != null ){
            split_string = product_is_available.getLocation().getProduct_location_code().split(",");
            if ((split_string.length>1)){
//                https://www.digitalocean.com/community/tutorials/java-remove-array-elements
                new_string = new String[split_string.length];
                for (int i=0, k=0; i<split_string.length;i++){
                    if (split_string[i].equals(location_number)){
                    }else{
                        new_string[k]=split_string[i];
                        k++;
                    }
                }
                String final_str = String.join(",",new_string);
                product_is_available.setLocation(final_str);
//
            }else{
            product_is_available.setLocation("");
            };
            return product_is_available;
        }else{
            return null;
        }
    }

    public Product changeLocation(IProduct wh,int product_number_to_change,String new_location){
        Product chnage_location = p.searchProduct(wh,product_number_to_change);
        if(chnage_location != null){
            chnage_location.setLocation(new_location);
            return chnage_location;
        }else{
            return null;
        }
    }
}
