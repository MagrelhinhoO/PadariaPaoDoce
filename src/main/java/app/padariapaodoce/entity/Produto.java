package app.padariapaodoce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    @NotNull(message = "O preço do produto é obrigatório")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @NotNull(message = "A categoria é obrigatória")
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;
}