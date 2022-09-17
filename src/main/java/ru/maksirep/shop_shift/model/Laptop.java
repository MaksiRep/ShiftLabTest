package ru.maksirep.shop_shift.model;

import javax.persistence.*;

@Entity
public class Laptop extends Technics {

    public Laptop() {
    }

    @Column(name = "LaptopDiagonal")
    @Enumerated(EnumType.STRING)
    private LaptopDiagonal laptopDiagonal;

    private enum LaptopDiagonal {
        thirteen,
        fourteen,
        fifteen,
        seventeen
    }

    public void setLaptopDiagonal(LaptopDiagonal laptopDiagonal) {
        this.laptopDiagonal = laptopDiagonal;
    }

    public LaptopDiagonal getLaptopDiagonal() {
        return laptopDiagonal;
    }

}
