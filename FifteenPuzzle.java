package presenter;

import java.awt.event.ActionEvent;
import javax.swing.JComponent;

/**
 *
 * @author Daniel
 */
public class FifteenPuzzle extends Presenter{
    //private ArrayList <Tile> tiles;
    PuzzleBoard board;
    /**
     * sets up game
     */
    public FifteenPuzzle()
    {
        title = "Fifteen Puzzle";
        board = new PuzzleBoard();
        northButton.setText("UP");
        eastButton.setText("RIGHT");
        southButton.setText("DOWN");
        westButton.setText("LEFT");
    }

    @Override
    public void northButtonPressed(ActionEvent e) 
    {
        if(board.moveNorth())
        {
            this.showText("Moved north");
        }
    }

    @Override
    public void eastButtonPressed(ActionEvent e) 
    {
        if(board.moveEast())
        {
            this.showText("Moved Right");
        }
    }

    @Override
    public void southButtonPressed(ActionEvent e) 
    {
        if(board.moveSouth())
        {
            this.showText("Moved South");
        }
    }

    @Override
    public void westButtonPressed(ActionEvent e) 
    {
        if(board.moveWest())
        {
            this.showText("Moved Left");
        }
    }

    @Override
    public JComponent createCenterComponent() 
    {
        
        return board;
    }
    
}
