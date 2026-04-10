package lk.ijse.cropservice.service;

import lk.ijse.cropservice.dto.CropResponseDTO;
import lk.ijse.cropservice.entity.Crop;
import lk.ijse.cropservice.repository.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {

    private final CropRepository repository;

    public CropService(CropRepository repository) {
        this.repository = repository;
    }

    public Crop save(Crop crop) {
        return repository.save(crop);
    }

    public List<Crop> getAll() {
        return repository.findAll();
    }

    public CropResponseDTO getById(Long id) {

        Crop crop = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found"));

        CropResponseDTO dto = new CropResponseDTO();
        dto.setId(crop.getId());
        dto.setName(crop.getName());
        dto.setType(crop.getType());
        dto.setSeason(crop.getSeason());
        dto.setArea(crop.getArea());

        return dto;
    }
}
