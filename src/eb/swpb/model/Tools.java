/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.model;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author jachnika
 */
public class Tools {

    public Component frame;

    /**
     *
     * @return settings gdy plik jest znaleziony i zwiera ustawienia
     * @return null gdy plik nie zosta³ znaleziony
     * @throws Exception
     */
    public Settings readSettingsFromFile() throws Exception {
        Settings settings = new Settings();
        File file = new File("settings.txt");
        if (file.exists()) {
            try {
                try (FileReader fr = new FileReader("settings.txt")) {
                    BufferedReader br = new BufferedReader(fr);
                    String s;
                    s = br.readLine();
                    settings.setSqlAddr(s);
                    s = br.readLine();
                    if (s != "") {
                        settings.setPort(Integer.parseInt(s));
                    } else {
                        settings.setPort(3306);
                    }
                    s = br.readLine();
                    settings.setUser(s);
                    s = br.readLine();
                    settings.setPassword(s);
                }

            } catch (IOException | NumberFormatException e) {
                throw e;
            }
            return settings;
        } else {
            JOptionPane.showMessageDialog(frame, "Plik z ustawieniami nie zosta³ znaleziony!");
            return null;
        }

    }

    public boolean saveSettingsToFile(Settings settings) throws Exception {
        boolean success = false;
        File file = new File("settings.txt");


        if (file.exists()) {
            FileWriter outFile;
            outFile = new FileWriter("settings.txt");
            try (PrintWriter out = new PrintWriter(outFile)) {
                out.println(settings.getSqlAddr());
                out.println(settings.getPort());
                out.println(settings.getUser());
                out.println(settings.getPassword());
                success = true;
            }
            return success;
        } else {
            JOptionPane.showMessageDialog(frame, "Plik z ustawieniami nie zosta³ znaleziony!");
            return success;
        }
    }

    public boolean isYear(String year) {
        boolean success = true;
        char ch;
        if (year.length() == 4) {
            for (int i = 0; i <= 3; i++) {
                ch = year.charAt(i);
                if (!Character.isDigit(ch)) {
                    success = false;
                }
            }
        } else {
            success = false;
        }
        return success;
    }

    public boolean isDay(String day) {
        boolean success = true;
        char ch;
        if (day.length() == 2) {
            for (int i = 0; i <= day.length() - 1; i++) {
                ch = day.charAt(i);
                if (Character.isDigit(ch)) {
                    if (Integer.parseInt(day) < 0 || Integer.parseInt(day) > 31) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        } else {
            success = false;
        }

        return success;
    }

    public boolean isMonth(String month) {
        boolean success = true;
        char ch;
        if (month.length() == 2)
        {
        for (int i = 0; i <= month.length() - 1; i++) {
            ch = month.charAt(i);
            if (Character.isDigit(ch)) {
                if (Integer.parseInt(month) < 0 || Integer.parseInt(month) > 31) {
                    success = false;
                }
            } else {
                success = false;
            }
        }
        } else {
            success=false;
        }
        return success;
    }

    public boolean isDigitCheck(String day) {
        boolean success = true;
        char ch;
        for (int i = 0; i <= day.length() - 1; i++) {
            ch = day.charAt(i);
            if (!Character.isDigit(ch)) {
                success = false;
            }
        }

        return success;
    }

    public boolean isPostCode(String firstPart, String secondPart) {
        boolean success = true;
        char ch;
        if (firstPart.length() == 2 || secondPart.length() == 3) {
            for (int i = 0; i <= 1; i++) {
                ch = firstPart.charAt(i);
                if (!Character.isDigit(ch)) {
                    success = false;
                }
            }
            for (int i = 0; i <= 2; i++) {
                ch = secondPart.charAt(i);
                if (!Character.isDigit(ch)) {
                    success = false;
                }
            }
        }
        return success;
    }
}
