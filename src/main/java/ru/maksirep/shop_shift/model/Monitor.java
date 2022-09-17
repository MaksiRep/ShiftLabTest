package ru.maksirep.shop_shift.model;

import javax.persistence.*;

@Entity
public class Monitor extends Technics {

    public Monitor() {
    }

    @Column(name = "monitorDiagonal")
    private Integer monitorDiagonal;

    public void setDiagonal(int diagonal) {
        this.monitorDiagonal = diagonal;
    }

    public Integer getDiagonal() {
        return monitorDiagonal;
    }
}
