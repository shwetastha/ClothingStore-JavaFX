import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product{
    private static int count;
    private ObjectProperty<Integer> productCode = new SimpleObjectProperty<Integer>(null);
    private StringProperty productName=new SimpleStringProperty();
    private ObjectProperty<Integer> inventoryCount= new SimpleObjectProperty<>(1);
    private ObjectProperty<Double> pricePerUnit=new SimpleObjectProperty<Double>(0.0);
    protected StringProperty category=new SimpleStringProperty();

    Product(){
        
    }

    Product(String category){
        
        setCategory(category);
       
    }

    Product(String name, int inventory, double price, String category){
        productCode.set(count+1);
        setCategory(category);
        setProductName(name);
        setInventoryCount(inventory);
        setPricePerUnit(price);
        count++;
    }

    public ObjectProperty<Integer> productCodeProperty(){
        return productCode;
    }

    public StringProperty productNameProperty(){
        return productName;
    }

    public ObjectProperty<Integer> inventoryCountProperty(){
        return inventoryCount;
    }

    public ObjectProperty<Double> pricePerUnitProperty(){
        return pricePerUnit;
    }

    public StringProperty categoryProperty(){
        return category;
    }
    //mutators
    void setProductCode(Integer code){
        productCode.set(code);;
    }

    void setProductName(String desc){
        this.productName.set(desc);;
    }

    void setInventoryCount(Integer quantity){
        this.inventoryCount.set(quantity);
    }

    void setPricePerUnit(Double price){
        this.pricePerUnit.set(price);
    }

    void setCategory(String category){
        this.category.set(category);
    }

    //accessors
    Integer getProductCode(){
        return productCode.get();
    }

    String getProductName(){
        return this.productName.get();
    }

    Integer getInventoryCount(){
        return this.inventoryCount.get();
    }

    Double getPricePerUnit(){
        return this.pricePerUnit.get();
    }

    String getCategory(){
        return this.category.get();
    }


    //methods
    void addInventory(int quantity){
        int count = getInventoryCount() + quantity;
        this.inventoryCount.set(count);
    }

    void removeInventory(int quantity){
        int count = getInventoryCount() - quantity;
        this.inventoryCount.set(count);
    }

    
}