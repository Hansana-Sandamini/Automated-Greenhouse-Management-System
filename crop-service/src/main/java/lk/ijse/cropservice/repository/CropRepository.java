package lk.ijse.cropservice.repository;

import lk.ijse.cropservice.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
