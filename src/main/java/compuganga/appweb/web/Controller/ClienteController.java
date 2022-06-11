package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import compuganga.appweb.web.Model.Cliente;
import compuganga.appweb.web.Model.Usuario;
import compuganga.appweb.web.Repository.ClienteRepository;
import compuganga.appweb.web.Repository.UsuarioRepository;

import javax.validation.Valid;

@Controller
public class ClienteController {
    static final String INDEX ="cliente/create"; 
    static String MODEL_CONTACT="client";
    final ClienteRepository clientsData;
    final UsuarioRepository usuariosData;

    public ClienteController(ClienteRepository clientsData,
        UsuarioRepository usuariosData    
        ){
        this.clientsData = clientsData;
        this.usuariosData = usuariosData;
    } 

    @GetMapping("/cliente/create")
    public String index(Model model) {
        model.addAttribute(MODEL_CONTACT, new Cliente());
        return INDEX;
    } 
    @PostMapping("/cliente/create")
    public String createSubmitForm(Model model, 
        @Valid Cliente objCliente, BindingResult result ){
        if(result.hasFieldErrors()) {
            model.addAttribute("mensaje", "No se registro un cliente");
        }else{
            Usuario user = objCliente.getUser();
            user.setTipoUsuario("C");
            this.usuariosData.save(user);
            this.usuariosData.flush();
            this.clientsData.save(objCliente);
            model.addAttribute(MODEL_CONTACT, objCliente);
            model.addAttribute("mensaje", "Se registro un cliente");
        }
        return INDEX;
    } 
}
