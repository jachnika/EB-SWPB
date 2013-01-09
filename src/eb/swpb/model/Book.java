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
public class Book{
    private String idBook;
    private String title;
    private String authorName;
    private String authorSurname;
    private String publishingHouse;
    private String publDate;
    private String attention;

    /**
     * @return the idBook
     */
    public String getIdBook() {
        return idBook;
    }

    /**
     * @param idBook the idBook to set
     */
    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the authorSurname
     */
    public String getAuthorSurname() {
        return authorSurname;
    }

    /**
     * @param authorSurname the authorSurname to set
     */
    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    /**
     * @return the publishingHouse
     */
    public String getPublishingHouse() {
        return publishingHouse;
    }

    /**
     * @param publishingHouse the publishingHouse to set
     */
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    /**
     * @return the publDate
     */
    public String getPublDate() {
        return publDate;
    }

    /**
     * @param publDate the publDate to set
     */
    public void setPublDate(String publDate) {
        this.publDate = publDate;
    }

    /**
     * @return the attention
     */
    public String getAttention() {
        return attention;
    }

    /**
     * @param attention the attention to set
     */
    public void setAttention(String attention) {
        this.attention = attention;
    }
    
    
}
