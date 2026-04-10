package lk.ijse.cropservice.controller;

import lk.ijse.cropservice.dto.CropResponseDTO;
import lk.ijse.cropservice.entity.Crop;
import lk.ijse.cropservice.service.CropService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crops")
public class CropController {

    private final CropService service;

    public CropController(CropService service) {
        this.service = service;
    }

    @PostMapping
    public Crop save(@RequestBody Crop crop) {
        return service.save(crop);
    }

    @GetMapping
    public List<Crop> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CropResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
