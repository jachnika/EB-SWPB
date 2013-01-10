/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author jachnika
 */
public class ModeForm extends javax.swing.JFrame{
    private JFrame frame;
    private JPanel jPanel1;
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel instrLabel;
    
    public JButton collectionButton;
    public JButton usersButton;
    public JButton settingsButton;
    private JButton exitButton;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    
    public JFrame CreateForm(ActionListener listener)
    {
        frame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        instrLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        collectionButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        titleLabel.setText("ELEKTRONICZNA BIBLIOTEKA");
    
        subtitleLabel.setText("System wspomagaj±cy pracê biblioteki");
        
        instrLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        instrLabel.setText("Wybierz tryb");

        collectionButton.setText("Zarz±dzaj zbiorem");
        collectionButton.addActionListener(listener);

        usersButton.setText("Zarz±dzaj u¿ytkownikami");
        usersButton.addActionListener(listener);
        
        exitButton.setText("Wyjd¼");
        exitButton.addActionListener(listener);
        
        settingsButton.setText("Ustawienia");
        settingsButton.addActionListener(listener);
                
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(titleLabel)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(jSeparator1)))
                    .add(layout.createSequentialGroup()
                        .add(60, 60, 60)
                        .add(subtitleLabel)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jSeparator2)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(instrLabel)
                .add(124, 124, 124))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(exitButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(usersButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(collectionButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(settingsButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(titleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(subtitleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(instrLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(collectionButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(usersButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(settingsButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(exitButton)
                .add(14, 14, 14))
        );
        frame.getContentPane().add(jPanel1);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }
    
}
