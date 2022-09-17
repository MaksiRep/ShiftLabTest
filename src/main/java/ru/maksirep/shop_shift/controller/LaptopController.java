package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Laptop;
import ru.maksirep.shop_shift.service.LaptopService;

import javax.transaction.Transactional;


@RestController
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping(value = "/technics/laptop")
    public void addLaptop(@RequestBody Laptop laptop) {
        laptopService.addPoint(laptop);
    }

    @PutMapping(value = "/technics/laptop/{id}")
    public void updateLaptop(@RequestBody Laptop laptop, @PathVariable(name = "id") Integer id) {
        laptopService.updatePoint(laptop, id);
    }

    @Transactional
    @DeleteMapping(value = "/technics/laptop/{id}")
    public void deleteLaptop(@PathVariable(name = "id") Integer id) {
        laptopService.deletePoint(id);
    }

}
