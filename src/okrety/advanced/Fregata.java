package okrety.advanced;

import okrety.basic.Ship;

public class Fregata extends Ship{
    static private int maxClassNumber=0;
    public int cannonCount;
    public Fregata(int positionY, int positionX){
        super(positionY, positionX);
        this.classNumber = maxClassNumber+1;
        maxClassNumber++;
        name = getType() + classNumber;
        toughness = 3;

    }
    @Override
    public String getType() {
        return "Fregata";
    }
    @Override
    public String getSymbol() {
        return "F";
    }
}
