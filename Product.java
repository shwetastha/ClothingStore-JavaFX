public abstract class Product{
    private String productCode;
    private String productName;
    private int inventoryCount;
    private double pricePerUnit;

    //mutators
    void setProductCode(String code){
        this.productCode=code;
    }

    void setProductName(String desc){
        this.productName=desc;
    }

    void setInventoryCount(int quantity){
        this.inventoryCount=quantity;
    }

    void setPricePerUnit(double price){
        this.pricePerUnit=price;
    }

    //accessors
    String getProductCode(){
        return this.productCode;
    }

    String getProductName(){
        return this.productName;
    }

    int getInventoryCount(){
        return this.inventoryCount;
    }

    double getPricePerUnit(){
        return this.pricePerUnit;
    }

    //methods
    void addInventory(int quantity){
        this.inventoryCount+=quantity;
    }

    void removeInventory(int quantity){
        this.inventoryCount-=quantity;
    }

    
}