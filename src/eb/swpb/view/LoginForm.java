/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 
 * @author jachnika
 */
public class LoginForm {
    	private JFrame frame;
	
	private JLabel titleLabel;
        private JLabel subtitleLabel;
        private JLabel userLabel;
        private JLabel passLabel;
        public JTextField userTextField;
        public JTextField passTextField;
	public JButton exitButton;
	public JButton enterButton;
	private JPanel jPanel1;
       
        
	public JFrame CreateForm(ActionListener listener){
		frame = new JFrame("LoginForm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                jPanel1 = new JPanel();
                GroupLayout layout = new GroupLayout(jPanel1);
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);
                jPanel1.setLayout(layout);
		titleLabel = new JLabel("Elektroniczna Biblioteka");
                subtitleLabel = new JLabel("System wspomagaj±cy pracê biblioteki");
                userLabel = new JLabel("Nazwa u¿ytkownika:");
                passLabel = new JLabel("Has³o");
                
                enterButton = new JButton("Zatwierd¼");
                exitButton = new JButton("Wyjd¼");
                userTextField = new JTextField("Nazwa u¿ytkownika");
                passTextField = new JTextField("Has³o");
		enterButton.addActionListener(listener);
                exitButton.addActionListener(listener);
                layout.setVerticalGroup(
                        layout.createSequentialGroup().addComponent(titleLabel)
                            .addGroup(layout.createSequentialGroup().addComponent(subtitleLabel)
                                .addGroup(layout.createParallelGroup().addComponent(userLabel).addComponent(userTextField))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(passLabel).addComponent(passTextField))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(exitButton).addComponent(enterButton))));
                layout.setHorizontalGroup(
                        layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(userLabel).addComponent(passLabel).addComponent(exitButton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(titleLabel).addComponent(subtitleLabel).addComponent(userTextField).addComponent(passTextField).addComponent(enterButton)));
                
                
		
		
		
		frame.getContentPane().add(jPanel1);
		frame.pack();
		frame.setVisible(true);
                
                return frame;
	}
    
}
