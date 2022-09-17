package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Laptop;
import ru.maksirep.shop_shift.model.Technics;
import ru.maksirep.shop_shift.repository.LaptopRepository;

@Service
public class LaptopService extends TechnicsService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public void addPoint(Technics technics) {
        if (laptopRepository.getBySerialID(technics.getSerialID()) != null) {
            throw new RuntimeException("Technics with this ID already exist");
        }
        Laptop laptop = (Laptop) technics;
        if (laptop.getLaptopDiagonal() == null) {
            throw new RuntimeException("Empty laptop diagonal");
        }
        laptopRepository.save(laptop);
    }
}
