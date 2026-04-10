package lk.ijse.automationservice.service;

import lk.ijse.automationservice.dto.AutomationRequestDTO;
import lk.ijse.automationservice.dto.AutomationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class AutomationService {

    public AutomationResponseDTO process(AutomationRequestDTO request) {

        AutomationResponseDTO response = new AutomationResponseDTO();

        if (request.getSensorType().equals("Temperature")
                && request.getValue() > 35) {

            response.setStatus("ALERT");
            response.setMessage("High temperature detected! Irrigation needed.");

        } else if (request.getSensorType().equals("Humidity")
                && request.getValue() < 30) {

            response.setStatus("ALERT");
            response.setMessage("Low humidity detected!");

        } else {
            response.setStatus("OK");
            response.setMessage("Conditions are normal.");
        }

        return response;
    }
}
