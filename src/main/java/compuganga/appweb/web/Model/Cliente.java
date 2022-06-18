package compuganga.appweb.web.Model;

import  javax.persistence.Entity ;
import  javax.persistence.Table ;
import  javax.persistence.Id ;
import  javax.persistence.FetchType ;
import  javax.persistence.OneToOne ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.JoinColumn ;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_customer")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String DNI;
    private String correo;
    private String telefono;
    private String direccion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Usuario user;
}
