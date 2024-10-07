package reveste.brecho.entity.pedido;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reveste.brecho.entity.usuario.Usuario;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private LocalDateTime data;

    private double valorTotal;
    @NotBlank
    private StatusEnum status;
    @ManyToOne
    private Usuario usuario;

}
