/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Daniel and Erik
 */
public class SouthPanel extends JPanel{
    public final JButton northButton;
    public final JButton eastButton;
    public final JButton southButton;
    public final JButton westButton;
    public SouthPanel()
    {
        JPanel buttonPanel  = new JPanel();
        northButton         = new JButton("north");
        eastButton          = new JButton("east");
        southButton         = new JButton("south");
        westButton          = new JButton("west");
        JPanel northPanel   = new JPanel();
        JPanel eastPanel    = new JPanel();
        JPanel southPanel   = new JPanel();
        JPanel westPanel    = new JPanel();
        
        northPanel.add(northButton);
        eastPanel.add(eastButton);
        southPanel.add(southButton);
        westPanel.add(westButton);
       
        
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(northPanel,BorderLayout.NORTH);
        buttonPanel.add(eastPanel,BorderLayout.EAST);
        buttonPanel.add(southPanel,BorderLayout.SOUTH);
        buttonPanel.add(westPanel, BorderLayout.WEST);
        setLayout(new BorderLayout());
        add(buttonPanel);
    }
}
