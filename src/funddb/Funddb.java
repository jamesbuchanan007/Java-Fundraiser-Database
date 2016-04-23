/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funddb;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author James
 */
@Entity
@Table(name = "FUNDDB", catalog = "", schema = "TEST")
@NamedQueries({
    @NamedQuery(name = "Funddb.findAll", query = "SELECT f FROM Funddb f"),
    @NamedQuery(name = "Funddb.findById", query = "SELECT f FROM Funddb f WHERE f.id = :id"),
    @NamedQuery(name = "Funddb.findByTitle", query = "SELECT f FROM Funddb f WHERE f.title = :title"),
    @NamedQuery(name = "Funddb.findByDonationAmount", query = "SELECT f FROM Funddb f WHERE f.donationAmount = :donationAmount"),
    @NamedQuery(name = "Funddb.findByCharity", query = "SELECT f FROM Funddb f WHERE f.charity = :charity"),
    @NamedQuery(name = "Funddb.findByFirstName", query = "SELECT f FROM Funddb f WHERE f.firstName = :firstName"),
    @NamedQuery(name = "Funddb.findByLastName", query = "SELECT f FROM Funddb f WHERE f.lastName = :lastName"),
    @NamedQuery(name = "Funddb.findByDate", query = "SELECT f FROM Funddb f WHERE f.date = :date")})
public class Funddb implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DONATION_AMOUNT")
    private BigDecimal donationAmount;
    @Column(name = "CHARITY")
    private String charity;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DATE")
    private String date;

    public Funddb() {
    }

    public Funddb(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public BigDecimal getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(BigDecimal donationAmount) {
        BigDecimal oldDonationAmount = this.donationAmount;
        this.donationAmount = donationAmount;
        changeSupport.firePropertyChange("donationAmount", oldDonationAmount, donationAmount);
    }

    public String getCharity() {
        return charity;
    }

    public void setCharity(String charity) {
        String oldCharity = this.charity;
        this.charity = charity;
        changeSupport.firePropertyChange("charity", oldCharity, charity);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funddb)) {
            return false;
        }
        Funddb other = (Funddb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "funddb.Funddb[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
