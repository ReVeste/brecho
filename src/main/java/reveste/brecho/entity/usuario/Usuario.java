package reveste.brecho.entity.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import reveste.brecho.enun.usuario.TipoEnum;

import java.time.LocalDate;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank @Size(min = 3, max = 100)
    private String nome;

    @NotBlank @CPF
    private String cpf;

    @NotBlank
    private String telefone;

    @NotNull @Past
    private LocalDate dataNascimento;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String senha;

    private TipoEnum tipo;
}
