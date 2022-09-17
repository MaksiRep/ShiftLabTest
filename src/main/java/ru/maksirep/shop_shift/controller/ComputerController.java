package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Computer;
import ru.maksirep.shop_shift.service.ComputerService;

import javax.transaction.Transactional;


@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @PostMapping(value = "/technics/computer")
    public void addComputer(@RequestBody Computer computer) {
        computerService.addPoint(computer);
    }

    @PutMapping(value = "/technics/computer/{id}")
    public void updateComputer(@RequestBody Computer computer, @PathVariable(name = "id") Integer id) {
        computerService.updatePoint(computer, id);
    }

    @Transactional
    @DeleteMapping(value = "/technics/computer/{id}")
    public void deleteComputer(@PathVariable(name = "id") Integer id) {
        computerService.deletePoint(id);
    }

}
