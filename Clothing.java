public class Clothing extends Products{
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
    String getSize(String size){
        return this.size;
    }

    String getColor(String color){
        return this.color;
    }

    String getTypeOfApparel(String typeOfApparel){
        this.typeOfApparel=typeOfApparel;
    }
}