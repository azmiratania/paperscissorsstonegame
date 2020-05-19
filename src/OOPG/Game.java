package OOPG;

public class Game {

    /*Codes for choosing the hand options*/

    public int getpaper(){
        int paper = 0;
        return paper;
    }//getpaper

    public int getscissors(){
        int scissors = 1;
        return scissors;
    }//getscissors

    public int getstone(){
        int stone = 2;
        return stone;
    }//getstone

    public int getroundsplayed(){
        int roundsplayed = 0;
        return roundsplayed;
    }//getroundsplayed

    public int getplayerwon(){
        int playerwon = 0;
        return playerwon;
    }//getplayerwon

    public int getcomputerwon(){
        int computerwon = 0;
        return computerwon;
    }//getcomputerwon

    public int getdraw(){
        int draw = 0;
        return draw;
    }//getdraw


    public int getchooseHand(){
        int chooseHand = (int) (Math.random() * 3);
        return chooseHand;
    }

}//class