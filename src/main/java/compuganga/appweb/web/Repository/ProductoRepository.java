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
}
