/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.model;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author jachnika
 */
public class Queries {
    

    public LinkedList executeSQLQuery(String query, Settings settings) throws Exception {
        try {
            Connection connect = null;
            Statement statement = null;
            ResultSet resultSet = null;
            int colSize;
            int rowSize;
            int rowIter;
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + settings.getSqlAddr(), settings.getUser(), settings.getPassword());
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
            colSize = resultSet.getMetaData().getColumnCount();
            rowSize = 0;
            while (resultSet.next()) {
                rowSize++;
            }
            LinkedList rows = new LinkedList();
            rowIter = 0;
            resultSet.beforeFirst();
            while (resultSet.next()) {
                LinkedList columns = new LinkedList();
                for (int i = 1; i <= colSize; i++) {
                    columns.add(resultSet.getString(i));
                }
                rows.add(columns);
            }
            connect.close();
            statement.close();
            resultSet.close();
            return rows;
        } catch (Exception e) {
            throw e;
        }
    }

    //JE�ELI FUNKCJA ZWRACA LICZB� WIERSZY R�WN� 1 WTEDY OZNACZA TO �E LOGIN ISTNIEJE W TABELI I MO�NA ZALOGOWA�
    public boolean checkLogin(String login, String password, Tools tools) throws Exception {
        boolean success = false;
        Settings settings;
        String query;
        int size;
        LinkedList rows;
        
        query = "SELECT * FROM USERS WHERE LOGIN = \"" + login + "\" AND PASSWORD = \"" + password + "\"";
        
        settings = tools.readSettingsFromFile();
        rows = executeSQLQuery(query, settings);
        size = rows.size();
        
        if (size != 1) 
        {
            return success;
        } 
        else 
        {
            success = true;
            return success;
        }
    }
    //a ta funkcja wyszukuje :)
    //na wejscie whatDoYouLookingFor - szukany ci�g
    //na wejscie whereDoYouLookingFor - w kt�rej kolumnie
    //na wejscie whichObjectDoYouLookingFor - w kt�rej tabeli
    //na wyj�ciu sukces or not
    //
    public LinkedList search(String whatDoYouLookingFor, String whereDoYouLookingFor, String whichObjectDoYouLookingFor, Tools tools) throws Exception 
    {
        Settings settings;
        String query;
        LinkedList rows;
        
        query = "SELECT * FROM "+whichObjectDoYouLookingFor+" WHERE " + whereDoYouLookingFor + " = \"" + whatDoYouLookingFor + "\"";
        settings = tools.readSettingsFromFile();
        rows = executeSQLQuery(query, settings);
       
        return rows;
    }
    
    public boolean addUser(User user, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "INSERT INTO USERSDATA VALUES ( \""
                + user.getUserName() + "\", \""
                + user.getUserSurname() + "\", \""
                + user.getBirthday() + "\", \""
                + user.getStreet() + "\", \""
                + user.getHouseNr() + "\", \""
                + user.getFlatNr() + "\", \""
                + user.getPostCode() + "\", \""
                + user.getCity() + "\", \""
                + user.getGroup() + "\";";
        rows = executeSQLQuery(query, settings);
        
        query = "INSERT INTO USERS VALUES ( \""
                + user.getEmail() + "\", \""
                + user.getPass() + "\";";
        
        rows = executeSQLQuery(query, settings);
        return success;
    }
    
    public boolean updateUser(User user, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "UPDATE USERSDATA SET ( NAME=\""
                + user.getUserName() + "\", SURNAME=\""
                + user.getUserSurname() + "\", BIRTHDAY=\""
                + user.getBirthday() + "\", STREET=\""
                + user.getStreet() + "\", HOUSENR=\""
                + user.getHouseNr() + "\", FLATNR=\""
                + user.getFlatNr() + "\", POSTCODE=\""
                + user.getPostCode() + "\", CITY=\""
                + user.getCity() + "\", GROUP=\""
                + user.getGroup() + "\";";
        rows = executeSQLQuery(query, settings);
        
        query = "UPDATE USERS SET ( LOGIN=\""
                + user.getEmail() + "\", PASSWORD=\""
                + user.getPass() + "\";";
        
        rows = executeSQLQuery(query, settings);
        return success;
    }
    
    public boolean deleteUser(User user, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "DELETE FROM USERSDATA WHERE USERID="
                + user.getIdUser() + ";";
        rows = executeSQLQuery(query, settings);
        
        query = "UPDATE USERS SET ( LOGIN=\""
                + user.getEmail() + "\", PASSWORD=\""
                + user.getPass() + "\";";
        
        rows = executeSQLQuery(query, settings);
        return success;
    }
    
    
}
