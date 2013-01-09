/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.controller;
import eb.swpb.model.*;
import eb.swpb.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author jachnika
 */
public class Logic implements ActionListener {
    LoginForm loginForm;
    ModeForm modeForm;
    CollectionForm collectionForm;
    SearchBookForm searchBookForm;
    EditBookForm editBookForm;
    RentForm rentForm;
    ReceiveForm receiveForm;
    JFrame frame;
    Tools tools;
    Queries queries;
    
    public void start()
    {
        
        loginForm   = new LoginForm();
        frame       = loginForm.CreateForm(this);
        tools       = new Tools();
        queries     = new Queries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Przyciski LOGINFORM
         */
        
        if(e.getSource() == loginForm.enterButton)
        {
            boolean success=false;
            try {
                    success = queries.checkLogin(loginForm.userTextField.getText(), loginForm.passTextField.getText(),tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
                if (success ==true)
                {
                    modeForm = new ModeForm();
                    frame.setVisible(false);
                    frame = modeForm.CreateForm(this);
                            
                }
                else
                {
                    JOptionPane.showMessageDialog(tools.frame, "B£ÊDNY LOGIN LUB HAS£O!");
                    frame.setVisible(true);
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
            
        }
        else
        /**
         * Przyciski MODEFORM
         */
        if(e.getSource() == modeForm.collectionButton)
        {
            LinkedList success = null;
            String [][] data = null; 
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            try {
                success = queries.search("%", "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            frame = collectionForm.CreateForm(this,success);
            
        } else
        if(e.getSource() == modeForm.usersButton)
        {
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            frame = collectionForm.CreateForm(this,null);
        }
        /**
         * Przyciski COLLECTIONFORM
         */
        else
        if(e.getSource() == collectionForm.collectionSearchBookButton)
        {
            searchBookForm = new SearchBookForm();
            frame.setVisible(false);
            frame = searchBookForm.createFrom(this);
        }
        else
        if(e.getSource() == collectionForm.CollectionAddBookButton)
        {
            editBookForm = new EditBookForm();
            frame.setVisible(false);
            frame = editBookForm.CreateForm(this,null);
        }
        else
        if(e.getSource() == collectionForm.CollectionModifyBookButton)
        {
            LinkedList success = null;
            try {
                success = queries.search(collectionForm.model.getValueAt(collectionForm.jTable1.getSelectedRow(),0).toString(),"ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            editBookForm = new EditBookForm();
            frame.setVisible(false);
            frame = editBookForm.CreateForm(this,success);
        }
        else
        if(e.getSource() == collectionForm.CollectionRentBookButton)
        {
            rentForm = new RentForm();
            frame.setVisible(false);
            frame = rentForm.createFrom(this);
        }
        else
        if(e.getSource() == collectionForm.CollectionReceiveBookButton)
        {
            receiveForm = new ReceiveForm();
            frame.setVisible(false);
            frame = receiveForm.createFrom(this);
            
        }
        else
        if(e.getSource() == searchBookForm.jButton1)
        {
            LinkedList success = null;
            
            try {
                success = queries.search(searchBookForm.jTextField1.getText(),searchBookForm.jComboBox1.getSelectedItem().toString(), "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            frame = collectionForm.CreateForm(this,success);
        }
        /**
         * Przyciski EDITBOOKFORM
         */
        else
        if(e.getSource() == editBookForm.BookConfirmChangeButton)
        {
            Book book = new Book();
            book.setIdBook(editBookForm.jTextField1.getText());
            book.setTitle(editBookForm.BookTitleTextField.getText());
            book.setAuthorName(editBookForm.BookAuthorTextField.getText());
            book.setAuthorSurname(editBookForm.BookAuthorTextField1.getText());
            book.setPublishingHouse(editBookForm.BookPublishingHouseTextField.getText());
            book.setPublDate(editBookForm.BookYearTextField.getText());
            book.setAttention(editBookForm.BookAdditionalInformTextArea.getText());
            boolean success;
            LinkedList success2=null;
            if(editBookForm.isNew==true)
            {
                try {
                    success = queries.addBook(book, tools);
                } catch (Exception ex) {
                    Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                try {
                    success=queries.updateBook(book, tools);
                } catch (Exception ex) {
                    Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                success2 = queries.search("%", "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            frame = collectionForm.CreateForm(this,success2);
            
        }
        /*
         * Przyciski RENTFORM
         */
        else
        if(e.getSource() == rentForm.RentSearchBookButton)
        {
            LinkedList resultUser = null;
            LinkedList resultBook = null;
            try {
                resultUser = queries.search(rentForm.RentUserIdTextField.getText(), "ID", "USERS", tools);
                resultBook = queries.search(rentForm.RentBookIdTextField.getText(), "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                LinkedList oneList = (LinkedList) resultUser.get(0);
                //String[] row = new String[oneList.size()];
                rentForm.RentUserNameLabel.setText((String) oneList.get(1));
                rentForm.RentUserSurnameLabel.setText((String) oneList.get(2)); 
                rentForm.RentUserStreetLabel.setText((String) oneList.get(4)+", "+(String) oneList.get(5)+"/"+(String) oneList.get(6)); 
                rentForm.RentUserCityLabel.setText((String) oneList.get(8)); 
                rentForm.RentUserBirthDateLabel.setText((String) oneList.get(3)); 
                oneList = (LinkedList) resultBook.get(0);
                rentForm.RentTitleLabel.setText((String) oneList.get(1));
                rentForm.RentAuthorLabel.setText((String) oneList.get(2) + " " +(String) oneList.get(3));
                rentForm.RentYearLabel.setText((String) oneList.get(9));
        }
        else
        if(e.getSource() == rentForm.RentConfirmButton)
        {
           
            try {
                queries.rentBook(rentForm.RentUserIdTextField.getText(), rentForm.RentBookIdTextField.getText(),tools);
                
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            LinkedList success = null;
      
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            try {
                success = queries.search("%", "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            frame = collectionForm.CreateForm(this,success);
            
                
        }
        /**
         * Przyciski RECEIVEFORM
         */
        else
        if(e.getSource() == receiveForm.ReceiveSearchButton)
        {
            LinkedList resultUser = null;
            LinkedList resultBook = null;
            try {
                resultBook = queries.search(receiveForm.ReceiveBookIdTexField.getText(), "ID", "BOOKS", tools);
                
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                LinkedList oneList = (LinkedList) resultBook.get(0);
                //String[] row = new String[oneList.size()];
                receiveForm.ReceiveTitleLabel.setText((String) oneList.get(1));
                receiveForm.ReceiveAuthorLabel.setText((String) oneList.get(2) + " " +(String) oneList.get(3));
                receiveForm.ReceiveYearLabel.setText((String) oneList.get(9));
            try {
                resultUser = queries.search((String) oneList.get(5), "ID", "USERS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
                oneList = (LinkedList) resultUser.get(0);
                receiveForm.ReceiveUserIdLabel.setText((String) oneList.get(0)); 
                receiveForm.ReceiveNameLabel.setText((String) oneList.get(1)); 
                receiveForm.ReceiveSurnameLabel.setText((String) oneList.get(2)); 
                
        }
        else
        if(e.getSource() == receiveForm.ReceiveConfirmButton)
        {
           
            try {
                queries.receiveBook(receiveForm.ReceiveBookIdTexField.getText(),tools);
                
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            LinkedList success = null;
      
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            try {
                success = queries.search("%", "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            frame = collectionForm.CreateForm(this,success);
        }
   
        
    }
}
