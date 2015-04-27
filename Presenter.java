
package presenter;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel and Erik
 */
public abstract class Presenter
{
    /*
    abstract declarations of action handlers. Has to be implemented
    */
    public abstract JComponent createCenterComponent();
    public abstract void northButtonPressed(ActionEvent e);
    public abstract void eastButtonPressed(ActionEvent e);
    public abstract void southButtonPressed(ActionEvent e);
    public abstract void westButtonPressed(ActionEvent e);
    /*
    buttons
    */
    public final JButton northButton;
    public final JButton eastButton;
    public final JButton southButton;
    public final JButton westButton;
    
    public String title;
    
    public final JTextArea info;
    /**
     * Constructor. Initializes variables
     */
    public Presenter()
    {   
        northButton         = new JButton("north");
        eastButton          = new JButton("east");
        southButton         = new JButton("south");
        westButton          = new JButton("west");
        info                = new JTextArea();
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
    }
    /**
     * Shows text in info area
     * @param text text to be shown
     */
    public void showText(String text) 
    {
        info.setText(text);
    }
}


