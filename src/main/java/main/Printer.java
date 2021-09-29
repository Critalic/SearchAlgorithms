package main;

public class Printer {
    public void printSolution(int[][] board)
    {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++)
                System.out.print(" " + ints[j]
                        + " ");
            System.out.println();
        }
    }
}
