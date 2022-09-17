package ru.maksirep.shop_shift.model;

import javax.persistence.*;

@Entity
@Table(name = "technics")
public class Technics {

    public Technics() {}

    @Id
    @Column(name = "id")
    private Integer serialID;

    @Column(name = "developer")
    private String developer;

    @Column(name = "price")
    private Integer price;

    @Column(name = "counts")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getSerialID() {
        return serialID;
    }

    public void setSerialID(int serialID) {
        this.serialID = serialID;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
