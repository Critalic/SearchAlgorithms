package IDS;

public class IDSearch {
    final int N = 8;

    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    /* A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placeed in columns from 0 to col -1. So we need
       to check only left side for attacking queens */
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;

        /* Check this row on right side */
        for (i = col+1; i < board.length; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on right side */
        for (i = row-1, j = col+1; i >=0 && j < board.length; i--, j++)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on right side */
        for (i = row+1, j = col+1; j < board.length && i < board.length; i++, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /* A recursive utility function to solve N
       Queen problem */
     boolean iterativeDepthSearch (int[][] board, int maximumDepth, int step) {
        for(int i=9; i<=maximumDepth; i+=step) {
            if(depthLimitedSearch(board, i, 0, 0).equals(State.TRUE)) return true;
//            if(depthLimitedSearch(board, i, 0, 0).equals(State.CUTOFF)) continue;
        }
        return false;
    }

    State depthLimitedSearch (int[][] board, int limit, int column, int iteration) {
//        printSolution(board);
//        System.out.println();
        // if the board's end has been reached then all queens are placed properly
        if(column >= board.length) return State.TRUE;
        // if the limit has been exceeded return cutoff
        if(iteration>=limit) return State.CUTOFF;
        // find the queen in the current column and recur forward if safe OR replace queen with 0 and go on
        for(int i=0; i<board.length; i++) {
            if(board[i][column]==1) {
                if(isSafe(board, i, column)) {
                    State s = depthLimitedSearch(board, limit, column+1, iteration+1);
                    if(s.equals(State.TRUE)) return State.TRUE;
                    if(s.equals(State.CUTOFF)) return State.CUTOFF;
                }
                board[i][column] =0;
                break;
            }
        }
        // find safe place for the queen (from top to bottom) and recur to the next column
        for(int i=0; i<board.length; i++) {
            if(isSafe(board, i, column)) {
                board[i][column] = 1;
                State state = depthLimitedSearch(board, limit ,column+1, iteration+1);
                if(state.equals(State.TRUE)) return State.TRUE;
                if(state.equals(State.CUTOFF)) return State.CUTOFF;
            }
        }
        // find safe place for the queen (from bottom to top) and recur to the next column
        for(int i=board.length-1; i>=0; i--) {
            if(isSafe(board, i, column)) {
                board[i][column] = 1;
                State state = depthLimitedSearch(board, limit ,column+1, iteration+1);
                if(state.equals(State.TRUE)) return State.TRUE;
                if(state.equals(State.CUTOFF)) return State.CUTOFF;
            }
        }
        // recur back if there's no safe place for the queen
        if(column !=0) depthLimitedSearch(board, limit, column-1, iteration+1);
        return State.FALSE;
    }

    /* This function solves the N Queen problem using
       Backtracking.  It mainly uses solveNQUtil () to
       solve the problem. It returns false if queens
       cannot be placed, otherwise, return true and
       prints placement of queens in the form of 1s.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.*/
    public boolean solveNQ(int[][] board)
    {
        if (!iterativeDepthSearch(board, 16, 2)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
}