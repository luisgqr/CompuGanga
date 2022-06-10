package compuganga.appweb.web.Model;

import java.math.BigDecimal;

import  java.util.Date ;
import  org.springframework.format.annotation.DateTimeFormat ;

import  lombok.*;

@Getter
@Setter

public class Ventas {
    String ventaID;
    BigDecimal precio;
    Integer cantidad;
    BigDecimal ptotal;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date fecha;
}
