

public class Accessories extends Product{

    Accessories(){
        super(Consts.ACCESSORIES);
    }
    
    Accessories(Integer code, String name, int inventory, double price, String category){
        super(code, name, inventory, price, Consts.ACCESSORIES, category);
    }
    
    Accessories(String[] array){
        super(Integer.valueOf(array[0]),array[1], Integer.valueOf(array[2]), 
        Double.valueOf(array[3]), array[4], array[5]);
    }

    public String toCSV () {
        String str;
        str = getProductCode() + "," + getProductName() + "," + getInventoryCount() 
         + "," + getPricePerUnit()
                + "," + getProductType()
                + "," + getCategory()
         + ","
         + ","
         + System.lineSeparator()
         ;
        return str;
    }
    
}