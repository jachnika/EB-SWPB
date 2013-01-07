/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jachnika
 */
public class RentForm extends javax.swing.JFrame {
    
    private JFrame frame;
    private JPanel jPanel1;
    private javax.swing.JLabel RentAuthorLabel;
    private javax.swing.JTextField RentBookIdTextField;
    private javax.swing.JButton RentConfirmButton;
    private javax.swing.JButton RentExitButton;
    private javax.swing.JButton RentSearchBookButton;
    private javax.swing.JLabel RentTitleLabel;
    private javax.swing.JLabel RentUserBirthDateLabel;
    private javax.swing.JLabel RentUserCityLabel;
    private javax.swing.JTextField RentUserIdTextField;
    private javax.swing.JLabel RentUserNameLabel;
    private javax.swing.JLabel RentUserStreetLabel;
    private javax.swing.JLabel RentUserSurnameLabel;
    private javax.swing.JLabel RentYearLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    
    private JFrame createFrom (ActionListener listener) {

        frame = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RentUserIdTextField = new javax.swing.JTextField();
        RentBookIdTextField = new javax.swing.JTextField();
        RentSearchBookButton = new javax.swing.JButton();
        RentExitButton = new javax.swing.JButton();
        RentConfirmButton = new javax.swing.JButton();
        RentUserNameLabel = new javax.swing.JLabel();
        RentUserSurnameLabel = new javax.swing.JLabel();
        RentUserStreetLabel = new javax.swing.JLabel();
        RentUserCityLabel = new javax.swing.JLabel();
        RentUserBirthDateLabel = new javax.swing.JLabel();
        RentTitleLabel = new javax.swing.JLabel();
        RentAuthorLabel = new javax.swing.JLabel();
        RentYearLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Wypo¿ycz");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setText("ID Czytelnika");

        jLabel3.setText("ID Ksi±¿ki");

        RentSearchBookButton.setText("Wyszukaj");
        RentSearchBookButton.addActionListener(listener);

        RentExitButton.setText("Wyjd¼");

        RentConfirmButton.setText("Zatwierd¼");

        RentUserNameLabel.setText("Nazwisko: ");

        RentUserSurnameLabel.setText("Imiê:");

        RentUserStreetLabel.setText("Ulica, nr domu/mieszkania:");

        RentUserCityLabel.setText("Miejscowo¶æ:");

        RentUserBirthDateLabel.setText("Data Urodzenia:");

        RentTitleLabel.setText("Tytu³:");

        RentAuthorLabel.setText("Autor:");

        RentYearLabel.setText("Rok:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(RentExitButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(RentConfirmButton))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 9, Short.MAX_VALUE)
                                .add(RentUserIdTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 252, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(RentUserNameLabel)
                                    .add(RentUserSurnameLabel)
                                    .add(RentUserStreetLabel)
                                    .add(RentUserCityLabel)
                                    .add(RentUserBirthDateLabel))
                                .add(0, 0, Short.MAX_VALUE)))
                        .add(18, 18, 18)
                        .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel3)
                                    .add(RentTitleLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 259, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(RentAuthorLabel)
                                    .add(RentYearLabel))
                                .add(0, 0, Short.MAX_VALUE))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, RentBookIdTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 252, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(178, 178, 178)
                                .add(RentSearchBookButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(RentSearchBookButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(RentBookIdTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentTitleLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentAuthorLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentYearLabel))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(RentUserIdTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentUserNameLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentUserSurnameLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentUserStreetLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentUserCityLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RentUserBirthDateLabel)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(RentExitButton)
                    .add(RentConfirmButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        frame.getContentPane().add(jPanel1);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }// </editor-fold>                   
}
