package com.example.shdemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
        @NamedQuery(name = "client.all", query = "Select c from Client c"),
        @NamedQuery(name = "client.byPin", query = "Select c from Client c where c.pin = :pin"),
        @NamedQuery(name = "client.deleteAll", query = "Delete from Client")
})

public class Client {

    private Long id;
    private String firstName = "unknown";
    private String pin = "";
    private List<Purchase> purchases = new ArrayList<Purchase>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(unique = true, nullable = false)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //lista zakupów u klienta.
    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchase) {
        this.purchases = purchase;
    }
}
