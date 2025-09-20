package app.padariapaodoce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data da venda é obrigatória")
    private LocalDate data;

    @NotNull(message = "O valor total é obrigatório")
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    @NotNull(message = "A forma de pagamento é obrigatória")
    @JsonIgnoreProperties("vendas")
    private FormaPagamento formaPagamento;
}