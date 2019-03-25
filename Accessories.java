import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Accessories extends Product{
    private StringProperty type = new SimpleStringProperty();//sunglasses, earrings, anklets

    Accessories(){
        super(Consts.ACCESSORIES);
        setType("");
        
    }
    
    Accessories(Integer code, String name, int inventory, double price, String type){
        super(code, name, inventory, price, Consts.ACCESSORIES);
        
        setType(type);
    }
    
    Accessories(String[] array){
        super(Integer.valueOf(array[0]),array[1], Integer.valueOf(array[2]), 
        Double.valueOf(array[3]), array[4]);
        //5,6 for size and color
        setType(array[7]);
    }
    StringProperty typeProperty(){
        return type;
    }
    void setType(String type){
        this.type.set(type);
    }

    String getType(){
        return this.type.get();
    }

    public String toCSV () {
        String str;
        str = getProductCode() + "," + getProductName() + "," + getInventoryCount() 
         + "," + getPricePerUnit()
         + "," + getCategory()
         + "," 
         + "," 
         + "," + getType()
         + System.lineSeparator()
         ;
        return str;
    }
    
}