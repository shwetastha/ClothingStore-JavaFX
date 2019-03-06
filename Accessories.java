public class Accessories extends Product{
    private String type;//sunglasses, earrings, anklets
    private String category;

    Accessories(){
        this.type="";
        this.category="Accesories";
    }
    
    Accessories(String type){
        this.type=type;
        this.category="Accesories";
    }
    
    void setType(String type){
        this.type=type;
    }

    String getType(){
        return this.type;
    }

    
}