package compuganga.appweb.web.Controller;
import java.util.Optional;

import javax.validation.Valid;

import compuganga.appweb.web.Model.Usuario;
import compuganga.appweb.web.Repository.UsuarioRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {
    static final String INDEX ="usuario/login"; 
    static String MODEL_CONTACT="user";
    static String MODEL_MESSAGE="mensaje";
    final UsuarioRepository usuariosData;

    public UsuarioController(UsuarioRepository usuariosData){
        this.usuariosData = usuariosData;
    }      

    @GetMapping("/usuario/login")
    public String login(Model model) {
        model.addAttribute(MODEL_CONTACT, new Usuario());
        return INDEX;
    } 
    
    @PostMapping("/usuario/login")
    public String loginSubmitForm(Model model, 
        @Valid Usuario objUser, HttpServletRequest request, BindingResult result ){
        String page=INDEX;
        model.addAttribute(MODEL_CONTACT, new Usuario());
        if(result.hasFieldErrors()) {
            model.addAttribute(MODEL_MESSAGE, "No se ha podido loguear");
        }else{
            Optional<Usuario> userDB = this.usuariosData.findById(objUser.getUserID());

            if(userDB.isPresent()){
                if(userDB.get().getPassword().equals(objUser.getPassword())){
                    model.addAttribute(MODEL_CONTACT,userDB.get());
                    model.addAttribute(MODEL_MESSAGE, "Usuario existe");
                    request.getSession().setAttribute("user", objUser);
                    page="welcome";    
                }else{
                    model.addAttribute(MODEL_MESSAGE, "Password no coincide");  
                }
            }else{
                model.addAttribute(MODEL_MESSAGE, "Usuario no existe");
            }
        }
        return page;
        
    }

    @GetMapping("/usuario/logout")
	public String logoutSession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
