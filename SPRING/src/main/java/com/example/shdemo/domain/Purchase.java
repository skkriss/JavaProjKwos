package com.example.shdemo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "purchase.all", query = "Select p from Purchase p"),
        @NamedQuery(name = "purchase.deleteAll", query = "Delete from Purchase")
})
public class Purchase {

    public Long id;
    public Date date;
    public Client client;
    public Phone phone;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

}
