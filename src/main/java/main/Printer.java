package main;

public class Printer {
    public void printSolution(int[][] board) {
        String output;
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                if(ints[j] ==1) output = "Q";
                else output = ".";
                System.out.print(" " + output
                        + " ");
            }
            System.out.println();
        }
    }
}
