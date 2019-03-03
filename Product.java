public abstract class Product{
    private String productCode;
    private String productDescription;
    private int inventoryCount;
    private double pricePerUnit;

    //mutators
    void setProductCode(String code){
        this.productCode=code;
    }

    void setProductDescription(String desc){
        this.productDescription=desc;
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

    String getProductDescription(){
        return this.productDescription;
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