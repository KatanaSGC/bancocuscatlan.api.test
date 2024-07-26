package bancocuscatlan.api.gateway.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveSignalController {
    
    @GetMapping("/")
    public String Alive() {
        return "Alive Signal Gateway";
    }
    
}