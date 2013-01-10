/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author jachnika
 */
public class Queries {
    

    public LinkedList<String> executeSQLQuery(String query, Settings settings,boolean isUpdate) throws Exception {
        try {
            Connection connect = null;
            Statement statement = null;
            ResultSet resultSet = null;
            int colSize;
            int rowSize;
            int rowIter;
            
            LinkedList rows = new LinkedList();
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + settings.getSqlAddr(), settings.getUser(), settings.getPassword());
            statement = connect.createStatement();
            if(isUpdate==false)
            {
                resultSet = statement.executeQuery(query);
                colSize = resultSet.getMetaData().getColumnCount();
                rowSize = 0;
                while (resultSet.next()) {
                    rowSize++;
                }
                
                rowIter = 0;
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    LinkedList<String> columns = new LinkedList<String>();
                    for (int i = 1; i <= colSize; i++) {
                        columns.add(resultSet.getString(i));
                    }
                    rows.add(columns);
                }
                connect.close();
                statement.close();
                resultSet.close();
            }
            else
            {
                rows = null;
                statement.executeUpdate(query);
                connect.close();
                statement.close();
            }
            
            
            return rows;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    //JE¯ELI FUNKCJA ZWRACA LICZBÊ WIERSZY RÓWN¡ 1 WTEDY OZNACZA TO ¯E LOGIN ISTNIEJE W TABELI I MO¯NA ZALOGOWAÆ
    public boolean checkLogin(String login, String password, Tools tools) throws Exception {
        boolean success = false;
        Settings settings;
        String query;
        int size;
        LinkedList rows;
        
        query = "SELECT * FROM USERS WHERE EMAIL = \"" + login + "\" AND PASSWORD = \"" + password + "\"";
        
        settings = tools.readSettingsFromFile();
        rows = executeSQLQuery(query, settings,false);
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
    //na wejscie whatDoYouLookingFor - szukany ci±g
    //na wejscie whereDoYouLookingFor - w której kolumnie
    //na wejscie whichObjectDoYouLookingFor - w której tabeli
    //na wyj¶ciu sukces or not
    //
    public LinkedList search(String whatDoYouLookingFor, String whereDoYouLookingFor, String whichObjectDoYouLookingFor, Tools tools) throws Exception 
    {
        Settings settings;
        String query;
        LinkedList rows;
        
        query = "SELECT * FROM "+whichObjectDoYouLookingFor+" WHERE " + whereDoYouLookingFor + " LIKE \"" + whatDoYouLookingFor + "\" ORDER BY ID ASC";
        settings = tools.readSettingsFromFile();
        rows = executeSQLQuery(query, settings,false);
       
        return rows;
    }
    
    public boolean addUser(User user, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        
        settings = tools.readSettingsFromFile();
        
        query = "INSERT INTO USERS (`NAME`, `SURNAME`, `BIRTH`, `STREET`, `HOUSE`, `FLAT`, `POSTCODE`, `CITY`, `GROUP`, `EMAIL`, `PASSWORD`) VALUES ( \""
                + user.getUserName() + "\", \""
                + user.getUserSurname() + "\", \""
                + user.getBirthday() + "\", \""
                + user.getStreet() + "\", \""
                + user.getHouseNr() + "\", \""
                + user.getFlatNr() + "\", \""
                + user.getPostCode() + "\", \""
                + user.getCity() + "\", \""
                + user.getGroup() + "\",\""
                + user.getEmail() + "\", \""
                + user.getPass() + "\");";
        executeSQLQuery(query, settings,true);
        
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
                + user.getGroup() + "\", LOGIN=\""
                + user.getEmail() + "\", PASSWORD=\""
                + user.getPass() + "\"";
        
        rows = executeSQLQuery(query, settings,true);
        return success;
    }
    
    public boolean deleteUser(String user, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "DELETE FROM USERS WHERE ID="
                + user + ";";
        rows = executeSQLQuery(query, settings,true);
        return success;
    }
    
    public boolean addBook(Book book, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "INSERT INTO BOOKS (TITLE, NAME, SURNAME, ISLENT, LENDER, LENDDATE, BACKDATE, PUBLISHINGHOUSE, YEAR, NOTES) VALUES ( \""
                + book.getTitle() + "\", \""
                + book.getAuthorName() + "\", \""
                + book.getAuthorSurname() + "\", 0, NULL, NULL, NULL, \""
                + book.getPublishingHouse() + "\", \""
                + book.getPublDate() + "\", \""
                + book.getAttention() + "\");";
        rows = executeSQLQuery(query, settings,true);
        
        return success;
    }
    
    public boolean updateBook(Book book, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows ;
        settings = tools.readSettingsFromFile();
        
        query = "UPDATE BOOKS SET  TITLE=\""
                + book.getTitle() + "\", NAME=\""
                + book.getAuthorName() + "\", SURNAME=\""
                + book.getAuthorSurname() + "\", PUBLISHINGHOUSE=\""
                + book.getPublishingHouse() + "\", YEAR=\""
                + book.getPublDate() + "\", NOTES=\""
                + book.getAttention() + "\""
                + " WHERE ID=" + book.getIdBook()+";";
        rows = executeSQLQuery(query, settings,true);
        
        return success;
    }
    
    public boolean rentBook(String book,String user, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "UPDATE BOOKS SET ISLENT=1, LENDER=" + user + ", LENDDATE=CURDATE(), BACKDATE=CURDATE()+7 WHERE ID=" + book;
        rows = executeSQLQuery(query, settings,true);
        
        return success;
    }
    
    public boolean receiveBook(String book, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        LinkedList rows;
        settings = tools.readSettingsFromFile();
        
        query = "UPDATE BOOKS SET ISLENT=0, LENDER=null, LENDDATE=null, BACKDATE=null WHERE ID=" + book;
        rows = executeSQLQuery(query, settings,true);
        
        return success;
    }
    
    public boolean deleteBook(String id, Tools tools) throws Exception
    {
        boolean success = false;
        Settings settings;
        String query;
        
        settings = tools.readSettingsFromFile();
        
        query = "DELETE FROM BOOKS WHERE ID="+id;
        executeSQLQuery(query, settings, true);
        
        return success;
    }
}
