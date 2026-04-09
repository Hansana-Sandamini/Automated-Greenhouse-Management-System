package lk.ijse.sensorservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {

    private Long id;
    private String name;
    private String type;
    private Long zoneId;
}
