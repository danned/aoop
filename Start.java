/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

/**
 *
 * @author Daniel
 */
public class Start 
{
    public static void main(String [] args)
    {
        ImagePresenter p = new ImagePresenter();
        //PresenterFrame frame = new PresenterFrame(p);
        //p.addSlide("Schleden tröja", "schledenn.png");
        
        FifteenPuzzle puzzle = new FifteenPuzzle();
        PresenterFrame frame2 = new PresenterFrame(puzzle);
    }
}
