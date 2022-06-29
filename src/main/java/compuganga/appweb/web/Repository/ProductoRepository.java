package compuganga.appweb.web.Repository;

import compuganga.appweb.web.Model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "SELECT o FROM Producto o WHERE o.status='A'")
    //@Query(value = "select * from t_product where status = 'A'")
  
    List<Producto> getAllActiveProductos();

    @Query(value = "SELECT o FROM Producto o WHERE o.nombre LIKE  %:searchName% And o.status='A'")
    List<Producto> getAllActiveProductosBySearch(@Param("searchName") String searchName);
    
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Procesador'") 
    List<Producto> getAllCategorProductos();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Placa Madre'") 
    List<Producto> getAllCategorProductos1();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Tarjeta de Video'") 
    List<Producto> getAllCategorProductos2();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Memoria RAM'") 
    List<Producto> getAllCategorProductos3();

    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='CPU'") 
    List<Producto> getAllCategorProductos4();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Monitor'") 
    List<Producto> getAllCategorProductos5();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Teclado'") 
    List<Producto> getAllCategorProductos6();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Mouse'") 
    List<Producto> getAllCategorProductos7();
    @Query(value = "SELECT o FROM Producto o WHERE o.categoria='Auricular'") 
    List<Producto> getAllCategorProductos8();

    
}
