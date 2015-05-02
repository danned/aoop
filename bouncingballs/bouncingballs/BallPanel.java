//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//
// Class          : bouncingBalls.BallPanel
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
//   This JPanel defines a paint method that calls the model to
// "draw" balls in their positions. By the Controller repeatedly
// "updating" the balls and calling repaint, it achieves animation.
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


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import javax.swing.JPanel;



class BallPanel extends JPanel
{

   //Save model to call its show method in paint
   public BallPanel(Model m)
   {
     //Save the model for use in paint (to call showAll)
     model = m;
     
     //Create a simple border
     setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
     
     //Set the prefered size (when the JFrame is packed); if the
     //  horizontal dimension is not bigger than the width of the
     //  button panel, it will be set to the width of the button panel
     //  (otherwise bigger, with the number below)
     setPreferredSize(new Dimension(500,500));
   }



   //Called by the Controller every 100ms; or, called by the operating
   //  system when a window's contents need to be redrawn (for example,
   //  on resizing, moving a window on/off of this window, etc.)
   //Overriding this method in the JPanel class is the sole reason
   //  for defining the BallPanel class 
   
   public void paint(Graphics g)
   {
    //Always call this class's super paint method first
    super.paint(g);
    
    setBackground(Color.white);
    model.displayAll(g);
   }

 
  
  
   //Instance Variables
   
   private Model model;
}


