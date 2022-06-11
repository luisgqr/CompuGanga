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
    Integer id;
    String nombre;
    String DNI;
    String correo;
    String telefono;
    String direccion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    Usuario user;
}
