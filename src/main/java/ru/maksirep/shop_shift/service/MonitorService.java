package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Monitor;
import ru.maksirep.shop_shift.model.Technics;
import ru.maksirep.shop_shift.repository.MonitorRepository;

@Service
public class MonitorService extends TechnicsService {

    @Autowired
    private MonitorRepository monitorRepository;

    @Override
    public void addPoint(Technics technics) {
        if (monitorRepository.getBySerialID(technics.getSerialID()) != null) {
            throw new RuntimeException("Technics with this ID already exist");
        }
        Monitor monitor = (Monitor) technics;
        if (monitor.getDiagonal() == null) {
            throw new RuntimeException("Empty monitor diagonal");
        }
        if (monitor.getDiagonal() <= 0 ) {
            throw new RuntimeException("Incorrect diagonal value");
        }
        monitorRepository.save(monitor);
    }
}
