package compuganga.appweb.web.Model;

import  javax.persistence.Entity ;
import  javax.persistence.Table ;
import  javax.persistence.Id ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_proveedor")

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;
    String DNI;
    String correo;
    String direccion;
    String telefono;
}
