package main;

import main.RBFS.RBFSearch;

import java.util.Random;

public class Main {

    static int[][] board ={ { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },};

    public static void main(String[] args) {
        for(int i=0; i<20; i++) {

        }

//        IDSearch Queen = new IDSearch();
//        Queen.solveNQ(board, 2000, 2);
        RBFSearch rbfSearch = new RBFSearch();
        rbfSearch.solveNQ(board);
    }

    private int[][] generateBoard ( int size) {
        int[][] result = new int[size][size];
        boolean isNotPut;
        Random r = new Random();
        int b;
        for(int i=0; i<size; i++) {
            isNotPut=true;
            b=0;
            while (isNotPut) {
                if(b>=8) b=0;
                result[i][b] = r.nextInt(2);
                if(result[i][b] ==1) isNotPut=false;
                b++;
            }
        }
        return result;
    }
}
