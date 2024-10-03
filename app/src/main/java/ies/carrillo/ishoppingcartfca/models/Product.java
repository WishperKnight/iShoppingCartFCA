package ies.carrillo.ishoppingcartfca.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String note = "", name = "";
    private boolean buy = false;

    //empty constructor
    public Product() {
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
