package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class ClienteController {
    static final String INDEX ="cliente/create"; 

    @GetMapping("/cliente/create")
    public String index(Model model) {
        
        return INDEX;
    }  
}
