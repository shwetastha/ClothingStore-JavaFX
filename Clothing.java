import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clothing extends Product{
    private StringProperty size = new SimpleStringProperty();
    private StringProperty color = new SimpleStringProperty();
    


    Clothing(){
        super(Consts.CLOTHING);

        setSize("");
        setColor("");
    }

    Clothing(String name, int inventory, double price, String size, String color){
        super(name, inventory, price, Consts.CLOTHING);

        setSize(size);
        setColor(color);
    }

    StringProperty sizeProperty(){
        return size;
    }

    StringProperty colorProperty(){
        return color;
    }
    //mutators
    void setSize(String size){
        this.size.set(size);
    }

    void setColor(String color){
        this.color.set(color);
    }

    
    //accessors
    String getSize(){
        return this.size.get();
    }

    String getColor(){
        return this.color.get();
    }

    public String toCSV () {
        String str;
        str = getProductCode() + "," + getProductName() + "," + getInventoryCount() 
         + "," + getPricePerUnit()
         + "," + getCategory()
         + "," + getSize()
         + "," + getColor()
         +"\n"
         ;
        return str;
    }
    
}