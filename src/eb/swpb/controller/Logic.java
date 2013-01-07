/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.controller;
import eb.swpb.view.*;
import eb.swpb.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author jachnika
 */
public class Logic implements ActionListener {
    LoginForm loginForm;
    ModeForm modeForm;
    CollectionForm collectionForm;
    JFrame frame;
    Tools tools;
    
    public void start()
    {
        
        loginForm = new LoginForm();
        frame = loginForm.CreateForm(this);
        tools = new Tools();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginForm.enterButton)
        {
            boolean success;
            try {
                success = tools.checkLogin(loginForm.userTextField.getText(), loginForm.passTextField.getText());
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (success=true)
            {
                modeForm = new ModeForm();
                frame.setVisible(false);
                frame = modeForm.CreateForm(this);
            }
            else
            {
                
            }
            
        }
        if(e.getSource() == modeForm.collectionButton)
        {
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            frame = collectionForm.CreateForm(this);
        }
        if(e.getSource() == modeForm.usersButton)
        {
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            frame = collectionForm.CreateForm(this);
        }
    }
}
