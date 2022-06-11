package compuganga.appweb.web.Model;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_payment")

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date paymentDate; 
    String nombreTarjeta;
    String numeroTarjeta;
    @Transient
    String dueDateYYMM;
    @Transient
    String cvv;
    BigDecimal montoTotal;
    Integer clienteId;
    
}
