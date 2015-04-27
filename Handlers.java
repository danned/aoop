/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.event.ActionEvent;

/**
 *
 * @author Daniel
 */
public interface Handlers {
    public void northButtonPressed(ActionEvent e);
    public void eastButtonPressed(ActionEvent e);
    public void southButtonPressed(ActionEvent e);
    public void westButtonPressed(ActionEvent e);
}
