package ru.maksirep.shop_shift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maksirep.shop_shift.model.Technics;
import ru.maksirep.shop_shift.repository.TechnicsRepository;

import java.util.List;
import java.util.Locale;

@Service
public class TechnicsService {

    @Autowired
    private TechnicsRepository technicsRepository;

    public void addPoint (Technics technics) {
        if (technicsRepository.getBySerialID(technics.getSerialID()) != null) {
            throw new RuntimeException("Technics with this ID already exist");
        }
        technicsRepository.save(technics);
    }

    public void updatePoint (Technics technics, Integer id) {
        if (technicsRepository.getBySerialID(id) == null) {
            throw new RuntimeException("Technics with this ID don't exist");
        }
        technics.setSerialID(id);
        technicsRepository.save(technics);
    }

    public void deletePoint (Integer id) {
        if (technicsRepository.getBySerialID(id) == null) {
            throw new RuntimeException("Technics with this ID isn't exist");
        }
        technicsRepository.deleteBySerialID(id);
    }

    public Technics getBySerialId (Integer id) {
        if (technicsRepository.getBySerialID(id) == null) {
            throw new RuntimeException("Technics with this ID isn't exist");
        }
        return technicsRepository.getBySerialID(id);
    }

    public List<Technics> getTechnicsByType (String type) {
        List<Technics> technicsList = technicsRepository.findAllByOrderBySerialIDDesc();
        if (technicsList == null) {
            throw new RuntimeException("Technics with this type isn't exist");
        }
        return technicsList.stream().filter(x -> x.getClass().getSimpleName().toLowerCase(Locale.ROOT).equals(type.toLowerCase(Locale.ROOT))).toList();
    }
}
