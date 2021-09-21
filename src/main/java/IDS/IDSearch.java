package IDS;

public class IDSearch {
    /* A utility function to print solution */
    void printSolution(int[][] board)
    {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++)
                System.out.print(" " + ints[j]
                        + " ");
            System.out.println();
        }
    }
    /* A utility function to check if a queen can
       be placed on board[row][col]. */
    boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        /* Check this row on right side */
        for (i = col + 1; i < board.length; i++)
            if (board[row][i] == 1)
                return false;
        /* Check this row on left side */
        for (i = col - 1; i >= 0; i--)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on right side */
        for (i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on right side */
        for (i = row + 1, j = col + 1; j < board.length && i < board.length; i++, j++)
            if (board[i][j] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row + 1, j = col - 1; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    int findSafe(int[][]board, int col) {
        for(int i =col+1; i< board.length; i++) {
            for(int b =0; b<board.length; b++) {
                if(isSafe(board, b, i) && board[b][i]!=1) return i;
            }
        }
        return 7;
    }

    boolean checkIfInFinalState (int[][] board) {
        for(int col =0; col<board.length; col++) {
            for(int row =0; row<board[col].length; row++) {
                if(board[row][col] ==1) {
                    if(isSafe(board, row, col)) continue;
                    return false;
                }
            }
        }
        return true;
    }

    /* A recursive utility function to solve N
       Queen problem */
     boolean iterativeDepthSearch (int[][] board, int maximumDepth, int step) {
        for(int i=9; i<=maximumDepth; i+=step) {
            if(depthLimitedSearch(board, i, 0, 0).equals(State.TRUE)) return true;
        }
        return false;
    }

    State depthLimitedSearch (int[][] board, int limit, int column, int iteration) {
        printSolution(board);
        System.out.println();
        if(checkIfInFinalState(board)) return State.TRUE;
        // if the board's end has been reached then all queens are placed properly
        if(column >= board.length) column=0;
        // if the limit has been exceeded return cutoff
        if(iteration>=limit) return State.CUTOFF;
        // find the queen in the current column and recur forward if safe OR replace queen with 0 and go on
        for(int i=0; i<board.length; i++) {
            if(board[i][column]==1) {
                if(isSafe(board, i, column)) {
                    return depthLimitedSearch(board, limit, column+1, iteration+1);
                }
                board[i][column] =0;
                break;
            }
        }
        // find safe place for the queen (from top to bottom) and recur to the next column
        for(int i=0; i<board.length; i++) {
            if(isSafe(board, i, column)) {
                board[i][column] = 1;
                return depthLimitedSearch(board, limit ,column+1, iteration+1);

            }
        }
        // find safe place for the queen (from bottom to top) and recur to the next column
        for(int i=board.length-1; i>=0; i--) {
            if(isSafe(board, i, column)) {
                board[i][column] = 1;
                return depthLimitedSearch(board, limit ,column+1, iteration+1);
            }
        }
        // recur back if there's no safe place for the queen
        board[(int)(Math.random()*(7 +1)+0)  ][column] = 1;
        State s;
        if(column !=0) s= depthLimitedSearch(board, limit, column-1, iteration+1);
        else s=depthLimitedSearch(board, limit, findSafe(board, column), iteration+1);
        if(s.equals(State.TRUE)) return State.TRUE;
        if(s.equals(State.CUTOFF)) return State.CUTOFF;
        return State.FALSE;
    }

    public boolean solveNQ(int[][] board, int maximumDepth, int step)
    {
        if (!iterativeDepthSearch(board, maximumDepth, step)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
}