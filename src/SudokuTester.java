/**
 * A program to test SudokuSolvers.
 * There are Simple, Easy, Medium, and Hard puzzles, as well as impossible puzzles.
 * @author scottm
 *
 */
public class SudokuTester
{
    private static final int COMPLETE = 1;
    private static final int SIMPLE1 = 11;
    private static final int SIMPLE2 = 12;
    private static final int SIMPLE3 = 13;
    private static final int EASY1 = 21;
    private static final int EASY2 = 22;
    private static final int EASY3 = 23;
    private static final int MEDIUM1 = 31;
    private static final int MEDIUM2 = 32;
    private static final int MEDIUM3 = 33;
    private static final int HARD1 = 41;
    private static final int HARD2 = 42;
    private static final int HARD3 = 43;
    private static final int EMPTY = 100;

    private static final int IMPOSSIBLE1 = 201;
    private static final int IMPOSSIBLE2 = 202;
    private static final int IMPOSSIBLE3 = 203;
    private static final int IMPOSSIBLE4 = 204;
    private static final int IMPOSSIBLE5 = 205;
    private static final int IMPOSSIBLE6 = 206;
    private static final int IMPOSSIBLE7 = 207;
    private static final int IMPOSSIBLE8 = 208;
    private static final int IMPOSSIBLE9 = 209;
    private static final int IMPOSSIBLE10 = 210;
    private static final int IMPOSSIBLE11 = 211;




    //******************************************

    public static void main(String[] args)
    {
        char [][] puzzle;

        puzzle = getPuzzle(HARD3);  // replace the parameter with a constant from above

//        SudokuDrawer picture = new SudokuDrawer(puzzle);
        SudokuSolver solver = new SudokuSolver(puzzle);

        long tStart = System.currentTimeMillis();

        if (solver.solve())
        {
            char [][] answer = solver.getAnswer();
//            picture.giveAnswer(answer);
            for (int r = 0; r < 9; r++)
            {
                for (int c = 0; c < 9; c++)
                    System.out.print(answer[r][c]);
                System.out.println();
            }
        }
        else
            System.out.println("CAN NOT BE SOLVED.");

        long tEnd = System.currentTimeMillis();

        System.out.println("TIME:" + (tEnd-tStart));



    }
    //**********************
    // puzzle creators
    private static char[][] getPuzzle(int which)
    {
        if ((IMPOSSIBLE1 <= which) && (which <= IMPOSSIBLE11))
            return getImpossiblePuzzle(which);

        char[][] puzzle = new char[9][9];
        String []values = new String[9];
        switch (which)
        {
            case COMPLETE:
                values[0] = "149326785";
                values[1] = "376851924";
                values[2] = "285749613";
                values[3] = "528917436";
                values[4] = "694238157";
                values[5] = "731465298";
                values[6] = "957184362";
                values[7] = "813672549";
                values[8] = "462593871";
                break;


            case SIMPLE1:
                values[0] = "5243 9681";
                values[1] = "379681524";
                values[2] = "681524379";
                values[3] = "94723 816";
                values[4] = "235816947";
                values[5] = "8169472 5";
                values[6] = "492753168";
                values[7] = " 53168492";
                values[8] = "168492753";
                break;

            case SIMPLE2:
                values[0] = "149326785";
                values[1] = "3768519 4";
                values[2] = " 85749613";
                values[3] = "5 8917436";
                values[4] = "69423815 ";
                values[5] = "731465298";
                values[6] = "957184362";
                values[7] = "813672549";
                values[8] = "  2593871";
                break;

            case SIMPLE3:
                values[0] = "5243 9681";
                values[1] = "3796815 4";
                values[2] = "681524379";
                values[3] = " 4723 816";
                values[4] = " 35816947";
                values[5] = "8169472 5";
                values[6] = "492753168";
                values[7] = " 53168492";
                values[8] = "168492753";
                break;
            case EASY1:
                values[0] = "1493 6785";
                values[1] = "3 6851924";
                values[2] = "2857496 3";
                values[3] = "52 917436";
                values[4] = "694238 57";
                values[5] = "73 465298";
                values[6] = "957184 62";
                values[7] = "8 3672549";
                values[8] = "46259387 ";
                break;
            case EASY2:
                values[0] = "1 932 785";
                values[1] = "3768519 4";
                values[2] = "285749613";
                values[3] = "52 917436";
                values[4] = "694238157";
                values[5] = "7314652 8";
                values[6] = "95 184 62";
                values[7] = " 13672549";
                values[8] = "4625 3871";
                break;

            case EASY3:
                values[0] = "14932  85";
                values[1] = "3768519 4";
                values[2] = "28574 613";
                values[3] = "528 17436";
                values[4] = "69423 157";
                values[5] = " 3146 29 ";
                values[6] = "9571 4362";
                values[7] = "81 672549";
                values[8] = "462593 7 ";
                break;

		  	     /*
				   case COMPLETE:
			   values[0] = "149326785";
		       values[1] = "376851924";
		       values[2] = "285749613";
		       values[3] = "528917436";
		       values[4] = "694238157";
		       values[5] = "731465298";
		       values[6] = "957184362";
		       values[7] = "813672549";
		       values[8] = "462593871";
		  	     break;

		  	      */
		  	     /*
				   case COMPLETE:
			   values[0] = "524379681";
		       values[1] = "379681524";
		       values[2] = "681524379";
		       values[3] = "947235816";
		       values[4] = "235816947";
		       values[5] = "816947235";
		       values[6] = "492753168";
		       values[7] = "753168492";
		       values[8] = "168492753";
		  	     break;

		  	      */
            case MEDIUM1:
                values[0] = "    2  8 ";
                values[1] = "37  5192 ";
                values[2] = "  5 49   ";
                values[3] = "5 8  7 36";
                values[4] = "69     57";
                values[5] = "73 4  2 8";
                values[6] = "   18 3  ";
                values[7] = " 1367  49";
                values[8] = " 6  9    ";
                break;

            case MEDIUM2:
                values[0] = "52 3 9 8 ";
                values[1] = "3796   24";
                values[2] = "  15  37 ";
                values[3] = "947     6";
                values[4] = "2    6  7";
                values[5] = "81 947  5";
                values[6] = "4  753  8";
                values[7] = "     84  ";
                values[8] = "1 8 92  3";
                break;

            case MEDIUM3:
                values[0] = " 2 3 9 8 ";
                values[1] = "3 9 8 5 4";
                values[2] = "   52   9";
                values[3] = "  7  5  6";
                values[4] = "2   16  7";
                values[5] = " 1  4  3 ";
                values[6] = "   75   8";
                values[7] = "75  6  9 ";
                values[8] = "1 8 92   ";
                break;

            case HARD1:
                values[0] = "2 1      ";
                values[1] = "9    3   ";
                values[2] = " 4   1 6 ";
                values[3] = "  5 17 94";
                values[4] = "4   2   5";
                values[5] = "73 49 2  ";
                values[6] = " 5 1   8 ";
                values[7] = "   6    2";
                values[8] = "      7 6";
                break;

            case HARD2:
                values[0] = "  26 4 93";
                values[1] = " 6  2 4  ";
                values[2] = "5 4  7   ";
                values[3] = "2 3      ";
                values[4] = "  8   6  ";
                values[5] = "      1 8";
                values[6] = "   3  7 5";
                values[7] = "  7 4  2 ";
                values[8] = "82 9 63  ";
                break;

            case HARD3:
                values[0] = "5    96  ";
                values[1] = "  9  1  4";
                values[2] = " 8 5 4  9";
                values[3] = " 4 2 5 1 ";
                values[4] = "       47";
                values[5] = "8 6 4 235";
                values[6] = "4   53  8";
                values[7] = " 5  6    ";
                values[8] = "1  49    ";
                break;




            default:
                values[0] = "         ";
                values[1] = "         ";
                values[2] = "         ";
                values[3] = "         ";
                values[4] = "         ";
                values[5] = "         ";
                values[6] = "         ";
                values[7] = "         ";
                values[8] = "         ";
                break;
        }

        for (int row =0; row < 9; row ++)
            for (int col =0; col < 9; col ++)
                puzzle[row][col] = values[row].charAt(col);

        return puzzle;
    }

