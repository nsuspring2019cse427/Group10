package com.ssaurel.tictactoe;
import java.util.Random;

public class GameEngine {

    private static final Random RANDOM = new Random();
    private char[] elts;
    private char currentPlayer;
    private boolean ended;

    public GameEngine() {
        elts = new char[9];
        newGame();
    }

    public boolean isEnded() {
        return ended;
    }

    public char play(int x, int y) // play method sets mark of the Current Player on the grid (x,y)
    {
        if (!ended && elts[3 * y + x] == ' ') //' ' represents an empty place at the grid where input can be placed
        {
            elts[3 * y + x] = currentPlayer;  //input from player placed
            changePlayer();   //player changes then
        }
        return checkEnd();          //method checks if game is over or not
    }


    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X'); //player will continue as X
    }

    public char elt(int x, int y) {
        return elts[3 * y + x];
    }

    public void newGame() {
        for (int i = 0; i < elts.length; i++) {
            elts[i] = ' ';
        }

        currentPlayer = 'X'; //User hardcoded to X while starting the game.
        ended = false;
    }

    public char checkEnd() {

        for (int i = 0; i < 3; i++) {
            if (elt(i, 0) != ' ' && elt(i, 0) == elt(i, 1) && elt(i, 1) == elt(i, 2)) {
                ended = true;
                return elt(i, 0);
            }


            if (elt(0, i) != ' ' && elt(0, i) == elt(1, i) && elt(1, i) == elt(2, i)) {
                ended = true;
                return elt(0, i);
            }
        }

            if (elt(0, 0) != ' ' && elt(0, 0) == elt(1, 1) && elt(1, 1) == elt(2, 2)) {
                ended = true;
                return elt(0, 0);
            }

            if (elt(2, 0) != ' ' && elt(2, 0) == elt(1, 1) && elt(1, 1) == elt(0, 2)) {
                ended = true;
                return elt(2, 0);
            }

            for (int i = 0; i < 9; i++) {

                if(elts[i]==' ')
                    return  ' ';

            }

        return 'T';

        }

        public char computer() {
        if (!ended){
            int position = -1;
            do {
                position = RANDOM.nextInt(9);
            }while (elts[position] != ' ');

            elts[position] = currentPlayer;
            changePlayer();
        }

        return  checkEnd();
    }
}