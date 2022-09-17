package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.HardDisk;
import ru.maksirep.shop_shift.model.Technics;
import ru.maksirep.shop_shift.repository.HardDiskRepository;

@Service
public class HardDiskService extends TechnicsService {

    @Autowired
    private HardDiskRepository hardDiskRepository;

    @Override
    public void addPoint(Technics technics) {
        if (hardDiskRepository.getBySerialID(technics.getSerialID()) != null) {
            throw new RuntimeException("Technics with this ID already exist");
        }
        HardDisk hardDisk = (HardDisk) technics;
        if (hardDisk.getSize() == null) {
            throw new RuntimeException("Empty size of disk");
        }
        if (hardDisk.getSize() <= 0 ) {
            throw new RuntimeException("Incorrect size value");
        }
        hardDiskRepository.save(hardDisk);
    }
}
