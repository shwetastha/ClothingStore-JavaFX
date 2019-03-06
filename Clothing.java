public class Clothing extends Product{
    private String size;
    private String color;
    private String category;

    Clothing(){
        this.category="Clothing";
        this.size="";
        this.color="";
    }

    Clothing(String size, String color){
        this.size=size;
        this.color=color;
        this.category="Clothing";
    }
    //mutators
    void setSize(String size){
        this.size=size;
    }

    void setColor(String color){
        this.color=color;
    }

    
    //accessors
    String getSize(){
        return this.size;
    }

    String getColor(){
        return this.color;
    }

    
}