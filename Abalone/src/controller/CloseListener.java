/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author veronika
 */
public class CloseListener extends AbstractAction{

    public CloseListener(){
        super();
    }

    public void actionPerformed(ActionEvent e) {
                System.exit(0);
    }

}
