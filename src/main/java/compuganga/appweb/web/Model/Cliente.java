package compuganga.appweb.web.Model;

import lombok.*;

@Getter
@Setter

public class Cliente {
    Integer id;
    String nombre;
    String DNI;
    String correo;
    String telefono;
    String direccion;
}
