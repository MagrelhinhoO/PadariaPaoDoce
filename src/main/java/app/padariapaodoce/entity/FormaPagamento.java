package app.padariapaodoce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição da forma de pagamento é obrigatória")
    private String descricao;

    @OneToMany(mappedBy = "formaPagamento", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("formaPagamento")
    private List<Venda> vendas;
}