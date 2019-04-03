import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Accessories extends Product{
    private String type;//sunglasses, earrings, anklets

    Accessories(){
        super(Consts.ACCESSORIES);
        setType("");
        
    }
    
    Accessories(Integer code, String name, int inventory, double price, String type, String category){
        super(code, name, inventory, price, Consts.ACCESSORIES, category);
        
        setType(type);
    }
    
    Accessories(String[] array){
        super(Integer.valueOf(array[0]),array[1], Integer.valueOf(array[2]), 
        Double.valueOf(array[3]), array[4], array[5]);
        //5,6 for size and color
        setType(array[8]);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toCSV () {
        String str;
        str = getProductCode() + "," + getProductName() + "," + getInventoryCount() 
         + "," + getPricePerUnit()
                + "," + getProductType()
                + "," + getCategory()
         + ","
         + "," 
         + "," + getType()
         + System.lineSeparator()
         ;
        return str;
    }
    
}