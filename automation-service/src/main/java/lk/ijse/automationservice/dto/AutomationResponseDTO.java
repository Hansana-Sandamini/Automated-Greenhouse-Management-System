package lk.ijse.automationservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutomationResponseDTO {

    private String status;   // OK / ALERT
    private String message;
}
