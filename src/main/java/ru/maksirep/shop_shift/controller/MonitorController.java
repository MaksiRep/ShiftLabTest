package ru.maksirep.shop_shift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.shop_shift.model.Computer;
import ru.maksirep.shop_shift.model.Monitor;
import ru.maksirep.shop_shift.service.MonitorService;

import javax.transaction.Transactional;


@RestController
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @PostMapping(value = "/technics/monitor")
    public void addMonitor(@RequestBody Monitor monitor) {
        monitorService.addPoint(monitor);
    }

    @PutMapping(value = "/technics/monitor/{id}")
    public void updateMonitor(@RequestBody Monitor monitor, @PathVariable(name = "id") Integer id) {
        monitorService.updatePoint(monitor, id);
    }

    @Transactional
    @DeleteMapping(value = "/technics/monitor/{id}")
    public void deleteMonitor(@PathVariable(name = "id") Integer id) {
        monitorService.deletePoint(id);
    }

}
