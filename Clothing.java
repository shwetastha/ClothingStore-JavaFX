public class Clothing extends Product{
    private String size;
    private String color;
    private String typeOfApparel;
    private String category;

    Clothing(){
        this.category="Clothing";
        this.size="";
        this.color="";
        this.typeOfApparel="";
    }

    Clothing(String size, String color, String typeOfApparel){
        this.size=size;
        this.color=color;
        this.typeOfApparel=typeOfApparel;
        this.category="Clothing";
    }
    //mutators
    void setSize(String size){
        this.size=size;
    }

    void setColor(String color){
        this.color=color;
    }

    void setTypeOfApparel(String typeOfApparel){
        this.typeOfApparel=typeOfApparel;
    }

    //accessors
    String getSize(){
        return this.size;
    }

    String getColor(){
        return this.color;
    }

    String getTypeOfApparel(){
        return this.typeOfApparel;
    }
}