package lk.ijse.sensorservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "zone-service")
public interface ZoneClient {

    @GetMapping("/zones/{id}")
    Object getZoneById(@PathVariable("id") Long id);
}
