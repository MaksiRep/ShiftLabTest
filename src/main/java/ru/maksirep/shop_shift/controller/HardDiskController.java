package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.HardDisk;
import ru.maksirep.shop_shift.model.Laptop;
import ru.maksirep.shop_shift.service.HardDiskService;

import javax.transaction.Transactional;


@RestController
public class HardDiskController {

    @Autowired
    private HardDiskService hardDiskService;

    @PostMapping(value = "/technics/hardDisk")
    public void addHardDisc(@RequestBody HardDisk hardDisk) {
        hardDiskService.addPoint(hardDisk);
    }

    @PutMapping(value = "/technics/hardDisk/{id}")
    public void redactHardDisc(@RequestBody HardDisk hardDisk, @PathVariable(name = "id") Integer id) {
        hardDiskService.updatePoint(hardDisk, id);
    }

    @Transactional
    @DeleteMapping(value = "/technics/hardDisk/{id}")
    public void getHardDriveGoods(@PathVariable(name = "id") Integer id) {
        hardDiskService.deletePoint(id);
    }

}
