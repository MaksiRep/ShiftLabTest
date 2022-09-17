package ru.maksirep.shop_shift.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HardDisk extends Technics {

    public HardDisk () {}

    @Column(name = "size")
    private Integer size;

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
