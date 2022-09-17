package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Technics;
import ru.maksirep.shop_shift.service.TechnicsService;

import java.util.List;


@RestController
public class TechnicsController {

    @Autowired
    private TechnicsService technicsService;

    @GetMapping(value = "/technics/technics/{id}")
    public ResponseEntity<Technics> getTechnicsById(@PathVariable(name = "id") Integer id) {
        Technics technics = technicsService.getBySerialId(id);
        return new ResponseEntity<>(technics, HttpStatus.OK);
    }

    @GetMapping(value = "/technics/getTechnics/{type}")
    public ResponseEntity<List<Technics>> getTechnicsByType(@PathVariable(name = "type") String type) {
        return new ResponseEntity<>(technicsService.getTechnicsByType(type), HttpStatus.OK);
    }
}
