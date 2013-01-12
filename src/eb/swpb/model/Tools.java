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
    public Component frame;
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
                out.println(settings.getUser());
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

