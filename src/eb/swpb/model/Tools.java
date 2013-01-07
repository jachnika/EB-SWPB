/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.model;

import java.awt.Component;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Tools{
    private Component frame;
    /**
     * @param query the query is execute, @return the rs 
     */
    
    public LinkedList executeSQLQuery(String query, Settings settings) throws Exception
    {
        try
        {
            Connection connect = null; //Object which contain data about SQL server
            Statement statement = null; //Object which contain data about conneciton status
            ResultSet resultSet = null;
            int colSize,rowSize,rowIter;
            
            
            //loading mysql driver
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection("jdbc:mysql://" + settings.getSqlAddr(),settings.getUser(),settings.getPassword());
            statement=connect.createStatement();
            resultSet=statement.executeQuery(query);
            colSize = resultSet.getMetaData().getColumnCount();
            rowSize = 0;
            while(resultSet.next())
            {
                rowSize++;
            }
            LinkedList rows = new LinkedList();
            rowIter = 0;
            resultSet.beforeFirst();
            while (resultSet.next())
            {
                LinkedList columns = new LinkedList();
                for (int i = 1; i <= colSize; i++)
                {
                    columns.add(resultSet.getString(i));           
                }
                rows.add(columns);
            }
            connect.close();
            statement.close();
            resultSet.close();
            return rows;
        }
        catch (Exception e)
        {
            throw e;
        }
    }
    
    //JE¯ELI FUNKCJA ZWRACA LICZBÊ WIERSZY RÓWN¡ 1 WTEDY OZNACZA TO ¯E LOGIN ISTNIEJE W TABELI I MO¯NA ZALOGOWAÆ
    public boolean checkLogin(String login,String password) throws Exception{
        
        boolean success = false;
        Settings settings;
        String query;
        int size;
        LinkedList rows;
        
        query = "SELECT * FROM USERS WHERE LOGIN = \"" + login +"\" AND PASSWORD = \"" + password + "\"";
        
        settings = readSettingsFromFile();
        
        rows = executeSQLQuery(query, settings);
        size=rows.size();
        
        if (size!=1)
        {
            JOptionPane.showMessageDialog(frame, "B£ÊDNY LOGIN LUB HAS£O!");
            return success;
        }
        else
        {
            success= true;
            return success; 
        }
        
    }
    /**
     * 
     * @return settings gdy plik jest znaleziony i zwiera ustawienia
     * @return null gdy plik nie zosta³ znaleziony
     * @throws Exception 
     */
    public Settings readSettingsFromFile() throws Exception
    {
        Settings settings = new Settings();
        File file = new File("settings.txt");
        if (file.exists())
        {
            try
            {
                try (FileReader fr = new FileReader("settings.txt")) {
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    s = br.readLine();
                    settings.setSqlAddr(s);
                    s = br.readLine();
                    if(s!="")
                    {
                        settings.setPort(Integer.parseInt(s));
                    }
                    else
                    {
                        settings.setPort(3306);
                    }
                    s = br.readLine();
                    settings.setUser(s);
                    s = br.readLine();
                    settings.setPassword(s);
                    }
                
            }
            catch (IOException | NumberFormatException e)
            {
                throw e;
            }
            return settings;
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Plik z ustawieniami nie zosta³ znaleziony!");
            return null;
        }
        
    }
    
    public boolean saveSettingsToFile(Settings settings) throws Exception
    {
        boolean success=false;
        File file = new File("settings.txt");
   
        
            if (file.exists())
            {
               FileWriter outFile;
               outFile = new FileWriter("settings.txt");
            try (PrintWriter out = new PrintWriter(outFile)) {
                out.println(settings.getSqlAddr());
                out.println(settings.getPort());
                out.print(settings.getUser());
                out.println(settings.getPassword());
                success=true;
            }
                return success;
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Plik z ustawieniami nie zosta³ znaleziony!");
                return success;
            }
      
        
        
    }
    
}

