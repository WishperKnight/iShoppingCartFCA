package ies.carrillo.ishoppingcartfca.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String note = "", name = "";
    private boolean buy = false;
    private boolean Lactose = false;
    private boolean gluten = false;


    //empty constructor
    public Product() {
    }

    //Getters and setters

    public boolean isLactose() {
        return Lactose;
    }

    public void setLactose(boolean lactose) {
        Lactose = lactose;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", name='" + name + '\'' +
                ", buy=" + buy +
                ", Lactose=" + Lactose +
                ", gluten=" + gluten +
                '}';
    }
}
