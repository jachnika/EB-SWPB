/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.model;



/**
 *
 * @author jachnika
 */
public class Settings {
    private String sqlAddr;
    private int port;
    private String user;
    private String password;

    
    public Settings()
    {
        
    }
    /**
     * @return the sqlAddr
     */
    public String getSqlAddr() {
        return sqlAddr;
    }

    /**
     * @param sqlAddr the sqlAddr to set
     */
    public void setSqlAddr(String sqlAddr) {
        this.sqlAddr = sqlAddr;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
