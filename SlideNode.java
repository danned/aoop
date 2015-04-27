/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;



/**
 *
 * @author Daniel and Erik
 */
public class SlideNode {
    private String picName;
    private String text;
    
    
    /**
     * constructor. Takes name of image and text as strings. 
     * @param image Filename of image. Image should be located in java working 
     *              dir
     * @param text String of text
     */
    public SlideNode(String image, String text)
    {
        this.text = text;
        this.picName = image;
    }
    
    /**
     * Getter of image name
     * @return name of picture
     */
    public String getImg()
    {
        return picName;
    }
    
    /**
     * getter of text
     * @return text
     */
    public String getText()
    {
        return text;
    }
}
