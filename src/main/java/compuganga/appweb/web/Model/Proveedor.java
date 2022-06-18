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
    private Integer id;
    private String nombre;
    private String DNI;
    private String correo;
    private String direccion;
    private String telefono;
}
