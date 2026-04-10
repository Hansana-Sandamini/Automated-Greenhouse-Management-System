package lk.ijse.sensorservice.controller;

import lk.ijse.sensorservice.dto.SensorResponseDTO;
import lk.ijse.sensorservice.entity.Sensor;
import lk.ijse.sensorservice.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping
    public Sensor save(@RequestBody Sensor sensor) {
        return service.save(sensor);
    }

    @GetMapping
    public List<Sensor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SensorResponseDTO getSensor(@PathVariable Long id) {
        return service.getSensorById(id);
    }

}
