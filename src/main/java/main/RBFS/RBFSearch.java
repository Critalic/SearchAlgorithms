package main.RBFS;

import main.Printer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RBFSearch {
    Printer printer = new Printer();
    PriorityQueue<Node> stack = new PriorityQueue<>();
    Node current;
    Node alternative;
    Node random;

    public void solveNQ(int[][] board) {
        current = new Node(board, numberOfIntersections(board));
        alternative = new Node(board, numberOfIntersections(board));
        if(getSolution(board)) printer.printSolution(current.getState());
        else System.out.println("Failed to find the solution");
    }

     boolean getSolution(int[][] board) {
        if(current.getNumberOfContacts()==0) return true;
        heuristicFunction(board);
        if(stack.isEmpty() || stack.peek().getNumberOfContacts()> current.getNumberOfContacts()) return false;
        if(stack.peek().getNumberOfContacts() >= alternative.getNumberOfContacts()) {
            current.setNumberOfConacts(stack.peek().getNumberOfContacts());
            return false;
        }
        current = stack.poll();
        alternative = stack.poll();
        pickRandom();
        stack.clear();
        if(getSolution(current.getState())) return true;
        for(int i=0; i<3; i++) {
            stack.clear();
            if(exchangeAndRerun()) return true;
        }
        return useRandom();
    }

    private void pickRandom() {
        for(int i=0; i<(int)(Math.random()*(stack.size()-1 +1)+1); i++) {
            stack.poll();
        }
        random = stack.poll();
    }

    private boolean useRandom() {
        current.setNumberOfConacts(18);
        alternative.setNumberOfConacts(18);
        return getSolution(random.getState());
    }

    private boolean exchangeAndRerun() {
        Node n = current;
        current = alternative;
        alternative = n;
        return getSolution(current.getState());
    }

    public void heuristicFunction (int[][] board) {
       int rowIndex;
       Node node = new Node(board ,numberOfIntersections(board));
       stack.add(node);
       for(int i=0; i< board.length;i++) {
           rowIndex= findQueen(board, i);
           board[rowIndex][i] = 0;
           for(int b=0; b< board.length; b++) {
               if(b==rowIndex) continue;
               board[b][i] = 1;
               stack.add(new Node(Arrays.stream(board).map(int[]::clone).toArray(int[][]::new), numberOfIntersections(board)));
               board[b][i] =0;
           }
           board[board.length-1][i] =0;
           board[rowIndex][i] = 1;
       }
    }

    private int numberOfIntersections (int[][]board) {
        int number=0;
        for(int i=0; i<board.length; i++) {
            for(int b=0; b<board.length; b++) {
                if(board[i][b] ==1) number+=findItersectionsOfAQueen(board, i, b);
            }
        }
        return number;
    }

    private int findItersectionsOfAQueen (int[][]board, int row, int col) {
        int number=0;
        int i, j;
        /* Check this row on right side */
        for (i = col + 1; i < board.length; i++)
            if (board[row][i] == 1) {
                number++;
                break;
            }

        /* Check this row on left side */
        for (i = col - 1; i >= 0; i--)
            if (board[row][i] == 1) {
                number++;
                break;
            }

        /* Check upper diagonal on right side */
        for (i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 1) {
                number++;
                break;
            }

        /* Check lower diagonal on right side */
        for (i = row + 1, j = col + 1; j < board.length && i < board.length; i++, j++)
            if (board[i][j] == 1) {
                number++;
                break;
            }

        /* Check upper diagonal on left side */
        for (i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) {
                number++;
                break;
            }

        /* Check lower diagonal on left side */
        for (i = row + 1, j = col - 1; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1) {
                number++;
                break;
            }

        return number;
    }

    private int findQueen(int[][] board, int col) {
        for(int i =0; i<board.length; i++) {
            if(board[i][col]==1) return i;
        }
        return 0;
    }
}