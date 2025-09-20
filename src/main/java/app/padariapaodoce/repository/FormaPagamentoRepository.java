package app.padariapaodoce.repository;

import app.padariapaodoce.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    FormaPagamento findByDescricaoIgnoreCase(String descricao);
}