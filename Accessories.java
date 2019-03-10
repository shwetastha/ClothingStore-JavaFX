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
    
    StringProperty typeProperty(){
        return type;
    }
    void setType(String type){
        this.type.set(type);
    }

    String getType(){
        return this.type.get();
    }

    
}