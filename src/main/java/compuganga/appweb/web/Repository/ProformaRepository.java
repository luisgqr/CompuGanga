package compuganga.appweb.web.Repository;

import java.util.List;
import java.util.Optional;

import compuganga.appweb.web.Model.Producto;
import compuganga.appweb.web.Model.Proforma;
import compuganga.appweb.web.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProformaRepository extends JpaRepository<Proforma, Integer>{
    @Query(value = "SELECT o FROM Proforma o WHERE o.user=?1 And o.status='PENDING'")
    List<Proforma> findItemsByUsuario(Usuario user);

    @Query(value = "SELECT o FROM Proforma o WHERE o.user=?1 And o.product=?2 And o.status='PENDING'")
    Optional<Proforma> findProformaByUsuarioAndProducto(Usuario user, Producto product);
}
