package models;

import javax.persistence.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "Visitors")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "VisitorID")
    public int visitorId;
    @Column (name = "Surname")
    public String surname;
    @Column (name = "Name")
    public String name;
    @Column (name = "Lastname")
    public String lastname;
    @Column (name = "DateOfBirth")
    public LocalDate dateOfBirth;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "visitor")
    public List<Address> addresses;

    public Visitor(){
    }

    public Visitor (int visitorId, String surname, String name, String lastname, LocalDate dayOfBirth){
        this.visitorId = visitorId;
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.dateOfBirth = dayOfBirth;
    }

    public int getVisitorId () {
        return this.visitorId;
    }

    public String getSurname () {
        return this.surname;
    }

    public String getName () {
        return this.name;
    }

    public String getLastname () {
        return this.lastname;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(LocalDate dayOfBirth) {
        this.dateOfBirth = dayOfBirth;
    }

    public void setAddresses (List<Address> addresses) { this.addresses = new ArrayList<Address>(addresses); }

    public void print (PrintWriter pw) {
        pw.println("VisitorID: " + this.getVisitorId() + "<br>");
        pw.println("Surname: " + this.getSurname() + "<br>");
        pw.println("Name: " + this.getName() + "<br>");
        pw.println("Lastname: " + this.getLastname() + "<br>");
        pw.println("DateOfBirth: " + this.getDateOfBirth() + "<br>");
        if (this.getAddresses().size()>0){
            pw.println("<br>");
            pw.println("Адреса пользователя: " + "<br>");
            for (Address a : this.getAddresses()){
                pw.println("Street: " + a.getStreet() + "<br>");
                pw.println("House: " + a.getHouse() + "<br>");
                pw.println("Flat: " + a.getFlat() + "<br>");
                pw.println("<br>");
            }
            pw.println("<br>");
        } else pw.println("<br>");
        pw.println("<br>");
    }
}
