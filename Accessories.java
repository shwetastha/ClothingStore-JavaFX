public class Accessories extends Product{
    private String type;//sunglasses, earrings, anklets
    private int countOfUnit; //a pair of earrings, 1 sunglasses, 1 anklet

    Accessories(){
        this.type="";
        this.countOfUnit=0;
    }
    
    Accessories(String type, int count){
        this.type=type;
        this.countOfUnit=count;
    }
    
    void setType(String type){
        this.type=type;
    }

    void setCountOfUnit(int countOfUnit){
        this.countOfUnit=countOfUnit;
    }

    
}