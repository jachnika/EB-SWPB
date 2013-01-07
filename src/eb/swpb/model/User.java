/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eb.swpb.model;

import java.util.Date;

/**
 *
 * @author jachnika
 */
public class User {
    private int idUser;
    private String userName;
    private String userSurname;
    private Date birthday;
    private String street;
    private int houseNr;
    private int flatNr;
    private String postCode;
    private String city;
    private int group;

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userSurname
     */
    public String getUserSurname() {
        return userSurname;
    }

    /**
     * @param userSurname the userSurname to set
     */
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the houseNr
     */
    public int getHouseNr() {
        return houseNr;
    }

    /**
     * @param houseNr the houseNr to set
     */
    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    /**
     * @return the flatNr
     */
    public int getFlatNr() {
        return flatNr;
    }

    /**
     * @param flatNr the flatNr to set
     */
    public void setFlatNr(int flatNr) {
        this.flatNr = flatNr;
    }

    /**
     * @return the postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
