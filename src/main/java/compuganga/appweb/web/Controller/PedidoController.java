package compuganga.appweb.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import compuganga.appweb.web.Model.Cliente;
import compuganga.appweb.web.Model.DetallePedido;
import compuganga.appweb.web.Model.Pedido;
import compuganga.appweb.web.Model.Usuario;
import compuganga.appweb.web.Model.Pago;//
//import compuganga.appweb.web.Model.Proforma;
import compuganga.appweb.web.Repository.ClienteRepository;
import compuganga.appweb.web.Repository.DetallePedidoRepository;
import compuganga.appweb.web.Repository.PedidoRepository;
import compuganga.appweb.web.Repository.PagoRepository;//
import compuganga.appweb.web.Repository.ProformaRepository;//

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class PedidoController {
    static final String VIEW_INDEX ="pedido/index";
    static final String FACTURA_INDEX="factura/index";
    static String MODEL_VIEW="pedido";
    static String MODEL_VIEW2="pago";
    static String MODEL_VIEW3="client";
    final PedidoRepository pedidoData;
    final DetallePedidoRepository detallePedidoData;
    final ClienteRepository clienteData;
    final PagoRepository pagoData; //
    final ProformaRepository proformaData;//
    
    public PedidoController(PedidoRepository pedidoData,
        DetallePedidoRepository detallePedidoData,
        ClienteRepository clienteData,
        PagoRepository pagoData,//
        ProformaRepository proformaData//
        ){
        this.pedidoData = pedidoData;
        this.detallePedidoData = detallePedidoData;
        this.clienteData = clienteData;
        this.pagoData = pagoData;
        this.proformaData = proformaData;//
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
    @GetMapping("/pedido2/view/{id}")
    public String createSubmitForm2(@PathVariable("id") int id, 
            Model model, HttpSession session ){
        Usuario user = (Usuario)session.getAttribute("user");

        Pedido pedido = pedidoData.getOne(id);
        pedido.getMontoTotal();
        pedido.getOrderDate();
        model.addAttribute(MODEL_VIEW, pedido);

        Pago pago = pagoData.getOne(id);
        pago.getNombreTarjeta();
        model.addAttribute(MODEL_VIEW2, pago);

        Cliente client = clienteData.findByUsuario(user);
        client.getDireccion();
        model.addAttribute(MODEL_VIEW3, client);

        List<DetallePedido> listItems = detallePedidoData.findItemsByPedido(pedido);
        model.addAttribute("detalles",listItems);
        return FACTURA_INDEX;
    }
}
