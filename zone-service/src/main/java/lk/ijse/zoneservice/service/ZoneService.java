package lk.ijse.zoneservice.service;

import lk.ijse.zoneservice.entity.Zone;
import lk.ijse.zoneservice.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository repository;

    public ZoneService(ZoneRepository repository) {
        this.repository = repository;
    }

    public Zone save(Zone zone) {
        return repository.save(zone);
    }

    public List<Zone> getAll() {
        return repository.findAll();
    }

    public Zone getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
    }

    public Zone update(Long id, Zone zone) {
        Zone existing = getById(id);

        existing.setName(zone.getName());
        existing.setLocation(zone.getLocation());
        existing.setMinTemp(zone.getMinTemp());
        existing.setMaxTemp(zone.getMaxTemp());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
