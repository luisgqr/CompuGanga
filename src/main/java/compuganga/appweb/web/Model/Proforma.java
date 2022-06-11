package compuganga.appweb.web.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import  lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_proforma")

public class Proforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")    
    Producto product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
   
    Usuario user;
    BigDecimal precio;
    Integer cantidad;
    @Builder.Default
    String status="PENDING"; 
}
