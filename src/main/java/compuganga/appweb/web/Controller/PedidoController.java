package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import compuganga.appweb.web.Model.Cliente;
import compuganga.appweb.web.Model.DetallePedido;
import compuganga.appweb.web.Model.Pedido;
import compuganga.appweb.web.Model.Usuario;
import compuganga.appweb.web.Repository.ClienteRepository;
import compuganga.appweb.web.Repository.DetallePedidoRepository;
import compuganga.appweb.web.Repository.PedidoRepository;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class PedidoController {
    static final String VIEW_INDEX ="pedido/index";
    final PedidoRepository pedidoData;
    final DetallePedidoRepository detallePedidoData;
    final ClienteRepository clienteData;
    
    public PedidoController(PedidoRepository pedidoData,
        DetallePedidoRepository detallePedidoData,
        ClienteRepository clienteData
        ){
        this.pedidoData = pedidoData;
        this.detallePedidoData = detallePedidoData;
        this.clienteData = clienteData;
    }      

    @GetMapping("/pedido/index")
    public String index(Model model, HttpSession session){
        Usuario user = (Usuario)session.getAttribute("user"); 
        Cliente cliente = clienteData.findByUsuario(user);
        List<Pedido> listItems = pedidoData.findItemsByCliente(cliente.getId());
        model.addAttribute("pedidos",listItems);
        return VIEW_INDEX;
    }    

    @GetMapping("/pedido/view/{id}")
    public String createSubmitForm(@PathVariable("id") int id, 
            Model model ){
        Pedido pedido = pedidoData.getOne(id);
        List<DetallePedido> listItems = detallePedidoData.findItemsByPedido(pedido);
        model.addAttribute("detalles",listItems);
        return "pedido/detalle";
    }
}
