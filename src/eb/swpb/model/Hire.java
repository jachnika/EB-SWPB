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
public class Hire {
    private int idHire;
    private User objUser;
    private Book objBook;
    private Date rentDate;
    private Date expRetDate;
    private Date retDate;

    /**
     * @return the idHire
     */
    public int getIdHire() {
        return idHire;
    }

    /**
     * @param idHire the idHire to set
     */
    public void setIdHire(int idHire) {
        this.idHire = idHire;
    }

    /**
     * @return the objUser
     */
    public User getObjUser() {
        return objUser;
    }

    /**
     * @param objUser the objUser to set
     */
    public void setObjUser(User objUser) {
        this.objUser = objUser;
    }

    /**
     * @return the objBook
     */
    public Book getObjBook() {
        return objBook;
    }

    /**
     * @param objBook the objBook to set
     */
    public void setObjBook(Book objBook) {
        this.objBook = objBook;
    }

    /**
     * @return the rentDate
     */
    public Date getRentDate() {
        return rentDate;
    }

    /**
     * @param rentDate the rentDate to set
     */
    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    /**
     * @return the expRetDate
     */
    public Date getExpRetDate() {
        return expRetDate;
    }

    /**
     * @param expRetDate the expRetDate to set
     */
    public void setExpRetDate(Date expRetDate) {
        this.expRetDate = expRetDate;
    }

    /**
     * @return the retDate
     */
    public Date getRetDate() {
        return retDate;
    }

    /**
     * @param retDate the retDate to set
     */
    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }
    
}
