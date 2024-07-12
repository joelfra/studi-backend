package Studi.ecf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcfController {
    
        @GetMapping
    public String Hello(){
        return "ECF studi BackEnd";
    }
}
