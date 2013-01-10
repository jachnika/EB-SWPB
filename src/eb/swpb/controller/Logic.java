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
import javax.swing.JTable;

/**
 *
 * @author jachnika
 */
public class Logic implements ActionListener {

    LoginForm loginForm;
    ModeForm modeForm;
    CollectionForm collectionForm;
    UsersForm usersForm;
    SearchBookForm searchBookForm;
    EditBookForm editBookForm;
    RentForm rentForm;
    ReceiveForm receiveForm;
    JFrame frame;
    Tools tools;
    Queries queries;
    EditUserForm editUserForm;
    SearchUserForm searchUserForm;
    SettingsForm settingsForm;

    public void start() {
        searchBookForm = new SearchBookForm();
        editBookForm = new EditBookForm();
        rentForm = new RentForm();
        receiveForm = new ReceiveForm();
        editUserForm = new EditUserForm();
        usersForm = new UsersForm();
        searchUserForm = new SearchUserForm();
        collectionForm = new CollectionForm();
        loginForm = new LoginForm();
        frame = loginForm.CreateForm(this);
        tools = new Tools();
        queries = new Queries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Przyciski LOGINFORM
         */
        if (e.getSource() == loginForm.enterButton) {
            boolean success = false;
            try {
                success = queries.checkLogin(loginForm.userTextField.getText(), loginForm.passTextField.getText(), tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (success == true) {
                    modeForm = new ModeForm();
                    frame.setVisible(false);
                    frame = modeForm.CreateForm(this);

                } else {
                    JOptionPane.showMessageDialog(tools.frame, "B£ÊDNY LOGIN LUB HAS£O!");
                    frame.setVisible(true);
                }
            } catch (Exception ex) {
                throw ex;
            }

        } else if (e.getSource() == loginForm.exitButton) {
            System.exit(0);

        } else /**
         * Przyciski MODEFORM
         */
        if (e.getSource() == modeForm.collectionButton) {
            LinkedList success = null;
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            try {
                success = queries.search("%", "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            frame = collectionForm.CreateForm(this, success);


        } else if (e.getSource() == modeForm.usersButton) {
            LinkedList success = null;
            usersForm = new UsersForm();
            frame.setVisible(false);
            try {
                success = queries.search("%", "ID", "USERS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            frame = usersForm.CreateForm(this, success);
        } else if (e.getSource() == modeForm.settingsButton) {
            settingsForm = new SettingsForm();
            frame.setVisible(false);
            Settings settings = new Settings();
            try {
                settings = tools.readSettingsFromFile();
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            frame = settingsForm.CreateForm(this, settings);
        }/**
         * Przyciski COLLECTIONFORM
         */
        else if (e.getSource() == collectionForm.collectionSearchBookButton) {
            searchBookForm = new SearchBookForm();
            frame.setVisible(false);
            frame = searchBookForm.createFrom(this);
        } else if (e.getSource() == collectionForm.CollectionAddBookButton) {
            editBookForm = new EditBookForm();
            frame.setVisible(false);
            frame = editBookForm.CreateForm(this, null);
        } else if (e.getSource() == collectionForm.CollectionModifyBookButton) {
            LinkedList success = null;
            try {
                success = queries.search(collectionForm.model.getValueAt(collectionForm.jTable1.getSelectedRow(), 0).toString(), "ID", "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            editBookForm = new EditBookForm();
            frame.setVisible(false);
            frame = editBookForm.CreateForm(this, success);
        } else if (e.getSource() == collectionForm.CollectionRentBookButton) {
            rentForm = new RentForm();
            frame.setVisible(false);
            frame = rentForm.createFrom(this);
        } else if (e.getSource() == collectionForm.CollectionReceiveBookButton) {
            receiveForm = new ReceiveForm();
            frame.setVisible(false);
            frame = receiveForm.createFrom(this);
        } /**
         * Przyciski SEARCHBOOKFORM
         */
        else if (e.getSource() == searchBookForm.jButton1) {
            LinkedList success = null;

            try {
                success = queries.search(searchBookForm.jTextField1.getText(), searchBookForm.jComboBox1.getSelectedItem().toString(), "BOOKS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            collectionForm = new CollectionForm();
            frame.setVisible(false);
            frame = collectionForm.CreateForm(this, success);
        } else if (e.getSource() == collectionForm.CollectionRemoveBookButton) {

            try {
                queries.deleteBook(collectionForm.model.getValueAt(collectionForm.jTable1.getSelectedRow(), 0).toString(), tools);

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
            frame = collectionForm.CreateForm(this, success);
        } /**
         * Przyciski EDITBOOKFORM
         */
        else if (e.getSource() == editBookForm.BookConfirmChangeButton) {
            Book book = new Book();
            book.setIdBook(editBookForm.jTextField1.getText());
            book.setTitle(editBookForm.BookTitleTextField.getText());
            book.setAuthorName(editBookForm.BookAuthorTextField.getText());
            book.setAuthorSurname(editBookForm.BookAuthorTextField1.getText());
            book.setPublishingHouse(editBookForm.BookPublishingHouseTextField.getText());
            book.setPublDate(editBookForm.BookYearTextField.getText());
            book.setAttention(editBookForm.BookAdditionalInformTextArea.getText());
            boolean success;
            LinkedList success2 = null;
            if (editBookForm.isNew == true) {
                try {
                    success = queries.addBook(book, tools);
                } catch (Exception ex) {
                    Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    success = queries.updateBook(book, tools);
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
            frame = collectionForm.CreateForm(this, success2);

        } /*
         * Przyciski RENTFORM
         */ else if (e.getSource() == rentForm.RentSearchBookButton) {
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
            rentForm.RentUserStreetLabel.setText((String) oneList.get(4) + ", " + (String) oneList.get(5) + "/" + (String) oneList.get(6));
            rentForm.RentUserCityLabel.setText((String) oneList.get(8));
            rentForm.RentUserBirthDateLabel.setText((String) oneList.get(3));
            oneList = (LinkedList) resultBook.get(0);
            rentForm.RentTitleLabel.setText((String) oneList.get(1));
            rentForm.RentAuthorLabel.setText((String) oneList.get(2) + " " + (String) oneList.get(3));
            rentForm.RentYearLabel.setText((String) oneList.get(9));
        } else if (e.getSource() == rentForm.RentConfirmButton) {

            try {
                queries.rentBook(rentForm.RentBookIdTextField.getText(), rentForm.RentUserIdTextField.getText(), tools);

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
            frame = collectionForm.CreateForm(this, success);


        } /**
         * Przyciski RECEIVEFORM
         */
        else if (e.getSource() == receiveForm.ReceiveSearchButton) {
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
            receiveForm.ReceiveAuthorLabel.setText((String) oneList.get(2) + " " + (String) oneList.get(3));
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

        } else if (e.getSource() == receiveForm.ReceiveConfirmButton) {

            try {
                queries.receiveBook(receiveForm.ReceiveBookIdTexField.getText(), tools);

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
            javax.swing.table.DefaultTableModel model;//to jest gówniana czê¶æ programu. Tworzymy model jTable, okre¶lamy kolumny, nastêpnie trzeba rozpakowaæ linkedlist data
            model = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            };

            JTable table = new JTable(model);
            model.addColumn("ID");
            model.addColumn("Tytul");
            model.addColumn("Nazwisko");
            model.addColumn("Imie");
            model.addColumn("Wypozyczone");
            model.addColumn("Wypozyczyl");
            model.addColumn("Data Wypo¿yczenia");
            model.addColumn("Data Zwrotu");
            model.addColumn("Wydawnictwo");
            model.addColumn("Rok");
            model.addColumn("Uwagi");
            //no i tu jest to rozpakowanie LinkedListy z LinkedListy..... gówniane
            for (int i = 0; i < success.size(); i++) {
                LinkedList oneList = (LinkedList) success.get(i);
                String[] row = new String[oneList.size()];
                for (int j = 0; j < oneList.size(); j++) {
                    row[j] = (String) oneList.get(j);
                }
                model.addRow(row);
            }

            collectionForm.jTable1.setModel(model);
        } /**
         * Przyciski USERSFORM
         *
         */
        else if (e.getSource() == usersForm.UsersAddButton) {
            editUserForm = new EditUserForm();
            frame.setVisible(false);
            frame = editUserForm.CreateForm(this, null);
        } else if (e.getSource() == usersForm.UsersModifyButton) {
            LinkedList success = null;
            try {
                int checked = usersForm.jTable1.getSelectedRow();
                success = queries.search(usersForm.model.getValueAt(checked, 0).toString(), "ID", "USERS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            editUserForm = new EditUserForm();
            frame.setVisible(false);
            frame = editUserForm.CreateForm(this, success);
        } else if (e.getSource() == usersForm.UsersSearchButton) {
            searchUserForm = new SearchUserForm();
            frame.setVisible(false);
            frame = searchUserForm.createFrom(this);
        } else if (e.getSource() == usersForm.UsersRemoveButton) {

            try {
                queries.deleteUser(usersForm.model.getValueAt(usersForm.jTable1.getSelectedRow(), 0).toString(), tools);

            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            LinkedList success = null;

            usersForm = new UsersForm();
            frame.setVisible(false);
            try {
                success = queries.search("%", "ID", "USERS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            frame = usersForm.CreateForm(this, success);
        }/**
         * Przyciski EDITUSERFORM
         */
        else if (e.getSource() == editUserForm.jButton1) {
            User user = new User();
            user.setIdUser(editUserForm.UserIdTextField.getText());
            user.setUserName(editUserForm.UserNameTextField.getText());
            user.setUserSurname(editUserForm.UserSurnameTextField.getText());
            user.setBirthday("2000-02-04");
            user.setStreet(editUserForm.UserStreetTextField.getText());
            user.setHouseNr(editUserForm.UserHouseTextField.getText());
            user.setFlatNr(editUserForm.UserFlatTextField.getText());
            user.setPostCode(editUserForm.UserFlatTextField.getText());
            user.setCity(editUserForm.UserCityTextField.getText());
            user.setGroup(Integer.toString(editUserForm.jComboBox1.getSelectedIndex()));
            user.setEmail("cokolwiek");
            user.setPass("12345678");
            boolean success;
            LinkedList success2 = null;
            if (editBookForm.isNew == true) {
                try {
                    success = queries.addUser(user, tools);
                } catch (Exception ex) {
                    Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    success = queries.updateUser(user, tools);
                } catch (Exception ex) {
                    Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                success2 = queries.search("%", "ID", "USERS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            usersForm = new UsersForm();
            frame.setVisible(false);
            frame = usersForm.CreateForm(this, success2);

        } /**
         * PRZYCISKI SEARCHUSERFORM
         */
        else if (e.getSource() == searchUserForm.jButton1) {
            LinkedList success = null;

            try {
                success = queries.search(searchUserForm.jTextField1.getText(), searchUserForm.jComboBox1.getSelectedItem().toString(), "USERS", tools);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            //success.toArray(data);
            usersForm = new UsersForm();
            frame.setVisible(false);
            frame = usersForm.CreateForm(this, success);
        } /**
         * Przyciski SETTINGSFORM
         */
        else if (e.getSource() == settingsForm.SettingsConfirmButton) {
            Settings settings = new Settings();
            settings.setSqlAddr(settingsForm.SettingsServerAddressTextField.getText());
            settings.setPort(Integer.parseInt(settingsForm.SettingsPortTextField.getText()));
            settings.setUser(settingsForm.SettingsUserTextField.getText());
            settings.setPassword(String.valueOf(settingsForm.SettingsPassPasswordField.getPassword()));
            try {
                tools.saveSettingsToFile(settings);
            } catch (Exception ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
            modeForm = new ModeForm();
            frame.setVisible(false);
            frame = modeForm.CreateForm(this);
        }

    }
}
