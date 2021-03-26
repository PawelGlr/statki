package okrety.advanced;

import okrety.basic.Ship;

public class Niszczyciel extends Ship {
    static private int maxClassNumber=0;
    public int rocketCount;
    public Niszczyciel(int positionY, int positionX){
        super(positionY, positionX);
        this.classNumber = maxClassNumber+1;
        maxClassNumber++;
        name = getType() + classNumber;
        toughness = 5;


    }
    @Override
    public String getType() {
        return "Niszczyciel";
    }
    @Override
    public String getSymbol() {
        return "M";
    }

    
}
