package okrety.basic;

import java.util.Random;

import gameEngine.Directions;

public abstract class Ship {
    public static Ship [][] board;
    public String name;
    private static int maxNumber;
    public int number;
    public int classNumber;
    public int toughness;
    public int hitsTaken;
    public int positionY;
    public int positionX;
    private static Random random= new Random();
    public Ship(int positionY, int positionX) {
        this.positionY = positionY;
        this.positionX = positionX;
        this.hitsTaken = 0;
        this.number = maxNumber + 1;
        maxNumber++;
        
    }
    public abstract String getType();
    public abstract String getSymbol();
    public void takeHit(){
        hitsTaken++;
        if (hitsTaken < toughness){
        System.out.println("Okret " + getType() + " nr " + number + " zostal trafiony");
        move();
        }
        else{
            
            System.out.println("Okret " + getType() + " nr " + number + " zostal trafiony i ZATOPIONY");
            board[positionY][positionX]=null;
            }
        }
    public static void setBoard(Ship[][] board) {
        Ship.board = board;
    }
    public void move(){
        Directions [] posibilities = new Directions [4];
        int numberOfPosibilities=0;
        if(positionY>0 && board[positionY-1][positionX]==null){
            posibilities[numberOfPosibilities++]=Directions.up;
        }
        if(positionY<99 && board[positionY+1][positionX]==null){
            posibilities[numberOfPosibilities++]=Directions.down;
        }
        if(positionX>0 && board[positionY][positionX-1]==null){
            posibilities[numberOfPosibilities++]=Directions.left;
        }
        if(positionX<99 && board[positionY][positionX+1]==null){
            posibilities[numberOfPosibilities++]=Directions.right;
        }
        switch(posibilities[random.nextInt(numberOfPosibilities)]){
        case right:
            board[positionY][positionX+1]=this;
            board[positionY][positionX] = null;
            positionX++;
            break;
        case up:
            board[positionY-1][positionX]=this;
            board[positionY][positionX] = null;
            positionY--;
            break;
        case down:
            board[positionY+1][positionX]=this;
            board[positionY][positionX] = null;
            positionY++;
            break;
        case left:
            board[positionY][positionX-1]=this;
            board[positionY][positionX] = null;
            positionX--;
            break;
        default:
            break;
            
        }

        
    }


    
}
