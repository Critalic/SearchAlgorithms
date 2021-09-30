package main;

import main.IDS.IDSearch;
import main.RBFS.RBFSearch;

import java.util.Random;

public class Main {

    static int[][] board ={ { 1, 1, 0, 1, 1, 1, 1, 1 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 1, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0},};

    public static void main(String[] args) {
        Main m = new Main();
        for(int i=0; i<5; i++) {
            RBFSearch rbfSearch = new RBFSearch();
            rbfSearch.solveNQ(m.generateBoard(8));
            System.out.println();
        }

//        IDSearch Queen = new IDSearch();
//        Queen.solveNQ(board, 12000, 2);
//        RBFSearch rbfSearch = new RBFSearch();
//        rbfSearch.solveNQ(board);
    }

    private int[][] generateBoard ( int size) {
        int[][] result = new int[size][size];
        Random r = new Random();
        int random;
        for(int i=0; i<size; i++) {
            random = r.nextInt(size);
           for(int b=0; b<random; b++) {
               result[b][i] = 0;
           }
           result[random][i] =1;
           for(int b= random+1; b<size; b++) {
               result[b][i] = 0;
           }
        }
        return result;
    }
}
