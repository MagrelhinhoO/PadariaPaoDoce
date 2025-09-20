package app.padariapaodoce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição da despesa é obrigatória")
    private String descricao;

    @NotNull(message = "O valor da despesa é obrigatório")
    private Double valor;

    @NotNull(message = "A data da despesa é obrigatória")
    private LocalDate data;
}