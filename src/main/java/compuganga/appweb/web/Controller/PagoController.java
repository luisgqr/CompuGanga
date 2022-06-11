package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagoController {
    static final String INDEX="pago/create";

    @GetMapping("/pago/create")
    public String index(Model model){
        return INDEX;
    }
}
