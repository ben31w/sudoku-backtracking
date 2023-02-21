/*draws DropDownPuzzles in a simple JFrame, with nothing fancy.
 */


import java.awt.*;
import javax.swing.*;


public class SudokuDrawer extends JComponent
{

    private Graphics g;   // this variable used for the graphics drawing

    private int cellwidth = 50;
    private int cellheight = cellwidth;
    private int left = 10;
    private int top = 50;
    private Color cellColor = Color.WHITE;
    private Color originalFontColor = Color.black;
    private Color solvedFontColor = Color.blue;
    private Font theFont = new Font("Times",Font.BOLD,cellwidth * 8/10);



    private char [][] thePuzzle;
    private char [][] answer;



    //**********
// constructor to specify width and height - automatically make the window visible
// and allow it to be closed.
    public SudokuDrawer(char[][] puzzle)
    {
        this.setOpaque(true);
        JFrame frame = new JFrame(this.getClass().getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(this);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(cellwidth*9 + left + 50,cellheight * 9 + top + 50 );
        frame.setVisible(true);

        // make a copy for later purposes
        thePuzzle = new char[9][9];
        for (int r =0; r<9 ; r++)
            for (int c =0; c<9; c++)
                thePuzzle[r][c] = puzzle[r][c];
        // make a copy for later purposes
        answer = new char[9][9];
        for (int r =0; r<9 ; r++)
            for (int c =0; c<9; c++)
                answer[r][c] = puzzle[r][c];

    }


    //***************
// this is called automatically by the system at various times to do the graphics.
    public void paint(Graphics g)
    {   this.g = g;
        for (int r = 0; r < thePuzzle.length; r++)
            for (int c = 0; c < thePuzzle[r].length; c++)
            {
                if (thePuzzle[r][c] != answer[r][c])
                    drawCell(r,c,answer[r][c],solvedFontColor);
                else
                    drawCell(r,c,thePuzzle[r][c],originalFontColor);
            }

        // draw the outline
        g.setColor(Color.black);
        g.drawRect(left-1,top-1,9*cellwidth+2, 9*cellheight+2);

        // draw verticals
        g.drawLine(left + cellwidth*3+1, top,left + cellwidth*3+1, top + 9*cellheight );
        g.drawLine(left + cellwidth*3+2, top,left + cellwidth*3+2, top + 9*cellheight );
        g.drawLine(left + cellwidth*6+1, top,left + cellwidth*6+1, top + 9*cellheight );
        g.drawLine(left + cellwidth*6+2, top,left + cellwidth*6+2, top + 9*cellheight );

        // draw horizontals
        g.drawLine(left, top + cellheight *3 + 1, left + cellheight * 9,  top + cellheight *3 + 1 );
        g.drawLine(left, top + cellheight *3 + 2, left + cellheight * 9,  top + cellheight *3 + 2 );
        g.drawLine(left, top + cellheight *6 + 1, left + cellheight * 9,  top + cellheight *6 + 1 );
        g.drawLine(left, top + cellheight *6 + 2, left + cellheight * 9,  top + cellheight *6 + 2 );
    }


    private void drawCell(int row, int col, char content, Color fontcolor)
    {
        g.setColor(cellColor);
        g.fillRect(left + col * cellwidth,top+ row * cellheight, cellwidth,cellheight);

        g.setFont(theFont);
        g.setColor(fontcolor);
        g.drawString(new String(""+content),left + col * cellwidth + cellwidth/5,top+ row * cellheight + cellheight * 5/6);


        g.setColor(Color.BLACK);
        g.drawRect(left + col * cellwidth,top+ row * cellheight, cellwidth,cellheight);
    }


    public void giveAnswer(char[][] answer)
    {
        for (int r =0; r<9 ; r++)
            for (int c =0; c<9; c++)
                this.answer[r][c] = answer[r][c];

        g = getGraphics();
        g.setColor(solvedFontColor);

        for (int r = 0; r < thePuzzle.length; r++)
            for (int c = 0; c < thePuzzle[r].length; c++)
            {
                if (thePuzzle[r][c] != answer[r][c])
                    drawCell(r,c,answer[r][c],solvedFontColor);
            }


    }




}  // end of  class