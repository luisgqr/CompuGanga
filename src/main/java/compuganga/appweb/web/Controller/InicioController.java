package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class InicioController {
    static final String INICIO_INDEX="welcome";

    @GetMapping("/")
    public String index(Model model){
        return INICIO_INDEX;
    }
}

