package compuganga.appweb.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import compuganga.appweb.web.Model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer>{
    
}
