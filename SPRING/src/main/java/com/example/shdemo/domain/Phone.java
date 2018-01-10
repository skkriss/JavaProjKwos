package com.example.shdemo.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "phone.all", query = "Select f from Phone f"),
})
public class Phone {

    public Long id;
    public String mark;
    public double priceNetto;
    public int vat;
    public Type model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public double getPriceNetto() {
        return priceNetto;
    }
    public void setPriceNetto(double priceNetto) {
        this.priceNetto = priceNetto;
    }
    public int getVat() {
        return vat;
    }
    public void setVat(int vat) {
        this.vat = vat;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Type getType() {
        return model;
    }
    public void setType(Type model) {
        this.model = model;
    }

}