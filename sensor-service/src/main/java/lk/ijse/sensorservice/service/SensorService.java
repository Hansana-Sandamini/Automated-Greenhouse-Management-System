package lk.ijse.sensorservice.service;

import lk.ijse.sensorservice.entity.Sensor;
import lk.ijse.sensorservice.repository.SensorRepository;
import lk.ijse.sensorservice.feign.ZoneClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository repository;
    private final ZoneClient zoneClient;

    public SensorService(SensorRepository repository, ZoneClient zoneClient) {
        this.repository = repository;
        this.zoneClient = zoneClient;
    }

    public Sensor save(Sensor sensor) {

        // Validate zone exists before saving
        Object zone = zoneClient.getZoneById(sensor.getZoneId());

        if (zone == null) {
            throw new RuntimeException("Zone not found");
        }

        return repository.save(sensor);
    }

    public List<Sensor> getAll() {
        return repository.findAll();
    }
}
