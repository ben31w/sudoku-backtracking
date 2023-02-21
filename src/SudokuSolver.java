import java.util.HashSet;
import java.util.Set;

public class SudokuSolver
{
    private char[][] puzzle;
    private char[][] answer;

    /**
     * @param puzzle
     */
    public SudokuSolver(char[][] puzzle)
    {
        this.puzzle = puzzle;
    }
    /**
     * solve the puzzle,
     * @return  true if can be solved.  False otherwise.
     */
    public boolean solve()
    {
        // find an empty spot
        int emptyrow = -1;
        int emptycol = -1;
        boolean found = false;
        for (int row =0; row<9 ; row++) {

            for (int col = 0; col < 9; col++) {
                if (puzzle[row][col] == ' ') {
                    found = true;
                    emptyrow = row;
                    emptycol = col;
                }
            }
        }
        // if no empty spot found, check if the puzzle is a solution
        if (!found) {
            if (okay())  // if the filled in puzzle has no "conflicts"
            {
                // record this answer
                answer = new char[9][9];
                for (int r =0; r<9 ; r++)
                    for (int c =0; c<9; c++)
                        answer[r][c] = puzzle[r][c];
                return true;
            }
            else
                return false;
        }
        else {
            Set<Character>  options = getOptionsForThisSpot(emptyrow,emptycol);
            for (Character ch  :  options) {
                puzzle[emptyrow][emptycol] = ch;  // record this option

                if (solve())
                    return true;

                puzzle[emptyrow][emptycol] = ' ';  // put it back to empty
            }
            return false;
        }
    }
    /**
     * return the set of options for this cell in the puzzle.
     * For now, returns all digits from 1 to 9.
     * @param row
     * @param col
     * @return  the set
     */
    private Set<Character> getOptionsForThisSpot(int row, int col)
    {
        // characters that have already been taken up in the row
        Set<Character> alreadyTaken = new HashSet<Character>();
        for (int c=0; c<9; c++) {
            if (puzzle[row][c] != ' ') {
                alreadyTaken.add(puzzle[row][c]);
            }
        }

        // characters that have not been taken
        Set<Character> choices = new HashSet<Character>();
        for (char ch = '1'; ch <= '9'; ch++) {
            if (!alreadyTaken.contains(ch))
                choices.add(ch);
        }
        return choices;

    }


    /**
     * @return true if there are no "Sudoku" conflicts.  false otherwise
     */
    private boolean okay()
    {
        // check each row
        for (int row = 0; row < 9; row ++)
            if (! checkRow(row))
                return false;

        // check each col
        for (int col = 0; col < 9; col ++)
            if (! checkCol(col))
                return false;
        // check each box
        for (int r = 0; r < 9; r+=3)
            for (int c = 0; c < 9; c+=3)
                if (! checkBox(r,c))
                    return false;


        // get here and everything is okay
        return true;
    }


    private boolean checkBox(int row, int col)
    {
        char[]check = new char[9];
        int i = 0;
        for (int rchange = 0; rchange < 3; rchange ++)
            for (int colchange = 0; colchange < 3; colchange ++)
            {
                check[i] = puzzle[row + rchange][col +colchange];
                i++;
            }
        for (int which = 0; which < 9 ; which ++)
            if (check[which] != ' ')
                for (int whichother = which + 1; whichother < 9; whichother ++)
                    if (check[which]  == check[whichother])
                        return false;

        return true;

    }


    private boolean checkCol(int col)
    {
        for (int row = 0; row <9; row++)
            if (puzzle[row][col] != ' ')
                for (int checkrow = row + 1; checkrow < 9; checkrow ++)
                    if (puzzle[row][col]  == puzzle[checkrow][col])
                        return false;
        return true;
    }
    private boolean checkRow(int row)
    {
        for (int col = 0; col <9; col++)
            if (puzzle[row][col] != ' ')
                for (int checkcol = col + 1; checkcol < 9; checkcol ++)
                    if (puzzle[row][col]  == puzzle[row][checkcol])
                        return false;
        return true;
    }
    /**
     *
     * @return  the answer found.  Will be null if no answer found.
     */
    public char[][] getAnswer()
    {
        return answer;
    }



}