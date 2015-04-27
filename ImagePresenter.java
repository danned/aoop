/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;


import java.awt.event.ActionEvent;
import java.util.LinkedList;

/**
 *
 * @author Daniel and Erik
 */
public class ImagePresenter extends Presenter
{
    LinkedList<SlideNode> list;
    public int curSlide;
    
    /**
     * Constructor. Modifies text on buttons and intializes datastructure
     * needed for imagepresenter
     */
    public ImagePresenter()
    {
        this.setEastText("Next");
        this.setWestText("Previous");
        curSlide = 0;
        list = new LinkedList();
        
        list.add(new SlideNode("start.png", "This is the slideshow program!"));
        showNode(list.get(0));

    }
    
    /**
     * Handles click on north button
     * @param e actionevent of buttonclick
     */
    @Override
    public void northButtonPressed(ActionEvent e)
    {
        
    }
    
    /**
     * Handles click on east button
     * @param e actionevent of buttonclick
     */
    @Override
    public void eastButtonPressed(ActionEvent e)
    {
        showNext();
    }
    
    /**
     * Handles click on south button
     * @param e actionevent of buttonclick
     */
    @Override
    public void southButtonPressed(ActionEvent e)
    {
        showText("pressed south");
    }
    
    /**
     * Handles click on west button
     * @param e actionevent of buttonclick
     */
    @Override
    public void westButtonPressed(ActionEvent e)
    {
        showPrev();
    }
    
    /**
     * Shows next slide. Increments current slide counter and calls showNode
     */
    private void showNext()
    {
        curSlide++;
        if(curSlide >= list.size() )
        {
            curSlide = 0;
        }
        showNode(list.get(curSlide));
    }
    
    /**
     * Shows next slide. Decrements current slide counter and calls showNode
     */
    private void showPrev()
    {
        curSlide--;
        if(curSlide < 0){
            curSlide = list.size()-1;
        }
        showNode(list.get(curSlide));
    }
    
    /**
     * Sets image and text to values of SlideNode s
     * @param s node to be shown
     */
    private void showNode(SlideNode s)
    {
        showImage(s.getImg());
        showText(s.getText());
    }
    
    /**
     * Adds slide to program
     * @param text String to be shown in info box
     * @param filename Name of image to be shown in main picture box
     */
    public void addSlide(String text, String filename)
    {
        list.add(new SlideNode(filename, text));
    }
}
