package compuganga.appweb.web.Model;

import java.math.BigDecimal;

import  java.util.Date ;
import  org.springframework.format.annotation.DateTimeFormat ;

import  lombok.*;

@Getter
@Setter

public class Entradas {
    String entradaId;
    Integer cantidad;
    BigDecimal precio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date fecha;
    
}

