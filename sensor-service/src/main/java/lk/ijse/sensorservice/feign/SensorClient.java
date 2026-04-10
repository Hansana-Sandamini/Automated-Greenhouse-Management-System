package lk.ijse.sensorservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "sensor-service")
public interface SensorClient {
}