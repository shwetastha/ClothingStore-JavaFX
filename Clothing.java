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

    Clothing(Integer code,String name, int inventory, double price, String size, String color){
        super(code,name, inventory, price, Consts.CLOTHING);

        setSize(size);
        setColor(color);
    }

    Clothing(String[] array){
        super(Integer.valueOf(array[0]),array[1], Integer.valueOf(array[2]), 
        Double.valueOf(array[3]), array[4]);

        setSize(array[5]);
        setColor(array[6]);
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