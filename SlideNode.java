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
    
    public SlideNode()
    {
        picName = null;
        text = null;
    }
    public SlideNode(String image, String text)
    {
        this.text = text;
        this.picName = image;
    }
    public String getImg()
    {
        return picName;
    }
    public String getText()
    {
        return text;
    }
}
