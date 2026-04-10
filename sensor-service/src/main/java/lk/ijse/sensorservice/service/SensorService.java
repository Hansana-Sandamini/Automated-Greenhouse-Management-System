package lk.ijse.sensorservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lk.ijse.sensorservice.dto.SensorResponseDTO;
import lk.ijse.sensorservice.dto.ZoneDTO;
import lk.ijse.sensorservice.entity.Sensor;
import lk.ijse.sensorservice.exception.ResourceNotFoundException;
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

    // Save Sensor with Zone Validation
    public Sensor save(Sensor sensor) {

        try {
            ZoneDTO zone = (ZoneDTO) zoneClient.getZoneById(sensor.getZoneId());

            if (zone == null) {
                throw new ResourceNotFoundException(
                        "Zone not found with ID: " + sensor.getZoneId()
                );
            }

        } catch (Exception e) {
            throw new ResourceNotFoundException(
                    "Zone not found with ID: " + sensor.getZoneId()
            );
        }

        return repository.save(sensor);
    }

    public List<Sensor> getAll() {
        return repository.findAll();
    }

    // Circuit Breaker + DTO mapping
    @CircuitBreaker(name = "zoneService", fallbackMethod = "zoneFallback")
    public SensorResponseDTO getSensorWithZone(Sensor sensor) {

        ZoneDTO zone = (ZoneDTO) zoneClient.getZoneById(sensor.getZoneId());

        SensorResponseDTO response = new SensorResponseDTO();
        response.setId(sensor.getId());
        response.setName(sensor.getName());
        response.setType(sensor.getType());
        response.setZone(zone);

        return response;
    }

    // Fallback Method
    public SensorResponseDTO zoneFallback(Sensor sensor, Throwable t) {

        SensorResponseDTO response = new SensorResponseDTO();
        response.setId(sensor.getId());
        response.setName(sensor.getName());
        response.setType(sensor.getType());

        // Return dummy zone instead of null
        ZoneDTO fallbackZone = new ZoneDTO();
        fallbackZone.setId(sensor.getZoneId());
        fallbackZone.setName("Unavailable");
        fallbackZone.setLocation("Service Down");

        response.setZone(fallbackZone);

        return response;
    }

    public SensorResponseDTO getSensorById(Long id) {

        Sensor sensor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor not found with ID: " + id));

        return getSensorWithZone(sensor);
    }

}