    //***************
    private static char[][] getImpossiblePuzzle(int which)
    {
        char[][] puzzle = new char[9][9];
        String []values = new String[9];
        values[0] = "149326785";
        values[1] = "376851924";
        values[2] = "285749613";
        values[3] = "528917436";
        values[4] = "694238157";
        values[5] = "731465298";
        values[6] = "957184362";
        values[7] = "813672549";
        values[8] = "462593871";

        for (int row =0; row < 9; row ++)
            for (int col =0; col < 9; col ++)
                puzzle[row][col] = values[row].charAt(col);

        switch (which)
        {
            case IMPOSSIBLE1:
                puzzle[3][5] = puzzle[3][8];   // same in row
                break;
            case IMPOSSIBLE2:
                puzzle[6][5] = puzzle[8][5];  // same in column
                break;
            case IMPOSSIBLE3:
                puzzle[0][0] = puzzle[1][1];  // upper left box
                break;
            case IMPOSSIBLE4:
                puzzle[1][4] = puzzle[2][5];  // upper center box
                break;
            case IMPOSSIBLE5:
                puzzle[0][0] = ' ';
                puzzle[1][0] = ' ';
                puzzle[2][0] = ' ';
                puzzle[2][8] = puzzle[0][7];  // upper right box
                break;
            case IMPOSSIBLE6:
                puzzle[3][0] = puzzle[5][2];  // middle left box
                break;
            case IMPOSSIBLE7:
                puzzle[4][5] = puzzle[5][4];// middle center box
                break;
            case IMPOSSIBLE8:
                puzzle[3][8] = puzzle[5][7];// middle right box
                break;
            case IMPOSSIBLE9:
                puzzle[0][0] = ' ';
                puzzle[1][0] = ' ';
                puzzle[2][0] = ' ';
                puzzle[7][6] = ' ';
                puzzle[4][8] = ' ';
                puzzle[8][0] = puzzle[6][1];   // bottom left box
                break;
            case IMPOSSIBLE10:
                puzzle[7][3] = puzzle[6][4];// bottom center box
                break;
            case IMPOSSIBLE11:
                puzzle[0][0] = ' ';
                puzzle[6][6] = puzzle[7][8]; // bottom right box
                break;
        }
        return puzzle;

    }






}