//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// Class          : bouncingBalls.View
//
// Author         : Richard E. Pattis
//                  Computer Science Department
//                  Carnegie Mellon University
//                  5000 Forbes Avenue
//                  Pittsburgh, PA 15213-3891
//                  e-mail: pattis@cs.cmu.edu
//
// Maintainer     : Author
//
//
// Description:
//
//   This View for the bouncingBalls package comprises two JPanels. The
// North one contains the controls (and a JText field); the Center one
// is for drawing; its paint method calls the model to "draw" all the
// balls in their positions. By the Controller repeatedly, and at a
// regular interval, "updating" the positions of the balls and calling
// repaint, we achieve animation.
//
//   Note that "no access modifier" means that the method is package
// friendly: this means the member is public to all other classes in
// the calculator package, but private elsewhere.
//
// Future Plans   : More Comments
//
// Program History:
//  10/20/01: R. Pattis - Operational for 15-100
//
//
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////



package bouncingBalls;


import javax.swing.BoxLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class View extends JFrame
{

  //Trivial constructor (could be automatically supplied by Java)
	public View()
	{}
	
  
  
  //Refer to the model (used in build to initialize it) 
	public void addModel(Model m)
	{model = m;}


	
  //Refer to the Controller (used in build to start animation)
	public void addController(Controller c)
	{controller = c;}


	
  //build does the heavy lifting; it builds the view, populating it
  //  with the appropriate JPanel
  //GUI applications have lots of little details to specify to make
  //  them look nice, and this method is in charge of them all
  public void build()
  {
	  //When a window close icon is pressed, exit the entire program
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//Create a font for all the buttons once (save it in an instance
		//  variable, so it can be  referred to in the buttonSetup method
		//  called subsequently)
		buttonFont = new Font("Monospaced", Font.BOLD, 11);

    //Title the JFrame
    setTitle("Bouncing Balls");
    
    //Add JPanels for the controls (to the North) and the BallPanel (to
    //  the Center) to the content pane of the JFrame
    JPanel controls = new JPanel();
    controls.setLayout(new BoxLayout(controls,BoxLayout.X_AXIS));
    
    //Setup buttons
    buttonSetup(controls,controller.getResetButton(),  "Reset");
    buttonSetup(controls,controller.getStartButton(),  "Start");
    buttonSetup(controls,controller.getStopButton (),  "Stop");
    
    //Setup JLabel for state of model (using text)
    ballCycleCount = new JLabel(" Balls = 0 / Cycles = 0     ");
    ballCycleCount.setFont(buttonFont);
    controls.add(ballCycleCount);
    
    //Setup ball panel: controller supplies Listener for mouse clicks
    // on the panel
    ballPanel = new BallPanel(model);
    ballPanel.addMouseListener(controller.getBallPanelMouseListener());
    
    Container contentPane = getContentPane();
    contentPane.add(controls, "North");
    contentPane.add(ballPanel,"Center");
    

    //Figure out the sizes for everything, initialize the model, and
    //  start animating it
    pack();
    controller.animate();
  }



  //Called only above, to set the attributes of the buttons (their label,
  //  font) and add them to the GUI Panel
  private void buttonSetup(JPanel  panelForButtons,
                           JButton b,
                           String  bLabel)
  {
		b.setText(bLabel);
		b.setFont(buttonFont);
		panelForButtons.add(b);
  }
  
  
  
  //First set the Balls/Cycles in the JLabel, then paint all the JPanels
  //  in this JFrame (that's what super.paint(g) does)
  public void paint(Graphics g)
  {
    ballCycleCount.setText(" Balls = " + model.getBallCount()+" / Cycles = " + model.getCycleCount());
    super.paint(g);
  }
  
 
  
  //The model needs this information to determine bouncing behavior
  //The ballPanel sizes changes if the user changes the JFrame size.
  Dimension getEnclosingBox()
  {return ballPanel.getSize();}



  //Instance Variables
  
  private Model      model;
  private Controller controller;
  
	private Font       buttonFont; 
  private BallPanel  ballPanel;
  private JLabel     ballCycleCount;
 }
