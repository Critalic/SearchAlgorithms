import IDS.IDSearch;

public class Main {

    static int board[][] ={ { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 0 ,1, 0 },
                            { 0, 0, 0, 0, 0, 0 ,0, 1 },
                            { 0, 0, 0, 0, 0, 0 ,0, 0 },
                            { 0, 1, 0, 0, 0, 0 ,0, 0 },
                            { 0, 0, 0, 1, 1, 0 ,0, 0 },
                            { 0, 0, 0, 0, 0, 1 ,0, 0 },
                            { 1, 0, 1, 0, 0, 0 ,0, 0 },};

    // driver program to test above function
    public static void main(String args[])
    {
        IDSearch Queen = new IDSearch();
        Queen.solveNQ(board, 190, 2);
    }
}
