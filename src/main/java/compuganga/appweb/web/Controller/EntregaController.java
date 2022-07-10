package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import javax.validation.Valid;


import compuganga.appweb.web.Model.Entrega;
import compuganga.appweb.web.Model.Cliente;

import compuganga.appweb.web.Repository.EntregaRepository;
import compuganga.appweb.web.Repository.ClienteRepository;

@Controller
public class EntregaController {
    private static final String INDEX ="entrega/create"; 
    private static String MODEL_CONTACT="entrega";
    static String MODEL_VIEW3="client";

    private final EntregaRepository entregaData;
    final ClienteRepository clienteData;
    
    public EntregaController(EntregaRepository entregaData, ClienteRepository clienteData){
        this.entregaData = entregaData;
        this.clienteData = clienteData;
    }

    @GetMapping("/entrega/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Entrega());
        return INDEX;
    }  
    
    @PostMapping("/entrega/create")
    public String createSubmitForm(Model model, 
        @Valid Entrega objEntrega, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro los datos de entrega");
        }else{
            this.entregaData.save(objEntrega);
            model.addAttribute(MODEL_CONTACT, objEntrega);
            model.addAttribute("mensaje", "Se registro un contacto");
        }
        return INDEX;
    }
    
}
