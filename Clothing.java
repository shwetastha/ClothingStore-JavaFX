import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clothing extends Product{
    private String size;
    private String color;

    Clothing(){
        super(Consts.CLOTHING);

        setSize("");
        setColor("");
    }

    Clothing(Integer code,String name, int inventory, double price, String size, String color,String category){
        super(code,name, inventory, price, Consts.CLOTHING,category);

        setSize(size);
        setColor(color);
    }

    Clothing(String[] array){
        super(Integer.valueOf(array[0]),array[1], Integer.valueOf(array[2]),
                Double.valueOf(array[3]), array[4],array[5]);

        setSize(array[6]);
        setColor(array[7]);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toCSV () {
        String str;
        str = getProductCode() + "," + getProductName() + "," + getInventoryCount()
                + "," + getPricePerUnit()
                + "," + getProductType()
                + "," + getCategory()
         + "," + getSize()
         + "," + getColor()
         + System.lineSeparator()
         ;
        return str;
    }
    
}