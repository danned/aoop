
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
<<<<<<< HEAD
        info                = new JTextArea();
=======
        
        JPanel northPanel   = new JPanel();
        JPanel eastPanel    = new JPanel();
        JPanel southPanel   = new JPanel();
        JPanel westPanel    = new JPanel();
        picLabel = new JLabel();
        
        
        this.setTitle("Presenter");
        this.setLayout(new BorderLayout());
        
        bottomRegion.setLayout(new BorderLayout());
        
        
        info = new JTextArea("Moving West to COORD");
        info.setBorder(BorderFactory.createEtchedBorder());
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
    
 
        mainPanel.setBorder(BorderFactory.createEtchedBorder());
                
        northPanel.add(northButton);
        eastPanel.add(eastButton);
        southPanel.add(southButton);
        westPanel.add(westButton);
        
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(northPanel,BorderLayout.NORTH);
        buttonPanel.add(eastPanel,BorderLayout.EAST);
        buttonPanel.add(southPanel,BorderLayout.SOUTH);
        buttonPanel.add(westPanel, BorderLayout.WEST);
        
        bottomRegion.add(buttonPanel,BorderLayout.WEST);
        bottomRegion.add(info,BorderLayout.CENTER);
        mainPanel.add(picLabel);
        this.add(mainPanel,BorderLayout.CENTER);
        this.add(bottomRegion,BorderLayout.SOUTH);

        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        /*
            using lambda expressions to call action handlers
        */
        northButton.addActionListener(e -> northButtonPressed(e));
        eastButton.addActionListener(e -> eastButtonPressed(e));
        southButton.addActionListener(e -> southButtonPressed(e));
        westButton.addActionListener(e -> westButtonPressed(e));
>>>>>>> c3523772c4594610ff9764a2cee84cfdbbb17037
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


