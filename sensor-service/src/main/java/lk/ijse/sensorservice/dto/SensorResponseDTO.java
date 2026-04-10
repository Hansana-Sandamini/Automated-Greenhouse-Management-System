package lk.ijse.sensorservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorResponseDTO {

    private Long id;
    private String name;
    private String type;
    private ZoneDTO zone;
}
