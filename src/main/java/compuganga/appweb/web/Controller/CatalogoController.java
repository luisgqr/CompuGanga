package compuganga.appweb.web.Controller;

import java.util.List;
import java.util.Optional;

import compuganga.appweb.web.Model.Producto;
import compuganga.appweb.web.Model.Proforma;
import compuganga.appweb.web.Model.Usuario;
import compuganga.appweb.web.Repository.ProductoRepository;
import compuganga.appweb.web.Repository.ProformaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

@Controller
public class CatalogoController {
    static final String INDEX="catalogo/index";
    final ProductoRepository productsData;
    final ProformaRepository proformaData;

    public CatalogoController(ProductoRepository productsData,  ProformaRepository proformaData){
        this.productsData = productsData;
        this.proformaData = proformaData; 
    }

    @GetMapping("/catalogo/index")
    public String index(@RequestParam(defaultValue="") String searchName, Model model){
        List<Producto> listProducto = null;
        if(searchName.isEmpty()){
            listProducto = this.productsData.getAllActiveProductos();
        }else{
            listProducto = this.productsData.getAllActiveProductosBySearch(searchName);
        }
        model.addAttribute("productos", listProducto);
        return INDEX;

    }
    //
    @GetMapping("/Procesador/index")
    public String index(Model model){
        List<Producto> listProducto = null;      
            listProducto = this.productsData.getAllCategorProductos();       
        model.addAttribute("productos", listProducto);
        return INDEX;
    }
    @GetMapping("/Placa/index")
    public String index2(Model model){
        List<Producto> listProducto = null;      
            listProducto = this.productsData.getAllCategorProductos1();       
        model.addAttribute("productos", listProducto);
        return INDEX;
    }
    @GetMapping("/Tarjeta/index")
    public String index3(Model model){
        List<Producto> listProducto = null;      
            listProducto = this.productsData.getAllCategorProductos2();       
        model.addAttribute("productos", listProducto);
        return INDEX;
    }
    @GetMapping("/RAM/index")
    public String index4(Model model){
        List<Producto> listProducto = null;      
            listProducto = this.productsData.getAllCategorProductos3();       
        model.addAttribute("productos", listProducto);
        return INDEX;
    }
    //
    @GetMapping("/catalogo/add/{id}")
    public String add(@PathVariable("id") Integer id, 
        HttpSession session,
        Model model){
        Usuario user = (Usuario)session.getAttribute("user"); 
        if(user==null) {
            model.addAttribute("mensaje", "Debe loguearse antes de agregar");
        }else{
            Producto productSeleccionado = productsData.getOne(id);
            Optional<Proforma> item= 
                proformaData.findProformaByUsuarioAndProducto(user, productSeleccionado);
            if(!item.isPresent()){
                Proforma itemCarrito = new Proforma();
                itemCarrito.setCantidad(1);
                itemCarrito.setUser(user);
                itemCarrito.setPrecio(productSeleccionado.getPrecio());
                itemCarrito.setProduct(productSeleccionado);
                proformaData.save(itemCarrito);
                model.addAttribute("mensaje", "Se agrego el producto al carrito");
            }else{
                Proforma itemCarritoExistente=item.get();
                itemCarritoExistente.setCantidad(itemCarritoExistente.getCantidad()+1);
                proformaData.save(itemCarritoExistente);
                model.addAttribute("mensaje", "Se adiciono el producto al carrito");
            }
        }   
        return INDEX;
    }
}
