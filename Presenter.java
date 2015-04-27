/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

//import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel and Erik
 */
public abstract class Presenter extends JFrame
{
    /*
    abstract declarations of action handlers. Has to be implemented
    */
    public abstract void northButtonPressed(ActionEvent e);
    public abstract void eastButtonPressed(ActionEvent e);
    public abstract void southButtonPressed(ActionEvent e);
    public abstract void westButtonPressed(ActionEvent e);
    
    
    /*
    buttons
    */
    private final JButton northButton;
    private final JButton eastButton;
    private final JButton southButton;
    private final JButton westButton;
    
    
    
    
    private final JPanel buttonPanel;
    private final JPanel mainPanel;
    private final JPanel bottomRegion;
    
    private final JTextArea info;
    
    JLabel picLabel;
    /*
        Default values of frame size. these values only set preferable sizes.
        Window may be resized by user later
    */
    private final int FRAME_WIDTH = 640;
    private final int FRAME_HEIGHT = 480;
    
    /**
     * Constructor. Initializes variables
     */
    public Presenter()
    {   
        /*
            initializing variables
        */
        buttonPanel         = new JPanel();
        mainPanel           = new JPanel();
        bottomRegion        = new JPanel();
        
        northButton         = new JButton("north");
        eastButton          = new JButton("east");
        southButton         = new JButton("south");
        westButton          = new JButton("west");
        
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
    }
    

    /**
     * Shows image filename. looks for file in working directory
     * @param filename filename of image
     */
    public void showImage(String filename)
    {
        try 
        {
            BufferedImage myPicture = ImageIO.read(new File("./"+filename));
            picLabel.setIcon(new ImageIcon(myPicture));
        } catch (IOException e) {
           
        }
    }
    
    /**
     * Shows text in info area
     * @param text text to be shown
     */
    public void showText(String text) 
    {
        info.setText(text);
    }
    
    /**
     * Sets value of north button
     * @param text text to be shown
     */
    public void setNorthText(String text)
    {
        northButton.setText(text);
    }
    
    /**
     * Sets value of east button
     * @param text text to be shown
     */
    public void setEastText(String text)
    {
        eastButton.setText(text);
    }
    
    /**
     * Sets value of south button
     * @param text text to be shown
     */
    public void setSouthText(String text)
    {
        southButton.setText(text);
    }
    
    /**
     * Sets value of west button
     * @param text text to be shown
     */
    public void setWestText(String text)
    {
        westButton.setText(text);
    }
}


