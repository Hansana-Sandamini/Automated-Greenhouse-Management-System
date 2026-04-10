package lk.ijse.sensorservice.feign;

import lk.ijse.sensorservice.dto.ZoneDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "zone-service")
public interface ZoneClient {

    @GetMapping("/zones/{id}")
    ZoneDTO getZoneById(@PathVariable Long id);
}
