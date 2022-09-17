package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Computer;
import ru.maksirep.shop_shift.model.Technics;
import ru.maksirep.shop_shift.repository.ComputerRepository;

@Service
public class ComputerService extends TechnicsService {

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public void addPoint(Technics technics) {
        if (computerRepository.getBySerialID(technics.getSerialID()) != null) {
            throw new RuntimeException("Technics with this ID already exist");
        }
        Computer computer = (Computer) technics;
        if (computer.getFormFactor() == null) {
            throw new RuntimeException("Empty computer form factor");
        }
        computerRepository.save(computer);
    }
}
