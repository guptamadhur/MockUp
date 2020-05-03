package web.app.madhurgupta.Learning.Interface;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

interface GameShape {
    void movePiece();
    void displayShape();
}
class PlayerPiece implements GameShape{
    public void movePiece(){
        System.out.println("Moving The Piece");
    }
    public void displayShape(){
        System.out.println("Displaying PlayerPiece");
    }
}

class TilePiece implements GameShape{
    public void movePiece(){
        System.out.println("Moving TilePiece");
    }
    public void displayShape(){
        System.out.println("Displaying TilePiece");
    }
}

public class TestGameShape{
    public static void main(String[] args) {
        PlayerPiece player = new PlayerPiece();
        TilePiece tilePiece= new TilePiece();
        doShape(player);
        doShape(tilePiece);
    }
    static void doShape(GameShape gameShape){
        gameShape.displayShape();
        gameShape.movePiece();
    }
}
