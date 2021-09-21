import IDS.IDSearch;
import RBFS.Node;
import RBFS.RBFSearch;

public class Main {

    static int[][] board ={ { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },};

    public static void main(String[] args)
    {
//        IDSearch Queen = new IDSearch();
//        Queen.solveNQ(board, 2000, 2);
        RBFSearch rbfSearch = new RBFSearch();
        rbfSearch.solveNQ(board);
    }
}
