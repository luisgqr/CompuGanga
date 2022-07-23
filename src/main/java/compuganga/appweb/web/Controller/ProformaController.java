package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import compuganga.appweb.web.Model.Proforma;
import compuganga.appweb.web.Model.Usuario;
import compuganga.appweb.web.Model.Cliente;
import compuganga.appweb.web.Repository.ProformaRepository;
import compuganga.appweb.web.Repository.ClienteRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@Controller
public class ProformaController {
    static final String VIEW_INDEX ="proforma/index";
    static String MODEL_PRODUCTO="proforma";
    static String MODEL_VIEW3="client";
    final ProformaRepository proformaData;
    final ClienteRepository clienteData;
    
    public ProformaController(ProformaRepository proformaData,
        ClienteRepository clienteData){
        this.proformaData = proformaData;
        this.clienteData = clienteData;
    }      

    public static String getMODEL_PRODUCTO() {
        return MODEL_PRODUCTO;
    }
    public static void setMODEL_PRODUCTO(String mODEL_PRODUCTO) {
        MODEL_PRODUCTO = mODEL_PRODUCTO;
    }

    @GetMapping("/proforma/index")
    public String index(Model model, HttpSession session){
        Usuario user = (Usuario)session.getAttribute("user"); 
        List<Proforma> listItems = this.proformaData.findItemsByUsuario(user);
        model.addAttribute("proformas",listItems);
        Cliente client = this.clienteData.findByUsuario(user);
        client.getDireccion();
        model.addAttribute(MODEL_VIEW3, client);
        return VIEW_INDEX;
    }
       
    @PostMapping("/proforma/edit")
	public String createSubmitForm(Model model, HttpSession session, 
			@Valid Cliente objCliente,
			BindingResult bindingResult){
            Usuario user = (Usuario)session.getAttribute("user");
		    Cliente client = this.clienteData.findByUsuario(user);
            client.setDireccion(objCliente.getDireccion());
            clienteData.save(client);
            return "redirect:/proforma/index";
	}
    @PostMapping("/proforma/delete")
    public String createSubmitForm2(Model model,
    @Valid Proforma objProforma, BindingResult result ){
        Proforma pro = proformaData.getOne(objProforma.getId());
        proformaData.delete(pro);
        return "redirect:/proforma/index";
    }

    @PostMapping("/proforma/update")
    public String createSubmitForm(Model model, 
    @Valid Proforma objProforma, BindingResult result ){
        Proforma prof = proformaData.getOne(objProforma.getId());
        prof.setCantidad(objProforma.getCantidad());
        proformaData.save(prof);
        return "redirect:/proforma/index";
    }
}
