/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel and Erik
 */
public class PresenterFrame extends JFrame{
    
    
    
    
    
    private final JPanel buttonPanel;
    public final JPanel mainPanel;
    private final JPanel bottomRegion;
    
    private final Presenter presenter;
    /*
        Default values of frame size. these values only set preferable sizes.
        Window may be resized by user later
    */
    public final int FRAME_WIDTH = 640;
    public final int FRAME_HEIGHT = 480;
    
    
    public PresenterFrame(final Presenter presenter)
    {
        /*
         *  initializing variables
         */
        buttonPanel         = new JPanel();
        mainPanel           = new JPanel();
        bottomRegion        = new JPanel();

        this.presenter      = presenter;
        
        setUpBottomRegion();  
        
        mainPanel.setBorder(BorderFactory.createEtchedBorder());
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(presenter.createCenterComponent(),BorderLayout.CENTER); 
         /*
        setting up layout for program
        */
        this.setTitle(presenter.title);
        this.setLayout(new BorderLayout());
        this.add(mainPanel,BorderLayout.CENTER);
        this.add(bottomRegion,BorderLayout.SOUTH);      
        this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);   
    }
    
    
    private void setUpBottomRegion()
    {
        JPanel northPanel   = new JPanel();
        JPanel eastPanel    = new JPanel();
        JPanel southPanel   = new JPanel();
        JPanel westPanel    = new JPanel();
        
        bottomRegion.setLayout(new BorderLayout());
        
        presenter.info.setBorder(BorderFactory.createEtchedBorder());
        
        northPanel.add(presenter.northButton);
        eastPanel.add(presenter.eastButton);
        southPanel.add(presenter.southButton);
        westPanel.add(presenter.westButton);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(northPanel,BorderLayout.NORTH);
        buttonPanel.add(eastPanel,BorderLayout.EAST);
        buttonPanel.add(southPanel,BorderLayout.SOUTH);
        buttonPanel.add(westPanel, BorderLayout.WEST);
        bottomRegion.add(buttonPanel,BorderLayout.WEST);
        bottomRegion.add(presenter.info,BorderLayout.CENTER);
        
        /*
            using lambda expressions to addActionHandlers to buttons
        */
        presenter.northButton.addActionListener( 
                e ->    presenter.northButtonPressed(e) );
        presenter.eastButton.addActionListener ( 
                e ->    presenter.eastButtonPressed(e)  );
        presenter.southButton.addActionListener( 
                e ->    presenter.southButtonPressed(e) );
        presenter.westButton.addActionListener ( 
                e ->    presenter.westButtonPressed(e)  );
    }
    
    
    
    /**
     * Sets value of north button
     * @param text text to be shown
     */
    public void setNorthText(String text)
    {
        presenter.northButton.setText(text);
    }
    
    /**
     * Sets value of east button
     * @param text text to be shown
     */
    public void setEastText(String text)
    {
        presenter.eastButton.setText(text);
    }
    
    /**
     * Sets value of south button
     * @param text text to be shown
     */
    public void setSouthText(String text)
    {
        presenter.southButton.setText(text);
    }
    
    /**
     * Sets value of west button
     * @param text text to be shown
     */
    public void setWestText(String text)
    {
        presenter.westButton.setText(text);
    }
}
