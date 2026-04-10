package lk.ijse.automationservice.controller;

import lk.ijse.automationservice.dto.AutomationRequestDTO;
import lk.ijse.automationservice.dto.AutomationResponseDTO;
import lk.ijse.automationservice.service.AutomationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/automation")
public class AutomationController {

    private final AutomationService service;

    public AutomationController(AutomationService service) {
        this.service = service;
    }

    @PostMapping
    public AutomationResponseDTO process(@RequestBody AutomationRequestDTO request) {
        return service.process(request);
    }
}
