package lk.ijse.automationservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutomationRequestDTO {

    private Long sensorId;
    private String sensorType;
    private Double value;

    private Long cropId;
    private String cropType;
}
