package reveste.brecho.entity.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Getter @Setter
@ToString
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;

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

    @NotNull
    private TipoEnum tipo;
}
