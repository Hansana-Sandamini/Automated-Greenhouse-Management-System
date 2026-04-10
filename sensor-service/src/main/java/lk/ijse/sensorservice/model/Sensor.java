package lk.ijse.sensorservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    private Long id;
    private String name;
    private String type;
    private Long zoneId;
}
