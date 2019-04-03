import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product{
    private Integer productCode;
    private String productName;
    private String productType;
    private Integer inventoryCount;
    private Double pricePerUnit;
    protected String category;

    Product(){

    }

    Product(String productType){

        setProductType(productType);

    }

    Product(Integer code, String name, int inventory, double price, String productType, String category){
        setProductCode(code);
        setCategory(category);
        setProductName(name);
        setInventoryCount(inventory);
        setPricePerUnit(price);
        setProductType(productType);
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //methods
    void addInventory(int quantity){
        int count = getInventoryCount() + quantity;
        this.inventoryCount=(count);
    }

    void removeInventory(int quantity){
        int count = getInventoryCount() - quantity;
        this.inventoryCount=(count);
    }

    public String toCSV () {
        String str;
        str = getProductCode() + "," + getProductName() + "," + getInventoryCount() 
         + "," + getPricePerUnit()
         + "," + getCategory()
         + ",,," ;
        return str;
    }
    
}