package okrety.advanced;

import okrety.basic.Ship;

public class Korweta extends Ship {
    static private int maxClassNumber=0;
    public int cannonCount;
    public Korweta(int positionY, int positionX){
        super(positionY, positionX);
        this.classNumber = maxClassNumber+1;
        maxClassNumber++;
        name = getType() + classNumber;
        toughness = 1;
        


    }
    @Override
    public String getType() {
        return "Korweta";
    }
    @Override
    public String getSymbol() {
        return "K";
    }
    
}
