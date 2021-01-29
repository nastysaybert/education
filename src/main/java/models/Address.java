package models;

import javax.persistence.*;
import java.io.PrintWriter;


@Entity
@Table (name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    public int addressId;
    @Column (name = "Street")
    public String street;
    @Column (name = "House")
    public String house;
    @Column (name = "Flat")
    public int flat;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "VisitorID")
    public Visitor visitor;


    public Address(){
    }

    public Address (int addressId, String street, String house, int flat, Visitor visitor){
        this.addressId = addressId;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.visitor = visitor;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public String getStreet() {
        return this.street;
    }

    public String getHouse() {
        return this.house;
    }

    public int getFlat() {
        return this.flat;
    }

    public Visitor getVisitor() {
        return this.visitor;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public void print (PrintWriter pw) {
        pw.println("AddressID: " + this.getAddressId() + "<br>");
        pw.println("Street: " + this.getStreet() + "<br>");
        pw.println("House: " + this.getHouse() + "<br>");
        pw.println("Flat: " + this.getFlat() + "<br>");
        //pw.println("VisitorID: " + this.getVisitor().getVisitorId() + this.getVisitor(). + "<br>");
        pw.println("<br>");
    }

}
