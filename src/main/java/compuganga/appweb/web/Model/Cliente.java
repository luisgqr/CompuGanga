package compuganga.appweb.web.Model;

import  javax.persistence.Entity ;
import  javax.persistence.Table ;
import  javax.persistence.Id ;
import  javax.persistence.FetchType ;
import  javax.persistence.OneToOne ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.JoinColumn ;

import lombok.*; // para no colocar los metodos get y set

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_customer") // creamos la tabla cliente

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera un id unico para cada valor de la tabla
    private Integer id;
    private String nombre;
    private String DNI;
    private String correo;
    private String telefono;
    private String direccion;
    @OneToOne(fetch = FetchType.LAZY) //para acceder a la lista usuario mediante su id de usuario
    @JoinColumn(name = "user_id")
    private Usuario user;
}
